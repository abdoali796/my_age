package com.abdoali.myage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Calendar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //starer text watcher
        by.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var ll = by.layoutParams as LinearLayout.LayoutParams
                if (by.text.isNotEmpty()) {

                    ll.weight = 5f
                } else {
                    ll.weight = 10f
                }
            }

            override fun afterTextChanged(s: Editable?) {


            }
        })
        bd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {

                    var bb = p0.toString().toInt()


                    if (bb > 31) {
                        p0?.replace(0, p0.length, "31")

                    } else if (bb < 1) {
                        p0?.replace(0, p0.length, "1")
                    }
                } catch (
                    ex: Exception
                ) {
                }
            }
        })
        bm.addTextChangedListener(
            object : TextWatcher {

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    var ll = by.layoutParams as LinearLayout.LayoutParams
                    if (by.text.isNotEmpty()) {

                        ll.weight = 3f
                    } else {
                        ll.weight = 5f
                    }


                }

                override fun afterTextChanged(p0: Editable?) {
                    try {

                        var bb = p0.toString().toInt()


                        if (bb > 12) {
                            p0?.replace(0, p0.length, "12")

                        } else if (bb < 1) {
                            p0?.replace(0, p0.length, "1")
                        }
                    } catch (
                        ex: Exception
                    ) {
                    }
                }
            }
        )


        // start of code
        button.setOnClickListener {
            var bby = getInstance().get(YEAR)
            var bbm = getInstance().get(MONTH)
            var bbd = getInstance().get(DAY_OF_MONTH)
            try {


                bby = by!!.text.toString().toInt()
                bbm = bm!!.text.toString().toInt()
                bbd = bd!!.text.toString().toInt()
            } catch (ex: Exception) {
                Toast.makeText(this, "ادخل العمر الصح", Toast.LENGTH_SHORT).show()
                age.text = ex.toString()
            }
            var y = getInstance().get(YEAR)
            var m = getInstance().get(MONTH)
            var d = getInstance().get(DAY_OF_MONTH)

            var od = 0
            if (d >= bbd) {
                od = d - bbd
            } else {
                od = 30 + d - bbd
                m = m - 1
            }
            var om = 0

            if (m >= bbm) {
                om = m - bbm
            } else {
                om = 12 + m - bbm
                y = y - 1
            }
            var oy = (y - bby)



            age.text = "your old $oy y $om m $od  يوم  "
            if (oy >= 1000) {
                age.text = "ادخل عمرك الصج"
            }
            age.animate().translationY(-500f)

        }
        end.setOnClickListener { finish() }
    }

}