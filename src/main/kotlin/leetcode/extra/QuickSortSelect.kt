package leetcode.extra

class QuickSortSelect<T: Comparable<T>> {
    fun sort(list: List<T>): List<T> {
        val l = list.toMutableList()

        l.quicksort()

        return l
    }

    fun kth(list: List<T>, index: Int): T {
        val l = list.toMutableList()
        return l.quickselect(index)
    }

    private fun MutableList<T>.quickselect(target: Int, range: IntRange = 0 until size): T {
        val pivotIndex = partition(range)
        return when {
            pivotIndex < target -> quickselect(target, (pivotIndex + 1)..range.last)
            pivotIndex > target -> quickselect(target, range.first until pivotIndex)
            else -> get(pivotIndex)
        }
    }

    private fun MutableList<T>.quicksort(range: IntRange = 0 until size) {
        if (range.isEmpty()) {
            return
        }

        val pivotIndex = partition(range)
        if (pivotIndex == range.last) {
            return
        }

        quicksort(range.first until pivotIndex)
        quicksort(pivotIndex..range.last)
    }

    private fun MutableList<T>.partition(range: IntRange): Int {
        val pivot = get(range.last)

        var storeIndex = range.first
        for (i in range) {
            if (get(i) < pivot) {
                swap(i, storeIndex)
                storeIndex++
            }
        }

        swap(storeIndex, range.last)

        return storeIndex
    }
}

private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val val1 = get(index1)
    set(index1, get(index2))
    set(index2, val1)
}
