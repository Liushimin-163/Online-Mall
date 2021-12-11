package min.dao;

import min.entity.Items;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemsDao {
    int deleteById(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectById(Integer id);

    int updateByIdSelective(Items record);

    int updateById(Items record);


    // 以下方法使用mybatis注解实现
    /**
     * 订单项列表
     * @paramOrdersid
     * @parampage
     * @paramrows
     * @return
     */
    @Select("select * from items where order_id=#{orderid}")
    public List<Items> getItemList(int orderid);

}
