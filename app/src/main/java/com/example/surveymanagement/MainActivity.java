package com.example.surveymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.surveymanagement.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.btonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = binding.inputText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Screen2.class);
                intent.putExtra("correo",correo);
                Log.i("Correo", correo);

                startActivity(intent);
            }
        });

        binding.btonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = binding.inputText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Screen2.class);
                intent.putExtra("correo",correo);
                startActivity(intent);

            }
        });



    }
}