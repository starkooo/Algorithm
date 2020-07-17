package cn.cityu.symbol;

public class SymbolTable<Key,Value> {

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

    public SymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public void put(Key key,Value value){
        //符号表中已经存在键为key的键值对，那么只需要找到该节点，替换值为value即可
        Node n = head;
        while (n.next != null){
            //变换n
            n = n.next;
            //判断n节点存储的键是否为新插入的key，是，则替换n节点的值
            if (n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        //如果符号表中不存在键为key，只需要创建新的节点，保存要插入的键值对，把新节点插入到链表头部，head.next=新节点即可
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;

        N ++;
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
