package com.athou.afnotify;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public abstract class FunctionWithParamAndResult<Result, Param> extends Function {
    public FunctionWithParamAndResult(String function) {
        super(function);
    }

    public abstract Result function(Param param);
}
