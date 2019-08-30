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
  
    ![Image text](https://raw.githubusercontent.com/wnhub/images/master/readme/%E9%98%9F%E5%88%97%E7%A4%BA%E6%84%8F%E5%9B%BE_meitu_1.jpg?token=AJNOIZ3HW2O6UZEIAOAQHYC5NC6PM)
  
    front随着输出而变化；rear随着输入而变化；
    当front=rear时，队列为空。
  
