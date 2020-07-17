package cn.cityu.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private int N;
    private Node last;



    //节点类
    private class Node{
        //数据
        T item;
        //下一个节点
        Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T t){
        //当前尾节点last为null
        if (last == null){
            last = new Node(t,null);
            head.next = last;
        }else {
            //尾节点不为null
            Node oldLast = last;
            last = new Node(t,null);
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;

        N--;
        //出队列是删除元素，因此如果队列中的元素被删除完了，需要重置last = null
        if (isEmpty()){
            last = null;
        }

        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{

        private Node n;

        public QIterator(){
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
