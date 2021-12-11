package min.dao;

import min.entity.Users;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDao_junitTest {
    ApplicationContext applicationContext = null;

    //如果不使用spring来支持junit，自己手动创建spring容器 自己去getBean对象 也可以的
    @Test
    public void testQueryRunner2() {
        applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring-mybatis.xml", "classpath:applicationContext.xml"}
        );
        UsersDao bean = applicationContext.getBean(UsersDao.class);
        Users min = bean.getByUsername("min");
        if (min != null) {
            System.out.println(min);
            System.out.println(min.getUsername());
        }
        Assert.assertNotNull(min);
    }
}
