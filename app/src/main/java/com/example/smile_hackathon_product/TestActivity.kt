package com.example.smile_hackathon_product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout.*
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class TestActivity : AppCompatActivity()  {

    private var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // to get dp unit
        val dp = resources.displayMetrics.density
        val sp = resources.displayMetrics.scaledDensity

        // Instantiation of linearLayout
        val layout = LinearLayout(this)

        val mParent =  LayoutParams.MATCH_PARENT
        val wContent =  LayoutParams.WRAP_CONTENT

        layout.layoutParams = LayoutParams(mParent, mParent)

        layout.orientation = VERTICAL

        layout.gravity = Gravity.CENTER

        // set up background color
        layout.setBackgroundColor(Color.rgb(0xdf, 0xff, 0xef))

        setContentView(layout)

        // Instantiation of TextView
        val textView = TextView(this)
        textView.text = getString(R.string.hello)
        textView.textSize = 12 * sp

        textView.layoutParams = LayoutParams(wContent, wContent)

        layout.addView(textView)


        // Instantiation of Button
        val button = Button(this)
        button.text = getString(R.string.button)

        val buttonLayoutParams = LayoutParams(
            (250 * dp).toInt(), wContent)

        buttonLayoutParams.topMargin = (40 * dp).toInt()

        button.layoutParams = buttonLayoutParams

        layout.addView(button)

        button.setOnClickListener {
            // flag == true
            if (flag) {
                textView.text = getString(R.string.hello)
                flag = false
            }
            // flag == false
            else {
                textView.text = getString(R.string.world)
                flag = true
            }
        }
    }
}