package com.example.surveymanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.surveymanagement.databinding.ActivityLastScreenBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastScreen extends AppCompatActivity {


    private ActivityLastScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLastScreenBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_last_screen);


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

        //Para obetener el correo de la view 2
        String email = getIntent().getExtras().getString("correo");
        binding.introduceEmail.setText(email);


        //Obtener una instancia sharedPreference
        SharedPreferences prefs = getSharedPreferences("MisCuentas", MODE_PRIVATE);


        String emailintroducido = binding.introduceEmail.getText().toString();
        String passwordintroducido = binding.eTextPassword.getText().toString();

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefs.contains("email")) {
                    String contraseñaguardada = prefs.getString("contraseña", "");
                    if (!passwordintroducido.equals(contraseñaguardada)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LastScreen.this);
                        builder.setMessage("La contraseña ingresada es incorrecta")
                                .setTitle("Error de inicio de sesión");
                        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), FirstQuestion.class);
                        startActivity(intent);
                    }
                } else {
                    // Si el correo electrónico no existe, guarda el correo electrónico y la contraseña en las pref
                    if (emailintroducido.contains("@")) {
                        prefs.edit()
                                .putString("email", emailintroducido)
                                .putString("contraseña", passwordintroducido)
                                .apply();
                        Intent intent = new Intent(getApplicationContext(), FirstQuestion.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LastScreen.this, "Email no valido", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }


}



