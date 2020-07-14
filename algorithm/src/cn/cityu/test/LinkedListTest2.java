package cn.cityu.test;

import cn.cityu.linear.LinkedList;

public class LinkedListTest2 {

    public static void main(String[] args) {
        //创建单向链表对象
        LinkedList<String> sl = new LinkedList<>();
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");

        for (String s : sl) {
            System.out.println(s);
        }

        System.out.println("-------------------------------");

        sl.reverse();
        for (String s : sl) {
            System.out.println(s);
        }

    }

}
