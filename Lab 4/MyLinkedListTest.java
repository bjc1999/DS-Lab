public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.print();
        list.reverse();
        System.out.println(list.getSize());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        int middleIndex = list.getSize()/2;
        System.out.println(list.remove(middleIndex));
        System.out.println(list.indexOf('b'));
        System.out.println(list.indexOf('c'));
        System.out.println(list.contains('c'));
        System.out.println(list.set(0, 'h'));
        System.out.println(list.set(1, 'e'));
        System.out.println(list.set(2, 'l'));
        System.out.println(list.set(3, 'l'));
        System.out.println(list.set(4, 'o'));
        list.print();

        list = reverseLinkedList(list);
        list.print();
    }

    public static <E> MyLinkedList<E> reverseLinkedList(MyLinkedList<E> list) {
        MyLinkedList<E> reverseList = new MyLinkedList<>();
        for(int i=list.getSize()-1; i >= 0; i--){
            reverseList.addLast(list.get(i));
        }
        return reverseList;
    }
    
}
