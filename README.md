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
