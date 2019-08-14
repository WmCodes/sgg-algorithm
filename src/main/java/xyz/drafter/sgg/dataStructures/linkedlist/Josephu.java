package xyz.drafter.sgg.dataStructures.linkedlist;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption 约瑟夫问题
 */
public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1, 2, 5);//2 4 1 5 3
    }
}

//创建环形单向链表
class CircleSingleLinkedList{
    // 创建一个first节点，当前没有编号
    private Boy first = null;
    // 添加小孩节点，构建一个环形的链表
    public void addBoy(int nums){
        if (nums <1){
            System.out.println("nums不正确");
        }
        Boy curBoy = null;
        for (int i =1;i<= nums;i++){
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;// curBoy指向第一个小孩
            }else {

                curBoy.setNext(boy);//
                boy.setNext(first);
                curBoy = boy;

            }
        }

    }


    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        // first不能动，使用辅助指针
        Boy curBoy = first;
        while (true){
            System.out.println("编号:"+curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();//后移
        }


    }


    // 根据用户的输入，计算出出圈的顺序
    /**
     *
     *
     * @author wangmeng
     * @date 2019/8/14 14:02
     * @param [startNo, countNum, nums]
     * @return void
     * @Instructions 从第几个小孩报数，数几下，最初的小孩子数量
     */
    public void countBoy(int startNo,int countNum,int nums){
        if (first ==null || startNo <1 || startNo > nums){
            System.out.println("参数输入有误");
            return;
        }
        Boy helper =first;
        while (true){
            if (helper.getNext() == first){
                break;
            }

            helper = helper.getNext();
        }
        // 小孩报数之前，先让first和helper移动k-1次
        for (int j = 0;j<startNo -1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first 和helper指针同时的移动m-1次，然后出圈
        while (true){
            if (helper == first){
                break;
            }
            //
            for (int j =0;j< countNum -1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的是要出圈的节点
            System.out.println("出圈: "+first.getNo());
            // 移除该节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈存的小孩的编号"+first.getNo());

    }
}


//创建boy类，表示节点
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
