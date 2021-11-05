package com.ugthesep.tipcalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate_tip.setOnClickListener {
            val tipPercentage = when(options.checkedRadioButtonId)
            {
                R.id.amazing -> .20
                R.id.good -> .18
                else -> .15
            }
            val tipStr = cost_of_service_edit_text.text.toString()
            var tip = 0.0
            if(tipStr.isEmpty())
            {
                Toast.makeText(this,"Please fill the cost of service",Toast.LENGTH_SHORT).show()
            }
            else
                tip = tipStr.toDouble() * tipPercentage
            if(tip_btn.isChecked)
            {
                tip = kotlin.math.ceil(tip)

            }
            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            tip_amount.text = getString(R.string.tip_amount,formattedTip)
        }
        cost_of_service_edit_text.setOnKeyListener {view, keyCode, _ -> handleKeyEvent(view, keyCode)}
    }
    private fun handleKeyEvent(view: View, keyCode:Int): Boolean{
        if(keyCode == KeyEvent.KEYCODE_ENTER)
        {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}