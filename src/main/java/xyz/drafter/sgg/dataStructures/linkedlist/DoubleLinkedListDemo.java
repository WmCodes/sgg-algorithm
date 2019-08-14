package xyz.drafter.sgg.dataStructures.linkedlist;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("测试双向链表");
        HeroNode2 h1 = new HeroNode2(1, "A", "a");
        HeroNode2 h2 = new HeroNode2(2, "B", "b");
        HeroNode2 h3 = new HeroNode2(3, "C", "c");
        HeroNode2 h4 = new HeroNode2(4, "D", "d");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(h1);
        doubleLinkedList.add(h2);
        doubleLinkedList.add(h3);
        doubleLinkedList.add(h4);

        doubleLinkedList.list();

        HeroNode2 h5 = new HeroNode2(4, "E", "e");
        doubleLinkedList.update(h5);
        doubleLinkedList.list();
        doubleLinkedList.del(3);
        doubleLinkedList.list();


    }


}

class DoubleLinkedList{

    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead(){
        return head;
    }

    // 遍历双向链表
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        while (temp!= null){

            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 在最后一位添加
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 顺序添加

    // 修改一个节点的内容
    public void update(HeroNode2 heroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
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
            System.out.println("没有找到该节点");
        }
    }

    // 双向链表中删除一个节点
    public void del(int no){
        // 判断当前链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag){
            temp.pre.next = temp.next;
            // 如果最后一个一节，不需要执行下面依据，否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("要删除的节点不存在");
        }



    }


}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
