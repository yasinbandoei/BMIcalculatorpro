package com.example.bmicalculatorpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculatorpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightpicker.minValue = 30
        binding.weightpicker.maxValue = 150

        binding.heightpicker.minValue = 100
        binding.heightpicker.maxValue = 250

        binding.weightpicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }
        binding.heightpicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }
    }
    private fun calculateBMI() {
        val ارتفاع = binding.heightpicker.value
        var doubleارتفاع = ارتفاع.toDouble() / 100

        val وزن = binding.weightpicker.value

        val bmi = وزن.toDouble() / (doubleارتفاع * doubleارتفاع)

        binding.resultsTV.text = String.format("شاخص توده بدنتان است : %.2f", bmi)
        binding.healthyTV.text = String.format(
            "نتایج: %s",
            healthyMessage(bmi)
        )
    }
        private fun healthyMessage(bmi: Double): String {
            if (bmi <18.5)
                return "کمبود وزن"
            if (bmi <25.0)
                return "نرمال"
            if (bmi <30.0)
                return "اضافه وزن"

            return "خارج از دسترس"
        }
    }