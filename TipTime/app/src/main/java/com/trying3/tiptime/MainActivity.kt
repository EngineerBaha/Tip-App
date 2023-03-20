package com.trying3.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trying3.tiptime.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonCalculate.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if(cost==null){
            binding.tipAmount.text = ""
            return
        }
        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost


        if (binding.roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }
        binding.tipAmount.text="Tip Amount: $$tip"
    }
}