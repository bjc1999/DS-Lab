import java.util.LinkedList;

public class FashionStore extends ShopLot implements Comparable<FashionStore>{
    LinkedList<Item<String, Integer>> clothes;

    public FashionStore (String name, Person contactPerson, Person[] employee, LinkedList<Item<String, Integer>> clothes) {
        // call parent class constructor
        super(name, contactPerson, employee);
        this.clothes = clothes;
    }

    @Override
    public int compareTo(FashionStore o) {
        // length will return int, thus cast to Integer to make use of compareTo method
        return ((Integer)this.employee.length).compareTo((Integer)o.employee.length);
    }

    @Override
    public boolean equals(Object o) {
        // it must accept object (instead of fashionstore) as argument only can considered as override
        return this.contactPerson.name.equals(((FashionStore)o).contactPerson.name);
    }

    @Override
    public String toString() {
        // when writing toString method please follow exactly what shown in question expected output
        String employeeStr = "";
        for(Person em: employee)
            employeeStr += em + ", ";
        employeeStr = employeeStr.substring(0, employeeStr.length()-2);
        employeeStr = "["+employeeStr+"]";

        String itemStr = "";
        for(Item<String, Integer> it: clothes)
            itemStr += it + ", ";
        itemStr = itemStr.substring(0, itemStr.length()-2);
        itemStr = "["+itemStr+"]";
        
        return "ShopLot{shopName="+name+", contact="+contactPerson+", clothes="+itemStr+", emloyees="+employeeStr+"}";
    }
}