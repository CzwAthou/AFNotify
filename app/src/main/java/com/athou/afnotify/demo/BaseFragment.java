package com.athou.afnotify.demo;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.athou.afnotify.FunctionManager;
import com.athou.afnotify.FunctionNoParamNoResult;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public class BaseFragment extends Fragment{

    public static final String NO_PARAM_NO_RESULT = Fragment1.class.getSimpleName() + "NPNR";
    public static final String PARAM_ONLY = Fragment1.class.getSimpleName() + "PO";
    public static final String RESULT_ONLY = Fragment1.class.getSimpleName() + "RO";
    public static final String WITH_PARAM_AND_RESULT = Fragment1.class.getSimpleName() + "WPAR";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            ((MainActivity) context).setFunc(getTag());
        }
    }
}
