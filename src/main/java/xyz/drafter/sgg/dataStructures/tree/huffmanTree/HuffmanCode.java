package xyz.drafter.sgg.dataStructures.tree.huffmanTree;

import java.util.*;

/**
 * @author wangmeng
 * @date 2019/8/18
 * @desciption
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] contents = str.getBytes();
        System.out.println(contents.length);
        List<Node1> node1s = getNodes(contents);
        System.out.println(node1s);

        Node1 huffmanTreeRoot = createHuffmanTree(node1s);
        huffmanTreeRoot.preOrder();
        //getCodes(huffmanTreeRoot, "", stringBuilder);
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        System.out.println("*********************"+codes);
    }
    // 生成赫夫曼树对应的赫夫曼编码
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    private static Map<Byte,String> getCodes(Node1 root){
        if (root == null){
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    //node1传入结点  code:路径 左子节点0，右子结点1  stringBuilder：拼接路径
    private static void getCodes(Node1 node1,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node1 != null){
            if (node1.data == null){
                //非叶子结点
                getCodes(node1.left, "0",stringBuilder1);
                getCodes(node1.right, "1",stringBuilder1);
            }else {
                // 叶子结点
                huffmanCodes.put(node1.data, stringBuilder1.toString());
            }
        }


    }

    private static void preOrder(Node1 root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空");
        }
    }

    private static List<Node1> getNodes(byte[] bytes){
        ArrayList<Node1> node1s = new ArrayList<>();
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b:bytes){
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b, 1);
            }else {
                counts.put(b,count+1);
            }
        }

        // 把每个键值转换一个Node对象，加入nodes集合
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            node1s.add(new Node1(entry.getKey(), entry.getValue()));
        }

        return node1s;

    }

    //通过List创建对应的赫夫曼树
    private static Node1 createHuffmanTree(List<Node1> node1s){

        while (node1s.size()>1){
            Collections.sort(node1s);
            Node1 lefrNode = node1s.get(0);
            Node1 rightNode = node1s.get(1);

            Node1 parent = new Node1(null,lefrNode.weight+rightNode.weight);

            parent.left = lefrNode;
            parent.right = rightNode;
            node1s.remove(lefrNode);
            node1s.remove(rightNode);
            node1s.add(parent);
        }

        return node1s.get(0);

    }
}


class  Node1 implements Comparable<Node1>{
    Byte data;// 数据本身
    int weight;
    Node1 left;
    Node1 right;

    public Node1(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node1 o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }
    }
}