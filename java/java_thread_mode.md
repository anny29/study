# 图解java多线程设计模式笔记

## 第1章 Single Threaded Execution 模式

### 1. Single Threaded Execution 模式
对于多个线程同时访问的资源（ShareResource），资源中暴露的修改属性的方法需要加锁控制，例如使用 synchronized。保证同一时刻只有一个线程使用共享资源。

### 2. 死锁
死锁存在的条件：
* 在 Single Threaded Execution 模式中存在多个ShareResource
* 一个线程持有一个ShareResource的锁时试图去获取另一个ShareResource的锁
* 获取多个ShareResource的顺序并不固定  
 
只要破坏其中一个条件就可以解除死锁。死锁的例子：    
* 吃饭时必须要用到刀和叉
* 拿到刀或者叉后，再去拿另一个工具
* 拿刀叉的顺序并不固定   
场景：两个人（A、B）吃饭，只有一副刀叉，A先拿到到，B拿到叉，则会进入死锁状态

### 3. 信号量
信号量相当于Single Threaded Execution 模式的扩展，存在N个ShareResource，用M个线程去竞争，M>N，可以使用信号量来控制。
````
Semaphore semaphore = new Semaphore(N);
try {
  semaphore.acquire();
  doUse();
} finally {
  semaphore.release();
}
````
