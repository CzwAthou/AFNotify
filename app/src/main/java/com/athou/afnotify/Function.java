package com.athou.afnotify;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public abstract class Function {
    String functionName;

    public Function(String function) {
        this.functionName = function;
    }

    public String getFunctionName() {
        return functionName;
    }
}
