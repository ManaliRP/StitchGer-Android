package com.example.indu157.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_tailer extends AppCompatActivity {

    EditText ET_ID, ET_FNAME, ET_MOB, ET_JOIN_DATE, ET_SAL;
    String id, f_name, mob, joindate, sal;
    Button savetailer,canceltailer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tailer);

        ET_ID = (EditText) findViewById(R.id.etid);
        ET_FNAME = (EditText) findViewById(R.id.new_user_name);
        ET_MOB = (EditText) findViewById(R.id.mobinumber);
        ET_JOIN_DATE = (EditText) findViewById(R.id.joindate);
        ET_SAL = (EditText) findViewById(R.id.salary);

        savetailer = (Button)findViewById(R.id.save);
        canceltailer = (Button)findViewById(R.id.cancel);

        savetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(add_tailer.this, manage_tailer.class));
            }
        });

        canceltailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(add_tailer.this, manage_tailer.class));
            }
        });


    }
}

