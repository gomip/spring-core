package gomip.core.singleton;

public class StatfuleService {
//    private int price; // <- warning

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
