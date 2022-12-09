package com.example.surveymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.surveymanagement.databinding.ActivityFirstQuestionBinding;

public class FirstQuestion extends AppCompatActivity {
    private ActivityFirstQuestionBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondQuestion.class);
                startActivity(intent);
            }
        });


    }

    public void onCheckBoxClick(View view) {
        boolean checked = ((com.google.android.material.checkbox.MaterialCheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.check1:
                if (checked) {
                    binding.check1.setBackgroundResource(R.drawable.button_shape_part2_clicked);
                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.getExtras().getString("check1",binding.check1.getText().toString());

                }else{
                    binding.check2.setBackgroundResource(R.drawable.noclickedshape);
                }break;
            case R.id.check2:
                if (checked) {
                    binding.check2.setBackgroundResource(R.drawable.button_shape_part2_clicked);
                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.getExtras().getString("check2",binding.check2.getText().toString());

                }else{
                    binding.check2.setBackgroundResource(R.drawable.noclickedshape);
                }break;
            case R.id.check3:
                if (checked) {
                    binding.check3.setBackgroundResource(R.drawable.button_shape_part2_clicked);
                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.getExtras().getString("check3",binding.check3.getText().toString());

                }else{
                    binding.check2.setBackgroundResource(R.drawable.noclickedshape);
                }break;
            case R.id.check4:
                if (checked) {
                    binding.check4.setBackgroundResource(R.drawable.button_shape_part2_clicked);
                    Intent intent = new Intent(getApplicationContext(),Result.class);
                    intent.getExtras().getString("check4",binding.check4.getText().toString());

                }else{
                    binding.check2.setBackgroundResource(R.drawable.noclickedshape);
                }break;
    }
}
}