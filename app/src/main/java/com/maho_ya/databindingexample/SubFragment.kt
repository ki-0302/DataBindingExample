package com.maho_ya.databindingexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maho_ya.databindingexample.databinding.FragmentSubBinding

class SubFragment: Fragment() {

    class Handler {
        var count = 0

        // メソッド参照はメソッドのパラメータがイベントリスナーのパラメーターと一致する必要がある
        fun onClickButton(view: View) {
            // Observeしていいのでこの値は反映されない
            count += 1
        }
    }

    class Presenter {
        fun onClickButton(view: View, text: String) {
            Log.v("SubFragment", "Presenter.onClickButton")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Fragment, ListView, RecyclerView で使用する場合は以下のようにinflateを使用する。
        val binding = FragmentSubBinding.inflate(layoutInflater, container, false)

        // DataBindingUtilを使用する方法
        // val binding = DataBindingUtil.inflate<FragmentSubBinding>(layoutInflater, R.layout.fragment_sub,
        //    container, false)

        binding.information = Information(
            "Information Caption",
            "Now on Android",
        true
        )
        binding.user = User(
            "Android",
            null
        )
        binding.list = mutableListOf("0","1","2")
        binding.map = mutableMapOf("foo" to "Foo", "bar" to "Bar")
        binding.handler = Handler()
        binding.presenter = Presenter()

        return binding.root
    }
}