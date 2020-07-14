package cn.cityu.test;

import cn.cityu.linear.Stack;

public class ReversePolishNotationTest {

    public static void main(String[] args) {
        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下 6+3=9
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int caculate(String[] notation){
        //1.定义一个栈存储操作数
        Stack<Integer> oprands = new Stack<>();
        //2.从左往右得到逆波兰表达式，的到每一个元素
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            //3.判断当前元素是运算符还是操作数
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr){
                //4.是运算符，从栈中弹出两个操作数，完成运算，把运算完的结果压入栈中
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 + o2;
                    oprands.push(result);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 - o1;
                    oprands.push(result);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 * o2;
                    oprands.push(result);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 / o1;
                    oprands.push(result);
                    break;
                //5.是操作数，把该操作数压入栈中
                default:
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        //6.遍历结束，得到栈中最后一个元素，就是表达式最终结果
        int result = oprands.pop();
        return result;
    }
}
