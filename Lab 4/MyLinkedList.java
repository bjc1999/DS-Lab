public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int getSize() {
        Node<E> current = head;
        int size = 0;
        while(current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void addFirst(E e) {
        head = new Node<E>(e, head);
        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        if (tail == null)
            tail = head = new Node<E>(e, head);
        else
            tail = tail.next = new Node<E>(e, null);
    }

    public void add(int index, E e) {
        if(index > getSize())
            System.out.println("Index out of bound");
        else if(index == 0)
            addFirst(e);
        else if(index == getSize())
            addLast(e);
        else {
            Node<E> previous = head;
            Node<E> current = head.next;
            int counter = 1;
            while(current != null) {
                if(counter == index) {
                    previous.next = new Node<E>(e, current);
                }
                previous = current;
                current = current.next;
                counter++;
            }
        }
    }

    public E removeFirst() {
        if(getSize() == 0)
            return null;
        E e = head.element;
        head = head.next;
        if(head == null)
            tail = null;
        return e;
    }

    public E removeLast() {
        if(getSize() == 0)
            return null;
        if(getSize() == 1) {
            E e = head.element;
            head = tail = null;
            return e;
        }
        Node<E> current = head;
        while(current.next != tail)
            current = current.next;
        E e = (E)current.next.element;
        current.next = null;
        tail = current;
        return e;
    }

    public E remove(int index) {
        if(index >= getSize()) {
            System.out.println("Index out of bound");
            return null;
        }
        else if(index == 0)
            return removeFirst();
        else if(index == getSize()-1)
            return removeLast();
        else {
            Node<E> current = head;
            E e = null;
            int counter = 1;
            while(current != null) {
                if(counter == index) {
                    e = (E)current.next.element;
                    current.next = current.next.next;
                }
                current = current.next;
                counter++;
            }
            return e;
        }
    }

    public void add(E e) {
        addLast(e);
    }

    public boolean contains(E e) {
        Node<E> current = head;
        while(current != null) {
            if(current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        Node<E> current = head;
        int counter = 0;
        while(current != null) {
            if(counter == index)
                return current.element;
            current = current.next;
            counter++;
        }
        System.out.println("Index Out Of Bound");
        return null;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(getSize()-1);
    }

    public int indexOf(E e) {
        Node<E> current = head;
        int counter = 0;
        while(current != null) {
            if(current.element.equals(e))
                return counter;
            current = current.next;
            counter++;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = head;
        int counter = 0;
        int index = -1;
        while(current != null) {
            if(current.element.equals(e))
                index = counter;
            current = current.next;
            counter++;
        }
        return index;
    }

    public E set(int index, E e) {
        E el = remove(index);
        if(el == null) {
            return el;
        }
        add(index, e);
        return el;
    }

    public void clear() {
        head = tail = null;
    }

    public void print() {
        String output = "";
        Node<E> current = head;
        while(current != null) {
            output = output + current;
            current = current.next;
        }
        System.out.println(output);
    }

    public void reverse() {
        String reverse = "";
        Node<E> current = head;
        while(current != null) {
            reverse = current + reverse;
            System.out.println(reverse);
            current = current.next;
        }
        System.out.println(reverse);
    }
}
