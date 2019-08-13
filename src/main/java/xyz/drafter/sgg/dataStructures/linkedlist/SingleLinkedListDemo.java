package xyz.drafter.sgg.dataStructures.linkedlist;

import java.util.Stack;

/**
 * @author wangmeng
 * @date 2019/8/13
 * @desciption
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "A", "a");
        HeroNode heroNode2 = new HeroNode(2, "B", "b");
        HeroNode heroNode3 = new HeroNode(3, "C", "c");
        HeroNode heroNode4 = new HeroNode(4, "D", "d");


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /*singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);*/
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.list();
        HeroNode heroNode5 = new HeroNode(2, "E","e");
        singleLinkedList.update(heroNode5);
        singleLinkedList.list();
        singleLinkedList.del(3);
        singleLinkedList.list();
    }

    static class SingleLinkedList{
        // 头节点
        private HeroNode head = new HeroNode(0, "", "");

        // 不考虑编号顺序，直接找到最后节点  修改next域
        public void add(HeroNode headNode){
            HeroNode temp = head;
            while (true){
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = headNode;

        }

        //删除节点
        public void del(int no){
            HeroNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next == null){
                    break;
                }
                if (temp.next.no == no){
                    flag = true;
                    break;
                }

                temp = temp.next;
            }
            if (flag){
                temp.next = temp.next.next;
            }else {
                System.out.println("没有要删除的节点");
            }

        }

        //修改节点的信息
        public void update(HeroNode heroNode){
            if (head.next == null){
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            boolean flag = false;
            while (true){
                if (temp == null){
                    break;
                }
                if (temp.no == heroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;

            }

            if (flag){
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
            }else {
                System.out.println("没有该节点");
            }


        }

        // 显示链表
        public void list(){
            if (head.next == null){
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            while (true){
                if (temp == null){
                    break;
                }
                System.out.println(temp);
                temp = temp.next;

            }
        }



        public void addByOrder(HeroNode heroNode){
            HeroNode temp = head;
            boolean flag = false;//标识添加的编号是否存在，默认false
            while (true){
                if (temp.next == null){ //temp在链表后
                    break;
                }
                if (temp.next.no>heroNode.no){ //temp后面插入
                    break;
                }
                if (temp.next.no == heroNode.no){ //编号存在
                    flag = true;
                    break;
                }

                temp = temp.next;
            }

            if (flag){
                // 不能添加
                System.out.println("已经存在");
            }else {
                //插入temp后面
                heroNode.next = temp.next;
                temp.next = heroNode;

            }

        }

        // 查找单链表中的倒数第K个节点
        public static HeroNode findLastIndexNode(HeroNode heroNode,int  index){
                if (heroNode.next == null){
                    return null;
                }
                int size = getLength(heroNode);
                if (index <= 0|| index>size){
                    return null;
                }

                HeroNode cur = heroNode.next;

                for (int i = 0;i<size -index;i++){
                    cur = cur.next;
                }
                return cur;


        }
        // 单链表逆序打印，使用栈方式
        public static void reversePoint(HeroNode heroNode){
            if (heroNode.next == null){
                return;
            }
            Stack<HeroNode> stack = new Stack<>();
            HeroNode cur = heroNode.next;
            while (cur != null){
                stack.push(cur);
                cur = cur.next;
            }
            while (stack.size()>0){
                System.out.println(stack.pop());
            }


        }


        //单链表反转
        public static void reverseList(HeroNode heroNode){
            if (heroNode.next ==null||heroNode.next.next ==null){
                return;
            }


            HeroNode cur = heroNode.next;
            HeroNode next = null;
            HeroNode reverseHead = new HeroNode(0, "", "");
            while (cur!= null){
                next = cur.next;
                cur.next = reverseHead.next; //将cur的下一个节点指向新的链表的最前端
                reverseHead.next = cur;
                cur = next;
            }
            heroNode.next = reverseHead.next;

        }


        // 获取单链表的节点个数(头节点不统计)
        public static int getLength(HeroNode heroNode){
            if (heroNode.next == null){
                return 0;
            }
            int length = 0;

            HeroNode cur = heroNode.next;
            while (cur != null){
                length++;
                cur = cur.next;
            }
            return length;
        }



        // 查找单链表的倒数第K个节点

    }

    static class  HeroNode{
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;

        public HeroNode(int no,String name,String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }


        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname +
                    '}';
        }
    }
}
