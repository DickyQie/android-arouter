package com.zhangqie.aroutermodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                ARouter.getInstance().build("/app/demo1/DemoA").navigation();
                break;
            case R.id.btn2:
                ARouter.getInstance().build("/app/demo2/TestA").navigation();
                break;
            case R.id.btn3:
                ARouter.getInstance().build("/app/fragment/FrActivity").navigation();
                break;

        }
    }
}