package com.example.indu157.admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextInputEditText username, password, role;
    Button login;
    String get_username, get_password, get_role;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (TextInputEditText) findViewById(R.id.login_username);
        password = (TextInputEditText) findViewById(R.id.login_password);
        role = (TextInputEditText) findViewById(R.id.login_role);
        login = (Button) findViewById(R.id.login_button);
        container = (LinearLayout) findViewById(R.id.container);

        role.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] singleChoiceItems = getResources().getStringArray(R.array.dialog_single_choice_array);
                int itemSelected = 0;
                new AlertDialog.Builder(login.this)
                        .setTitle("Select your role")
                        .setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedIndex) {
                                Toast.makeText(login.this, "choice" +selectedIndex, Toast.LENGTH_SHORT).show();
                                get_role = singleChoiceItems[selectedIndex];
                                role.setText(get_role);
                            }
                        })
                        .show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*get_username = username.getText().toString().trim();
                get_password = password.getText().toString().trim();
                if(get_username.isEmpty() || get_password.isEmpty() || get_role.isEmpty()){
                    Snackbar.make(container, "Please fill all the details", Snackbar.LENGTH_SHORT).show();
                }
                else{


                }*/

             Intent i = new Intent("android.intent.action.MANAGE_TAILER");
                startActivity(i);

            }
        });
    }


}

