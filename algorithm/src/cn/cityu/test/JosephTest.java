package cn.cityu.test;

public class JosephTest {

    public static void main(String[] args) {
        //1.构建循环列表，包含41个节点
        //首节点
        Node<Integer> first = null;
        Node<Integer> pre = null;

        for (int i = 1; i <= 41; i++) {
            //如果是第一个节点
            if (i == 1){
                first = new Node<>(i,null);
                pre = first;
                continue;
            }
            //如果不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;

            //如果是最后一个节点，那么需要让最后一个节点的下一个节点变为first
            if (i == 41){
                pre.next = first;
            }
        }

        //2.需要count计数器，模拟报数
        int count = 0;

        //3.遍历循环链表
        //记录每次遍历拿到的节点，默认从首节点开始
        Node<Integer> n = first;
        //记录当前节点的上一个节点，为什么需要这个变量？
        //当报数为3，会把当前节点删除掉，删除就需要将before的next指向当前节点的next
        Node<Integer> before = null;
        //循环终止条件，当删到最后一个元素时，它会自己指向自己
        while (n != n.next){
            //模拟报数
            count ++;
            //判断当前报数是否为3
            if (count == 3){
                //如果是3，把当前删除删除，打印当前节点，重置count=0，让当前节点后移
                before.next = n.next;
                System.out.print(n.item+" ");
                count = 0;
                n = n.next;
            }else{
                //不是3，让当前节点后移；让before变为当前节点
                before = n;
                n = n.next;
            }
        }
        //打印最后一个元素
        System.out.println(n.item);
    }




    private static class Node<T>{
        T item;
        Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

}
