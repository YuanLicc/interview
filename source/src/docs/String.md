## String

#### 疑问  
- 不可变  
- intern 以及 `==` 判定 

#### 头  
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {}
```
- final 不能被继承 
- CharSequence 字符序列

#### 存储结构  
```java
private final char value[];
```
private 私有不可被外部访问；final 不可被重复赋值；可以利用反射先修改 value 的修饰符达到修改的目的。
char unicode 编码，16 bits(2 个字节)；
#### 构造方法
```java
...
public String(int[] codePoints, int offset, int count) {}
public String(byte ascii[], int hibyte, int offset, int count){}
...
```
除通常的字符串、字符数组相关构造函数外，还包含一些基于编码及字节高低位组合的构造函数

#### intern
intern 方法的调用，若常量池存在 equals 方法返回 true 的常量，则返回常量池内的引用，否则创建并返回。
```java
String str = "a";
```  
常量赋值情况下，"a" 已经位于常量池中，赋值时返回常量池引用，所以 str == "a" && str.intern() == "a"  
```java
String str = new String("a");
```  
同样，"a" 作为字面常量也已经位于常量池中，但 str 的初始化会在堆内分配内存进行初始化，
虽说 str 的 value 指向的仍是常量池中的 "a"，但是两者引用不相等，str != "a" && str.intern() == "a"
 ```java
final a = "a"; 
final b = "b"; 
String c = a + b;
```
final 作为不可变常量在编译器会被替换为 String c = "a" + "b" => String c = "ab"; 
所以 c == "ab" && c.intern() == "ab"
```java
String a = "a", b = "b", c = a + b;
```
非 final 变量则不会被替换，而是以 StringBuilder.append 的方式进行 + 的替换，所以 c != "ab"
```java
String a = "a", b = "b", ab = a + b;
ab.intern();
```
ab == "ab"，ab 变量在堆内创建后，调用 intern 方法将 ab 的引用存放在常量池内，所以 "ab" 的引用就是 ab 的引用(jdk1.7；1.7 以前 intern 方法是将 "ab" 本身 copy 到常量池)