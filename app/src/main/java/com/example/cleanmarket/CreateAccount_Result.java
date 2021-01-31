package com.example.cleanmarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount_Result extends AppCompatActivity {

    public CreateAccount_Result(){}

    TextView create_account_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_result);

        create_account_result = findViewById(R.id.create_account_result);

        Intent intent = getIntent();

//        Bundle bundle = intent.getExtras();
        //MainActivity에서 putExtra로 값을 보냈기 때문에 bundle을 만들고 만든 bundle로 값을 받아옴

//        String id = bundle.getString("id");
//        String pw = bundle.getString("pw");
//        String name = bundle.getString("name");
//        String email = bundle.getString("email");
//
//        create_account_result.setText("아이디: "+ id + "\n" +"비밀번호: " +pw);
//        create_account_result.setText("이름: "+ name + "\n" +"이메일: " +email); //값을 잘 가져왔는지 확인
    }

}
