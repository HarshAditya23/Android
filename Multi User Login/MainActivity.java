package com.example.android.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText _txtUser, _txtPass;
    Button _btnLogin;
    Spinner _spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtPass=(EditText)findViewById(R.id.txtPass);
        _txtUser=(EditText)findViewById(R.id.txtUser);
        _btnLogin=(Button)findViewById(R.id.btnlogin);
        _spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = _spinner.getSelectedItem().toString();
                if (_txtUser.getText().toString().equals("Admin") && _txtPass.getText().toString().equals("1234") && item.equals("Admin")) {
                    Intent intent = new Intent(MainActivity.this, admin.class);
                    startActivity(intent);
                }else if (_txtUser.getText().toString().equals("User") && _txtPass.getText().toString().equals("1234") && item.equals("User")) {
                    Intent intent = new Intent(MainActivity.this, user.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, wrong.class);
                    startActivity(intent);
                }
            }
        });
    }
}
