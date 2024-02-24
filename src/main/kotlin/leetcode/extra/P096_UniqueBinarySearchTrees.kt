package leetcode.extra

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
class P096_UniqueBinarySearchTrees {
    fun numTrees(maxN: Int): Int = P096Solution(maxN).numTreesRecursively(maxN)

    private class P096Solution(maxN: Int) {
        private val precalculated = IntArray(maxN + 1).also {
            it[0] = 1
            it[1] = 1
        }

        fun numTreesRecursively(value: Int): Int {
            if (precalculated[value] > 0) {
                return precalculated[value]
            }

            when (value) {
                // if both child nodes are null
                0 -> return 1

                // if there is only one child node
                1 -> return 1
            }

            var result = 0

            // iterate through all variants of the tree
            // from when it is skewed towards left to skewed towards right
            for (n in 0 until value) {
                val leftN = numTreesRecursively(n)
                val rightN = numTreesRecursively(value - n - 1)

                // for each left variant there is rightN right variants
                result += leftN * rightN
            }

            precalculated[value] = result
            return result
        }

    }
}
