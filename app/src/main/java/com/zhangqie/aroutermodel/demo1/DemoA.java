package com.zhangqie.aroutermodel.demo1;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhangqie.aroutermodel.R;
import com.zhangqie.aroutermodel.bean.ARouterBean;

/**
 * Created by zhangqie on 2018/9/12
 * Describe:
 */

@Route(path = "/app/demo1/DemoA")
public class DemoA extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1_a);
        initView();
    }

    void initView(){
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("content","我是demo1传递的内容");
                ARouter.getInstance().build("/app/demo1/DemoB").withBundle("bundle",bundle).navigation();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouterBean ar = new ARouterBean(2,"我是实体类参数");
                ARouter.getInstance().build("/app/demo1/DemoC")
                        .withLong("key1", 1111)
                        .withString("key2","传递参数测试")
                        .withSerializable("key3",ar)
                        .navigation();
            }
        });
    }

}
