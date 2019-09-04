# dataStruture
数据结构与算法

一、稀疏数组和队列

1、稀疏数组

    --当一个数组中大部分是0或者相同的数时可以使用稀疏数组
    
    -------------
    行   列    值
    6    7     8 -->第一行表示数组总共有6行7列，8个不同的值
    0    3     4 -->除第一行外，其他行数据表示原始数组中第几行第几列的值是多少
    2    1     5
    ...
    -------------

2、队列

  --队列是一个有序列表，可以用数组或链表表示
  
  --遵循先入先出原则
  
  --示意图：
  ![image](https://github.com/wnhub/images/blob/master/readme/20190830.jpg)
  
    front=rear=-1;即最开始二者都指向队列的第一个元素之前
    front随着输出而变化；rear随着输入而变化；
    当front=rear时，队列为空。
  
3、环形队列

--①front指向队列第一个元素，初始值为0；

   ②rear指向队列最后一个元素的后一个位置（作为预留空间，参考下图），初始值为0；
  
   ③队列空：   rear==front
   
   ④队列满：   (rear+1)% maxSize ==front
  
   ⑤队列中有效数据的个数：(rear+maxSize-front)%maxSize
  

--示意图：
![image](https://github.com/wnhub/images/blob/master/readme/%E7%8E%AF%E5%BD%A2%E9%98%9F%E5%88%97.png)

二、链表

1、介绍

①链表以结点的方式存储

②每个节点包含data域和next域（指向下一节点）

③链表的各个节点不一定是连续存储

④链表分为带头节点的链表和不带头节点的链表

2、单链表（此处使用带头节点的链表）

   2.1、头结点：
                
               ①不存放任何数据
   
               ②表示单链表头next
   2.2、增加
        2.2.1、在尾部直接添加
        ![image](https://github.com/wnhub/images/blob/master/readme/%E5%8D%95%E9%93%BE%E8%A1%A8_%E5%9C%A8%E5%B0%BE%E9%83%A8%E6%B7%BB%E5%8A%A0.png)
         2.2.2、按顺序添加
        ![image](https://github.com/wnhub/images/blob/master/readme/%E5%8D%95%E9%93%BE%E8%A1%A8_%E6%8C%89%E9%A1%BA%E5%BA%8F%E6%B7%BB%E5%8A%A0.png)
        
   2.3、删除
        ![image](https://github.com/wnhub/images/blob/master/readme/%E5%8D%95%E9%93%BE%E8%A1%A8_%E5%88%A0%E9%99%A4.png)
        
   2.4、修改
        
        思路：1）通过遍历找到修改的节点
        
              2）修改节点信息-->temp.name = newNode.name;
              
                                temp.nickName = newNode.nickName;
   
   2.5面试题(可在代码中查看)

        1）求单链表中有效节点的个数
        2）查找单链表中倒数第k个节点【新浪】
        3）单链表的反转【腾讯】
        4）从尾到头打印单链表【百度】
