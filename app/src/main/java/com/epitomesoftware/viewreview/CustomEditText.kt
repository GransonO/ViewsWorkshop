package com.epitomesoftware.viewreview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet

class CustomEditText(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    private var mRect: Rect = Rect()
    private var mPaint: Paint = Paint()

    init {
        // Creates a Rect and a Paint object, and sets the style and color of the Paint object.
        mPaint.style = Paint.Style.STROKE
        mPaint.color = -0x7fffff01

    }

    override fun onDraw(canvas: Canvas) {
        // Gets the number of lines of text in the View.
        val count = lineCount
        // Gets the global Rect and Paint objects
        val r: Rect = mRect
        val paint: Paint = mPaint
        /*
         * Draws one line in the rectangle for every line of text in the EditText
         */for (i in 0 until count) {
            // Gets the baseline coordinates for the current line of text
            val baseline = getLineBounds(i, r)
            /*
             * Draws a line in the background from the left of the rectangle to the right,
             * at a vertical position one dip below the baseline, using the "paint" object
             * for details.
             */canvas.drawLine(
                r.left.toFloat(),
                (baseline + 1).toFloat(),
                r.right.toFloat(),
                (baseline + 1).toFloat(),
                paint
            )
        }
        // Finishes up by calling the parent method
        super.onDraw(canvas)
    }

}