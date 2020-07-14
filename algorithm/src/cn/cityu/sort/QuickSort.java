package cn.cityu.sort;

public class QuickSort {

    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }

    //对数组中从索引lo到索引hi之间的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi){
        //安全性校验
        if (hi <= lo){
            return;
        }

        //需要对数组中lo索引到hi索引的元素进行分组（分为左子组和右子组）
        int partition = partition(a, lo, hi);//返回的是分组的分界值对应的索引，分界值位置变换后的索引

        //让左子组有序
        sort(a,lo,partition - 1);

        //让右子组有序
        sort(a,partition + 1, hi);
    }

    //对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a, int lo, int hi){

        //确定分界值
        Comparable key = a[lo];

        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi + 1;

        //切分
        while (true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，截止
            while (less(key,a[--right])){
                if (right == lo){
                    break;
                }
            }

            //先从左往右扫描，移动left指针，找到一个比分界值大的元素，截止
            while (less(a[++left],key)){
                  if (left == hi){
                      break;
                  }
            }

            //判断left >= right，是，则扫描完毕；不是，交换元素
            if (left >= right){
                break;
            }else {
                exch(a,left,right);
            }
        }

        //交换分界值
        exch(a,lo,right);
        return right;
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
