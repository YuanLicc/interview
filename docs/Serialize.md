## 序列化相关

### 1. Java 中，Serializable 与 Externalizable 的区别？

Serializable 接口是一个序列化 Java 类的接口，以便于它们可以在网络上传输或者可以将它们的状态保存在磁盘上，是 JVM 内嵌的默认序列化方式，成本高、脆弱而且不安全。Externalizable 允许你控制整个序列化过程，指定特定的二进制格式，增加安全机制。 



### 2. java序列化的方式？

实现Serializable接口、实现Externalizable接口（一般只希望序列化一部分数据，其他数据都使用transient修饰的话有点麻烦，这时候可以使用externalizable接口，指定序列化的属性）。