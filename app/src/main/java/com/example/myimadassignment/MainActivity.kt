package com.example.myimadassignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //variables declared here//
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggestion = findViewById<Button>(R.id.buttonSuggestion)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewSuggest = findViewById<TextView>(R.id.textViewSuggest)
        buttonSuggestion.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "Bacon, eggs and COFFEE!"
                "mid-morning" -> "Fruit"
                "afternoon" -> "A ham and cheese sandwich with a bottle of water"
                "mid-afternoon" -> "Chips and a cola"
                "dinner" -> "Steak, salad and some red wine"
                else -> "CAUTION: Please enter a valid time of day."
            } //text should be entered here//
            textViewSuggest.text = suggestion
        }
        //Output will appear here when result is put in//
        buttonReset.setOnClickListener {
            editTextTime.text.clear()
            textViewSuggest.text = ""
        }
    }
}

