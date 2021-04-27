package algorithms

/**
 * 使用 scala语言 解决QB09
 *
 * Created by MoncozGC on 2021/4/27
 */
class QB09SFun {
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

object QB09S {
  def main(args: Array[String]): Unit = {
    val qB09SFun = new QB09SFun
    println(qB09SFun.isPalindrome(1213))
  }
}
