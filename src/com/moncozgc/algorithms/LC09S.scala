package com.moncozgc.algorithms

/**
 * 使用 scala语言 解决LC09
 *
 * Created by MoncozGC on 2021/4/27
 */
class LC09SFun {
  def isPalindrome(x: Int): Boolean = {
    var cur = 0
    var res = x
    if (x < 0) {
      return false
    }
    while (res != 0) {
      cur = cur * 10 + res % 10
      res /= 10
    }
    return cur == x
  }
}

object LC09S {
  def main(args: Array[String]): Unit = {
    val LC09SFun = new LC09SFun
    println(LC09SFun.isPalindrome(1213))
  }
}
