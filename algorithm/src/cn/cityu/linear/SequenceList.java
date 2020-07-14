package cn.cityu.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    //存储元素的数组
    private T[] eles;
    //记录当前线性表中的元素个数
    private int N;

    public SequenceList(int capacity){
        this.eles = (T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将线性表置为空表
    public void clear(){
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        return eles[i];
    }

    public void insert(T t){
        if (N == eles.length){
            resize(2*eles.length);
        }

        eles[N++] = t;
    }

    public void insert(int i,T t){
        if (N == eles.length){
            resize(2*eles.length);
        }

        //先把i索引的元素及其后面的元素依次向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index-1];
        }

        //再把t元素放到i索引处即可
        eles[i] = t;
        N ++;
    }

    public T remove(int i){
        //记录索引i处的值
        T current = eles[i];
        //索引i后面的元素依次向前移动一位即可
        for (int index = i + 1; index < N; index++) {
            eles[i] = eles[i+1];
        }
        N --;

        if (N < eles.length/4){
            resize(eles.length/2);
        }
        return current;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t))
                return i;
        }
        return -1;
    }

    public void resize(int newSize){
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
             temp[i] = eles[i];
        }
        eles = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cusor;
        public SIterator(){
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
