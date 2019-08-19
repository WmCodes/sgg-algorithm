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
        byte[] huffmanCodesBytes = huffmanZip(contents);
        System.out.println("huffmanCodeBytes="+Arrays.toString(huffmanCodesBytes));

        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原字符串:"+new String(sourceBytes));
      /*  List<Node1> node1s = getNodes(contents);
        System.out.println(node1s);

        Node1 huffmanTreeRoot = createHuffmanTree(node1s);
        huffmanTreeRoot.preOrder();
        //getCodes(huffmanTreeRoot, "", stringBuilder);
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        System.out.println("*********************"+codes);
        byte[] huffmanCodeBytes = zip(contents, codes);
        System.out.println("huffmanCodeBytes="+Arrays.toString(huffmanCodeBytes));*/
    }

    // 完成数据的解压
    //1.将huffmanCodeBytes=[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28] 重新转成 赫夫曼编码对应的二进制字符串
    //2. 赫夫曼编码对应的二进制字符串对照 赫夫曼编码重新转成字符串

    //对压缩数据的解码
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        // 先得到huffmanBytes对应的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        for (int i=0;i<huffmanBytes.length;i++){
            String str ;
            if (i == huffmanBytes.length-1){
                str = byteToBitString(true,huffmanBytes[i]);
            }else {
                str = byteToBitString(false,huffmanBytes[i]);
            }
            stringBuilder.append(str);
        }
        System.out.println("解码后的二进制内容:"+stringBuilder.toString());
        // 将字符串按照指定的赫夫曼编码进行解码
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String>entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        // 创建集合  存放byte
        List<Byte> list = new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            int count = 1;// 小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag){
                //取出
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if (b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[]  b = new byte[list.size()];
        for (int i=0;i<b.length;i++){
         b[i] = list.get(i);
        }
        return b;
    }

    //将一个byte转成一个二进制的字符串
    private static String byteToBitString(boolean flag,byte b){
        if (flag) {
            return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(" ", "");
        }else {
            return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(" ", "0");
        }
    }






    // 使用一个方法，封装前面的方法
    // bytes :原始字符串对应的字节数组
    // 返回的经过huffman编码处理后的字节数组
    private static byte[] huffmanZip(byte[] bytes){
        List<Node1> node1s = getNodes(bytes);
        Node1 huffmanTreeRoot = createHuffmanTree(node1s);
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes, codes);
        return huffmanCodeBytes;

    }


    // 编写一个方法，将一个字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[] 数组
    // bytes:这时原始的字符串对应的byte[]    huffmanCodes:生成的赫夫曼编码map  返回赫夫曼编码处理后的byte[]
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("stringBuilder="+stringBuilder.toString());
        //1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //将上面内容转换成byte[]
        int len;
        if (stringBuilder.length() % 8 ==0){
            len =stringBuilder.length() /8;
        }else {
            len = stringBuilder.length()/8+1;
        }

        // int len = (stringBuilder.length()+7)/8;
        //创建存储压缩后的byte[]
        byte[] by = new byte[len];
        int index = 0;
        for (int i =0 ;i<stringBuilder.length();i+=8){
            String strByte;
            if (i+8>stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            // 将strByte转换成一个byte，放入到by中
            by[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return by;
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