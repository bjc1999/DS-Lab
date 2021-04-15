public class Item<E, V> {
    E item;
    V price;

    public Item(E item, V price) {
        this.item = item;
        this.price = price;
    }

    public String toString() {
        return "Item{item="+item+", price=RM"+price+"}";
    }
}
