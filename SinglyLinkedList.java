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

    // Node<E> curr = head;
    // Node<E> prev = curr;
    // Node<E> temp_next = curr.getNext();

    // tail = curr;
    // curr.setNext(temp_next);

    // while (curr != null) {
    // temp_next = curr.getNext();
    // curr.setNext(prev);
    // prev = curr;
    // curr = temp_next;
    // }
    // head = prev;
    // }

    public void reverse() {
        if (head == null) {
            return;
        }

        Node<E> curr = head;
        Node<E> prev = null;
        tail = curr;

        if (tail == curr) {
            head = null;
            tail = null;
            return;
        }

        while (curr != null) {
            Node<E> temp_next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp_next;
        }
        head = prev;
    }

    // public static void main(String[] args) {
    //     // Test 1: removeLast - single element
    //     System.out.println("=== Single element ===");
    //     SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    //     list1.addLast(1);
    //     System.out.println("Before: " + list1.toString() + " | size=" + list1.size());
    //     list1.removeLast();
    //     System.out.println("After: " + list1.toString() + " | size=" + list1.size());
    //     System.out.println("isEmpty: " + list1.isEmpty());
    //     System.out.println();

    //     // Test 2: removeLast - multiple elements
    //     System.out.println("=== Multiple elements ===");
    //     SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
    //     list2.addLast(1);
    //     list2.addLast(2);
    //     list2.addLast(3);
    //     System.out.println("Before: " + list2.toString() + " | size=" + list2.size());
    //     list2.removeLast();
    //     System.out.println("After: " + list2.toString() + " | size=" + list2.size());
    //     System.out.println("last(): " + list2.last());
    // }
}