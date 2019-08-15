package xyz.drafter.sgg.dataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption 逆波兰表达式计算
 */
public class PolandNotation {

    public static void main(String[] args) {
        //中缀表达式转换成后缀表达式
        String expression = "11+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式list: "+parseSuffixExpressionList);




        // (3+4)x5-6 =>3 4 + 5 x 6 -
        //数字和符号使用空格隔开
        //String suffixExpression = "30 4 + 5 * 6 -";

        //List<String> rpnList = getListString(suffixExpression);
        //System.out.println(rpnList);
        //int res = calculate(rpnList);
        //System.out.println(res);

    }

    //将中缀表达式对应的list =>后缀表达式对应的list
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        List<String> s2 = new ArrayList<>();// 存储中间结果的Lists2

        for (String item:ls){
            if (item.matches("\\d+")){
                // 为数
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //item小于等s1栈顶的优先级时，将s1栈顶运算符弹出s1放入s2，在将item和现在的s1栈顶比较
                while (s1.size()!= 0 &&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1剩余的运算符依次弹出加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;//存放为list 正常输出就是逆波兰表达式
    }

    //中缀表达式转换成对应的List
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0;//用于遍历中缀表达式字符串
        String str;//对多位数的拼接
        char c;
        do{

            if ((c=s.charAt(i))<48|| (c=s.charAt(i))>57){
                //非数字
                ls.add(""+c);
                i++;
            }else {
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48 &&(c=s.charAt(i))<=57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String str:split){
            list.add(str);
        }
        return list;

    }

    // 逆波兰表达式的运算
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<String>();
        for (String item:list){
            if (item.matches("\\d+")){//匹配的是多位数
                stack.push(item);
            }else {
                //pop出两个数并运算在入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 +num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1/num2;
                }else {
                    throw new RuntimeException("不支持该运算符");
                }

                stack.push(res+"");
            }
        }

        return Integer.parseInt(stack.pop());
    }

}

// 编写一个类 Operation ,返回运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private  static  int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String opration){
        int result = 0;
        switch (opration){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;

        }
        return result;
    }
}