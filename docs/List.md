## List 相关

### 1. ArrayList 和 LinkedList 有什么区别？

`ArrayList` 和 `LinkedList` 都实现了List接口，有以下的不同点：

- `ArrayList` 是基于索引的数据接口。它的底层是数组。它可以以 `O(1)` 时间复杂度对元素进行随机访问。以此对应，`LinkedList` 是以元素列表的形式存储的数据，每一个元素都和它的前一个后一个元素链接在一起，在这种情况下，查找某个元素的时间复杂度是`O(n)`。 
- 相对于 `ArrayList`，`LinkedList` 的插入，添加，删除操作速度更快，因为当元素被添加到集合任意位置的时候，不需要像数组那样重新计算大小或者是更新索引。
- `LinkedList` 比 `ArrayList` 更占内存，因为`LinkedList` 为每一个节点存储了两个引用，一个指向前一个元素，一个指向下一个元素。

