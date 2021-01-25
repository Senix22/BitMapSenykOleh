package com.senix22.bitmap

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {
    val TAG =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crearPunto(0f, 0f, 2500f, 3500f, Color.GREEN)
        imageToBitmap(progress)

    }

    private fun crearPunto(x: Float, y: Float, xend: Float, yend: Float, color: Int) {
        val bmpDraw = progress.drawable as BitmapDrawable
        val bmp = bmpDraw.bitmap.copy(Bitmap.Config.RGB_565, true)
        val c = Canvas(bmp)
        val p = Paint()
        p.color = color
        c.drawLine(x, y, xend, yend, p)
        progress.setImageBitmap(bmp)
    }
    private fun imageToBitmap(image: ImageView): ByteArray {
        val bitmap = (image.drawable as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)

        return stream.toByteArray()
    }
}