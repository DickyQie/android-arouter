package com.zhangqie.order;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhangqie.order.api.OrderARouterUrl;
import com.zhangqie.order.bean.OrderBean;

/**
 * Created by zhangqie on 2018/9/12
 * Describe: 登录模块接收参数
 */

@Route(path = OrderARouterUrl.Order)
public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_order);

        TextView textView = findViewById(R.id.textView);

        Long key1 = getIntent().getLongExtra("key1",11);
        String key2 = getIntent().getStringExtra("key2");
        Log.i("aaaa","cccc="+key1+"---"+key2);


        OrderBean orderBean = (OrderBean) getIntent().getSerializableExtra("key3");
        textView.setText("我是Id:"+orderBean.id+"---"+ orderBean.name);

        Log.i("aaaa","AA="+ orderBean.id+"---"+ orderBean.name);


        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("dataresult","OrderActivity");
                setResult(1,intent);
                finish();
            }
        });
    }
}
