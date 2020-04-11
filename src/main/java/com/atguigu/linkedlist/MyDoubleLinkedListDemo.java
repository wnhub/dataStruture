package com.atguigu.linkedlist;

public class MyDoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表：");
        //创建节点
        MyDoubleLinkedListHeroNode hero1 = new MyDoubleLinkedListHeroNode(1, "宋江", "及时雨");
        MyDoubleLinkedListHeroNode hero2 = new MyDoubleLinkedListHeroNode(2, "卢俊义", "玉麒麟");
        MyDoubleLinkedListHeroNode hero3 = new MyDoubleLinkedListHeroNode(3, "吴用", "智多星");
        MyDoubleLinkedListHeroNode hero4 = new MyDoubleLinkedListHeroNode(4, "林冲", "豹子头");

        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();

        myDoubleLinkedList.addByNo(hero1);
        myDoubleLinkedList.addByNo(hero3);
        myDoubleLinkedList.addByNo(hero2);
        myDoubleLinkedList.addByNo(hero4);

        myDoubleLinkedList.list();

    }
}

class MyDoubleLinkedList {
    private MyDoubleLinkedListHeroNode head = new MyDoubleLinkedListHeroNode(0, "", "");

    public MyDoubleLinkedListHeroNode getHead() {
        return head;
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        MyDoubleLinkedListHeroNode temp = head;
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
    public void add(MyDoubleLinkedListHeroNode node) {
        MyDoubleLinkedListHeroNode temp = head;
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

    public void addByNo(MyDoubleLinkedListHeroNode node) {
        MyDoubleLinkedListHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }

            if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.pre = node;
                temp.next = node;
                node.pre = temp;
                break;
            } else if (temp.next.no == node.no) {
                System.out.printf("已有此编号(%d)，不能重复添加！\n", node.no);
                break;
            }

            temp = temp.next;
        }
    }

}

class MyDoubleLinkedListHeroNode {
    public int no;
    public String name;
    public String nickName;
    public MyDoubleLinkedListHeroNode pre;
    public MyDoubleLinkedListHeroNode next;


    public MyDoubleLinkedListHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "MyDoubleLinkedListHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
