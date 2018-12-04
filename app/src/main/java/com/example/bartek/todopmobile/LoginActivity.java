package com.example.bartek.todopmobile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    String URL = "http://192.168.0.2:8080/";
    public void tapLogin(View v) {
        //http://localhost:8080/user?user=User&password=qwerty
        EditText login = (EditText)findViewById(R.id.editLogin);
        EditText password = (EditText)findViewById(R.id.editPassword);
        Log.e("Rest Response" , URL + "user?user="+ login.getText() + "&password=" + password.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e("Rest Response" , "I'm in");


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response" , response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response" , error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }
}