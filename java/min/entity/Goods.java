package min.entity;


import java.util.List;
import min.entity.Types;
public class Goods {
    private Integer id;

    private String name;

    private String cover;

    private Integer price;

    private String intro;

    private Integer typeId;

    private Types type;

    private boolean show;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public List<SkuGood> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuGood> skuList) {
        this.skuList = skuList;
    }

    List<SkuGood> skuList;



}
