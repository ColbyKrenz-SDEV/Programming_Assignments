/*
Programmer:	Colby Krenz
Date: 09/15/2023
Program Name: M04 Programming Assignment 3: Chapter 24: Exercise 24.3
Purpose: Using MyLinkedList class, modify and implement a new class called TwoWayLinkedList.
*/

//code from: https://liveexample.pearsoncmg.com/test/Exercise24_03.txt

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class ImplementDoublyLinkedList {

    public static void main(String[] args) {
        new ImplementDoublyLinkedList();
    }

    public ImplementDoublyLinkedList() {
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
        System.out.print("Enter five numbers: ");
        Scanner input = new Scanner(System.in);
        double[] v = new double[5];
        for (int i = 0; i < 5; i++) {
            v[i] = input.nextDouble();
        }

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        java.util.ListIterator<Double> iterator1 = list.listIterator();
        System.out.print("The list in forward order: ");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
        System.out.print("\nThe list in backward order: ");
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous() + " ");
        }
    }
}

interface MyList<E> extends Collection<E> {

    //Add a new element at the specified index in this list
    public void add(int index, E e);

    //Return the element from this list at the specified index
    public E get(int index);

    //Return the index of the first matching element in this list. Return -1 if no match.
    public int indexOf(Object e);

    //Return the index of the last matching element in this list Return -1 if no match.
    public int lastIndexOf(E e);

    /*Remove the element at the specified position in this list Shift any subsequent
     elements to the left. Return the element that was removed from the list.*/
    public E remove(int index);

    //Replace the element at the specified position in this list with thespecified element and returns the new set.
    public E set(int index, E e);

    @Override
    //Add a new element at the end of this list
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    //Return true if this list contains no elements
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    /*Remove the first occurrence of the element e from this list. Shift any
     subsequent elements to the left. Return true if the element is removed.*/
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
	// Left as an exercise
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
	// Left as an exercise
        return true;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
	// Left as an exercise
        return true;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
	// Left as an exercise
        return true;
    }

    @Override
    public default Object[] toArray() {
	// Left as an exercise
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
	// Left as an exercise
        return null;
    }
}

class TwoWayLinkedList<E> implements MyList<E> {

    private Node<E> head, tail;
    private int size;
    
    //Create a default list
    public TwoWayLinkedList() {
    }

    //Create a list from an array of objects
    public TwoWayLinkedList(E[] objects) {
        for (E e : objects) {
            add(e);
        }
    }

    //Return the head element in the list
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    //Return the last element in the list
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    //Clear the list
    public void clear() {
        head = tail = null;
    }

    //Return true if this list contains the element o
    public boolean contains(Object e) {
        System.out.println("Implementation left as an exercise");
        return true;
    }

