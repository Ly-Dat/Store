package solid;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<>();
        Cats cats = new Cats(15);
        goods.add(cats);
        Clothes clothes = new Clothes(5);
        goods.add(clothes);
        Shoes shoes = new Shoes(100);
        goods.add(shoes);
    }
}
