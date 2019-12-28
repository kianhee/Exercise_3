package com.example.exercise_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var age : Spinner
    lateinit var gender : RadioGroup
    lateinit var isSmoker : CheckBox
    lateinit var insurancePremium : TextView
    lateinit var calculatePremium : Button
    lateinit var reset : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        age = findViewById<Spinner>(R.id.spinnerAge)
        gender = findViewById<RadioGroup>(R.id.radioGroupGender)
        isSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        insurancePremium = findViewById<TextView>(R.id.textViewPremium)
        calculatePremium = findViewById<Button>(R.id.buttonCalculate)
        reset = findViewById<Button>(R.id.buttonReset)
        calculatePremium.setOnClickListener { calculateLifeInsurancePremium() }
        reset.setOnClickListener{reset()}
    }
    private fun calculateLifeInsurancePremium() {
        var premium = 0
        premium = when (age.selectedItemPosition) {
            0 -> 60
            1 -> 70
            2 -> 90
            3 -> 120
            else -> 150
        }
        if(gender.checkedRadioButtonId == R.id.radioButtonMale){
            premium += getExtraChargeForMale()
        }
        if(isSmoker.isChecked){
            premium += getExtraChargeForSmoker()
        }
        insurancePremium.text = String.format("%s RM%s",getString(R.string.insurance_premium).toString(),premium.toString())
    }
    private fun getExtraChargeForMale() : Int{
        var extraChargeForMale = 0
        extraChargeForMale = when (age.selectedItemPosition) {
            0 -> 0
            1 -> 50
            2 -> 100
            3 -> 150
            else -> 200
        }
        return extraChargeForMale
    }
    private fun getExtraChargeForSmoker() : Int{
        var extraChargeForSmoker = 0
        extraChargeForSmoker = when (age.selectedItemPosition) {
            1 -> 100
            2 -> 150
            3 -> 200
            4 -> 250
            5 -> 300
            else -> 0
        }
        return extraChargeForSmoker
    }
    private fun reset(){
        age.setSelection(0)
        gender.clearCheck()
        isSmoker.isChecked = false
        insurancePremium.text = getString(R.string.insurance_premium)
    }
}







//jianxi