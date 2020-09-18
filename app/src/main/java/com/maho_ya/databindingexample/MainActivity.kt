package com.maho_ya.databindingexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.maho_ya.databindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Data Binding
    // https://developer.android.com/topic/libraries/data-binding?hl=ja

    // XMLレイアウトにlayoutを記述することによって、Viewとデータオブジェクトをバインディングするクラスが
    // レイアウト毎に自動生成される。ファイル名はパスカルケースでSuffixにBindingと付く（例: activity_main.xml -> ActivityMainBinding）
    //
    // またレイアウト式（例: @{user.firstName}）が記述できるようになるが、レイアウト式はUnitTestが行えず、
    // IDEのサポートも少ないため最小限に留める必要がある。
    // レイアウト式をシンプルにするためにはBindingAdapterを使用する方法がある。

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // バインディングの作成。レイアウトをinflateするタイミングで行うのが安全
         val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

        // または以下のようにDataBindingUtil.setContentViewでもバインディングを作成できる。こちらはsetContentViewを実行しているのでこれのみでOK
        // val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = User("Test", "Taro")

        binding.openButton.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}