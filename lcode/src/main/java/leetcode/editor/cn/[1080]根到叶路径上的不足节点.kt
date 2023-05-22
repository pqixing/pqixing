import java.util.*

//给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
//
// 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。 
//
// 叶子节点，就是没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
//输出：[1,2,3,4,null,null,7,8,9,null,14]
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
//输出：[5,4,8,11,null,17,4,7,null,null,null,5]
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,2,-3,-5,null,4,null], limit = -1
//输出：[1,null,-3,4]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 5000] 内 
// -10⁵ <= Node.val <= 10⁵ 
// -10⁹ <= limit <= 10⁹ 
// 
//
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 115 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
//class TreeNode(var `val`: Int) {
//    var left: TreeNode? = null
//    var right: TreeNode? = null
//}

class Solution {

    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
        if (root == null) return null
        val waitMarkNode = LinkedList<TreeNode>()
        val marks = hashMapOf<TreeNode, Boolean>()
        markNodes(waitMarkNode, marks, root, limit, 0)

        waitMarkNode.clear()
        waitMarkNode.add(root)
//        println("test ${marks.map { "${it.key.`val`} : ${it.value}" }}")
        while (waitMarkNode.isNotEmpty()) {
            val node = waitMarkNode.pollLast()
            val left = node.left
            val right = node.right
            if (left != null) {
                if (marks[left] != true) {
                    node.left = null
                } else {
                    waitMarkNode.push(left)
                }
            }
            if (right != null) {
                if (marks[right] != true) {
                    node.right = null
                } else {
                    waitMarkNode.push(right)
                }
            }
        }

        return root.takeIf { marks[it] == true }
    }

    private fun markNodes(waitMarkNode: LinkedList<TreeNode>, marks: HashMap<TreeNode, Boolean>, node: TreeNode?, limit: Int, sum: Int) {
        if (node == null) return
        val newSum = node.`val` + sum

        waitMarkNode.add(node)
        //标记
        if (node.left == null && node.right == null) {
            waitMarkNode.forEach {
                if (newSum >= limit && !marks.getOrDefault(it, false)) {
                    marks[it] = true
                }
            }
        } else {
            markNodes(waitMarkNode, marks, node.left, limit, newSum)
            markNodes(waitMarkNode, marks, node.right, limit, newSum)
        }
        waitMarkNode.removeLast()
    }

}
//leetcode submit region end(Prohibit modification and deletion)
