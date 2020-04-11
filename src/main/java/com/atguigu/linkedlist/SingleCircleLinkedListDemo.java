package com.atguigu.linkedlist;

/**
 * ************************
 *
 * @Description: 单向环形链表（约瑟夫问题josephu）
 * @Author: wanghaining
 * @Date: 2020/4/11 9:50
 * <p>
 * ************************
 */
public class SingleCircleLinkedListDemo {
    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addBoys(5);
        singleCircleLinkedList.showBoy();
        singleCircleLinkedList.popBoy(1, 2, 5);
    }
}

class SingleCircleLinkedList {
    private Boy first = null;

    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不能小于1");
            return;
        } else {
            Boy curBoy = null;
            for (int i = 1; i <= nums; i++) {
                Boy boy = new Boy(i);
                if (i == 1) {
                    first = boy;
                    boy.setNext(first);
                    curBoy = first;
                } else {
                    boy.setNext(first);
                    curBoy.setNext(boy);
                    curBoy = boy;
                }
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("编号=" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * @param startNo  开始的编号
     * @param countSum 淘汰位置
     * @param nums     小孩总数
     */
    public void popBoy(int startNo, int countSum, int nums) {
        if (first == null || startNo < 1 || startNo > nums || countSum < 0) {
            System.out.println("参数有误");
            return;
        }
        Boy helper = first;
        //移动到最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        //移动到开始位置
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        //循环知道只有一个
        while (true) {
            if (helper == first) {
                System.out.printf("淘汰编号%d\t", first.getNo());
                break;
            }
            for (int i = 0; i < countSum - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.printf("淘汰编号%d\t", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }

}

/**
 * 表示一个节点
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
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


