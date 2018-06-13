Python编程：从入门到实践学习笔记
===========================
---
## 第二章 变量和简单数据类型
### 2.3 字符串
#### 1. 字符串可以使用单引号，或者双引号，在两个双引号中，可以直接加入单引号，无需转义，例如：  

```

     name = "James Hardon"  
     other_name = 'James Hardon'  
     another = "James's football"
	 
``` 

#### 2. 字符串中涉及的常用函数
* title() 首字母大写，其余小写，例如：  `print("jamEs hardoN")` 输出 James Hardon
* upper(),lower()大小写转换
* strip(),lstrip(),rstrip()去掉空白字符，包含空格、制表符\t等
* 字符串连接使用 + 

### 2.4 整数和浮点数
* 指数运算可以使用两个 ** 。
* 数字转化为字符串使用 `str()`函数。

### 2.5 添加注释
注释在一行前加上 #，没有区块注释？

---

## 第三章 列表简介
### 3.1 列表是什么
直接使用[]即可定义列表,例如:  

```
list = ["aa", "bb"]
```
访问列表元素时,直接使用下表,例如:`list[0]`  
使用坐标-1可以访问最后一个元素.-2表示倒数第二个,以此类推  
### 3.2 修改 添加和删除元素
* 新增  
    + 在尾部添加,使用append()
    + 使用insert(i, o), 在指定位置添加
* 修改
    + 直接使用`list[i] = o`来修改
* 删除
    + __del__,例如`del list[0]`,指定元素坐标
    + __pop()__,弹出末尾的元素,例如 `name = list.pop()`,也可以指定坐标,弹出指定元素
    + __remove()__,根据元素值来删除,例如`list.remove("aa")`
      
### 3.3 列表排序
* 改变列表元素顺序
    + sort()，例如 `list.sort()`，可以指定reverse逆序，例如 `list.sort(reverse=True)`
	+ reverse()，例如 `list.reverse()`，将列表中的元素逆序排列
* 临时性排序，不改变元素顺序
    + sorted()，例如`sorted(list)`	
    
## 第四章 操作列表
### 4.1 遍历列表
使用for来遍历,例如:
```
  for str in list:
      print(str)
```
### 4.2 整数列表
* 使用`list() range()`创建整数列表,例如创建1~10的整数列表:
```
numbs = list(range(1, 11))
```
range()的第三个参数可以用来指定步长,例如1~10的奇数列表:
```
odd_numbs = list(range(1, 11, 2))
```
* 使用统计方法,例如`min(list), max(list), sum(list)`等函数
* __列表解析__,使用表达式和循环生成列表,例如创建1~10的平方数:
```
square = [value ** 2 for value in range(1, 11)]
```

### 4.3 切片
从列表中取出子集,例如取头三个元素,后三个元素:
```
top_3 = numbs[0:3]
last_3 = numbs[-3:]
```
    




 
 