package com.example.advancedformvalidationapp;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextPasswordcheck;
    private Button buttonSubmit;


    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordcheck = findViewById(R.id.editTextPasswordcheck);
        buttonSubmit = findViewById(R.id.buttonSubmit);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){

                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String checkpassword = editTextPasswordcheck.getText().toString().trim();

                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić e-mail", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić prawidłowy adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić numer teleonu", Toast.LENGTH_SHORT).show();
                } else if (phone.length()<9) {
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić numer teleonu", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić hasło", Toast.LENGTH_SHORT).show();
                } else if (password.length()<=5) {
                    Toast.makeText(MainActivity.this, "Hasło musi posiadać co najmniej 6 znaków", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(checkpassword)) {
                    Toast.makeText(MainActivity.this, "Wprowadzone hasło jest niezgodne ze wcześniejszym", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz został przsłany poprawnie", Toast.LENGTH_SHORT).show();
                }

            }
        });
    };
}