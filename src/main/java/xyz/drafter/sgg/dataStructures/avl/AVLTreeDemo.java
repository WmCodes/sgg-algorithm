package xyz.drafter.sgg.dataStructures.avl;

/**
 * @author wangmeng
 * @date 2019/8/19
 * @desciption
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
        //int[] arr = {10,12,8,9,7,6};
        int[] arr = {10,11,7,6,8,9};// 旋转后 还是非平衡二叉树
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i =0 ;i<arr.length;i++){
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();

        System.out.println("做平衡处理");
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot());
    }
}

class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    // 当做二叉排序树的根节点
    // 返回以二叉排序树的最小节点，node为根节点
    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;

    }


    //删除节点
    public void delNode(int value){
        if (root == null) {
            return ;
        } else {
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            if (root.left == null && root.right == null && root.value == value){
                root = null;
                return;
            }
            Node parent = searchParent(value);

            if (targetNode.left == null && targetNode.right == null){
                //要删除的节点为叶子节点
                //判断targetNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                // 要删除的节点有左右节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                // 要删除的节点只有一个节点
                if (targetNode.left != null){
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }

            }
        }
    }

}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    //返回当前节点的高度，以该节点为根节点的树的高度
    public int height(){
        return Math.max(left == null?0:left.height(), right == null?0:right.height())+1;
    }

    // 左旋转
    private void leftRotate(){
        // 创建新节点，以当前根节点的值
        Node newNode = new Node(value);
        // 新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        // 新节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //当前节点的值替换成右子节点的值
        value = right.value;
        // 当前节点的右子树设置成当前结点的右子树的右子树
        right = right.right;
        // 当前结点的左子树设置成新的节点
        left = newNode;
    }

    // 右旋转
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    // 查找要删除的节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //添加结点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断掺入结点的值 和当前子树的根节点的值关系
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        // 当添加完一个节点后，(右子树的高度-左子树的高度)>1，左旋转
        if (rightHeight() - leftHeight() >1){

            if (right != null && right.leftHeight()>right.rightHeight()){
                // 如果它的右子树的左子树的高度大于它的右子树的右子树的高度，
                // 先对右子节点进行右旋转
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() >1){

            if (left != null && left.rightHeight()>left.leftHeight()){
                //先对当前节点的左节点(左子树)->左旋转
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }


    }


    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
