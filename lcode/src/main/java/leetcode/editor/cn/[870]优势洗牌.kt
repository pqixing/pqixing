import java.util.*

//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 378 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
        //nums1重新排序
        Arrays.sort(nums1)
        val indexs = IntArray(nums2.size) { it }.sortedBy { nums2[it] }

        var left = 0
        var right = nums2.size - 1

        val result = IntArray(nums1.size)

        for (value1 in nums1){

            val index2 = indexs[left]
            val value2 = nums2[index2]

            if (value1 > value2) {
                result[index2] = value1
                left++
            } else {
                result[indexs[right]] = value1
                right--
            }
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
