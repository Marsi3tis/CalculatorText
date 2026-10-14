package com.example.calculatortext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editTextInput = findViewById(R.id.editTextInput);
        Spinner spinnerMetric = findViewById(R.id.spinnerMetric);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);

        TextCalculator textCalculator = new TextCalculator();
        buttonCalculate.setOnClickListener(view -> {
            String text = editTextInput.getText().toString();
            if(text.trim().isEmpty()){
                Toast.makeText(this, R.string.empty_input, Toast.LENGTH_SHORT).show();
                return;
            }
            int result;

            switch (spinnerMetric.getSelectedItemPosition()){
                case 0:
                    result = textCalculator.countSentences(text);
                    break;
                case 1:
                    result = textCalculator.countWords(text);
                    break;
                case 2:
                    result = textCalculator.countPunctuation(text);
                    break;
                case 3:
                    result = textCalculator.countNumbers(text);
                    break;
                default:
                    result = 0;
                    break;
            }
            textViewResult.setText(getString(R.string.result_format, result));

        });


    }
}