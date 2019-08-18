package xyz.drafter.sgg.dataStructures.tree;

/**
 * @author wangmeng
 * @date 2019/8/18
 * @desciption 线索化二叉树
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {

    }
}


class HeroNode1{
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;

    private int leftType;// 0 为左子树  1则表示前驱节点
    private int rigthType;// 0 为右子树  1表示后驱节点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRigthType() {
        return rigthType;
    }

    public void setRigthType(int rigthType) {
        this.rigthType = rigthType;
    }

    public HeroNode1(int no, String name){
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

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
