package com.lupeng.customer.singleton;

/**
 * 单例模式 (静态内部类)
 */
public class SingleTon3 {
   private static class SingletonHolder{
       private static  SingleTon3 singleTon1 = new SingleTon3();
   }
   private SingleTon3(){}

   public static SingleTon3 getInstan(){
       return SingletonHolder.singleTon1;
   }

}
