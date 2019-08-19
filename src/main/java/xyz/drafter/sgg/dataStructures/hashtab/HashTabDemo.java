package xyz.drafter.sgg.dataStructures.hashtab;

/**
 * @author wangmeng
 * @date 2019/8/16
 * @desciption
 */
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Emp emp1 = new Emp(1, "A");
        Emp emp2 = new Emp(2, "B");
        Emp emp3 = new Emp(3, "C");
        Emp emp4 = new Emp(4, "D");
        Emp emp5 = new Emp(5, "E");
        Emp emp6 = new Emp(6, "F");
        Emp emp7 = new Emp(7, "G");
        Emp emp8 = new Emp(8, "H");
        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);
        hashTab.add(emp4);
        hashTab.add(emp5);
        hashTab.add(emp6);
        hashTab.add(emp7);
        hashTab.add(emp8);

        hashTab.list();
        hashTab.findEmpById(9);

    }
}
// 创建HashTab 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size){
        this.size = size;
        // 初始化 empLinkedLists
        empLinkedLists = new EmpLinkedList[size];
        // 分别初始化每个链表
        for (int i = 0; i<size;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }

    }

    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedLists[empLinkedListNo].add(emp);

    }

    // 遍历所有的链表 hashtab
    public void list(){
        for (int i = 0;i<size;i++){
            empLinkedLists[i].list(i+1);
        }
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].findEmpById(id);
        if (emp!= null){
            System.out.println("在第"+(empLinkedListNo+1)+"找到:"+emp);
        }else {
            System.out.println("未找到");
        }
    }

    // 编写散列函数
    public int hashFun(int id){
        return id % size;
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// 创建EmpLinkedList 表示链表
class EmpLinkedList{
    // 头指针
    private Emp head;

    // 加到最后
    public void add(Emp emp){
        // 如果添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(int no){
        if (head == null){
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.print("第"+no+"链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.print(curEmp);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }

        System.out.println();
    }

    // 根据id查找雇员
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表中不存在");
            return null;
        }

        Emp curEmp = head;
        while (true){
            if (curEmp == null || curEmp.id == id){
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;

    }
}
