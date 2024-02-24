package leetcode.extra

class P787_CheapestFlightsWithinKStops {
    fun findCheapestPrice(cities: Int, flights: Array<IntArray>, src: Int, dst: Int, maxStops: Int): Int {
        val session = Bfs(
            cities = cities,
            flights = flights,
            srcId = NodeId(src),
            dstId = NodeId(dst),
            maxStops = maxStops
        )

        return session.bfs()?.weight?.value ?: -1
    }

    private class Bfs(
        cities: Int,
        flights: Array<IntArray>,
        private val srcId: NodeId,
        private val dstId: NodeId,
        maxStops: Int
    ) {
        val maxPath = maxStops + 2 // also includes starting and ending points

        // all nodes with corresponding directions
        val nodes = buildTree(cities, flights)

        fun bfs(): Path? {
            // a lot of duplicates, hash set will allow to dedup them
            val queue = linkedSetOf(Path(srcId, 1, Weight(0)))

            var minPath: Path? = null
            while (queue.isNotEmpty()) {
                // leetcode doesn't run with jdk21, have to get/remove manually
                val currentPath = queue.iterator().next()
                queue.remove(currentPath)

                val currentNode = nodes.getValue(currentPath.latestNode)

                for ((childId, childWeight) in currentNode.childToWeight) {
                    val totalChildWeight = currentPath.weight + childWeight

                    // ignore all child paths that are longer than the current min one
                    if (minPath != null && minPath.weight <= totalChildWeight) {
                        continue
                    }

                    val childPath = Path(childId, currentPath.numberOfNodes + 1, totalChildWeight)
                    if (childId == dstId) {
                        if (minPath == null || minPath.weight > childPath.weight) {
                            minPath = childPath
                        }
                    } else if (childPath.numberOfNodes < maxPath) {
                        // only adding if not exceeding the max path
                        queue.add(childPath)
                    }
                }
            }

            return minPath
        }
    }

    @JvmInline
    value class NodeId(val id: Int)

    @JvmInline
    value class Weight(val value: Int) : Comparable<Weight> {
        operator fun plus(another: Weight) = Weight(value + another.value)
        override operator fun compareTo(other: Weight) = value.compareTo(other.value)

        companion object {
            val INF = Weight(Int.MAX_VALUE)
        }
    }

    data class Path(val latestNode: NodeId, val numberOfNodes: Int, val weight: Weight)

    data class Node(val id: NodeId, val childToWeight: MutableMap<NodeId, Weight> = hashMapOf())

    companion object {
        private fun buildTree(cities: Int, flights: Array<IntArray>): Map<NodeId, Node> {
            val nodes = (0..cities).associateTo(HashMap()) { NodeId(it) to Node(NodeId(it)) }
            for (flight in flights) {
                val from = NodeId(flight[0])
                val to = NodeId(flight[1])
                val price = Weight(flight[2])

                nodes.computeIfAbsent(from) { Node((it)) }.childToWeight[to] = price
            }

            return nodes
        }
    }
}
