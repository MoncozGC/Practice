package algorithms;

/**
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1输入: "III"输出: 3
 * 示例 2输入: "IV"输出: 4
 * 示例 3输入: "IX"输出: 9
 * 示例 4输入: "LVIII"输出: 58解释: L = 50, V= 5, III = 3.
 * 示例 5输入: "MCMXCIV"输出: 1994解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * Created by MoncozGC on 2021/4/28
 */

class Solution13 {
    public int romanToInt(String s) {
        // 总数
        int sum = 0;
        // 获取第一个罗马字符的数字
        int preNum = getValue(s.charAt(0));
        //System.out.println(preNum);
        for (int i = 1; i < s.length(); ++i) {
            // 获取每一个罗马字符的数字
            int num = getValue(s.charAt(i));
            //System.out.println(num);
            // 当左边的大于右边的数字时进行减法
            if (preNum < num) {
                sum -= preNum;
            } else {
                // 当左边的小于等于右边的数字时进行减法
                sum += preNum;
            }
            // 将最后获取到的罗马数字赋值给preNum
            System.out.println(preNum + " " + num + " " + sum);
            preNum = num;
        }
        // sum中加入最后一个罗马数字
        sum += preNum;
        System.out.println("|");
        System.out.println(sum + " " + preNum);
        System.out.println("---");
        return sum;
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param ch 输入罗马字符
     * @return 返回罗马字符对应的数字
     */
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

public class QB13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.romanToInt("CMXCIX"));
    }
}
