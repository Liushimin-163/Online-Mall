package min.dao;

import min.entity.SkuColor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SkuColorDao {
    int deleteById(Integer id);

    int insert(SkuColor record);

    int insertSelective(SkuColor record);

    SkuColor selectById(Integer id);

    int updateByIdSelective(SkuColor record);

    int updateById(SkuColor record);

    // 以下方法使用mybatis注解实现
    /**
     * 获取列表
     * @return
     */
    @Select("select * from sku_color order by id desc")
    public List<SkuColor> getList();

    /**
     * 获取列表
     * @return
     */
    @Select("select * from sku_color where id in (select color_id from sku_good where good_id=#{goodid})")
    List<SkuColor> getListByGoodid(int goodid);
}
