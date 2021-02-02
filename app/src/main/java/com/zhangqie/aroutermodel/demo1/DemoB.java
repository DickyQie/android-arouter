package com.zhangqie.aroutermodel.demo1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhangqie.aroutermodel.R;

/**
 * Created by zhangqie on 2018/9/12
 * Describe: 接收参数
 */

@Route(path = "/app/demo1/DemoB")
public class DemoB extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1_b);
        initView();
    }

    private void initView(){
        TextView textView = (TextView) findViewById(R.id.tv1);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        textView.setText(bundle.getString("content"));

    }

}
