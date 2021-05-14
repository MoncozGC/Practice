package com.moncozgc.algorithms;


import java.util.Stack;

/**
 * 知识点: 栈、dfs
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1 输入：s = "3[a]2[bc]"输出："aaabcbc"
 * 示例 2 输入：s = "3[a2[c]]"输出："accaccacc"
 * 示例 3 输入：s = "2[abc]3[cd]ef"输出："abcabccdcdcdef"
 *
 * Created by MoncozGC on 2021/5/13
 */
public class LC394 {
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString("3[a2[c]]"));
    }
}

/**
 * 思路:
 * 创建两个栈进行解题，一个用来存放数字，另一个用来临时存放子字符串
 * 由于可能会在 [] 中还包含其他的 [] ，所以我们只要遇到 [ 就先将其前面的字符串暂时入栈，稍后再进行计算
 * 如果遇到 ] ，则将存放数字的栈和存放子字符串的栈分别出栈一个，然后进行字符串的拼接，然后再将该字符串作为答案的一部分进行下一轮迭代计算
 *
 * 遇到数字保存数字到临时变量
 * 遇到字母保存字母到临时变量
 * 遇到左括号把数字和字母推到栈中
 * 遇到右括号对栈中的数字和字母出栈进行解析
 */
class Solution394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        // toCharArray: 字符串转换为字符数组
        for (char c : s.toCharArray()) {
            if (c != ']')
                // 把所有的字母push到栈中，除了]
                stack.push(c);
            else {
                // step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();
                // isLetter: 用于判断指定字符是否为字母; 判断取出的顶部对象是否为字母
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    // 在第0位插入出栈的对象
                    sb.insert(0, stack.pop());
                }

                //[ ]内的字符串
                String sub = sb.toString();
                // 去除[
                stack.pop();

                //step 2: 获取倍数数字
                sb = new StringBuilder();
                // isDigit: 判断指定字符是否为数字;  判断取出的顶部对象是否为数字
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                // 倍数
                int count = Integer.valueOf(sb.toString());

                // step 3: 根据倍数把字母再push回去
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        // 把栈里面所有的字母取出来
        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty()) {
            retv.insert(0, stack.pop());
        }

        return retv.toString();
    }
}



