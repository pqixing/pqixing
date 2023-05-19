//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 计数 👍 228 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val results = hashSetOf<String>()
        val char = tiles.toCharArray()
        val sb = StringBuilder()
        tryAddToResult(char, results, sb, 0)
        return results.size;
    }

    private fun tryAddToResult(char: CharArray, results: HashSet<String>, content: StringBuilder, index: Int) {
        if (index >= char.size) return
        for (i in char.indices) {
            if (char[i] == '0') continue
            val c = char[i]
            content.append(c)
            results.add(content.toString())
            char[i] = '0'
            tryAddToResult(char, results, content, index + 1)
            content.deleteCharAt(content.length - 1)
            char[i] = c
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
