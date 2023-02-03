package com.moncozgc.algorithms;

import java.util.HashMap;

/**
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 *
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 *
 * 示例 1：
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * 输出："this is a secret"
 * 解释：对照表如上图所示。
 * 提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/decode-the-message
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by MoncozGC on 2023/2/1
 */
public class LC2325 {

    public String decodeMessage(String key, String message) {
        char cur = 'a';
        // hashMap来代替对照表
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            // 当遍历的字符不等于空且不存在于对照表中hashmap, 则添加到hashmap中
            // 如果存在于hashmap中则不需要添加了, 因为每一个字符只需要记录第一次出现的时候
            if (c != ' ' && !hashMap.containsKey(c)) {
                /**
                 * 对照关系:
                 * t -> a
                 * h -> b
                 * e -> c
                 * ....
                 */
                hashMap.put(c, cur);
                cur++;
            }
        }

        // 根据加密表, 提取对照表中的字符获取 密码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            // 提取加密表中的字符不等于空时, 和对照表中的字符进行匹配
            if (c != ' ') {
                c = hashMap.get(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC2325 lc2325 = new LC2325();
        // this is a secret
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String result = lc2325.decodeMessage(key, message);
        System.out.println(result);
    }
}
