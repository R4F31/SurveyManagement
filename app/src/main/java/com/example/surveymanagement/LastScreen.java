package com.example.surveymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.surveymanagement.databinding.ActivityLastScreenBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastScreen extends AppCompatActivity {



    private ActivityLastScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLastScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Para que nos introduzca una contraseña segura con minimo 8 caracteres y uno especial
        binding.eTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                if (password.length() >= 8) {
                    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                    Matcher matcher = pattern.matcher(password);

                    boolean isPwdContainsSpeChar = matcher.find();
                    if (isPwdContainsSpeChar) {
                        binding.LayoutPassword.setHelperText("Password Okey!");
                        binding.LayoutPassword.setError("");
                    } else {
                        binding.LayoutPassword.setHelperText("");
                        binding.LayoutPassword.setError("Invalid Password, more than 8 characters and one special");
                    }
                } else {
                    binding.LayoutPassword.setHelperText("");
                    binding.LayoutPassword.setError("Invalid Password, more than 8 characters and one special");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstQuestion.class);
                startActivity(intent);
            }
        });



    }


}
