package min.dao;

import min.entity.Admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminsDao {
    int deleteById(Integer id);

    int insert(Admins record);

    int insertSelective(Admins record);

    Admins selectById(Integer id);

    int updateByIdSelective(Admins record);

    int updateById(Admins record);

    // 以下方法使用mybatis注解实现
    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    @Select("select * from admins where username=#{username}")
    public Admins getByUsername(String username);

    /**
     * 通过用户名和密码查找
     * @param username
     * @param password
     * @return 无记录返回null        
     */
    @Select("select * from admins where username=#{username} and password=#{password}")
    public Admins getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    /**
     * 获取列表
     * @param begin
     * @param size
     * @return 无记录返回空集合
     */
    @Select("select * from admins order by id desc limit #{begin}, #{size}")
    public List<Admins> getList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 总数
     * @return
     */
    @Select("select count(*) from admins")
    public long getTotal();

}
