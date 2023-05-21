//逆序对的定义如下：对于数组 nums 的第 i 个和第 j 个元素，如果满足 0 <= i < j < nums.length 且 nums[i] > 
//nums[j]，则其为一个逆序对；否则不是。 
//
// 给你两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个 逆序对 的不同的数组的个数。由于答案可能很大，只需要返回对 10⁹ + 
//7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 0
//输出：1
//解释：
//只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, k = 1
//输出：2
//解释：
//数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= k <= 1000 
// 
//
// Related Topics 动态规划 👍 285 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var mod = 0;
    val MOD_NUM = 1000000007
    fun kInversePairs(n: Int, k: Int): Int {
        val nums = IntArray(n) { it + 1 }
        val result = IntArray(n)
        dfs(result, nums, 0,k)
        return mod % MOD_NUM;
    }

    fun dfs(result: IntArray, nums: IntArray, index: Int, k: Int) {
        if (index == result.size) {
            val match = checkIfMatch(result, k)
            if (match) mod = (mod + 1) % MOD_NUM
            return
        }
        for (i in nums.indices) {
            if (nums[i] == -1) continue
            result[index] = nums[i]
            nums[i] = -1
            dfs(result, nums, index + 1, k)
            nums[i] = result[index]
        }

    }

    fun checkIfMatch(nums: IntArray, k: Int): Boolean {

        var sum = 0;
        for (i in nums.indices) {
            val value = nums[i]
            for (j in i + 1 until nums.size) {
                if (nums[j] < value) {
                    sum++
                    if (sum > k) return false
                }
            }
        }
        return sum == k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
