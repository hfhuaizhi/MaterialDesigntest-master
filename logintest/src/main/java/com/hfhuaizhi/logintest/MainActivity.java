package com.hfhuaizhi.logintest;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBt_test;
    private TextInputLayout mTl_username;
    private TextInputLayout mTl_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        mBt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        mTl_username.setEnabled(true);
        mTl_username.setError("你写错了哦，嘿嘿");
        startActivity(new Intent(getApplicationContext(),ScrollingActivity.class));
    }

    private void initView() {
        mBt_test = (Button) findViewById(R.id.bt_commit);
        mTl_username = (TextInputLayout) findViewById(R.id.tl_username);
        mTl_password = (TextInputLayout) findViewById(R.id.tl_password);
    }
}
