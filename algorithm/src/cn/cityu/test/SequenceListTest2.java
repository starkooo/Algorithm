package cn.cityu.test;

import cn.cityu.linear.SequenceList;

public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> sl = new SequenceList<>(3);
        sl.insert("zs");
        sl.insert("ls");
        sl.insert("ww");
        sl.insert("zl");
    }
}
