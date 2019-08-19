package xyz.drafter.sgg.dataStructures.tree;

/**
 * @author wangmeng
 * @date 2019/8/16
 * @desciption
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        HeroNode h1 = new HeroNode(1, "A");
        HeroNode h2 = new HeroNode(2, "A");
        HeroNode h3 = new HeroNode(3, "A");
        HeroNode h4 = new HeroNode(4, "A");
       HeroNode h5 = new HeroNode(5, "A");
  /*       HeroNode h6 = new HeroNode(6, "A");
        HeroNode h7 = new HeroNode(7, "A");
        HeroNode h8 = new HeroNode(8, "A");*/
        h1.setLeft(h2);
        h1.setRight(h3);
        h3.setRight(h4);
        h3.setLeft(h5);
        binaryTree.setRoot(h1);

       /*   binaryTree.preOrder();

        binaryTree.infixOrder();*/

       HeroNode result = binaryTree.postOrderSearch(15);
       if (result != null){
           System.out.println(result);
       }else {
           System.out.println("没有找到num为5的人");
       }

    }
}


// 定义BinaryTree
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    // 中序遍历查找
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    // 后序遍历查找
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder(){
        // 先输出父结点
        System.out.println(this);

        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }

    }

    // 中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }

        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        // 比较当前结点是不是
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;

        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;

    }

    // 中序遍历
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;

        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    // 后序遍历
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;

        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        return resNode;

    }
}


