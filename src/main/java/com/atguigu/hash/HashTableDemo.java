package com.atguigu.hash;

/**
 * ************************
 *
 * @Description: 哈希表
 * @Author: wanghaining
 * @Date: 2020/4/23 10:01
 * <p>
 * ************************
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        Emp emp1 = new Emp(1, "aa");
        Emp emp2 = new Emp(2, "bb");
        Emp emp3 = new Emp(3, "cc");
        Emp emp4 = new Emp(4, "dd");
        Emp emp5 = new Emp(8, "ee");
        Emp emp6 = new Emp(9, "ff");
        hashTable.add(emp1);
        hashTable.add(emp2);
        hashTable.add(emp3);
        hashTable.add(emp4);
        hashTable.add(emp5);
        hashTable.add(emp6);
        hashTable.list();
        hashTable.findEmpById(90);
    }
}

class HashTable {
    public EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int index = getListIndex(emp.id);
        empLinkedListArray[index].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.printf("链表%d:\n", (i + 1));
            empLinkedListArray[i].list();
        }
    }

    public void findEmpById(int id) {
        int index = getListIndex(id);
        Emp emp = empLinkedListArray[index].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d链表找到雇员%d", (index + 1), id);
        } else {
            System.out.printf("没有找到雇员%d", id);
        }
    }

    private int getListIndex(int id) {
        return id % size;
    }
}

/**
 * 雇员链表
 */
class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp currentEmp = head;
        while (true) {
            if (currentEmp.next == null) {
                break;
            }
            currentEmp = currentEmp.next;
        }
        currentEmp.next = emp;
    }

    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp currentEmp = head;
        while (true) {
            if (currentEmp == null) {
                break;
            }
            System.out.println(currentEmp);
            currentEmp = currentEmp.next;
        }
        System.out.println("---------------");
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            return null;
        }
        Emp currentEmp = head;
        while (true) {
            if (currentEmp == null) {
                return null;
            }
            if (id == currentEmp.id) {
                return currentEmp;
            }
            currentEmp = currentEmp.next;
        }
    }
}

/**
 * 雇员
 */
class Emp {
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