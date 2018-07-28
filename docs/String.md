## String 相关

### 1. String 能被继承吗？为什么？

不可以，因为 `String` 类有 `final` 修饰符，而 `fina` 不能被继承的，实现细节不允许改变。平常我们定义的 `String str = "a"` 和 `String str = new String("a")` 还是有差异的。前者默认调用的 `String.valueof` 来返回 `String` 的实例对象，至于调用哪个则取决于你的赋值，比如`String num = 1`，调用的是：

```java
public static String valueOf(int i) {
   return Integer.toString(i);
}
```

后者则是调用如下部分：

```java
public String(String original) { 
    this.value = original.value; 
    this.hash = original.hash; 
} 

```

最后我们的变量都存储在一个`char`数组中。



### 2. String，StringBuffer，StringBuilder 的区别？

`String` 字符串常量(final修饰，不可被继承)，`String` 是常量，当创建之后即不能更改。可以通过 `StringBuffer` 和 `StringBuilder` 创建 `String` 对象（常用的两个字符串操作类）。`StringBuffer` 字符串变量（线程安全），其也是 `final` 类别的，不允许被继承，其中的绝大多数方法都进行了同步处理，包括常用的 `append` 方法也做了同步处理。其自 `Jdk 1.0` 起就已经出现。其 `toString` 方法会进行对象缓存，以减少元素的复制开销。

```java
public synchronized String toString() { 
    if (toStringCache == null) { 
    	toStringCache = Arrays.copyOfRange(value, 0, count); 
    } 
    return new String(toStringCache, true); 
}
```

`StringBuilder` 字符串变量，（非线程安全）其自 `Jdk 1.5` 起开始出现。与 `StringBuffer` 一样都继承和实现同一个接口和类，方法除了没有使用 `synchronized` 修饰以外基本一致，不同之处在于最后 `toString` 的时候，会直接返回一个新对象。 

```java
public String toString() { 
	// Create a copy, don’t share the array 
    return new String(value, 0, count); 
}
```



#### 2.1 String，StringBuilder ，StringBuffer的区别？

`String` 类型和 `StringBuffer` 类型的主要性能区别其实在于 `String` 是不可变的对象。因此在每次对 `String` 类型进行改变的时候其实都等同于生成了一个新的 `String` 对象，然后将指针指向新的 `String` 对象，所以经常改变内容的字符串最好不要用 `String` ，因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后，`JVM` 的 `GC` 就会开始工作，影响性能，可以考虑使用可变字符序列`StringBuilder`。

ava平台提供了两种类型的字符串：String和StringBuffer/StringBuilder，它们可以储存和操作字符串。其中String是只读字符串，也就意味着String引用的字符串内容是不能被改变的。而StringBuffer/StringBuilder类表示的字符串对象可以直接进行修改。StringBuilder是Java 5中引入的，它和StringBuffer的方法完全相同，区别在于它是在单线程环境下使用的，因为它的所有方面都没有被synchronized修饰，因此它的效率也比StringBuffer要高。 

String一旦赋值或实例化后就不可更改，如果赋予新值将会重新开辟内存地址进行存储。而StringBuffer类使用append和insert等方法改变字符串值时只是在原有对象存储的内存地址上进行连续操作，减少了资源的开销。因此我们得出结论：如果使用少量的字符串操作，使用 (+运算符)连接字符串； 当需要进行频繁修改字符串的操作时先建立StringBuffer类对象进行操作，将最后结果转化成String类对象返回，这样效率会高很多。



### 3. 为什么 Java 中的 String 是不可变的（Immutable）？  

Java 中的 String 不可变是因为 Java 的设计者认为字符串使用非常频繁，将字符串设置为不可变可以允许多个客户端之间共享相同的字符串。 



### 4. 我们能在 Switch 中使用 String 吗？

从 Java 7 开始，我们可以在 switch case 中使用字符串，但这仅仅是一个语法糖。内部实现在 switch 中使用字符串的 hash code。 



### 5. 怎么检查一个字符串只包含数字？



### 6. 在不使用 StringBuffer 的前提下，怎么反转一个字符串？



### 7. 如何检查出两个给定的字符串是反序的？

StringBuilder.reverse();





### 8. Java 中，怎么打印出一个字符串的所有排列？



### 9. Java 中如何将字符串转换为整数？

Integer.valueOf();

Integer.parseInt();



### 10. 你能写出一个正则表达式来判断一个字符串是否是一个数字吗?

一个数字字符串，只能包含数字，如 0 到 9 以及 +、- 开头，通过这个信息，你可以下一个如下的正则表达式来判断给定的字符串是不是数字。 

### 数组有没有length()方法？String有没有length()方法

数组没有length()方法，有length 的属性。String 有length()方法。JavaScript中，获得字符串的长度是通过length属性得到的，这一点容易和Java混淆。 

### String str = new String(“abc”)  到底创建了几个对象？

两个对象，堆区(str)和常量池("abc")中。

