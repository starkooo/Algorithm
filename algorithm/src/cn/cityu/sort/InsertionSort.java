package cn.cityu.sort;

public class InsertionSort {
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j],a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    //为了提高插入排序速度，可将内循环中将较大元素都向右移而不是总是交换两个元素
    public static void sort2(Comparable[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            //寻找arr[i]合适的插入位置，将要插入的元素先复制一份
            Comparable e = a[i];
            int j;// j保存e应插入位置
            for (j = i; j > 0 && less(e, a[j - 1]) ; j--) {
                a[j] = a[j - 1];
            }
            a[j] = e;
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
        sort2(arr);
        sort2(chars);
        show(arr);
        show(chars);
    }
}
