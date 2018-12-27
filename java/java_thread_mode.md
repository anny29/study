# 图解java多线程设计模式笔记

## 第1章 Single Threaded Execution 模式

### 1. Single Threaded Execution 模式
对于多个线程同时访问的资源（ShareResource），资源中暴露的修改属性的方法需要加锁控制，例如使用 synchronized。

