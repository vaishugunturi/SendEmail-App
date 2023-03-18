package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {

    EditText Email,subject;
    EditText message;
    Button send;

    String userEmail,userSubject;
    String userMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Email = findViewById(R.id.editTextEmail);
        subject=findViewById(R.id.editTextSubject);
        message = findViewById(R.id.editTextMessage);
        send = findViewById(R.id.buttonsend);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userEmail=Email.getText().toString();
                userSubject=subject.getText().toString();
                userMessage=message.getText().toString();

                sendEmail(userEmail,userSubject,userMessage);

                Toast.makeText(MainActivity.this, "Email was send successfully", Toast.LENGTH_LONG).show();

            }
        });


    }

    public  void sendEmail(String userEmail,String userSubject,String userMessage)
    {
        String[] emailArray = {userEmail};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);


        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailArray);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT,userMessage);

        startActivity(Intent.createChooser(emailIntent,"Select Below option to send Email"));
    }
}