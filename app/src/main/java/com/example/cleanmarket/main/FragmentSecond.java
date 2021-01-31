package com.example.cleanmarket.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.cleanmarket.R;
import com.example.cleanmarket.cleanmarket_main.MarketMainActivity;

public class FragmentSecond extends Fragment {

    ImageButton fragment_second_findstore,fragment_second_cleanmarket,fragment_second_delivery_apply;
    public FragmentSecond(){
    } //기본생성자

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_second, container, false);

        fragment_second_findstore = rootView.findViewById(R.id.fragment_second_findstore);
        fragment_second_cleanmarket = rootView.findViewById(R.id.fragment_second_cleanmarket);
        fragment_second_delivery_apply = rootView.findViewById(R.id.fragment_second_delivery_apply);


        //크린마켓 바로가기 버튼이 눌렸을때 조치
        fragment_second_cleanmarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarketMainActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
    }

}