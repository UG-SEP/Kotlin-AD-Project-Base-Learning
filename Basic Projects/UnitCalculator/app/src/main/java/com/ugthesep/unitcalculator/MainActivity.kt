package com.ugthesep.unitcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate.setOnClickListener {
            var value = amount_text_edit.text.toString().toDoubleOrNull()
            if(value == null)
            {
                Toast.makeText(this,R.string.error,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else
            {
                val fChooser = from_chooser.selectedItem.toString()
                val tChooser = to_chooser.selectedItem.toString()
                if (fChooser.compareTo(resources.getString(R.string.ounce)) == 0 && tChooser.compareTo(resources.getString(R.string.millimeter)) == 0) {
                    value *= 29.574
                }
                else if (fChooser.compareTo(resources.getString(R.string.ounce)) == 0 && tChooser.compareTo(resources.getString(R.string.gram)) == 0) {
                    value*= 28.35
                }
                else if (fChooser.compareTo(resources.getString(R.string.millimeter)) == 0 && tChooser.compareTo(resources.getString(R.string.ounce)) == 0) {
                    value/=28350
                }
                else if (fChooser.compareTo(resources.getString(R.string.millimeter)) == 0 && tChooser.compareTo(resources.getString(R.string.gram)) == 0) {
                    value/=1000
                }
                else if (fChooser.compareTo(resources.getString(R.string.gram)) == 0 && tChooser.compareTo(resources.getString(R.string.ounce)) == 0) {
                    value/=28.5
                }
                else if (fChooser.compareTo(resources.getString(R.string.gram)) == 0 && tChooser.compareTo(resources.getString(R.string.millimeter)) == 0) {
                    value*=1000
                }
                result.text = String.format("%.2f",value)
            }

        }
    }

}