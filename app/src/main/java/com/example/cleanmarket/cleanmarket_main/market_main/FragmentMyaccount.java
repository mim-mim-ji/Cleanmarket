package com.example.cleanmarket.cleanmarket_main.market_main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.cleanmarket.R;

public class FragmentMyaccount extends Fragment {

    public FragmentMyaccount(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.market_fragment_myaccount, container, false);
    }
}
