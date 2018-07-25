## Map 相关

### 1. HashMap 是线程安全的吗?

[重新认识 HashMap](https://zhuanlan.zhihu.com/p/21673805)



### 2. ConcurrentHashMap 在 Java 8 中为什么放弃了分段锁？

[ConcurrentHashMap 源码分析](https://yq.aliyun.com/articles/36781)



### 3. 有顺序的 Map 有哪些？

TreeMap、LinkedHashMap

[LinkedHashMap](http://uule.iteye.com/blog/1522291)



### 4. WeakHashMap 是怎么工作的？

WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。 



### 5. Java 中 LinkedHashMap 和 PriorityQueue 的区别是什么？

PriorityQueue 保证最高或者最低优先级的的元素总是在队列头部，但是 LinkedHashMap 维持的顺序是元素插入的顺序。当遍历一个 PriorityQueue 时，没有任何顺序保证，但是 LinkedHashMap 课保证遍历顺序是元素插入的顺序。 



### 6. Java 中的 TreeMap 是采用什么树实现的？

Java 中的 TreeMap 是使用红黑树实现的。 



### 7. Hashtable 与 HashMap 有什么不同之处？

这两个类有许多不同的地方，下面列出了一部分： a) Hashtable 是 JDK 1 遗留下来的类，而 HashMap 是后来增加的。 b）Hashtable 是同步的，比较慢，但 HashMap 没有同步策略，所以会更快。 c）Hashtable 不允许有个空的 key，但是 HashMap 允许出现一个 null key。 



### 8. HashMap源码，实现原理，JDK8以后对HashMap做了怎样的优化？

HashMap是基于哈希表的Map接口的非同步实现，提供所有可选的映射操作，并允许使用null值和null键，不保证映射的顺序；HashMap是一个“链表散列”的数据结构，即数组和链表的结合体；它的底层就是一个数组结构，数组中的每一项又是一个链表，每当新建一个HashMap时，就会初始化一个数组。

[彻底搞懂 HashMap...](https://www.cnblogs.com/wang-meng/p/5808006.html)

而在JDK8中引入了红黑树的部分，当存入到数组中的链表长度大于（默认）8时，即转为红黑树；利用红黑树快速增删改查的特点提高HashMap的性能，其中会用到红黑树的插入、删除、查找等算法。 

[教你初步了解红黑树](https://blog.csdn.net/v_july_v/article/details/6105630)



### 9. HashMap的扩容是怎样扩容的，为什么都是2的N次幂的大小？



### 10. HashMap，HashTable，ConcurrentHashMap的区别？　　

a、HashMap是非线程安全的，HashTable是线程安全的。

b、HashMap的键和值都允许有null值存在，而HashTable则不行。

c、因为线程安全的问题，HashMap效率比HashTable的要高。

HashMap：

它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。 HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。

Hashtable：

Hashtable是遗留类，很多映射的常用功能与HashMap类似，不同的是它承自Dictionary类，并且是线程安全的，任一时间只有一个线程能写Hashtable，并发性不如ConcurrentHashMap，因为ConcurrentHashMap引入了分段锁。



### 11. 极高并发下HashTable和ConcurrentHashMap哪个性能更好，为什么，如何实现的？

当然是ConcurrentHashMap，因为ConcurrentHashMap引入了分段锁，而HashTable则使用的是方法级别的锁；因此在新版本中一般不建议使用HashTable，不需要线程安全的场合可以使用HashMap，而需要线程安全的场合可以使用ConcurrentHashMap；

 

### 12. HashMap在高并发下如果没有处理线程安全会有怎样的隐患，具体表现是什么？

可能造成死循环，具体表现链表的循环指向；

