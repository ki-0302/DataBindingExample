package com.maho_ya.databindingexample

class MyUtils {

    // Kotlinではstaticメソッドの宣言ができないため、companion objectを使用するなどの代替案になる
    companion object {
        // Javaと違いcompanion objectは実行時にインスタンス化されるのでJavaのstaticのように呼べない。
        // 回避方法として@JvmStaticアノテーションを付けることによって、Javaのstaticと同じ用に生成させることができる。
        @JvmStatic
        fun convertName(name: String): String {
            return "Kimiko"
        }
    }
}