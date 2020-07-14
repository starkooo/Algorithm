package cn.cityu.linear;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    //记录头节点
    private Node head;
    //链表长度
    private int N;


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

    public LinkedList(){
        //初始化头节点
        this.head = new Node(null,null);
        this.N = 0;
    }

    public void clear(){
        head.next = null;
        this.N = 0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public T get(int i){
        //通过循环，从头节点开始往后找，依次找i次，就可以找到对应元素
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t){
        //找到当前最后一个节点
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        //创建新节点，保存元素t
        Node newNode = new Node(t, null);
        //让当前最后一个节点指向新节点
        n.next = newNode;
        //元素个数+1
        N ++;
    }

    public void insert(int i,T t){
        //找到i位置前一个节点
        Node pre = head;
        for (int index = 0; index <= i-1; index++) {
            pre = pre.next;
        }

        //找到i位置节点
        Node curr = pre.next;
        //创建新节点，新节点需指向原来i位置的节点
        Node newNode = new Node(t, curr);
        //原来i位置的前一个节点指向新节点即可
        pre.next = newNode;
        //元素个数+1
        N ++;
    }

    public T remove(int i){
        //找到i位置的前一个节点
        Node pre = head;
        for (int index = 0; index <= i-1; index++) {
            pre = pre.next;
        }
        //要找到i位置的节点
        Node curr = pre.next;
        //找到i位置的下一个节点
        Node nextNode = curr.next;
        //前一个节点指向下一个节点
        pre.next = nextNode;
        //元素-1
        N --;
        return curr.item;
    }

    public int indexOf(T t){
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t))
                return i;
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{

        private Node n;
        public LIterator(){
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

    //反转整个链表
    public void reverse(){
        //若为空链表，结束运行，如果不是，调用重载reverse方法完成反转
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }

    //反转指定的节点curr，并把反转后的节点返回
    public Node reverse(Node curr){
        if (curr.next == null){
            head.next = curr;
            return curr;
        }
        //递归反转当前节点curr的下一个节点；返回值就是链表反转后，当前节点的上一个节点
        Node pre = reverse(curr.next);
        //让返回的节点的下一个节点变为当前节点curr
        pre.next = curr;
        //把当前节点的下一个节点变为null
        curr.next = null;

        return curr;
    }
}
