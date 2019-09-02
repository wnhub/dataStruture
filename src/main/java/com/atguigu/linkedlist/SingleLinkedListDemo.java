package com.atguigu.linkedlist;

/**
 * ************************
 *
 * @Description: 单链表
 * @Author: wanghaining
 * @Date: Create in 2019/9/2 10:23
 * <p>
 * ************************
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();

        HeroNode hero5 = new HeroNode(5, "林冲", "禁军教头");
        singleLinkedList.update(hero5);

        System.out.println("修改后的链表：");
        singleLinkedList.list();

        singleLinkedList.delete(4);
        singleLinkedList.delete(2);
        System.out.println("删除后的链表：");
        singleLinkedList.list();

        System.out.println("链表的节点数量：" + SingleLinkedList.getLength());

        int index = 2;
        HeroNode res = SingleLinkedList.findLastIndexNode(index);
        System.out.printf("倒数第%d个节点是%S", index, res);
    }
}

/**
 * 定义SingleLinkedList,来管理我们的hero
 */
class SingleLinkedList {
    static HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                //直接在链表末尾添加节点，并退出
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 第二种添加节点的方法（根据编号按顺序添加到指定位置）
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        //判断编号是否已经存在
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //到达链表末尾
                break;
            }
            if (temp.next.no > node.no) {
                //找到应该插入的位置，即temp的后面
                break;
            } else if (temp.next.no == node.no) {
                //准备添加的节点编号已经存在
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的节点的编号%d已经存在了，不能加入\n", node.no);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
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
     * 修改节点信息
     */
    public void update(HeroNode newNode) {
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        //是否找到要删除的节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号%d的节点,不能删除\n", no);
        }
    }

    /**
     * 获取链表中的节点数量
     *
     * @return
     */
    public static int getLength() {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 新浪面试题
     * 查找单链表的第index个节点
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength();
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量，循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }



}

/**
 * 每个HeroNode对象都是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}