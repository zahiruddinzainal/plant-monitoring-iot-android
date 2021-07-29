package com.example.androidphpmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private EditText Username, Email,Password;
private Button buttonRegister;
        TextView Login;
private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.editTextEmail);
        Username = (EditText) findViewById(R.id.editTextUsername);
        Password = (EditText) findViewById(R.id.editTextPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        Login = findViewById(R.id.textView2);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);
    }

    private void registerUser(){
        final String email =Email.getText().toString().trim();
        final String username =Username.getText().toString().trim();
        final String password =Password.getText().toString().trim();

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

            }
                })  {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("username",username);
                params.put("email",email);
                params.put("password",password);
                return params;


            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);




    }






    @Override
    public void onClick(View view){

        String username = Username.getText().toString();
        String email = Email.getText().toString();
        String pwd = Password.getText().toString();

        if(username.isEmpty()){
            Username.setError("Username not inserted");
            Username.requestFocus();
        }
        else if(email.isEmpty()){
            Email.setError("Email not inserted");
            Email.requestFocus();
        }
        else if(pwd.isEmpty()){
            Password.setError("Password not inserted");
            Password.requestFocus();
        }
        else if(username.isEmpty() && email.isEmpty() && pwd.isEmpty()){
            Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
        }


         buttonRegister.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openHomeActivity();
                 Intent i = new Intent(MainActivity.this,HomeActivity.class);
                 startActivity(i);
             }
         });

    }

        public void openHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        }
}