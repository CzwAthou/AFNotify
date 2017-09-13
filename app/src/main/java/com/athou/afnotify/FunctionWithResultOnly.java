package com.athou.afnotify;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public abstract class FunctionWithResultOnly<Result> extends Function {

    public FunctionWithResultOnly(String function) {
        super(function);
    }

    public abstract Result function();
}
