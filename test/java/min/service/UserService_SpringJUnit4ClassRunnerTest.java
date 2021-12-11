package min.service;

import min.entity.Users;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = SpringConfiguration.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:applicationContext.xml"})
public class UserService_SpringJUnit4ClassRunnerTest {
    @Autowired
    private UserService userService = null;


    @Test
    public void testFindAll() {
        //3.执行方法
        Users min = userService.get("min");
        Assert.assertNotNull(min);
    }
}
