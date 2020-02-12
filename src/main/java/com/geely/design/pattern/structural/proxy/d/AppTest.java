package com.geely.design.pattern.structural.proxy.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 针对于c包中的问题,使用jdk中的api:动态代理。
 */

interface ICalc {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}

class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {

        int r =a+b;
        return r;
    }

    @Override
    public int sub(int a, int b) {
        int r =a-b;
        return r;
    }

    @Override
    public int mul(int a, int b) {
        int r =a*b;
        return r;
    }

    @Override
    public int div(int a, int b) {
        int r =a/b;
        return r;
    }
}

// ===============================================================
class MyHandler implements InvocationHandler {

    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + "开始，参数是" + Arrays.toString(args));

        // 这里运用了反射机制
        // target传入的是真实的方法
        Object r = method.invoke(target, args);
        System.out.println(method.getName() + "结束，结果是" + r);

        // 这里随便写个0，如果return null 会报空指针异常
        return 0;
    }
}

public class AppTest {

    public static void main(String[] args) {

        // 目标对象(真实对象)
        CalcImpl calc = new CalcImpl();
        calc.add(1,2);

        // 创建代理对象:
        // 第一个参数，ClassLoader
        // 我们都知道,要实例化一个对象,是需要调用类的构造器的,在程序运行期间第一次调用构造器时,就会引起类的加载,
        //加载类的时候,就是jvm拿 class着 Loader去加载类的字节码的,只有字节码被加载到了内存中,才能进一步去实例化出类的对象。
        //简单来说,就是只要涉及实例化类的对象就一定要加载类的字节码,而加载字节码就必须使用类加载器
        //下面我们使用的是动态代理的api来创建一个类的对象,这是一种不常用的实例化类对象的方式,尽管不常用,但毕竟涉及实例化类的对象
        //那就一定也需要加载类的字节码,也就一定需要类加载器,所以我们手动把类加载器传入
        ClassLoader cl = AppTest.class.getClassLoader();

        // 第2个参数: Class[]
        //我们已经知道,下面的代码,是用来实例化一个对象的,实例化对象,就一定是实例化某一个类的对象,问题是,到底是哪个类呢?
        //类在哪里?字节码又在哪里?这个类,其实并不在硬盘上,而是在内存中!是由动态代理在内存中“动态”生成的!(见本包的图)
        //要知道,这个在内存中直接生成的字节码,会去自动实现下面方法中的第2个参数中,所指定的接口!
        // 所以,利用动态代理生成的代理对象,就能转成ICa1c接口类型!那么这个代理对象就拥有 add sub mul div方法

        // 第3个参数: InvocationHandler
        //我们已经知道,下面的代理对象porxy所属的类,实现了ICa1c接口,所以,这个代理对象就拥有 add sub mul div方法
        //我们就可以通过代理对象调用 add sub mul div方法!
        //注意,每次对代理对象任何方法的调用,都不会进入真正的实现方法中。而是统统进入第3个参数的 invoke方法中!
        ICalc proxy = (ICalc) Proxy.newProxyInstance(cl, new Class[]{ICalc.class}, new MyHandler(calc));

        // 这里对应MyHandler.invoke方法
        // Object proxy 就是下面的proxy
        // Method method 就是add
        // Object[] args 就是(2,3)
        proxy.add(2,3);
    }
}
