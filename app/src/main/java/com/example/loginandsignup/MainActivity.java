package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button register;
    EditText first;
    EditText last;
    EditText email;
    EditText user;
    EditText pass;
    Switch tog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        first = findViewById(R.id.first);
        last = findViewById(R.id.last);
        email = findViewById(R.id.email);
        register = findViewById(R.id.button);
         tog = findViewById(R.id.toggle);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String userName = user.getText().toString();
                String password = pass.getText().toString();

                // checking if the entered text is empty or not.
                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }

                // calling a method to register a user.
       //         registeruser(userName, password);
            }
        });

    }


}