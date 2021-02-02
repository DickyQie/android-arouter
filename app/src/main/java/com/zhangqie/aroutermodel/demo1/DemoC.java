package com.zhangqie.aroutermodel.demo1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhangqie.aroutermodel.R;
import com.zhangqie.aroutermodel.bean.ARouterBean;

/**
 * Created by zhangqie on 2018/9/12
 * Describe:
 */

@Route(path = "/app/demo1/DemoC")
public class DemoC extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1_b);
        initView();

    }

    private void initView(){
        TextView textView = (TextView) findViewById(R.id.tv1);
        Long key1 = getIntent().getLongExtra("key1",11);
        String key2 = getIntent().getStringExtra("key2");
        textView.setText(key2);


        ARouterBean ARouterBean = (ARouterBean) getIntent().getSerializableExtra("key3");
        TextView textView2 = (TextView) findViewById(R.id.tv2);
        textView2.setText("我是Id:"+ARouterBean.id+"---"+ ARouterBean.name);


        Log.i("aaaa","cccc="+key1+"---"+key2);
        Log.i("aaaa","AA="+ ARouterBean.id+"---"+ ARouterBean.name);

    }
}
