package com.lxb.myapp.handwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lxb.myapp.R
import com.lxb.myapp.handwrite.view.DrawingSurfaceView
import com.lxb.myapp.handwrite.view.DrawingTouchListener

class HandWriteActivity2 : AppCompatActivity() {

    private lateinit var drawingSurfaceView: DrawingSurfaceView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hand_write2)

        drawingSurfaceView = findViewById(R.id.drawing_view)
        drawingSurfaceView.setOnTouchListener(DrawingTouchListener())
    }
}