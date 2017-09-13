package com.athou.afnotify;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by sy-caizhaowei on 2017/9/13.
 */

public class FunctionManager {
    private static final FunctionManager instance = new FunctionManager();

    private HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private HashMap<String, FunctionParamOnly> mFunctionParamOnly;
    private HashMap<String, FunctionWithResultOnly> mFunctionWithResultOnly;
    private HashMap<String, FunctionWithParamAndResult> mFunctionWithParamAndResult;

    private FunctionManager() {
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionParamOnly = new HashMap<>();
        mFunctionWithResultOnly = new HashMap<>();
        mFunctionWithParamAndResult = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        return instance;
    }

    public void addFunction(FunctionNoParamNoResult func) {
        mFunctionNoParamNoResult.put(func.getFunctionName(), func);
    }

    public void invokeFunc(String funcName) {
        if (TextUtils.isEmpty(funcName)) {
            return;
        }
        if (mFunctionNoParamNoResult != null) {
            FunctionNoParamNoResult f = mFunctionNoParamNoResult.get(funcName);
            if (f != null) {
                f.function();
            } else {
                try {
                    throw new FunctionException("Has no this Function in");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addFunction(FunctionParamOnly func) {
        mFunctionParamOnly.put(func.getFunctionName(), func);
    }

    public <Param> void invokeFunc(String funcName, Param data) {
        if (TextUtils.isEmpty(funcName)) {
            return;
        }
        if (mFunctionParamOnly != null) {
            FunctionParamOnly f = mFunctionParamOnly.get(funcName);
            if (f != null) {
                f.function(data);
            } else {
                try {
                    throw new FunctionException("Has no this Function in");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addFunction(FunctionWithResultOnly func) {
        mFunctionWithResultOnly.put(func.getFunctionName(), func);
    }

    public <Result> Result invokeFunc(String funcName, Class<Result> resultClass) {
        if (TextUtils.isEmpty(funcName)) {
            return null;
        }
        if (mFunctionWithResultOnly != null) {
            FunctionWithResultOnly f = mFunctionWithResultOnly.get(funcName);
            if (f != null) {
                if (resultClass != null) {
                    return resultClass.cast(f.function());
                }
                return (Result) f.function();
            } else {
                try {
                    throw new FunctionException("Has no this Function in");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void addFunction(FunctionWithParamAndResult func) {
        mFunctionWithParamAndResult.put(func.getFunctionName(), func);
    }

    public <Result, Param> Result invokeFunc(String funcName, Param data, Class<Result> resultClass) {
        if (TextUtils.isEmpty(funcName)) {
            return null;
        }
        if (mFunctionWithParamAndResult != null) {
            FunctionWithParamAndResult f = mFunctionWithParamAndResult.get(funcName);
            if (f != null) {
                if (resultClass != null) {
                    return resultClass.cast(f.function(data));
                }
                return (Result) f.function(data);
            } else {
                try {
                    throw new FunctionException("Has no this Function in");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
