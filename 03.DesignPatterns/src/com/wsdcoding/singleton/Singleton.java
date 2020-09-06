package com.wsdcoding.singleton;

/**
 * @Description:
 * @Authror wsdcoding
 */
public enum  Singleton {
    INSTANCE;
    public void whateverMethod(){

    }
}
//静态内部类写法
//public class Singleton {
//    private static class SingletonInstance {
//        private static final Singleton singleton = new Singleton();
//    }
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return SingletonInstance.singleton;
//    }
//}
//DCL双重检查
//public class Singleton {
//    private static volatile Singleton singleton;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}
////懒汉式
//
//public class Singleton {
//    private static Singleton singleton;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                singleton = new Singleton();
//            }
//        }
//        return singleton;
//    }
//}
//变种饿汉式
//public class Singleton {
//    private static Singleton singleton;
//
//    static {
//        singleton = new Singleton();
//    }
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return singleton;
//    }
//}

////饿汉式
//public class Singleton {
//    //加载时就完成的实例，避免线程同步的问题
//    private static Singleton singleton = new Singleton();
//
//    private Singleton() {
//    }
//
//    //返回实例
//    public static Singleton getInstance() {
//        return singleton;
//    }
//}