package min.dao;

import min.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersDao {
    int deleteById(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectById(Integer id);

    int updateByIdSelective(Users record);

    int updateById(Users record);

    // 以下方法使用mybatis注解实现
    /**
     * 通过用户名查找用户
     * @return 无记录返回null
     */
    @Select("select * from users where username=#{username}")
    public Users getByUsername(String username);

    /**
     * 通过用户名和密码查找
     * @param username
     * @param password
     * @return 无记录返回null
     */
    @Select("select * from users where username=#{username} and password=#{password}")
    public Users getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    /**
     * 获取列表
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from users order by id desc limit #{begin}, #{size}")
    public List<Users> getList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 总数
     * @return
     */
    @Select("select count(*) from users")
    public long getTotal();
}
