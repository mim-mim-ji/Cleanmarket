package com.example.cleanmarket.cleanmarket_main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.cleanmarket.R;
import com.example.cleanmarket.cleanmarket_main.market_main.Adapter;
import com.example.cleanmarket.cleanmarket_main.market_main.FragmentDashboard;
import com.example.cleanmarket.cleanmarket_main.market_main.FragmentHome;
import com.example.cleanmarket.cleanmarket_main.market_main.FragmentMyaccount;
import com.example.cleanmarket.cleanmarket_main.market_main.FragmentPlace;
import com.example.cleanmarket.cleanmarket_main.market_main.FragmentSearch;
import com.example.cleanmarket.main.MyAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MarketMainActivity extends AppCompatActivity {

    FragmentHome fragmentHome;
    FragmentDashboard fragmentDashboard;
    FragmentMyaccount fragmentMyaccount;
    FragmentPlace fragmentPlace;
    FragmentSearch fragmentSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_main);

//        //ViewPager
//        ViewPager viewPager = findViewById(R.id.market_view_pager);
//        //Adapter
//        Adapter myAdapter = new Adapter(getSupportFragmentManager(),5);
//        //viewPager와 adapter를 연결
//        viewPager.setAdapter(myAdapter);
//        //viewPager.setCurrentItem(1);

        //toolBar를 통해 App Bar 생성
        Toolbar toolbar = findViewById(R.id.market_toolbar);
        setSupportActionBar(toolbar); //툴바를 액션바와 같게 만들어줌
        ActionBar actionBar = getSupportActionBar();

        //actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setHomeButtonEnabled(true);

        //FragmentSecond에서 intent 받아옴
        Intent intent = getIntent();

        fragmentHome = new FragmentHome();
        fragmentDashboard = new FragmentDashboard();
        fragmentMyaccount = new FragmentMyaccount();
        fragmentPlace = new FragmentPlace();
        fragmentSearch = new FragmentSearch();

        // 초기화면 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commitAllowingStateLoss();

        //BottomNavigationView 정의
        BottomNavigationView navView = findViewById(R.id.market_nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commitAllowingStateLoss();
                        return true;

                    case R.id.navigation_dashboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentDashboard).commitAllowingStateLoss();
                        return true;

                    case R.id.navigation_place:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentPlace).commitAllowingStateLoss();
                        return true;

                    case R.id.navigation_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentSearch).commitAllowingStateLoss();
                        return true;

                    case R.id.navigation_myaccount:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMyaccount).commitAllowingStateLoss();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.market_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            //noinspection SimplifiableIfStatement
            case R.id.market_search: {

                return true;
            }

            case R.id.market_star:{

                return true;
            }
        }
        return super.onOptionsItemSelected(item);

    }



}
