package com.rey.aplikasikeuangan3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Memanggil layout register

        dbHelper = new DBHelper(this); // Inisialisasi DBHelper

        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtConfirm = findViewById(R.id.edtConfirm);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLogin = findViewById(R.id.btnLogin);

        // Fungsi tombol Register
        btnRegister.setOnClickListener(view -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String confirmPass = edtConfirm.getText().toString().trim();

            if (password.equals(confirmPass)) {
                boolean inserted = dbHelper.insertUser(username, password);

                if (inserted) {
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(moveToLogin); // Pindah ke LoginActivity
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });

        // Fungsi tombol Login untuk kembali ke halaman login
        btnLogin.setOnClickListener(view -> {
            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(loginIntent); // Pindah ke LoginActivity
        });
    }
}
