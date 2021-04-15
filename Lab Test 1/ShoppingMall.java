import java.util.LinkedList;

public class ShoppingMall {
    
    public static void main(String[] args) {
        // foodstores initializations
        LinkedList<FoodStore> foodStores = new LinkedList<>();

        Person mike = new Person("Mike", "0101122334");
        Person[] mcdEmployee = {new Person("Jack", null), new Person("Jane", null)};
        LinkedList<Item<String, Integer>> mcdMenu = new LinkedList<>();
        mcdMenu.add(new Item<>("Burger", 10));
        mcdMenu.add(new Item<>("Fried Chicken", 12));
        FoodStore mcDonalds = new FoodStore("McDonalds", mike, mcdEmployee, mcdMenu);

        Person max = new Person("Max", "0112233445");
        Person[] sushiEmployee = {new Person("Adam", null), new Person("Alex", null), new Person("Andrew", null)};
        LinkedList<Item<String, Integer>> sushiMenu = new LinkedList<>();
        sushiMenu.add(new Item<>("Chicken Katsu Don", 15));
        sushiMenu.add(new Item<>("Ramen", 12));
        FoodStore sushiMentai = new FoodStore("Sushi Mentai", max, sushiEmployee, sushiMenu);

        Person[] penyetEmployee = {new Person("Lex", null), new Person("Leon", null)};
        LinkedList<Item<String, Integer>> penyetMenu = new LinkedList<>();
        penyetMenu.add(new Item<>("Ayam Penyet", 10));
        FoodStore waroengPenyet = new FoodStore("Waroeng Penyet", mike, penyetEmployee, penyetMenu);

        foodStores.add(mcDonalds);
        foodStores.add(sushiMentai);
        foodStores.add(waroengPenyet);

        // fashionstores initializations
        LinkedList<FashionStore> fashionStores = new LinkedList<>();

        Person nate = new Person("Nate", "0199988776S");
        Person[] uniqloEmployee = {new Person("Kate", null), new Person("Ken", null), new Person("Kurt", null)};
        LinkedList<Item<String, Integer>> uniqloClothes = new LinkedList<>();
        uniqloClothes.add(new Item<>("Shirt", 80));
        uniqloClothes.add(new Item<>("T-shirt", 60));
        FashionStore uniqlo = new FashionStore("Uniqlo", nate, uniqloEmployee, uniqloClothes);

        Person nick = new Person("Nick", "0195544332");
        Person[] padiniEmployee = {new Person("Frank", null), new Person("Felix", null)};
        LinkedList<Item<String, Integer>> padiniClothes = new LinkedList<>();
        padiniClothes.add(new Item<>("Blouse", 100));
        padiniClothes.add(new Item<>("Skirt", 80));
        FashionStore padini = new FashionStore("Padini", nick, padiniEmployee, padiniClothes);

        Person nicole = new Person("Nicole", "0194433221");
        Person[] mangoEmployee = {new Person("Ron", null), new Person("John", null)};
        LinkedList<Item<String, Integer>> mangoClothes = new LinkedList<>();
        mangoClothes.add(new Item<>("Dress", 120));
        FashionStore mango = new FashionStore("Mango", nicole, mangoEmployee, mangoClothes);

        fashionStores.add(uniqlo);
        fashionStores.add(padini);
        fashionStores.add(mango);

        // print sushimentai and mango shop info
        System.out.println(sushiMentai);
        System.out.println(mango);

        // find stores with highest number of employees
        System.out.println("Food store with the highest number of employees: "+highestEmployee(foodStores).name);
        System.out.println("Fashion store with the highest number of employees: "+highestEmployee(fashionStores).name);

        // compare contact person among all foodstores
        for(int i=0; i<foodStores.size(); i++) {
            for(int j=i+1; j<foodStores.size(); j++) {
                FoodStore store1 = foodStores.get(i);
                FoodStore store2 = foodStores.get(j);
                if(store1.equals(store2))
                    System.out.println("The contact person for "+store1.name+" and "+store2.name+" is the same");
                else
                    System.out.println("The contact person for "+store1.name+" and "+store2.name+" is different");
            }
        }

        // compare number of employees between sushimentai and waroengpenyet
        if(sushiMentai.compareTo(waroengPenyet) > 0)
            System.out.println("Sushi Mentai have more employees than Waroeng Penyet");
        else if(sushiMentai.compareTo(waroengPenyet) < 0)
            System.out.println("Waroeng Penyet have more employees than Sushi Mentai");
        else
            System.out.println("Sushi Mentai and Waroeng Penyet have the same nuber of employees");

        // find out most expensive item in mcdonalds and padini
        System.out.println("The most expensive item in McDonalds is "+mostExpensive(mcDonalds).item);
        System.out.println("The most expensive item in Padini is "+mostExpensive(padini).item);
    }

    // as question specify it should be a generic method, extend shoplot make sure it produce compile error
    // when something else is passed in and extend comparable so that you can use compareTo method in this
    // method (when you extend comparable means you tell compiler the generic type must be something comparable
    // so that we can safely use compareTo here)
    public static <E extends ShopLot & Comparable<E>> E highestEmployee(LinkedList<E> stores) {
        E shop = stores.getFirst();
        for(E store: stores)
            if(store.compareTo(shop) > 0)
                shop = store;
        return shop;
    }

    // same as above method it should be generic too, extend shoplot make sure it produce compile error
    // when something else is passed in, since shoplot does not have item variable (its defined in foodstore
    // or fashion store), thus you need check whether the passed in object is instance of foodstore or fashionstore
    // then only can cast the generic type to foodstore or fashionstore in order to access item (menu/clothes) variable
    public static <E extends ShopLot> Item<String, Integer> mostExpensive(E store) {
        Item<String, Integer> item = null;
        if(store instanceof FoodStore) {
            item = ((FoodStore)store).menu.getFirst();
            for(Item<String, Integer> it: ((FoodStore)store).menu)
                if(it.price > item.price)
                    item = it;
        }
        else {
            item = ((FashionStore)store).clothes.getFirst();
            for(Item<String, Integer> it: ((FashionStore)store).clothes)
                if(it.price > item.price)
                    item = it;
        }
        return item;
    }

}
