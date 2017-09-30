package com.hfhuaizhi.materialdesigntest;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout activity_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        Button bt_test = (Button) findViewById(R.id.bt_test);
        bt_test.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showSnackbar();
                return false;
            }
        });
    }

    private void showSnackbar() {
        Snackbar.make(activity_main,"哈哈哈",Snackbar.LENGTH_LONG).setAction("点击事件", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"点了",Toast.LENGTH_SHORT).show();
            }
        }).setDuration(Snackbar.LENGTH_LONG).show();
    }
}
