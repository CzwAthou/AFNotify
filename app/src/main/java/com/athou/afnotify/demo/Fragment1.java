package com.athou.afnotify.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.athou.afnotify.FunctionManager;
import com.athou.afnotify.R;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public class Fragment1 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment, null);

        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getInstance().invokeFunc(NO_PARAM_NO_RESULT);
            }
        });
        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getInstance().invokeFunc(PARAM_ONLY, "我是参数");
            }
        });
        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(FunctionManager.getInstance().invokeFunc(RESULT_ONLY, String.class));
            }
        });
        view.findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(FunctionManager.getInstance().invokeFunc(WITH_PARAM_AND_RESULT, "我是参数", String.class));
            }
        });
        return view;
    }
}
