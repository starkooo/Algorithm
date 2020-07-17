package cn.cityu.symbol;

public class OrderSymbolTable<Key extends Comparable<Key>,Value> {

    private Node head;
    private int N;

    private class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public void put(Key key,Value value){

    }

    public void delete(Key key){
        //找到键为key的节点，把该节点从链表中删除
        Node n = head;
        while (n.next != null){
            //判断n节点的下一个节点的key是否为key，是则删除该节点
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N --;
                return;
            }

            //变换n
            n = n.next;
        }
    }

    public Value get(Key key){
        //找到key所在的节点
        Node n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
}
