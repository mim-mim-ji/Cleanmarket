package com.example.cleanmarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cleanmarket.cleanmarket_main.MarketMainActivity;
import com.google.android.material.textfield.TextInputEditText;

public  class CreateAccount extends AppCompatActivity {

    private EditText create_account_id,create_account_pw,create_account_name,create_account_email;
    private Button create_account_submit;
    //final EditText create_account_id, create_account_pw, create_account_name,create_account_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        //toolBar를 통해 App Bar 생성
        Toolbar toolbar = findViewById(R.id.create_account_toolbar);
        setSupportActionBar(toolbar); //툴바를 액션바와 같게 만들어줌

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        toolbar.setTitle("회원가입");

        //Intent intent = getIntent();

        //회원가입 버튼
        create_account_submit = findViewById(R.id.create_account_submit);
        create_account_id = findViewById(R.id.create_account_id);
        create_account_pw = findViewById(R.id.create_account_pw);
        create_account_name = findViewById(R.id.create_account_name);
        create_account_email = findViewById(R.id.create_account_email);

        create_account_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.create_account_submit:     // 회원가입 버튼
                        register();
                        Intent intent = new Intent(CreateAccount.this, CreateAccount_Result.class);
                        intent.putExtra("data",create_account_id.getText().toString()+"님 환영합니다");
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });

    }

    //서버와 연동하기
    void register(){
        Log.w("register", "회원가입 하는 중");
        try {
            String id = create_account_id.getText().toString();
            String pw = create_account_pw.getText().toString();
            String name = create_account_name.getText().toString();
            String email = create_account_email.getText().toString();
            Log.w("앱에서 보낸값",id+", "+pw+", "+name+", "+email);

            RegisterActivity register = new RegisterActivity();
            String result = register.execute(id, pw, name, email).get();
            Log.w("받은 값",result);

        } catch (Exception e){

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case R.id.create_account_home: {
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                finish();
                return true;
            }

            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
