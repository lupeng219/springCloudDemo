package com.lupeng.customer.singleton;

/**
 * 单例模式 (Threadlocal)
 */
public class SingleTon4 {
    private static final ThreadLocal<SingleTon4> singleTon =
            new ThreadLocal<SingleTon4>(){
                @Override
                protected SingleTon4 initialValue(){
                    return  new SingleTon4();
                }
            };
    public static SingleTon4 getInstance(){
        return singleTon.get();
    }
    private SingleTon4(){}
}
