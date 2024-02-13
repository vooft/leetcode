class P033_SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        return nums.search(nums.indices, target) ?: -1
    }

    private fun IntArray.search(range: IntRange, target: Int): Int? {
        if (range.isEmpty()) {
            return null
        }

        val pivotIndex = range.first + (range.last - range.first) / 2
        val pivot = get(pivotIndex)
        if (pivot == target) {
            return pivotIndex
        }

        val beforePivotRange = range.first until  pivotIndex
        val afterPivotRange = (pivotIndex + 1)..range.last

        if (isAscending(range)) {
            // sorted part, normal binary search
            return when {
                target < pivot -> search(beforePivotRange, target)
                else -> search(afterPivotRange, target)
            }
        } else {
            return search(beforePivotRange, target) ?: search(afterPivotRange, target)
        }
    }

    private fun IntArray.isAscending(range: IntRange) = get(range.first) < get(range.last)
}
