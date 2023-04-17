package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    EditText email,pwd;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // registerApi();

        email=findViewById(R.id.etEmail);
        pwd=findViewById(R.id.etPwd);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
                System.out.println("Button Clicked..");
            }
        });


    }

    private void checkLogin()
    {
        String str1=email.getText().toString();
        String str2=pwd.getText().toString();

        RetrofitInstanse.CallApi().Login(str1,str2).enqueue(new Callback<Registeruser>() {
            @Override
            public void onResponse(Call<Registeruser> call, Response<Registeruser> response)
            {
                System.out.println("Hello");
                Log.d("bbb", "Connection: "+response.body().getConnection()+"Result="+response.body().getResult());
                if (response.body().getConnection()==1)
                {
                    if(response.body().getResult()==1)
                    {
                        Toast.makeText(MainActivity2.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else if(response.body().getResult()==2)
                    {
                        Toast.makeText(MainActivity2.this, "Already Logged in", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity2.this, "Something went wrong..", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Registeruser> call, Throwable t) {

            }
        });
    }

    private void registerApi()
    {
        RetrofitInstanse.CallApi().
                RegisterData("AAA","aaa@gmail.com","123123")
                .enqueue(new Callback<Registeruser>() {
                    @Override
                    public void onResponse(Call<Registeruser> call, Response<Registeruser> response) {
                        if (response.body().getConnection()==1)
                        {
                            if(response.body().getResult()==1)
                            {
                                Toast.makeText(MainActivity2.this, "User Rgistered Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else if(response.body().getResult()==2)
                            {
                                Toast.makeText(MainActivity2.this, "User already Registered", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity2.this, "Something went wrong..", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Registeruser> call, Throwable t) {

                    }
                });
    }

}
