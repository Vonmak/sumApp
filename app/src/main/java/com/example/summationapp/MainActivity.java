package com.example.summationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstNumber;
    private EditText editTextSecondNumber;
    private TextView textViewResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
        Button buttonSum = findViewById(R.id.buttonSum);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSum.setOnClickListener(v -> {
            String firstNumber = editTextFirstNumber.getText().toString();
            String secondNumber = editTextSecondNumber.getText().toString();

            if (!firstNumber.isEmpty() && !secondNumber.isEmpty()) {
                try {
                    int num1 = Integer.parseInt(firstNumber);
                    int num2 = Integer.parseInt(secondNumber);
                    int sum = num1 + num2;
//                    Toast.makeText(MainActivity.this, getString(R.string.sum_result) + sum, Toast.LENGTH_LONG).show();
                    textViewResult.setText(getString(R.string.sum_result) + sum);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, R.string.error_invalid_input, Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(MainActivity.this, R.string.error_empty_input, Toast.LENGTH_LONG).show();
            }
        });
    }
}
