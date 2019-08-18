package xyz.drafter.sgg.dataStructures.tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangmeng
 * @date 2019/8/18
 * @desciption 赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root  = createHuffmanTree(arr);
        root.preOrder();

    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("该树为空");
        }
    }


    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for (int value:arr){
            nodes.add(new Node(value));
        }

        while (nodes.size()>1) {
            Collections.sort(nodes);
            System.out.println(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.rigth = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
            System.out.println(nodes);
        }
        //返回赫夫曼树的root点
        return nodes.get(0);

    }
}

class Node implements Comparable<Node>{
    int value;//结点权值
    char c;
    Node left;
    Node rigth;

    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }

        if (this.rigth != null) {
        this.rigth.preOrder();
        }
    }



    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", c=" + c +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大
        return this.value - o.value;
    }
}
