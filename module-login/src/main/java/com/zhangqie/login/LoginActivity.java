package com.zhangqie.login;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhangqie.login.api.LoginARouterUrl;

/**
 * Created by zhangqie on 2018/9/12
 * Describe: 登录模块接收参数
 */

@Route(path = LoginARouterUrl.Login)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);

        TextView textView = findViewById(R.id.textView);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        textView.setText(bundle.getString("content"));


        findViewById(R.id.ivCha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//去主页app的Activity
                Bundle bundle = new Bundle();
                bundle.putString("content","我是登录下跳转的内容");
                ARouter.getInstance().build("/app/demo1/DemoB").withBundle("bundle",bundle).navigation();
            }
        });
    }
}
