本文摘自书籍[《深入理解Java虚拟机：JVM高级特性与最佳实践》](https://www.amazon.cn/dp/B00DA0E170/ref=sr_1_1_twi_kin_2?s=books&ie=UTF8&qid=1528283344&sr=1-1&keywords=%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3java%E8%99%9A%E6%8B%9F%E6%9C%BA) 

## 引用

当内存空间在GC 后依旧紧张，此时想清理一些"食之无味，弃之可惜"的对象显得尤为重要，但在JDK 1.2之前的引用仅仅表示着一块内存的起始地址，无法区分所引用的对象是否应该第二次回收。JDK 1.2 之后，Java 对引用的概念进行了扩充，将引用分为：

1）强引用

2）软引用

3）弱引用

4）虚引用

### 强引用

指在程序代码之中普遍存在的，类似`Object o = new Object()`这类的引用，只要强引用还存在，垃圾收集器永远不会回收掉被引用的对象。

### 软引用

指一些还有用，但并非必需的对象。对于这类对象，在系统将要发生内存溢出异常之前，会把这些对象列进回收范围之中并进行第二次回收。若这次回收还没有足够的内存，则抛出内存溢出异常。相关类：

```java
SoftReference
```

### 弱引用

指一些还有用，但并非必需的对象。它的强度比软引用更弱，被弱引用关联的对象只能生存到下一次垃圾收集发生之前。当垃圾收集器工作时，无论当前内存是否足够，都会回收掉只被弱引用关联的对象。相关类：

```java
WeakReference
```

### 虚引用

最弱的一种引用关系，一个对象是否有虚引用的存在，完全不会对其生存时间构成影响，也无法通过虚引用来取得一个对象实例。为一个对象设置虚引用的唯一目的就是希望在这个对象被收集器回收时收到一个系统通知。相关类：

```java
PhantomReference
```