package com.lxb.myapp.handwrite.view

import android.view.MotionEvent
import android.view.View

class DrawingTouchListener : View.OnTouchListener {
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (v is DrawingSurfaceView) {
            val drawingView: DrawingSurfaceView = v
            drawingView.drawPath(event)
            return true
        }
        return false
    }
}