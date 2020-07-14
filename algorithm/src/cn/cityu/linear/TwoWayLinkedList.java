package cn.cityu.linear;

import java.util.Iterator;

public class TwoWayLinkedList<T> implements Iterable<T>{

    //首节点
    private Node head;
    //最后一个节点
    private Node last;

    private int N;

    private class Node{
        T item;
        Node next,pre;

        public Node(T item, Node pre, Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;

        }
    }

    public TwoWayLinkedList(){
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }

    public void clear(){
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public T getFirst(){
        if (isEmpty()){
            return null;
        }

        return head.next.item;
    }

    public T getLast(){
        if (isEmpty()){
            return null;
        }

        return last.item;
    }

    public void insert(T t){

        if (isEmpty()){
            //链表为空

            //需要创建新的节点
            Node newNode = new Node(t,head,null);
            //让新节点称为尾节点
            last = newNode;
            //让头节点指向尾节点
            head.next = last;
        }else {
            //链表不为空
            Node oldLast = last;

            //创建新节点
            Node newNode = new Node(t, oldLast, null);
            //让当前尾节点指向新节点
            oldLast.next = newNode;
            //让新节点称为尾节点
            last = newNode;
        }
        N ++;
    }

    public void insert(int i,T t){
        //找到i位置的前一个节点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //找到i位置的节点
        Node curr = pre.next;
        //创建新节点
        Node newNode = new Node(t, pre, curr);
        //让i位置的前一个节点的下一个节点指向新节点
        pre.next = newNode;
        //让i位置的前一个节点变为新节点
        curr.pre = newNode;

        N++;
    }

    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    public int indexOf(T t){
        Node n = head;
        for (int i = 0; n.next != null ; i++) {
            n = n.next;
            if (n.item.equals(t))
                return i;
        }
        return -1;
    }

    public T remove(int i){
        //找到i位置的前一个节点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //找到i位置的节点
        Node curr = pre.next;
        //找到i位置的下一个节点
        Node nextNode = curr.next;
        //让i位置的前一个节点的下一个节点变为i位置的下一个节点
        pre.next = nextNode;
        //让i位置的下一个节点的上一个节点变为i位置的前一个节点
        nextNode.pre = pre;

        N--;
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{

        private Node n;
        public TIterator(){
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
