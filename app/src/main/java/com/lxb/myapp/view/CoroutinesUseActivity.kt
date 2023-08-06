package com.lxb.myapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lxb.myapp.databinding.ActivityCoroutinesUseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesUseActivity : AppCompatActivity() {
    private val TAG = "CoroutinesUse"
    lateinit var binding: ActivityCoroutinesUseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesUseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.btGlobalScope.setOnClickListener {
            globalScopeUse()
        }
    }

    private fun globalScopeUse() {
        Log.i(TAG,"Start")
        GlobalScope.launch {
            delay(1000) // 暂停1秒钟
            Log.i(TAG, "Task completed")
        }
        Thread.sleep(500) // 等待2秒钟，确保协程有足够时间时间完成
        Log.i(TAG,"End")
    }

}