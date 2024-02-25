package leetcode

/**
 * https://leetcode.com/problems/lru-cache
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 * Constraints:
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
class P146_LRUCache(private val capacity: Int, private val logEnabled: Boolean = false) {

    private val storage = mutableMapOf<Int, Node>()
    private var headNode: Node? = null
    private var lastNode: Node? = null

    fun get(key: Int): Int {
        log { "get($key)" }

        return when (val result = storage[key]) {
            null -> {
                log { "key missing $key" }
                -1
            }

            else -> {
                moveToHead(result)
                result.value
            }
        }
    }

    fun put(key: Int, value: Int) {
        log { "put($key, $value), storage.size=${storage.size}, capacity=$capacity" }

        if (storage.containsKey(key)) {
            val existing = storage.getValue(key)
            existing.value = value
        } else {
            val new = Node(key = key, value = value, prev = null, next = null)
            storage[key] = new
        }

        val node = storage.getValue(key)
        if (storage.size == 1) {
            log { "single element, just updating links and leaving" }
            headNode = node
            lastNode = node
            return
        }

        moveToHead(node)

        if (storage.size > capacity) {
            evictLRU()
        }

        log { "after put $headNode" }
    }

    private fun evictLRU() {
        val last = requireNotNull(lastNode) { "Can't evict from an empty cache" }
        log { "evicting $last" }
        storage.remove(last.key)

        val prev = last.prev

        if (prev != null) {
            prev.next = null
        }

        lastNode = prev
    }

    private fun moveToHead(node: Node) {
        log { "move to head: $node" }
        if (headNode === node) {
            log { "already at the head" }
            return
        }

        // detach node itself
        val prev = node.prev
        val next = node.next

        if (node === lastNode) {
            lastNode = prev
        }

        if (prev != null) {
            prev.next = next
        }

        if (next != null) {
            next.prev = prev
        }

        // replace head node
        val head = headNode
        if (head != null) {
            head.prev = node
        }

        node.prev = null
        node.next = head
        headNode = node

        log { "after move to head, headNode=$headNode" }
        log { "after move to head, lastNode=$lastNode" }
    }

    private fun log(block: () -> String) {
        if (logEnabled) {
            println(block())
        }
    }

    class Node(val key: Int, var value: Int, var prev: Node?, var next: Node?) {
        override fun toString(): String {
            return "Node(key=$key, value=$value, prev=${prev?.let { "${it.key}-${it.value}" }}, next=$next)"
        }
    }
}
