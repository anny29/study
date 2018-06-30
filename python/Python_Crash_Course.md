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

### 4.4 元组
与列表基本一致,元组中的值不能改变,定义时用圆括号,例如:
```
food = ('apple', 'banana')
```
## 第五章 if语句
### 5.2 条件测试
布尔值的关键字为 `True`和`False`,条件运算符为`and` 或者 `or`
### 5.3 if语句
if语句的关键字为 `if` `elif` `else`

## 第六章 字典
### 6.1 定义字典
字典是键值对的集合,使用大括号定义,例如:
```
city = {"name": "Wuhan", "country": "China"}
```
### 6.2 使用字典
* 访问字典中的值: `city["name"]`
* 添加键值对: `city["fact"] = "home"`
* 删除键值对: `del city["fact"]`

### 6.3 遍历字典
* 遍历键值对: 
```
for name, val in city.items()
    print(name)
    print(val)
```
* 遍历键: `for name in city.keys()`
* 遍历值: `for val in city,values()`

## 第七章 用户输入和while循环
### 7.1 接收用户输入
使用input()函数接收用户输入,例如:
```
  message = input("What's your name?")
```
### 7.2 while循环
for循环一般应用于列表和字典的遍历,while用于对情况的判断,或者集合中的元素会变化时使用while.

## 第八章 函数
### 8.1 定义函数
使用关键字def,例如:
```
def display_city(city_name. country, population = 100):
    print(city_name + " " + country)
```
定义函数时可以指定参数的默认值,不传时就使用默认值.
调用函数时可以使用定义时的参数顺序,也可以使用参数名称指定:
```
     display("武汉", "中国", 1000000)
     display(city_name = "宜昌", country = "中国")
```
有返回值时在函数中加入`return`即可.
    




 
 