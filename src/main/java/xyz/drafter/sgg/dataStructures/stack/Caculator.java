package xyz.drafter.sgg.dataStructures.stack;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption
 */
public class Caculator {
    public static void main(String[] args) {
        String expression = "700+2*6-4";// 两位数以上处理不了
        //创建两个栈，数栈 符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepNum = "";

        char ch =  ' ';
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        // 当前操作符的优先级小于或者等于栈中操作符，就需要从数栈中pop出两个数，从符号栈中pop出一个符号，进行运算，并将得到结果入数栈，当前操作符入符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    // 为空直接入栈
                    operStack.push(ch);

                }
            }else {
                //numStack.push(ch-48);// '1' :48
                //当处理多位数时，不能发现一个数就立即入栈
                keepNum += ch;
                //如果ch 已经是expression的最后一位，就直接入栈
                if (index == expression.length() -1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }

        // 表达式扫描完毕
        while (true){
            //符号栈为空，计算到最后结果，数栈只有最后一个结果
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);

        }

        System.out.println("表达式计算结果: "+numStack.pop());

    }

}

//
class ArrayStack2{
    private int maxSize; //栈的大小
    private int[] stack; // 数组
    private int top = -1;//表示栈顶，初始化为-1


    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    // 栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    public int peek(){
        return stack[top];
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;

    }

    // 遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，无数据");
            return;
        }

        for (int i = top;i>=0;i--){
            System.out.println("栈数据: "+stack[i]);
        }
    }

    //返回运算符的优先级，由人为来定:使用数字表示，数字越大，优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+'||oper == '-'){
            return 0;
        }else {
            return -1;//假定表达式为 + - * /
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' ||val =='-'||val =='*'||val == '/';
    }
    // 计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;// 计算结果
        switch (oper){
            case '+':
                res = num1 +num2;
                break;
            case '-':
                res = num2 - num1;//后弹出的数据放在前面
                break;
            case '/':
                res = num2 / num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            default:
                break;
        }
        return res;
    }
}
