package com.lxb.myapp.handwrite.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView


class DrawingSurfaceView(context: Context, attrs: AttributeSet)  : SurfaceView(context, attrs) {
    private val TAG = "lxb"
    private val surfaceHolder: SurfaceHolder = holder
    private val drawingPath: Path = Path()
    private val drawingPaint: Paint = Paint()
    private val drawBitmap: Bitmap
    private val backgroundPaint = Paint()
    private var drawCanvas: Canvas? = null

    var eraseMode: Boolean = false

    init {
        drawingPaint.color = Color.BLACK
        drawingPaint.style = Paint.Style.STROKE
        drawingPaint.strokeWidth = 15f
        drawBitmap = Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(drawBitmap)
        backgroundPaint.color = Color.WHITE
        backgroundPaint.style = Paint.Style.FILL
    }

    fun drawPath(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> drawingPath.moveTo(event.x, event.y)
            MotionEvent.ACTION_MOVE -> drawingPath.lineTo(event.x, event.y)
            MotionEvent.ACTION_UP -> {
                if (eraseMode) {
                    drawingPaint.color = Color.WHITE
                    drawingPaint.style = Paint.Style.FILL
                } else {
                    drawingPaint.color = Color.BLACK
                    drawingPaint.style = Paint.Style.STROKE
                }
                //drawCanvas?.drawPath(drawingPath, drawingPaint)
                //drawingPath.reset()
            }
            else -> return
        }
        invalidate()
        val canvas: Canvas = surfaceHolder.lockCanvas()
        if (eraseMode) {
            drawingPaint.color = Color.WHITE
            drawingPaint.style = Paint.Style.FILL
        } else {
            drawingPaint.color = Color.BLACK
            drawingPaint.style = Paint.Style.STROKE
        }
        canvas.drawColor(Color.WHITE)
        canvas.drawPath(drawingPath, drawingPaint)
        surfaceHolder.unlockCanvasAndPost(canvas)

    }

    override fun onDraw(canvas: Canvas) {
        Log.i(TAG, "onDraw")
        canvas.drawBitmap(drawBitmap, 0f, 0f, backgroundPaint)
        canvas.drawPath(drawingPath, drawingPaint)
    }

}