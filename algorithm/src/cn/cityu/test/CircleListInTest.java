package cn.cityu.test;

public class CircleListInTest {
    public static void main(String[] args) throws Exception {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;

        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);
    }

    /**
     * 查找有环链表中环的入口结点
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first) {
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        //遍历链表，先找到环（快慢指针相遇），再准备一个临时节点，指向链表的首节点，继续遍历，知道慢指针和临时指针相遇，相遇时所指向的节点就是环的入口
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            //判断快慢指针相遇
            if (fast.equals(slow)){
                temp = first;
                continue;
            }

            if (temp != null){
                temp = temp.next;
                if (temp.equals(slow))
                    break;
            }
        }
        return temp;
    }
    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
