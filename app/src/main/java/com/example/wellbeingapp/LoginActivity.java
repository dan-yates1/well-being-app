package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private Button btnLogin, btnGoogleLogin;
    private EditText etEmail, etPassword;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        // check if user is already signed in
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        initInterface();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpTextView:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.loginButton:
                login();
            case R.id.googleLoginButton:
                break;
        }
    }

    private void login() {
        mAuth.signInWithEmailAndPassword(etEmail.getText().toString().trim(),
                        etPassword.getText().toString().trim())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "User logged in successfully!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void initInterface() {
        tvSignUp = findViewById(R.id.signUpTextView);
        tvSignUp.setOnClickListener(this);
        btnGoogleLogin = findViewById(R.id.googleLoginButton);
        btnGoogleLogin.setOnClickListener(this);
        btnLogin = findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(this);
        etEmail = findViewById(R.id.emailEditText2);
        etPassword = findViewById(R.id.passwordEditText2);
    }
}