package com.yl.learn.dp.proxy.impl;

import com.yl.learn.dp.proxy.AfterInvokeHandler;
import com.yl.learn.dp.proxy.DynamicProxy;
import com.yl.learn.util.util.PrintUtil;

/**
 * 打印对象代理
 * @author YuanLi
 */
public class PrintObjectChangeProxy extends DynamicProxy {

    public PrintObjectChangeProxy(Object proxied, AfterInvokeHandler afterInvokeHandler) {
        super(proxied, afterInvokeHandler);
    }

    @Override
    public void preInvoke() {
        PrintUtil.println(proxied);
    }
}
