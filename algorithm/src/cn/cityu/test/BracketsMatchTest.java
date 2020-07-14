package cn.cityu.test;

import cn.cityu.linear.Stack;

public class BracketsMatchTest {

    public static void main(String[] args) {
        String str = "上海((长安)())";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配："+match);
    }

    public static boolean isMatch(String str){
        //1.创建栈对象
        Stack<String> chars = new Stack<>();
        //2.从左往右遍历
        for (int i = 0; i < str.length(); i++) {
            //返回char对象操作不方便，加个""就能转化为String
            String currChar = str.charAt(i) + "";
            //3.判断当前字符为左括号，是，放入栈中
            if (currChar.equals("(")){
                chars.push(currChar);
            }else if (currChar.equals(")")){
                //4.继续遍历，判断当前字符是否为右括号，是，则从栈中弹出一个左括号，并判断弹出的结果是否为null，为null，则没有匹配的左括号；不为null，则有匹配的左括号
                String pop = chars.pop();
                if (pop == null){
                    return false;
                }
            }
        }
        //5.判断栈中还有没有剩余的左括号，有，则括号不匹配
        if (chars.size() == 0){
            return true;
        }else
            return false;
    }

}
