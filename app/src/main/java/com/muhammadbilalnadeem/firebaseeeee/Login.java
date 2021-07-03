package com.muhammadbilalnadeem.firebaseeeee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText editTextEmail , editTextPassword;
    Button btnCreateAccount;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail=  findViewById(R.id.editTextTextEmailAddress);
        editTextPassword= findViewById(R.id.editTextTextPassword);
        btnCreateAccount= findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAccount();

            }
        });
    }

    void loginAccount(){
        String email=editTextEmail.getText().toString().trim();
        String password =editTextPassword.getText().toString();
        Task<AuthResult> account_is_created = mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Account is Logged", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

}