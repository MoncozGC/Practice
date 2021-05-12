package com.moncozgc.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by MoncozGC on 2021/4/21
 */
public class CharAtTest {
    public static void main(String[] args) {
        Set<Character> occ = new HashSet<Character>();
        String s = "abcasdas";
        for (int i = 1; i < s.length(); ++i) {

            System.out.println(occ.remove(s.charAt(i - 1)) + " " + i);
            System.out.println(occ.contains(s.charAt(i - 1)) + " " + i);
        }
    }
}
