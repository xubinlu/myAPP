package com.lxb.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lxb.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    fun initView() {
        binding.btUseViewmodel.setOnClickListener {
            startTargetActivity("com.lxb.myapp.view.ViewModelUseActivity")
        }

        binding.btUseCoroutines.setOnClickListener {
            startTargetActivity("com.lxb.myapp.view.CoroutinesUseActivity")
        }

        binding.btHandwriting.setOnClickListener {
            startTargetActivity("com.lxb.myapp.handwrite.HandWriteActivity")
        }

        binding.btHandwriting2.setOnClickListener {
            startTargetActivity("com.lxb.myapp.handwrite.HandWriteActivity2")
        }
    }

    private fun startTargetActivity(className: String) {
        val intent = Intent()
        intent.setClassName(
            applicationContext.packageName,
            className
        )
        startActivity(intent)
    }
}