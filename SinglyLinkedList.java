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

        if (head == walk && tail == walk) {
            System.out.println("1 ELE LIST");
            head = null;
            tail = null;
            size--;
            return walk.getElement();
        }
        while (walk != null) {
            Node<E> temp = walk.getNext();
            if (temp.getNext() == null) {
                break;
            }
            walk = walk.getNext();
        }
        walk.setNext(null);
        tail = walk;
        size--;

        return walk.getElement();
    }

    public void reverse() {
        if (head == null) {
            return;
        }

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

    // public static void main(String[] args) {
    // SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    // list.addLast(1);
    // list.addLast(2);
    // list.addLast(3);
    // list.addLast(4);
    // list.addLast(5);

    // System.out.println("Original: " + list.toString());

    // list.reverse();
    // System.out.println("Reversed: " + list.toString());

    // System.out.println("First after reverse: " + list.first());
    // System.out.println("Last after reverse: " + list.last());
    // System.out.println("Size: " + list.size());

    // //tets
    // System.out.println("=== Single element ===");
    // SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    // list1.addLast(1);
    // System.out.println("Before: " + list1.toString() + " | size=" +
    // list1.size());
    // Integer removed1 = list1.removeLast();
    // System.out.println("Removed: " + removed1);
    // System.out.println("After: " + list1.toString() + " | size=" + list1.size());
    // System.out.println("isEmpty: " + list1.isEmpty());
    // System.out.println();

    // // Test 2: removeLast - multiple elements
    // System.out.println("=== Multiple elements ===");
    // SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
    // list2.addLast(1);
    // list2.addLast(2);
    // list2.addLast(3);
    // System.out.println("Before: " + list2.toString() + " | size=" +
    // list2.size());
    // Integer removed2 = list2.removeLast();
    // System.out.println("Removed: " + removed2);
    // System.out.println("After: " + list2.toString() + " | size=" + list2.size());
    // System.out.println("last(): " + list2.last());
    // }
}