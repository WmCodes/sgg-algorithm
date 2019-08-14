package xyz.drafter.sgg.dataStructures.stack;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption
 */
public class ArrayStackDemo {


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.list();
        System.out.println(arrayStack.pop());

    }

}

// 定义一个ArrayStack 表示栈
class ArrayStack{
    private int maxSize; //栈的大小
    private int[] stack; // 数组
    private int top = -1;//表示栈顶，初始化为-1


    public ArrayStack(int maxSize){
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
}
