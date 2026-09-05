public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);

        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> walk = head;
        while (walk != null) {
            // System.out.println(walk.getElement());
            result.append(walk.getElement());
            walk = walk.getNext();
        }
        return result.toString();
    }

    public E removeLast() {
        // if is empty
        if (head == null) {
            return null;
        }

        Node<E> walk = head;
        while (walk != null) {
            Node<E> temp = walk.getNext();
            if (temp.getNext() == null) {
                break;
            }
            walk = walk.getNext();
        }
        walk.setNext(null);
        tail = walk;

        return walk.getElement();
    }

    // public void reverse() {

    //     Node<E> curr = head;
    //     Node<E> prev = curr;
    //     Node<E> temp_next = curr.getNext();

    //     tail = curr;
    //     curr.setNext(temp_next);

    //     while (curr != null) {
    //         temp_next = curr.getNext();
    //         curr.setNext(prev);
    //         prev = curr;
    //         curr = temp_next;
    //     }
    //     head = prev;
    // }

    public void reverse() {

        Node<E> curr = head;
        Node<E> prev = null;
        tail = curr;

        while (curr != null) {
            Node<E> temp_next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp_next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original: " + list.toString());

        list.reverse();
        System.out.println("Reversed: " + list.toString());

        System.out.println("First after reverse: " + list.first());
        // System.out.println("Last after reverse: " + list.last());
        // System.out.println("Size: " + list.size());
    }
}