package com.example.finalwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class user extends AppCompatActivity {
    String username;
    String userpasswd;
    Button btn;
    LinearLayout userlogin_layout;
    LinearLayout userinfo_layout;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userlogin_layout = findViewById(R.id.userlogin_layout);
        userinfo_layout = findViewById(R.id.userinfo_layout);
        btn = findViewById(R.id.confirm_button);
        user = findViewById(R.id.username);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_name =(EditText)findViewById(R.id.username_edit);
                username=editText_name.getText().toString();
                EditText editText_passwd =(EditText)findViewById(R.id.userpasswd_edit);
                userpasswd=editText_passwd.getText().toString();

                if (username == null || userpasswd == null) {
                    Toast.makeText(user.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                }
                else if (!username.equals("aaa") || !userpasswd.equals("aaa")) {
                    Toast.makeText(user.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
                else if (username.equals("aaa") || userpasswd.equals("aaa")) {
                    Toast.makeText(user.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    userlogin_layout.setVisibility(View.GONE);
                    user.setText(username);
                    userinfo_layout.setVisibility(View.VISIBLE);
                }
            }
        });







        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.user:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                ,DashBoard.class));
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
                }
                return false;

            }
        });


    }
}