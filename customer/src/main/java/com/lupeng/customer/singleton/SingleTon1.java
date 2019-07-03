package com.lupeng.customer.singleton;

/**
 * 单例模式 (双重校验锁法)
 */
public class SingleTon1 {
    private static volatile  SingleTon1 singleTon1;

    private  SingleTon1(){};

    public static  SingleTon1 getInstance(){
        if (singleTon1 == null) {
            synchronized (SingleTon1.class){
                if (singleTon1 == null) {
                    singleTon1 = new SingleTon1();
                }
            }
        }
        return  singleTon1;
    }
}
