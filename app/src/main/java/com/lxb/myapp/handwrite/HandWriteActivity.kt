package com.lxb.myapp.handwrite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lxb.myapp.R
import com.lxb.myapp.databinding.ActivityHandWriteBinding
import com.lxb.myapp.handwrite.view.DrawingView

class HandWriteActivity : AppCompatActivity() {
    //private lateinit var drawingSurfaceView: DrawingSurfaceView
    private lateinit var drawingView: DrawingView
    private lateinit var binding: ActivityHandWriteBinding
    private val TAG = "lxb" //"HandWriting"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHandWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawingView = findViewById(R.id.drawing_view)
        //drawingSurfaceView.setOnTouchListener(DrawingTouchListener())

        initView()
    }

    private fun initView() {
        binding.btPen.setOnClickListener {
            Log.i(TAG, "pen")
            /*drawingSurfaceView.eraseMode = false
            drawingSurfaceView.invalidate()*/
            drawingView.setPenFlag(true)
        }

        binding.btEraser.setOnClickListener {
            Log.i(TAG, "erase")
            /*drawingSurfaceView.eraseMode = true
            drawingSurfaceView.invalidate()*/
            drawingView.setPenFlag(false)
        }

        binding.btClean.setOnClickListener {
            Log.i(TAG, "clean")
        }
    }

}