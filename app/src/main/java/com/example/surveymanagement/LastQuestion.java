package com.example.surveymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.surveymanagement.databinding.ActivityLastQuestionBinding;
import com.example.surveymanagement.databinding.ActivityLastScreenBinding;

public class LastQuestion extends AppCompatActivity {
    private ActivityLastQuestionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLastQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.butnPorevius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondQuestion.class);
                startActivity(intent);
            }
        });

    }



}