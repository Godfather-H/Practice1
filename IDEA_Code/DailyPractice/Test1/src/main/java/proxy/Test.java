package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    interface Subject {
        void request();
    }

    static class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("RealSubject: Handling request.");
        }
    }

    static class SubjectProxy {
        public static Subject createSubject(RealSubject realSubject) {
            Subject subject = (Subject) Proxy.newProxyInstance(
                    Subject.class.getClassLoader(),
                    new Class<?>[]{Subject.class},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("Before method call");
                            Object result = method.invoke(realSubject, args);
                            System.out.println("After method call");
                            return result;
                        }
                    }
            );
            return subject;
        }
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject subject = SubjectProxy.createSubject(realSubject);
        subject.request();
    }

}
