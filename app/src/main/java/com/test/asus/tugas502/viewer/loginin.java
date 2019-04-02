package com.test.asus.tugas502.viewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toast;

import com.test.asus.tugas502.R;

public class loginin  extends AppCompatActivity{
    EditText username,password;
    Button btnMasuk, btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        btnMasuk = (Button) findViewById(R.id.btn_masuk);

        btnMasuk.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if(usernameKey.equals("ADMIN") && passwordKey.equals("admin")){
                    Toast.makeText(getApplicationContext(), "Login Succes",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginin.this, MainActivity.class);
                    loginin.this.startActivity(intent);
                    finish();;
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(loginin.this);
                    builder.setMessage("Username or Password Invalid!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}