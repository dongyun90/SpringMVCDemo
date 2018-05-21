import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import test.Bean;
import test.HelloWorldImpl1;
import test.HelloWorldImpl2;
import test.Inter;

public class Main {
    @Autowired
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//        Inter a = (HelloWorldImpl1) context.getBean("impl1");
//        Inter b = (HelloWorldImpl2) context.getBean("impl2");
//        a.doPrint();
//        a.printHelloWorld();
//        b.doPrint();
//        b.printHelloWorld();
//        System.out.println(context.isTypeMatch("bean", Bean.class));
//        Bean bean = (Bean) context.getBean("bean");
//        System.out.println(bean);
//        bean.setA(0);
//        bean.setB(0);
//        Bean bean2 = (Bean) context.getBean("bean");
//        System.out.println(bean2);
//        ClassPathResource res = new ClassPathResource("spring/applicationContext.xml");
//        XmlBeanFactory factory = new XmlBeanFactory(res);
//        System.out.println(factory.containsBean("bean"));
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring/applicationContext.xml");
        Bean bean2 = (Bean) context.getBean("bean");
    }
}
