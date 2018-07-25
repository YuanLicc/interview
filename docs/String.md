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

#### 2.1 String，StringBuilder 的区别？

`String` 类型和 `StringBuffer` 类型的主要性能区别其实在于 `String` 是不可变的对象。因此在每次对 `String` 类型进行改变的时候其实都等同于生成了一个新的 `String` 对象，然后将指针指向新的 `String` 对象，所以经常改变内容的字符串最好不要用 `String` ，因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后，`JVM` 的 `GC` 就会开始工作，影响性能，可以考虑使用可变字符序列`StringBuilder`。