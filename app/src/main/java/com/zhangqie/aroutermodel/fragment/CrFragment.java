package com.zhangqie.aroutermodel.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhangqie.aroutermodel.R;
import com.zhangqie.order.bean.OrderBean;


@Route(path = "/app/fragment/CrFragment")
public class CrFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cr_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String bundle = getArguments().getString("key2");
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(bundle);

        Long key1 = getArguments().getLong("key1");
        String key2 = getArguments().getString("key2");
        Log.i("aaaa","cccc="+key1+"---"+key2);

        OrderBean orderBean = (OrderBean) getArguments().getSerializable("key3");
        textView.setText("我是Id:"+orderBean.id+"---"+ orderBean.name);
        Log.i("aaaa","AA="+ orderBean.id+"---"+ orderBean.name);
    }

}
