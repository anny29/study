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
## 第2章 Immutable模式

### 1. Immutable模式定义
当一个类的实例创建后状态不再发生变化，其他线程访问时无需做同步控制，则该类为Immutable。满足Immutable的一般条件：
* 成员变量使用final修饰，一般用private
* 没有set等方法修改成员变量的状态

__使用场景__: 当实例被多个线程频繁访问，需要提高性能时，可以考虑修改mutable类

### 2. Immutable类例子
* String，创建后不可再改变
* Integer, Long等各种基本类型的包装类

java集合框架的很多类并非线程安全，在使用时要注意，例如ArrayList，HashMap等

## 第3章 Guarded Suspension模式

### 1. Guarded Suspension模式定义
对于多个线程同时被保护的资源（Guarded Object），存在取、存的同步方法，当有存入的资源时，__取__ 方法才能执行，否则执行wait()等待，直到 __存__ 方法notifyAll()。

```
class RequestQue<T> {
    private Queue<T> msgQueue = new LinkedList<T>();
    
    public synchronized T getRequest() {
        while (msgQueue.peek() == null) {
            try {
                wait();         
            } catch(InterruptedException e) {
               
            }
        }
        return msgQueue.remove();
    }
    
    public synchronized void putRequest(T msg) {
        msgQueue.offer(msg);
        notifyAll();
    }
}
```
### 2. 适用场景
线程协作时需要判断是否存在资源，类似于生产者-消费之模式？

### 3. java.util.concurrent 工具类
可以直接使用 BlockingQueue<E>接口。

## 第4章 Balking 模式

### 1. Balking 模式定义
在 Guarded Object中存在属性代表守护条件，在 Guarded Method检查守护条件，如果条件不成立，则直接返回。返回的形式有3种：
* 直接返回，无返回值
* 有返回值，为null则表示不满足守护条件
* 通过异常，不满足守护条件则跑出异常

```
class Data {
   private boolean status = false;
   
   public synchronized stateChange() {
       status = true;
   }
   
   public synchronized guardedMethod() {
       if (!status)
           return;    
        
        doSomething();
        status = false;
   }
}
```
### 2. 与 Guarded Suspension模式的区别
Guarded Suspension模式在条件不成立时会始终wait()，而Balking则是直接返回，适用于需要快速响应的场景。    
两者之间则可以设置超时时间，可以使用 BlockingQueue的poll(timeout, unit)方法来实现，在超时时间内wait()，超时后则返回null。

### 3. 线程的interrupt方法
主要适用于调用过sleep()、wait()、join()方法的线程中，interrupt()可以中断线程的受阻状态，并抛出InterruptedException。   
__注意__：被synchronized阻塞的线程，无法使用interrupt中断。   
sleep()与wait()的区别：sleep()时不会释放锁，wait()则会释放锁。调用wait()前必须先获得锁。

## 第5章 Producer-Consumer模式

### 1. Producer-Consumer模式定义
涉及到的角色：
* Data: 产品
* Producer：创建供消费的产品
* Consumer：消费者
* Channel：存放产品的通道，一般在通道中处理同步、线程协作

原型代码：
```
    class Channel {
        private final List<E> products = new LinkedList<>();
        private int count;
        private final int size = 3;
        
        public synchronized E take() {
            while (count == 0) 
                wait();
            count--;
            notifyAll();
            return products.remove();
        }
        
        public void synchronized put(E product) {
            while (count >= size)
                wait();
            products.add(product)
            count++;
            notifyAll();
        }
    }
```

与Guarded Suspension模式不同的地方在Channel接收生产者的产品时也有条件判断。

### 2. ArrayBlockingQueue<E> 实现Channel
使用 ArrayBlockingQueue的take() put()方法，可以屏蔽底层的同步和协作。另外，BlockingQueue有其他实现类，优先级、延迟等。

### 3. 适用场景
适用于多个生产者和消费者协同工作的场景，如果只有单一的生产者和消费者，例如读文件写入数据库的场景，可考虑使用Exchanger。

### 4. 线程中断
对于会抛出InterruptedException的方法，表明方法有耗时且可以取消。主要有
* Thread.sleep()，
* Object.wait()，被调用interrupt()后，必须重新获得锁，才能抛出异常
* Thread.join()   
interrupt()将线程的中断状态改为true，由sleep()、wait()等方法的内部去判断状态抛出异常。   
interrupted()将清空线程的中断状态，由中断改为非中断。

## 第6章 Read-Write Lock模式
### 1. Read-Write Lock模式定义
对于共享资源，多个线程可以同时读取，但是读和写要做同步控制（读写互斥），写之前也要互斥。   
涉及到的角色：
* SharedResource 共享资源
* ReadWriteLock 读写锁
* 读取线程
* 写入线程   
使用读写锁中的读取锁控制共享资源中的读操作，写入锁控制写操作。 
```
class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingWritiers = 0;
    private int writingWriters = 0;
    private boolean preferWriter = true;
    
    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWritiers)) {
            wait();
        }
        readingReaders++;
    }
    
    public synchronized void readUnlock() throws InterruptedException {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }
    
    public synchronized void writeLock() throws InterruptedException {
        waitingWritiers++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
            writingWriters++;
        } finally {
            waitingWritiers--;
        }
            
    }
    
    public synchronized void writeUnlock() throws InterruptedException {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }
}

class Data {
    private ReadWriteLock lock = new ReadWriteLock();
    
    public E read() {
        lock.readLock();
        try {
            doRead();
        } finally {
            lock.readUnlock();
        }
    }
    
    public void write() {
        lock.writeLock();
        try {
            doWrite();
        } finally {
            lock.writeUnlock();
        }
    }
}
```  
### 2. java.util.concurrent中的实现
已经提供了ReadWriteLock接口，和ReentrantReadWriteLock的实现类。

### 3. 适用场景
适用于读取操作多于写入操作的场景，例如缓存。

