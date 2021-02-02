package com.zhangqie.aroutermodel.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhangqie.aroutermodel.R;
import com.zhangqie.aroutermodel.bean.ARouterBean;
import com.zhangqie.login.api.LoginARouterUrl;
import com.zhangqie.order.api.OrderARouterUrl;
import com.zhangqie.order.bean.OrderBean;

/**
 * Created by zhangqie on 2018/9/12
 * Describe: 模块跳转
 */

@Route(path = "/app/demo2/TestA")
public class TestA extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo2_a);

        textView = findViewById(R.id.tv_text);
        initView();
    }

    void initView(){
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("content","跳转到登录模块下传递内容_Login");
                ARouter.getInstance().build(LoginARouterUrl.Login).withBundle("bundle",bundle).navigation();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转并携带参数返回   RequestCode设置成大于0的值
                OrderBean ar = new OrderBean(2,"我是实体类参数");
                ARouter.getInstance().build(OrderARouterUrl.Order)
                        .withLong("key1", 1111)
                        .withString("key2","传递参数测试")
                        .withSerializable("key3",ar)
                        .navigation(TestA.this,5);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == 1){
            textView.setText("返回参数=="+data.getStringExtra("dataresult"));
            Toast.makeText(this, data.getStringExtra("dataresult"),Toast.LENGTH_SHORT).show();
        }
    }


}
