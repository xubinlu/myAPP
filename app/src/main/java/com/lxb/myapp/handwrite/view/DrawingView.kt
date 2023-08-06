package com.lxb.myapp.handwrite.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Xfermode
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class DrawingView(context: Context, attrs: AttributeSet)
    : android.view.View(context, attrs) {
    private val TAG = "lxb"
    private var path = Path()
    private val paint = Paint()
    private val backgroundPaint = Paint()
    private var drawCanvas: Canvas? = null
    lateinit var drawBitmap: Bitmap
    private var previousX = 0f
    private var previousY = 0f
    private var clearXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    init {
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 10f
        paint.xfermode = null
        backgroundPaint.color = Color.WHITE
        backgroundPaint.style = Paint.Style.FILL
        setLayerType(LAYER_TYPE_HARDWARE, null)
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        var viewHeight = MeasureSpec.getSize(heightMeasureSpec)
        drawBitmap = Bitmap.createBitmap(viewWidth, viewHeight, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(drawBitmap)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                previousX = x
                previousY = y
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                path.quadTo(previousX, previousY, (x + previousX) / 2, (y + previousY) / 2)
                previousX = x
                previousY = y
            }

            MotionEvent.ACTION_UP -> {
                path.lineTo(x, y)
                drawCanvas?.drawPath(path, paint)
                path.reset()
            }
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        Log.i(TAG, "onDraw")
        canvas.drawBitmap(drawBitmap, 0f, 0f, backgroundPaint)
        canvas.drawPath(path, paint)
    }

    fun setPenFlag(isPen: Boolean) {
        if (isPen) {
            paint.xfermode = null
            paint.strokeWidth = 10.0f
            paint.color = Color.BLACK
        } else {


            paint.xfermode = clearXfermode
            paint.strokeWidth = 30.0f
            paint.color = Color.argb(1, 0, 0, 0)
        }
    }
}