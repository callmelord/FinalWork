package com.example.finalwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashBoard extends AppCompatActivity {
    private String[] titles = {"Shelly Linestad","Lugh Belflare","Tachibana Yakumo","Camus Holmes","Lancelot","Gilbert Rainforth","Lydia","Flare"};
    private String[] prices = {"CV：白月かな","CV：鹿瀬紫卯","CV：蒼乃むすび","CV：小波すず","华丽的猫剑士","迷之猫","迷之魔女","谜之骑士"};
    private int[] icons = {
            R.drawable.chara01_img_pc, R.drawable.chara02_img_pc,R.drawable.chara03_img_pc,R.drawable.chara04_img_pc,
            R.drawable.chara13_img_pc,R.drawable.chara14_img_pc,R.drawable.chara19_img_pc,R.drawable.chara20_img_pc
    };
    private List<Goods> goods;


    private void initView() {
        ListView lvGoods = findViewById(R.id.lv_goods);
        BaseAdapter adapter = new GoodsAdapter(this, goods);
        lvGoods.setAdapter(adapter);
        lvGoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Goods good = (Goods) parent.getItemAtPosition(position);
            }
        });
    }

    private void initData() {
        goods = new ArrayList<>();
        for (int i = 0; i < titles.length; i++){
            goods.add(new Goods(titles[i], prices[i], icons[i]));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        initData();
        initView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dashboard:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext()
                                ,About.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.music:
                        startActivity(new Intent(getApplicationContext()
                                ,music.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext()
                                , user.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;

            }
        });


    }
}
