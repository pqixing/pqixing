//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1382 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    val gravityX = intArrayOf(1, 0, -1, 0)
    val gravityY = intArrayOf(0, 1, 0, -1)
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val xLength = matrix[0].size
        val yLength = matrix.size
        val result = ArrayList<Int>(xLength * yLength)

        val cur = arrayOf(0, 0)
        var gravity = 0

        while (true) {

            val value = matrix[cur[1]][cur[0]]
            result.add(value)
            matrix[cur[1]][cur[0]] = Int.MIN_VALUE

            //检查下一个标记为
            var newX = cur[0] + gravityX[gravity]
            var newY = cur[1] + gravityY[gravity]
            //如果下一个坐标，超出范围，或者已经访问过，调转方向
            if (newX < 0 || newX >= xLength || newY < 0 || newY >= yLength
                || matrix[newY][newX] == Int.MIN_VALUE
            ) {
                gravity = (gravity + 1) % gravityX.size
                newX = cur[0] + gravityX[gravity]
                newY = cur[1] + gravityY[gravity]
            }
            //如果再次转变方向后，依旧不合法，代表依旧遍历完成
            if (newX < 0 || newX >= xLength || newY < 0 || newY >= yLength
                || matrix[newY][newX] == Int.MIN_VALUE
            ) {
                break
            }
            cur[0] = newX
            cur[1] = newY
        }
        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
