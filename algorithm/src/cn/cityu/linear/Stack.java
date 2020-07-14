package cn.cityu.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    //记录首节点
    private Node head;
    //栈中元素个数
    private int N;


    private class Node{
        public T item;
        public Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        //找到首节点指向的第一个节点
        Node oldNode = head.next;
        //创建新节点，并让新节点指向原来的第一个节点
        Node node = new Node(t, oldNode);
        //让首节点指向新节点
        head.next = node;

        N++;
    }

    public T pop(){
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;

        if (oldFirst == null){
            return null;
        }
        //让首节点指向原来第一个节点的下一个节点
        head.next = oldFirst.next;

        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        //记录每次遍历的当前节点
        private Node n;

        public SIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
