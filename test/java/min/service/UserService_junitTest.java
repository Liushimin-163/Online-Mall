package min.service;

import min.entity.Users;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService_junitTest {
    ApplicationContext applicationContext = null;

    //如果不使用spring来支持junit，自己手动创建spring容器 自己去getBean对象 也可以的
    @Test
    public void testQueryRunner2() {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-mybatis.xml", "classpath:applicationContext.xml"});
        UserService bean = applicationContext.getBean(UserService.class);
        Users min = bean.get("min");
        Assert.assertNotNull(min);
    }
}