    //Return the element from this list at the specified index
    public E get(int index) {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    //Return the index of the head matching element in this list. Return -1 if no match.
    public int indexOf(Object e) {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    //Return the index of the last matching element in this list Return -1 if no match.
    public int lastIndexOf(Object e) {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    //Replace the element at the specified position in this list with the specified element.
    public E set(int index, E e) {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    private class LinkedListIterator implements java.util.ListIterator<E> {

        private Node<E> current = head; // Current index

        public LinkedListIterator() {
        }

        public LinkedListIterator(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                        + size);
            }
            for (int nextIndex = 0; nextIndex < index; nextIndex++) {
                current = current.next;
            }
        }

        public void setLast() {
            current = tail;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            System.out.println("Implementation left as an exercise");
        }

        @Override
        public void add(E e) {
            System.out.println("Implementation left as an exercise");
        }

        @Override
        public boolean hasPrevious() {
            return current != null;
        }

        @Override
        public int nextIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public E previous() {
            E e = current.element;
            current = current.previous;
            return e;
        }

        @Override
        public int previousIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public void set(E e) {
            current.element = e; // TODO Auto-generated method stub
        }
    }

    private class Node<E> {

        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E o) {
            element = o;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);
    }

    @Override
    public Iterator<E> iterator() {
	// TODO Auto-generated method stub
        return null;
    }

//BEGIN REVEL SUBMISSION

    //Add an element to the beginning of the list
    public void addFirst(E e) {
		
		//create a new node for the value e
		Node<E> node = new Node<>(e);
		
		//if list is empty, update tail to node
		if (head == null) {
			tail = node;
		}
		
		//update the next node to head and update the previoius head to node 
		else {
			node.next = head;
			head.previous = node;
		}
		
		//update the head to node and increment size by 1
		head = node;
		size++;
	}

    //Add an element to the end of the list
    public void addLast(E e) {
		
		//create a new node for the value e
        Node<E> node = new Node<>(e);
		
		//if list is empty, update head to node
        if(head == null) {
            head = node;
		}
		
		//update the previous node to tail and update the next tail to node
        else {
            node.previous = tail;
            tail.next = node;
        }
		
		//update the tail to node and increment size by 1
        tail = node;
        size++;
	}

    //Add a new element at the specified index in this list. The index of the head element is 0
    public void add(int index, E e) {
		
		//if index is equal to zero, insert element at the beginning/head
        if(index == 0) {
            addFirst(e);
		}
		
		//if index is equal to the size, insert element at the end/tail
        else if(index == size) {
            addLast(e);
		}
		
		//if index is greater than zero and less than size, insert element in the middle
        else if(index > 0 &&  index < size) {
			
			//create new node for the value e
            Node<E> node = new Node<E> (e);
			
			//update current to head
            Node<E> current = head;
			
			//loop through the list while the index is greater than 0 and decrement index by 1
            while(index > 0) {
                current = current.next;
                index--;
            }
			
			/*update the next node to current, update previous node to previous current, update next 
			previous current to node, update previous current to node, and increment size by 1*/
            node.next = current;
            node.previous = current.previous;
            current.previous.next = node;
            current.previous = node;
            size++;
        }

    }

    //Remove the head node and return the object that is contained in the removed node.
    public E removeFirst() {
		
		//if the list isn't empty, set the element to head element and update head to next head
        if(head != null) {
            E element = head.element;
            head = head.next;
			
			//if list is empty after removing, update the tail to null
            if(head == null) {
                tail = null;
			}
			
			//if the list isn't empty, update the previous head to null 
			else {
                head.previous = null;
			}
			
			//decrement the size by 1 and return the element
            size--;
            return element;
        }
		
		//if the list is empty, return null
        else {
            return null;
		}
    }

    //Remove the last node and return the object that is contained in the removed node.
    public E removeLast() {
		
		//if the list isn't empty, set the element to tail element and update tail to previous tail
        if(head != null) {
            E element = tail.element;
            tail = tail.previous;
			
			//if list is empty after removing, update the head to null
            if(tail == null) {
                head = null;
			}
			
			//if the list isn't empty, update the next tail to null
            else {
                tail.next = null;
			}
            
			//decrement the size by 1 and return the element
            size--;
            return element;
        }
		
		//if the list is empty, return null
        else {
            return null;
		}

    }

    //Remove the element at the specified position in this list. Return the element that was removed from the list.
    public E remove(int index) {
		
		//if the index is equal to zero, remove the head
        if(index == 0) {
            return removeFirst();
		}
		
		//if the index is equal to the size minus 1, remove the tail
        else if(index == size-1) {
            return removeLast();
		}
		
		//if the index is greater than zero and less than the size minus 1, set the current to head
        else if(index > 0 && index < size-1) {
            Node<E> current = head;
			
			//while the index is greater than zero, update current to next current and decrement index by 1
            while(index > 0) {
                current = current.next;
                index--;
            }
			
			/*update next previous current to next current and previous next current to previous current,
			decrement the size by 1 and return the element current*/
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            return current.element;
        }
		
		//if index isn't valid, return null
        else {
            return null;
		}

    }
}
// END REVEL SUBMISSION