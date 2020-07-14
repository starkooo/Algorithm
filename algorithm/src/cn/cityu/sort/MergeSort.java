package cn.cityu.sort;

public class MergeSort {

    //归并所需要的辅助数组
    private static Comparable[] assit;

    //对数组a进行排序
    public static void sort(Comparable[] a){
        //1.初始化辅助数组assit
        assit = new Comparable[a.length];
        //2.定义一个lo变量和hi变量，分别记录数组中最小索引和最大索引
        int lo = 0;
        int hi = a.length - 1;
        //3.调用sort重载方法完成数组a中，从索引lo到索引hi的元素排序
        sort(a,lo,hi);
    }

    //对数组a从lo到hi的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi){
        //校验
        if (lo >= hi){
            return;
        }

        //对lo到hi之间的数据进行分为2组
        int mid = lo + (hi - lo)/2;

        //分别对每一组数据进行排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        //排完序后再把两个组中的数据进行归并
        merge(a,lo,mid,hi);
    }

    //对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组进行归并
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        //遍历，移动p1、p2指针，比较对应索引的值，找到小的那个，放到辅助数组的对应索引处
        while (p1 <= mid && p2 <= hi){
            //比较对应索引处的值
            if (less(a[p1],a[p2])){
                assit[i++] = a[p1++];
            }else {
                assit[i++] = a[p2++];
            }
        }

        //遍历，如果p1指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1 <= mid){
            assit[i++] = a[p1++];
        }
        //遍历，如果p2指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p2 <= hi){
            assit[i++] = a[p2++];
        }
        //把辅助数组中的元素拷贝到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assit[index];
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
