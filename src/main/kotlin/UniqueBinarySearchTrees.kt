/**
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
class UniqueBinarySearchTrees {
    fun numTrees(maxN: Int): Int {
        val precalculated = IntArray(maxN + 1)
        precalculated[0] = 1
        precalculated[1] = 1
        return numTrees(maxN, precalculated)
    }

    private fun numTrees(maxN: Int, precalculated: IntArray): Int {
        if (precalculated[maxN] > 0) {
            return precalculated[maxN]
        }
        if (maxN == 0) { // if there is nothing on the side, then only the item itself left
            return 1
        } else if (maxN == 1) { // if there only one item on the side, then there is also only one way to structure them
            return 1
        }
        var result = 0
        for (n in 0 until maxN) {
            val leftN = numTrees(n, precalculated)
            val rightN = numTrees(maxN - n - 1, precalculated)
            result += leftN * rightN
        }
        precalculated[maxN] = result
        return result
    }
}
