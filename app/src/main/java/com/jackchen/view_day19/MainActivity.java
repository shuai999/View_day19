package com.jackchen.view_day19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jackchen.view_day19.baseUse.BaseUseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     *  基本使用
     * @param view
     */
    public void baseUseClick(View view){
        Intent intent = new Intent(MainActivity.this , BaseUseActivity.class) ;
        startActivity(intent);
    }
}
