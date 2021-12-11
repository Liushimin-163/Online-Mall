package min.service;

import min.dao.ShopcartDao;
import min.entity.Shopcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ShopcartService {
    @Autowired
    private ShopcartDao shopcartDao;
    @Autowired
    private GoodService goodService ;
    @Autowired
    private SkuService skuService;

    /**
     * 获取购物车列表
     * @param userid
     * @return
     */
    public List<Shopcart> getList(int userid){
        return pack(shopcartDao.getList(userid));
    }

    /**
     * 添加购物车
     * @param shopcart
     * @return
     */
    public boolean save(Shopcart shopcart) {
        Shopcart old = shopcartDao.getCart(shopcart.getUserId(), shopcart.getGoodId(), shopcart.getColorId(), shopcart.getSizeId());
        if(Objects.isNull(old)) {
            return shopcartDao.insert(shopcart) > 0;
        }
        old.setAmount(old.getAmount() + shopcart.getAmount());
        return shopcartDao.updateById(old) > 0;
    }

    /**
     * 获取购物车总数
     * @param userid
     */
    public int getTotal(int userid) {
        return shopcartDao.getTotal(userid);
    }

    /**
     * 数量+1
     * @param id
     * @return
     */
    public boolean add(int id) {
        Shopcart cart = shopcartDao.get(id);
        cart.setAmount(cart.getAmount() + 1);
        return shopcartDao.updateById(cart) > 0;
    }


    /**
     * 数量-1
     * @param id
     * @return
     */
    public boolean less(int id) {
        Shopcart cart = shopcartDao.get(id);
        if(cart.getAmount()<=1) {
            return delete(id);
        }
        cart.setAmount(cart.getAmount() - 1);
        return shopcartDao.updateById(cart) > 0;
    }


    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(int id) {
        return shopcartDao.deleteById(id) > 0;
    }

    /**
     * 清空购物车
     * @param userid
     * @return
     */
    public boolean clean(Integer userid) {
        return shopcartDao.deleteByUserid(userid);
    }


    /**
     * 封装
     * @param list
     * @return
     */
    private List<Shopcart> pack(List<Shopcart> list) {
        for(Shopcart cart : list) {
            cart.setGood(goodService.get(cart.getGoodId()));
            cart.setColor(skuService.getColor(cart.getColorId()));
            cart.setSize(skuService.getSize(cart.getSizeId()));
        }
        return list;
    }

    /**
     * 获取总金额
     * @param userid
     * @return
     */
    public int getTotalPrice(int userid) {
        int total = 0;
        List<Shopcart> cartList = this.getList(userid);
        if(Objects.nonNull(cartList) && ! cartList.isEmpty()) {
            for(Shopcart cart : cartList) {
                total += cart.getGood().getPrice() * cart.getAmount();
            }
        }
        return total;
    }
}
