package com.atguigu.linkedlist;

/**
 * ************************
 *
 * @Description: 双向链表
 * @Author: wanghaining
 * @Date: Create in 2019/9/4 15:53
 * <p>
 * ************************
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表：");
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode2 hero5 = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(hero5);
        System.out.println("修改后的链表：");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表：");
        doubleLinkedList.list();

    }
}

class DoubleLinkedList {
    static HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 遍历链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head;
        while (true) {
            //判断链表是否到了最后
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            //将temp后移
            temp = temp.next;
        }
    }

    /**
     * 添加节点
     */
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                //直接在链表末尾添加节点，并退出
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改节点信息
     */
    public void update(HeroNode2 newNode) {
        HeroNode2 temp = head.next;
        //是否找到要修改的节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("没有找到编号%d的节点,不能修改\n", newNode.no);
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，不能删除！");
        }
        HeroNode2 temp = head.next;
        //是否找到要删除的节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.pre;
            }
        } else {
            System.out.printf("没有找到编号%d的节点,不能删除\n", no);
        }
    }


}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}