package com.turskyi.dynamiclayoutbyclick

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

/** Creating buttons by clicking  */
class MainActivity : Activity(), View.OnClickListener {
    var wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCreate.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreate -> {
                // Создание LayoutParams c шириной и высотой по содержимому
                val lParams = LinearLayout.LayoutParams(
                        wrapContent, wrapContent)
                // переменная для хранения значения выравнивания
                // по умолчанию пусть будет LEFT
                var btnGravity = Gravity.START
                when (rgGravity!!.checkedRadioButtonId) {
                    R.id.rbLeft -> btnGravity = Gravity.START
                    R.id.rbCenter -> btnGravity = Gravity.CENTER_HORIZONTAL
                    R.id.rbRight -> btnGravity = Gravity.END
                }
                // переносим полученное значение выравнивания в LayoutParams
                lParams.gravity = btnGravity

                // создаем Button, пишем текст и добавляем в LinearLayout
                val btnNew = Button(this)
                btnNew.text = etName!!.text.toString()
                llMain.addView(btnNew, lParams)
            }
            R.id.btnClear -> {
                llMain.removeAllViews()
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}