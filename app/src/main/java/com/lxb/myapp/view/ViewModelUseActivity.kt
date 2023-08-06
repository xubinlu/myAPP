package com.lxb.myapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.lxb.myapp.databinding.ActivityViewModelUseBinding
import com.lxb.myapp.vm.ViewModelUse

class ViewModelUseActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewModelUseBinding
    val vmUser: ViewModelUse by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelUseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}