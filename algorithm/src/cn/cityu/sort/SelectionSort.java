package cn.cityu.sort;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SelectionSort {
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

    //验证v是否小于w
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    //交换元素
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //打印数组
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    //测试数组属否有序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,9,3,2,0};
        Character[] chars = {'s','a','m','p','l','e'};
        sort(arr);
        sort(chars);
        show(arr);
        show(chars);
    }
}
