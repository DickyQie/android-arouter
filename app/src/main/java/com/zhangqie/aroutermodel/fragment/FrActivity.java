package com.zhangqie.aroutermodel.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhangqie.aroutermodel.R;
import com.zhangqie.order.bean.OrderBean;

import java.util.ArrayList;

@Route(path = "/app/fragment/FrActivity")
public class FrActivity extends AppCompatActivity {

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        initFragment();

        viewPager = findViewById(R.id.view_pager);
        ViewFragmentAdapter viewFragmentAdapter = new ViewFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewFragmentAdapter);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });


    }

    private void initFragment() {
        fragmentArrayList.add((Fragment) ARouter.getInstance().build("/app/fragment/ArFragment").withString("aaaa", "我是传递参数").navigation());
        fragmentArrayList.add((Fragment) ARouter.getInstance().build("/app/fragment/BrFragment").navigation());
        OrderBean ar = new OrderBean(2, "我是实体类参数");
        fragmentArrayList.add((Fragment) ARouter.getInstance().build("/app/fragment/CrFragment")
                .withLong("key1", 1111)
                .withString("key2", "传递参数测试")
                .withSerializable("key3", ar)
                .navigation());
    }


    class ViewFragmentAdapter extends FragmentPagerAdapter {

        public ViewFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
