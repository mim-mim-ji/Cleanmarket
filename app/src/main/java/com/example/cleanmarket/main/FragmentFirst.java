package com.example.cleanmarket.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cleanmarket.CreateAccount;
import com.example.cleanmarket.LoginRequest;
import com.example.cleanmarket.R;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentFirst extends Fragment {

    private TextInputEditText TextInputEditText_email, TextInputEditText_password;
    private Button FragmentFirst_login,find_id,re_pw,create_account;

    //DB 구축 전이라 입력값과 비교
    String emailOk = "abc1234@naver.com";
    String passwordOk = "1234";
    String inputEmail = null, inputPassword = null;

    public FragmentFirst(){

    } //기본생성자

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_first, container, false);

        TextInputEditText_email = rootView.findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = rootView.findViewById(R.id.TextInputEditText_password);
        FragmentFirst_login = rootView.findViewById(R.id.FragmentFirst_login);

        // 로그인 버튼 비활성화
        FragmentFirst_login.setEnabled(false);

        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            //// 입력하기 전에 조치
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            // 입력란에 변화가 있을 시 조치(변화와 동시에 처리)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();
                inputEmail = email;
                inputPassword = password;

                //입력된 값이 null이 아닐 때 입력값과 정해준 변수값이 같을 때 로그인버튼 활성화
                if (inputEmail != null && inputPassword != null ){
                    if(validation_input()){
                        validation_FragmentFirst_login();
                    }
                }
            }
            // 입력이 끝났을 때 조치
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            //// 입력하기 전에 조치
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            // 입력란에 변화가 있을 시 조치(변화와 동시에 처리)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();
                inputEmail = email;
                inputPassword = password;

                //입력된 값이 null이 아닐 때 입력값과 정해준 변수값이 같을 때 로그인버튼 활성화
                if (inputEmail != null && inputPassword != null ){
                    if(validation_input()){
                        validation_FragmentFirst_login();
                    }
                }
            }
            // 입력이 끝났을 때 조치
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        find_id = rootView.findViewById(R.id.find_id);
        re_pw = rootView.findViewById(R.id.re_pw);


        create_account = rootView.findViewById(R.id.create_account);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateAccount.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


    public boolean validation_input(){
        return inputEmail.equals(emailOk) && inputPassword.equals(passwordOk);
    }

    public void validation_FragmentFirst_login(){
        //버튼 활성화
        FragmentFirst_login.setEnabled(true);

        //사용자가 이메일과 비밀번호를 입력한 후 로그인 버튼을 클릭했을 때 값을 받아옴
        FragmentFirst_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = TextInputEditText_email.getText().toString(); //값을 가져온다
                String password = TextInputEditText_password.getText().toString();

                Intent intent = new Intent(getActivity(), LoginRequest.class); //어디로 값을 던질지 설정
                intent.putExtra("email",email); //이메일 값 넣기
                intent.putExtra("password", password); //비밀번호 값 넣기
                //putExtra : key와 value 를 이용하여 값을 찾아온다
                startActivity(intent); //다음 액티비티로 값 던지기 시작
            }
        });

    }

}