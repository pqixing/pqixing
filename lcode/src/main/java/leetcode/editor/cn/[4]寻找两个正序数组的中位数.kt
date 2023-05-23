//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6543 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val len = nums1.size + nums2.size
        val mid1 = (len+1) / 2;
        val mid2 = (len + 2) / 2
        val result = findMid(nums1, nums2, 0, 0, mid1)
        if (mid1 == mid2) return result.toDouble()

        return (result + findMid(nums1, nums2, 0, 0, mid2)) / 2.0
    }

    private fun findMid(nums1: IntArray, nums2: IntArray, n1: Int, n2: Int, i: Int): Int {
        if (nums1.size == n1) {
            return nums2[n2 + i-1]
        }
        if (nums2.size == n2) {
            return nums1[n1 + i-1]
        }
        if (i == 1) return Math.min(nums1[n1], nums2[n2])

        val haf = i / 2
        val nn1 = Math.min(nums1.size - 1, (n1 + haf)-1)
        val nn2 = Math.min(nums2.size - 1, (n2 + haf)-1)
        return if (nums1[nn1] < nums2[nn2]) {
            findMid(nums1, nums2, nn1 + 1, n2, i - nn1 + n1 -1)
        } else {
            findMid(nums1, nums2, n1, nn2 + 1, i - nn2 + n2-1)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
