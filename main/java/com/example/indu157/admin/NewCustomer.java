package com.example.admin1.stitchger_android;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import okhttp3.OkHttpClient;

public class NewCustomer extends AppCompatActivity {

    EditText name, mob, addr;
    Button submit;
    OkHttpClient client;
    public static final String HttpURL = "https://stitchger.000webhostapp.com/insertCustomer.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    String finalResult, customerName, customerMob, customerAddr;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_customer);
        name = (EditText) findViewById(R.id.new_customer_name);
        mob = (EditText) findViewById(R.id.new_customer_mob);
        addr = (EditText) findViewById(R.id.new_customer_addr);
        submit = (Button) findViewById(R.id.new_customer_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    // If EditText is not empty and CheckEditText = True then this block will execute.

                    CustomerRegistration(customerName,customerMob, customerAddr);

                }
                else {

                    // If EditText is empty then this block will execute .
                    Toast.makeText(NewCustomer.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public void CustomerRegistration(final String S_Name, final String S_Phone, final String S_Class){

        class CustomerRegistrationClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(NewCustomer.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(NewCustomer.this,httpResponseMsg, Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("customerName",params[0]);

                hashMap.put("customerMobile",params[1]);

                hashMap.put("customerAddress",params[2]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        CustomerRegistrationClass customerRegistrationClass = new CustomerRegistrationClass();

        customerRegistrationClass.execute(S_Name,S_Phone,S_Class);
    }


    public void CheckEditTextIsEmptyOrNot(){

        customerName = name.getText().toString().trim();
        customerMob = mob.getText().toString().trim();
        customerAddr = addr.getText().toString().trim();

        Log.e("test", "name "+customerName+"  "+customerMob+"  "+customerAddr);

        if(TextUtils.isEmpty(customerName) || TextUtils.isEmpty(customerMob) || TextUtils.isEmpty(customerAddr))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }
}
