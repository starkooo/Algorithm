package cn.cityu.sort;

//希尔排序是插入排序的优化版
public class ShellSort {
    public static void sort(Comparable[] a){
        //1.根据数组a的长度，确定增长量h的初始值
        int h = 1;
        while (h < a.length/2){
            h = h * 2 + 1;
        }
        //2.希尔排序
        while(h >= 1){
            //排序
            //2.1找到待插入元素
            for (int i = h; i < a.length; i++) {
                //2.2把待插入元素插入到有序数列中
                for (int j = i; j >= h; j -= h) {
                    //带插入元素是a[j]，比较a[j]和a[j-h]
                    if (less(a[j],a[j - h])){
                        //交换元素
                        exch(a, j - h, j);
                    }else {
                        //带插入元素已找到合适位置，结束循环
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
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
