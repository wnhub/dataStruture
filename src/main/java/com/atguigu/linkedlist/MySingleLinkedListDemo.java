package com.atguigu.linkedlist;

public class MySingleLinkedListDemo {
    public static void main(String[] args) {
        MyHeroNode hero1 = new MyHeroNode(1, "宋江", "及时雨");
        MyHeroNode hero2 = new MyHeroNode(2, "卢俊义", "玉麒麟");
        MyHeroNode hero3 = new MyHeroNode(3, "吴用", "智多星");
        MyHeroNode hero4 = new MyHeroNode(4, "林冲", "豹子头");
        MyHeroNode hero5 = new MyHeroNode(5, "林冲", "豹子头");
        MyHeroNode hero6 = new MyHeroNode(6, "林冲", "豹子头");
        MyHeroNode hero7 = new MyHeroNode(7, "林冲1", "豹子头1");

        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        mySingleLinkedList.addByNo(hero1);
        mySingleLinkedList.addByNo(hero6);
        mySingleLinkedList.addByNo(hero2);
        mySingleLinkedList.addByNo(hero4);
        MyHeroNode headNode = mySingleLinkedList.getHeadNode();


        mySingleLinkedList.list(headNode);
        System.out.println("---------------------");
        mySingleLinkedList.update(hero5);
        System.out.println("链表长度=" + mySingleLinkedList.getLength());
        mySingleLinkedList.list(headNode);
        System.out.println("---------------------");
        mySingleLinkedList.delete(2);
        mySingleLinkedList.list(headNode);
        System.out.println("---------------------");
        System.out.println("链表长度=" + mySingleLinkedList.getLength());
        System.out.println("---------------------");
        mySingleLinkedList.reverse();


        System.out.println("---------------------");
        MySingleLinkedList mySingleLinkedList1 = new MySingleLinkedList();
        mySingleLinkedList1.addByNo(hero5);
        mySingleLinkedList1.addByNo(hero3);
        mySingleLinkedList1.addByNo(hero7);
        mySingleLinkedList1.addByNo(hero1);


    }
}

class MySingleLinkedList {
    private MyHeroNode headNode = new MyHeroNode(0, "", "");

    public MyHeroNode getHeadNode() {
        return headNode;
    }

    public void add(MyHeroNode node) {
        MyHeroNode temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    public void addByNo(MyHeroNode node) {
        MyHeroNode temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                break;
            }

            if (temp.getNext().getNo() > node.getNo()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            } else if (temp.getNext().getNo() == node.getNo()) {
                System.out.printf("已有此编号(%d)，不能重复添加！\n", node.getNo());
                break;
            }

            temp = temp.getNext();
        }
    }

    public void list(MyHeroNode headNode) {
        MyHeroNode temp = headNode.getNext();
        if (temp == null) {
            System.out.println("队列为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void update(MyHeroNode node) {
        MyHeroNode temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == node.getNo()) {
                temp.getNext().setName(node.getName());
                temp.getNext().setNickName(node.getNickName());
                break;
            }
            temp = temp.getNext();
        }
        System.out.println("=======");
    }

    public void delete(int no) {
        MyHeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("要删除的节点不存在");
        }

    }

    public int getLength() {
        MyHeroNode temp = headNode;
        int length = 0;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext() != null) {
                length++;
                temp = temp.getNext();
            }
        }
        return length;
    }

    public void reverse() {
        if (headNode.getNext() == null || headNode.getNext().getNext() == null) {
            return;
        }
        MyHeroNode cur = headNode.getNext();
        MyHeroNode next;
        MyHeroNode myHeadNode = new MyHeroNode(0, "", "");

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(myHeadNode.getNext());
            myHeadNode.setNext(cur);
            cur = next;
        }
        list(myHeadNode);
        System.out.println("~~~~~~~~~~~~~");
        list(headNode);
    }

    public void addByNoWithNode(MyHeroNode node) {
        MyHeroNode temp = headNode;
        while (node.getNext() != null) {

            while (true) {
                if (temp.getNext() == null) {
                    temp.setNext(node);
                    break;
                }
                if (temp.getNext().getNo() > node.getNo()) {
                    node.setNext(temp.getNext());
                    temp.setNext(node);
                    break;
                } else if (temp.getNext().getNo() == node.getNo()) {
                    System.out.printf("已有此编号(%d)，不能重复添加！\n", node.getNo());
                    break;
                }

                temp = temp.getNext();
            }
        }
    }


}

class MyHeroNode {
    private int no;
    private String name;
    private String nickName;
    private MyHeroNode next;

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setNext(MyHeroNode next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public MyHeroNode getNext() {
        return next;
    }

    public MyHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "MyHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

