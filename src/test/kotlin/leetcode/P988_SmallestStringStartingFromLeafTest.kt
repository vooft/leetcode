package leetcode

import io.kotest.matchers.shouldBe
import leetcode.P988_SmallestStringStartingFromLeaf.TreeNode
import org.junit.jupiter.api.Test

class P988_SmallestStringStartingFromLeafTest {

    private val test = P988_SmallestStringStartingFromLeaf()

    @Test
    fun `example 1`() {
        val input = listOf(0, 1, 2, 3, 4, 3, 4).toTreeNode()
        val expected = "dba"

        val actual = test.smallestFromLeaf(input)
        actual shouldBe expected
    }

    @Test
    fun `example 2`() {
        val input = listOf(25, 1, 3, 1, 3, 0, 2).toTreeNode()
        val expected = "adz"

        val actual = test.smallestFromLeaf(input)
        actual shouldBe expected
    }

    @Test
    fun `example 3`() {
        val input = listOf(2, 2, 1, null, 1, 0, null, 0).toTreeNode()
        val expected = "abc"

        val actual = test.smallestFromLeaf(input)
        actual shouldBe expected
    }

    @Test
    fun `corner case 1`() {
        val input = listOf(0, null, 1).toTreeNode()
        val expected = "ba"

        val actual = test.smallestFromLeaf(input)
        actual shouldBe expected
    }

    @Test
    fun `corner case 2`() {
        val input = listOf(21).toTreeNode()
        val expected = "v"

        val actual = test.smallestFromLeaf(input)
        actual shouldBe expected
    }

    private fun List<Int?>.toTreeNode(): TreeNode {
        val root = TreeNode(requireNotNull(get(0)))

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var index = 1
        while (index < size) {
            val node = queue.removeFirst()

            val left = get(index++)?.let { TreeNode(it) }
            if (left != null) {
                queue.add(left)
                node.left = left
            }

            val right = getOrNull(index++)?.let { TreeNode(it) }
            if (right != null) {
                queue.add(right)
                node.right = right
            }
        }

        return root
    }
}
