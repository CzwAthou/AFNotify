package com.athou.afnotify.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.athou.afnotify.FunctionManager;
import com.athou.afnotify.FunctionNoParamNoResult;
import com.athou.afnotify.FunctionParamOnly;
import com.athou.afnotify.FunctionWithParamAndResult;
import com.athou.afnotify.FunctionWithResultOnly;
import com.athou.afnotify.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new Fragment1(), Fragment1.class.getName());
        ft.commit();
    }

    public void setFunc(String tag) {
        FunctionManager.getInstance().addFunction(new FunctionNoParamNoResult(BaseFragment.NO_PARAM_NO_RESULT) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "成功调用 =>> FunctionNoParamNoResult", Toast.LENGTH_SHORT).show();
            }
        });
        FunctionManager.getInstance().addFunction(new FunctionParamOnly<String>(BaseFragment.PARAM_ONLY) {
            @Override
            public void function(String data) {
                Toast.makeText(MainActivity.this, "成功调用 =>> FunctionParamOnly  参数：" + data, Toast.LENGTH_SHORT).show();
            }
        });
        FunctionManager.getInstance().addFunction(new FunctionWithResultOnly<String>(BaseFragment.RESULT_ONLY) {
            @Override
            public String function() {
                Toast.makeText(MainActivity.this, "成功调用 =>> FunctionWithResultOnly", Toast.LENGTH_SHORT).show();
                return "我是返回值";
            }
        });
        FunctionManager.getInstance().addFunction(new FunctionWithParamAndResult<String, String>(BaseFragment.WITH_PARAM_AND_RESULT) {
            @Override
            public String function(String data) {
                Toast.makeText(MainActivity.this, "成功调用 =>> FunctionWithParamAndResult  参数：" + data, Toast.LENGTH_SHORT).show();
                return "我是返回值";
            }
        });
    }
}
