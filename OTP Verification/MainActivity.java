package com.example.android.otp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.phone);
        findViewById(R.id.Continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editText.getText().toString();
                if(number.isEmpty() || number.length()<10)
                {
                    editText.setError("Valid number is required.");
                    editText.requestFocus();
                    return;
                }
                String phonenumber = "+91"+number;
                Intent intent = new Intent(MainActivity.this,VerifyPhone.class);
                intent.putExtra("phonenumber",phonenumber);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
