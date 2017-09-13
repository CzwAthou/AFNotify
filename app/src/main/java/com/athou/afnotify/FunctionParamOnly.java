package com.athou.afnotify;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public abstract class FunctionParamOnly<Param> extends Function{
    public FunctionParamOnly(String function) {
        super(function);
    }

    public abstract void function(Param data);
}
