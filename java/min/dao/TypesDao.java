package min.dao;


import min.entity.Types;
import min.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypesDao {
    int deleteById(Integer id);

    int insert(Types record);

    int insertSelective(Types record);

    Types selectById(Integer id);

    int updateByIdSelective(Types record);

    int updateById(Types record);
    /**
     * 获取列表
     * @return
     */
    @Select("select * from types order by num")
    public List<Types> getList();

}
