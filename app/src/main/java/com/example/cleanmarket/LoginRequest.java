package com.example.cleanmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginRequest extends AppCompatActivity {

    TextView textView_get;

    public LoginRequest(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_result);

        textView_get = findViewById(R.id.textView_get);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        //MainActivity에서 putExtra로 값을 보냈기 때문에 bundle을 만들고 만든 bundle로 값을 받아옴

        String email = bundle.getString("email");
        String password = bundle.getString("password");

        textView_get.setText("이메일: "+ email + "\n" +"비밀번호: " +password); //값을 잘 가져왔는지 확인
    }

}
