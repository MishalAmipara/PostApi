package com.example.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://amiparaandroid.000webhostapp.com/Myapp/Register.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.


                        Log.d("====", "onResponse:" + response);


                        try {
                            JSONObject aa = new JSONObject(response);
                            int  con = aa.getInt("con");
                            int  suc = aa.getInt("success");


                            if(con==1)
                            {
                                if(suc==1)
                                {
                                    Toast.makeText(MainActivity.this, "User SuccessFully Refgister", Toast.LENGTH_SHORT).show();
                                }
                                else if(suc==2)
                                {
                                    Toast.makeText(MainActivity.this, "User already registered..", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this, "Not Connected..", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("====", "onErrorResponse:" + error.getLocalizedMessage());
            }
        })

        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap map = new HashMap();

                map.put("name", "Mishal");
                map.put("email", "hh@gmail.com");
                map.put("password", "123456");

                return map;
            }
        };

// Add the request to the RequestQueue.
        queue.add(stringRequest);

//        RetrofitInstanse.CallApi().RegisterData("sfsf", "zdsdf","sdfsdf","sfds","sfffsf").enqueue(new Callback<Registeruser>() {
//            @Override
//            public void onResponse(Call<Registeruser> call, Response<Registeruser> response) {
//                Log.d("=======", "onResponse: " + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Registeruser> call, Throwable t) {
//                Log.d("=======", "onResponse: " + t.getLocalizedMessage());
//
//            }
//        });

    }
}