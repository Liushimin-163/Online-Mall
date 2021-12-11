package min.dao;

import min.entity.SkuSize;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SkuSizeDao {
    int deleteById(Integer id);

    int insert(SkuSize record);

    int insertSelective(SkuSize record);

    SkuSize selectById(Integer id);

    int updateByIdSelective(SkuSize record);

    int updateById(SkuSize record);

    // 以下方法使用mybatis注解实现
    /**
     * 获取列表
     * @return
     */
    @Select("select * from sku_size order by id desc")
    public List<SkuSize> getList();


    /**
     * 获取列表
     * @return
     */
    @Select("select * from sku_size where id in (select size_id from sku_good where good_id=#{goodid})")
    List<SkuSize> getListByGoodid(int goodid);

}
