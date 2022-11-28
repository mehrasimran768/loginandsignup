package com.example.loginandsignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    Button login;
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
        login = findViewById(R.id.button2);
         tog = findViewById(R.id.toggle);

         register.setVisibility(View.GONE);
        first.setVisibility(View.INVISIBLE);
        last.setVisibility(View.INVISIBLE);
        email.setVisibility(View.INVISIBLE);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String userName = user.getText().toString();
                String password = pass.getText().toString();
                if(user.getText().toString().equals("admin") &&
                        pass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                }
                // checking if the entered text is empty or not.
                else if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String firststr = first.getText().toString();
                String laststr = last.getText().toString();
                String emailstr = email.getText().toString();
                String userName = user.getText().toString();
                String password = pass.getText().toString();


                if (TextUtils.isEmpty(firststr)) {
                    Toast.makeText(MainActivity.this, "Please enter first name ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(laststr)) {
                    Toast.makeText(MainActivity.this, "Please enter last name ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(emailstr)) {
                    Toast.makeText(MainActivity.this, "Please enter email ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(MainActivity.this, "Please enter user name ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter password ", Toast.LENGTH_SHORT).show();
                } else {
                    // Create the object of AlertDialog Builder class
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    // Set the message show for the Alert time
                    builder.setMessage("Register the user?");

                    // Set Alert Title
                    builder.setTitle("Alert !");

                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                    builder.setCancelable(false);

                    // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // When the user click yes button then app will close
                        finish();
                    });

                    // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // If user click no then dialog box is canceled.
                        dialog.cancel();
                    });

                    // Create the Alert dialog
                    AlertDialog alertDialog = builder.create();
                    // Show the Alert Dialog box
                    alertDialog.show();
                }
            }
        });
        tog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    first.setVisibility(View.VISIBLE);
                    last.setVisibility(View.VISIBLE);
                    email.setVisibility(View.VISIBLE);
                    register.setVisibility(View.VISIBLE);
                    login.setVisibility(View.GONE);
                } else {
                    first.setVisibility(View.GONE);
                    last.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    register.setVisibility(View.GONE);
                    login.setVisibility(View.VISIBLE);

                }
            }
        });
    }


}