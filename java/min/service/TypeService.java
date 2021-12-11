package min.service;

import min.dao.TypesDao;
import min.entity.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeService {
    @Autowired
    private TypesDao typeDao;


    /**
     * 获取列表
     * @return
     */
    public List<Types> getList(){
        return typeDao.getList();
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Types get(int id) {
        return typeDao.selectById(id);
    }

    /**
     * 添加
     * @param type
     * @return
     */
    public Integer add(Types type) {
        return typeDao.insert(type);
    }

    /**
     * 更新
     * @param type
     */
    public boolean update(Types type) {
        return typeDao.updateById(type) > 0;
    }

    /**
     * 删除
     * @param type
     */
    public boolean delete(Types type) {
        return typeDao.deleteById(type.getId()) > 0;
    }
}
