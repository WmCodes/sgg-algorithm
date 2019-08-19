package xyz.drafter.sgg.dataStructures.binarySortTree;

/**
 * @author wangmeng
 * @date 2019/8/19
 * @desciption 二叉排序树(BTS)
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        System.out.println("**********************");
        binarySortTree.delNode(7);
        binarySortTree.infixOrder();

    }
}

//创建二叉排序树
class BinarySortTree {
    private Node root;

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
