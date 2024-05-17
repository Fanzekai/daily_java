package demo13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  9:49
 */
@Slf4j
public class proityExample implements InvocationHandler {

    private Proity proity;

    public void setObject(Proity proity) {
        this.proity = proity;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {


        log.info("学号2040129126");
        Object invoke = method.invoke(proity, args);
        log.info("老家汕头");
        return invoke;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), proity.getClass().getInterfaces(),this::invoke);
    }


    public static void main(String[] args) {

        Proity proity1 = new Proity();
        proityExample proityExample = new proityExample();
        proityExample.setObject(proity1);
         Proity proxy =(Proity) proityExample.getProxy();
         proxy.shuchu();

    }
}
