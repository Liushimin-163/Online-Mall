package min.service;

import min.dao.UsersDao;
import min.entity.Users;
import min.util.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired        //spring注入类对象
    private UsersDao userDao;

    /**
     * 验证用户密码
     * @param username
     * @param password
     * @return
     */
    public boolean checkUser(String username, String password){
        return userDao.getByUsernameAndPassword(username, SafeUtil.encode(password)) != null;
    }

    /**
     * 用户是否存在
     * @param username
     * @return
     */
    public boolean isExist(String username) {
        return userDao.getByUsername(username) != null;
    }

    /**
     * 添加
     * @param user
     * @return
     */
    public boolean add(Users user) {
        user.setPassword(SafeUtil.encode(user.getPassword()));
        return userDao.insert(user) > 0;
    }

    /**
     * 通过id获取
     * @param userid
     * @return
     */
    public Users get(int userid){
        return userDao.selectById(userid);
    }

    /**
     * 通过username获取
     * @param username
     * @return
     */
    public Users get(String username){
        return userDao.getByUsername(username);
    }

    /**
     * 列表
     * @param page
     * @param rows
     * @return
     */
    public List<Users> getList(int page, int rows) {
        return userDao.getList(rows * (page-1), rows);
    }

    /**
     * 总数
     * @return
     */
    public long getTotal() {
        return userDao.getTotal();
    }

    /**
     * 更新
     * @param user
     */
    public boolean update(Users user) {
        return userDao.updateById(user) > 0;
    }

    /**
     * 删除
     * @param user
     * @return
     */
    public boolean delete(Users user) {
        return userDao.deleteById(user.getId()) > 0;
    }
}
