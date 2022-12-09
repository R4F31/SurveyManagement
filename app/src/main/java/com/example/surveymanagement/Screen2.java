package com.example.surveymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.surveymanagement.databinding.ActivityScreen2Binding;

public class Screen2 extends AppCompatActivity {

    private ActivityScreen2Binding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScreen2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Para coger el correo de la view1
        String email = getIntent().getExtras().getString("correo");
        binding.inputEmail.setText(email);

        binding.btonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), FirstQuestion.class);
                startActivity(intent);
            }
        });



        binding.btonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstQuestion.class);
                startActivity(intent);
            }
        });
    }



    private boolean revisarSesion() {
        return false;
    }

    private void guardarSesion(boolean checked){

    }

    private void iniciarlizarElementos(){
        preferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
}