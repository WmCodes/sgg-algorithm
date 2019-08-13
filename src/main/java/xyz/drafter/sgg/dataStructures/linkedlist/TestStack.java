package xyz.drafter.sgg.dataStructures.linkedlist;

import java.util.Stack;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption
 */
public class TestStack {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
}
