package cn.cityu.sort;

public class BubbleSort {
    public static void sort(Comparable[] a){
        if (a == null || a.length < 2)
            return;
        int n = a.length;

        //每一趟排完，最大的数都沉到最底
        //所以，一共需要 n - 1 趟，确定i
        for (int i = 0; i < n - 1; i++) {
            //每次比较都是相邻两个元素比较，从第一个元素开始（j = 0）
            // 最后一个元素下标是n - 1，经过i趟后，后面有i个元素已确定（最大值），所以到n-1-i结束循环
            for (int j = 0; j < n - 1 - i; j++) {
                if (less(a[j + 1],a[j]))
                    exch(a, j, j + 1);
            }
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
