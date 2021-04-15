public class Person {
    String name;
    String contact;


    public Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String toString() {
        return "Person{name="+name+", contact="+contact+"}";
    }
    
}