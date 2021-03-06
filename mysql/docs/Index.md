## 创建高性能的索引

索引是存储引擎用于快速找到记录的一种数据结构。索引对于良好的性能非常关键。尤其是当表中的数据量越来越大时，索引对性能的影响愈发重要。在数据量较小且负载较低时，不恰当的索引对性能的影响可能还不明显，但当数据量逐渐增大时，性能会急剧下降。不过，索引却经常被忽略，有时候甚至被误解，所以在实际案例中经常会遇到由糟糕索引导致的问题。

索引优化应该是对查询性能优化最有效的手段了。索引能够轻易将查询性能提高几个数量级，最优的索引有时比一个好的索引性能要好两个数量级。创建一个真正最优的索引经常需要重写查询。



### 索引基础

索引可以包含一个或多个列的值。如果索引包含多个列，那么列的顺序也十分重要，因为 MySQL 只能高效的使用索引的最左前缀列。创建一个包含两个列的索引，和创建两个只包含一列的索引是大不相同的。



####索引的类型

索引有很多种类型，可以为不同的场景更好的性能。在 MySQL 中，索引是在存储引擎层而不是服务器层实现的。所以，并没有统一的索引标准：不同的存储引擎的索引的工作方式并不一样，也不是所有的存储引擎都支持所有类型的索引。即使多个存储引擎支持同一种类型的索引，其底层实现也可能不同。



##### B-Tree 索引

当人们谈论索引时，如果没有指明类型。多半在说 B-Tree 索引，它使用 B-Tree 数据结构来存储数据。大多数 MySQL 引擎都支持这种索引。存储引擎以不同的方式使用 B-Tree 索引，性能也各有不同，各有优劣。如：MyISAM 使用前缀压缩技术使得索引更小，但 InnoDB 则按照原数据格式进行存储。再如：MyISAM 索引通过数据的物理位置引用被索引的行，而 InnoDB 则根据主键引用被索引的行。

B-Tree 通常意味着所有的值都是按顺序存储的，并且每一个叶子页到根的距离相同。B-Tree 索引能够加快访问数据的速度，因为存储引擎不再需要进行行全表扫描来获取需要的数据，取而代之的是从索引的根节点开始进行搜索。根节点的槽中放了指向子节点的指针，存储引擎根据这些指针想下层查找。通过比较节点页的值和要查找的值可以找到合适的指针进入下层子节点，这些指针实际上定义了子节点页中值的上限和下限。最终存储引擎要么是找到对应的值，要么该记录不存在。

叶子节点比较特别，他们的指针指向的是被索引的数据，而不是其它的节点页。根节点和叶子节点之间可能有很多层节点页。树的深度和表的大小直接相关。B-Tree 对索引列时顺序组织存储的，所以很适合查找范围数据。索引多多个值进行排序的依据是 CREATE TABLE 语句中定义索引时列的顺序。



##### B-Tree 索引适用查询类型

```mysql
create table user(
    name varchar(20) not null,
    age TINYINT UNSIGNED not null,
    sex char(1) not null,
    key(name, age)
);
## 这里索引为 name，key
```

1）全值匹配

全值匹配指的是和索引中的所有列进行匹配。

2）匹配最左前缀

可只使用索引的第一列。如例子中的 name。

3）匹配列前缀

可以只匹配某一列的值的开头部分。

4）匹配范围值

5）精确匹配某一列兵范围匹配另一列

6）只访问索引的查询

即查询只需要访问索引，而无须访问数据行。

7）匹配列前缀

8）匹配范围值



由于索引树中的节点是有序的，所以除了按值查找之外，索引还可以用于查询中的 ORDER BY 操作。一般来说，如果 B_Tree 可以按照某种方式查找到值，那么也可以按照这种方式用于排序。所以，如果 ORDER BY 子句满足前面列出的几种查询类型，则这个索引也可以满足对应的排序需求。



##### B-Tree 索引的限制

1）如果不是按照索引的最左列开始查找，则无法使用索引。

2）不能跳过索引中的列。

3）如果查询中有某个列的范围查询，则其右边所有列都无法使用索引优化查询。



索引列的顺序很重要：这些限制都和索引列的顺序有关。在优化性能的时候，可能需要使用相同的列但顺序不同的索引来满足不同类型的查询需求。



#### 哈希索引

哈希索引基于哈希表实现，只有精确匹配索引所有列的查询才有效。对于每一行数据，存储引擎都会对所有的索引列计算一个哈希码，哈希码是一个较小的值，并且不同键值的行计算出来的哈希码也不一样。哈希索引将所有的哈希码存储在索引中，同时在哈希表中保存指向每个数据行的指针。

在 MySQL 中，只有 Memory 引擎显示支持哈希索引。这也是 Memory 引擎表的默认索引类型，Memory 引擎同时也支持 B-Tree 索引。值得一提的是，Memory 引擎是支持非唯一哈希索引的，这在数据库世界里面与众不同。因为索引自身只需存储对应的哈希值，所以索引的结果十分紧凑，这也让哈希索引查找的速度非常快。然而，哈希索引也有他的限制：

1）哈希索引只包含哈希值和行指针，而不存储字段值，所以不能使用索引中的值来避免读取行。

2）哈希索引数据并不是按照索引值顺序存储的，所以也就无法用于排序。

3）哈希索引也不支持部分索引列匹配查找，因为哈希索引始终是使用索引列的全部内容来计算哈希值。

4）哈希索引只支持等值比较查询，包括 = 、IN()、<=>。

5）访问哈希索引的数据非常快，除非有很多哈希冲突。当出现哈希冲突的时候，存储引擎必须遍历链表中所有的行指针，逐行比较，知道找到所有符合条件的行。

6）如果哈希冲突很多的话，一些索引维护操作的代价也会很高。

因为这些限制，哈希索引值适用于某些特定的场合。而一旦适合哈希索引，则它带来的性能提升将非常显著。除了 Memory 引擎外，NDB 集群引擎也支持唯一哈希索引，且在 NDB 集群引擎中作用非常特殊。InnoDB 引擎有哟个特殊的功能叫做“自适应哈希索引”。当InnoDB 注意到某些索引值使用的非常频繁时，他会在内存中基于 B-Tree 索引之上再创建一个哈希索引。这样就让 B-Tree 索引也具有哈希索引的一些优点，比如快速的哈希查找。这是一个完全自动的、内部的行为，用户无法控制或者配置，不过如果有必要，完全可以关闭该功能。

创建自定义哈希索引。如果存储引擎不支持哈希索引，则可以模拟像InnoDB一样创建哈希索引，这可以享受一些哈希索引的便利，例如只需要你很小的索引就可以为超长的健创建索引。在 B-Tree 上创建一个伪哈希索引。这和真正的哈希索引不是一回事，因为还是使用 B-Tree 进行查找，但是它使用哈希值而不是健本身进行索引查找。你需要做的就是在查询的 where 子句中手动指定使用哈希函数。



#### 空间数据索引

MyISAM 表支持空间索引，可以用作地理数据存储。和 B-Tree 索引不同，这类索引无需前缀查询。空间索引会从所有维度来索引数据。查询时，可以有效的使用任意维度来组合查询。必须使用 MySQL 的 GIS 相关函数如 MDRCONTAINS() 等来维护数据。MySQL 的 GIS 支持并不完善，所以大部分的人都不会使用这个特性。



#### 全文索引

全文索引是一种特殊类型的索引，它查找的是文本中的关键字，而不是直接比较索引中的值。全文搜索和其它几类索引的匹配方式完全不一样。它有许多需要注意的细节，如停用词、词干、负数和布尔搜索等。全文搜索更类似于搜索引擎做的事情，而不是简单的 where 条件匹配。

在相同的列上同事创建全文索引和基于值的 B-Tree 索引不会有冲突，全文索引适用于 MATCH AGAINST 操作，而不是普通的 where 条件操作。



### 索引的优点

索引可以让服务器快速定位到表的指定位置。但是这并不是索引的唯一作用，到目前为止可以看到，根据创建索引的数据结构不同，索引也有一些其它的附加作用。最常见的 B-Tree 索引，按照顺序存储数据，索引 MySQL 可以用来 order by 和 group by 操作。因为数据是有序的，所以 B_Tree 也就会将相关的列值都存储在一起。最后，因为索引中存储了实际的列值，所以某些查询只使用索引就能够完成全部查询。总结如下三点优点：

- 索引减少了服务器需要扫描的数据量。
- 索引可以帮助服务器避免排序和临时表。
- 索引可以将随机 I/O 变为顺序 I/O。

只有当索引帮助存储引擎快速查找到记录带来的好处大于其带来的额外工作时，索引才是有效的。对于非常小的表，大部分情况下简单的全表扫描更高效。对于中到大型的表，索引就非常有效。但对于特大型的表，建立和使用索引的代价随之增长。需要一种技术直接区分出查询需要的一组数据，而不是一条记录一条记录的匹配，如分区技术。如果表的数量特别多，可以建立一个元数据信息表，用来查询需要用到的某些特性。如执行那些需要聚合多个应用分布在多个表的数据的查询，则需要记录 哪个用户的信息存储在那个表中的元数据，这样查询时就可以直接忽略那些不包含指定用户信息的表。对于大型系统，这是一个常用的技巧。



### 高性能的索引策略

正确的创建和使用索引是实现高性能查询的基础。高效的选择和使用索引有很多方式，其中有些是针对特殊案例的优化方法，有些则是针对特定行为的优化。使用哪个索引，以及如何评估选择不同索引的性能影响的技巧，则需要持续不断的学习。



#### 独立的列

如果查询中的列不是独立的，则 MySQL 就不会使用索引。独立的列是指索引列不能是表达式的一部分，也不能是函数的参数。例如：

```mysql
select id from table_a where id + 1 = 5;
```

上面的查询是无法使用 Id 列的索引的。凭肉眼很容易看出 where 中的表达式其实等价于 `id = 4` ，但是 MySQL 无法自动解析这个方程式。应该习惯将索引列单独放在比较符号的一侧。



#### 前缀索引和索引选择性

有时候需要索引很长的字符列，这会让索引变得大且慢。一个策略是前面提到过的模拟哈希索引。但有时候这样做还不够。通常可以索引开始的部分字符，这样可以大大节约索引空间，从而提高索引效率。但这样也会降低索引的选择性。索引的选择性是指，不重复的索引值和数据表的记录总数（#T）的比值，范围从 1/#T 之间。索引的选择性越高则查询效率越高，因为选择性高的索引可以让 MySQL 在查找时过滤掉更多的行。唯一索引的选择性是 1，这是最好的索引选择性，性能也是最好的。

一般情况下某个列前缀的选择性也是足够高的，足以满足查询性能。对于 BLOB、TEXT 或者很长的 VARCHAR 类型的列，必须使用前缀索引，因为 MySQL 不允许索引这些列的完整长度。

诀窍在于要选择足够长的前缀以保证较高的选择性，同时又不能太长。前缀应该足够长，以使得前缀索引的选择性接近于索引整个列。换句话说，前缀的基数应该接近于完整列的基数。为了决定前缀的合适长度，需要找到最常见的值得列表，然后和最常见的前缀列表进行比较。



#### 多列索引

在多个列上建立独立的单列索引大部分情况下并不能提高 MySQL 的查询性能。索引合并的策略，在一定程度上可以使用表上多个单列索引来定位指定的行。索引策略有时候是一种优化的结果，但实际上更多时候表明了表上的索引建的很糟糕：

- 当出现服务器对多个索引做相交操作（通常是 AND）时，通常意味着需要一个包含所有相关列的多列索引，而不是多个独立的单列索引。
- 当服务器需要多多个索引做联合操作（通常是 OR）时，通常需要耗费大量 CPU 和内存资源在算法的缓存、排序和合并操作上。特别是当其中有些索引的选择性不高，需要合并扫描返回的大量数据的时候。
- 优化器不会把这些计算到 “查询成本” 中，有乎其只关心随机页面读取。这会使得查询的成本被低估，导致该执行计划还不如直接全表扫描。这样做不但会消耗更多的 CPU 和内存资源，还可能会影响查询的并发性，但如果是单独运行这样的查询则往往会忽略并发性的影响。

如果在 EXPLAIN 中看到索引合并，应该检查查询和表的结构。



#### 选择合适的索引列顺序

正确的索引列顺序依赖于使用该索引的查询，并且同时需要考虑如何更好的满足排序和分组的需要。在一个多列 B-Tree 索引中，索引列的顺序意味着索引首先按照最左列进行排序，其次是第二列。所以索引可以按照升序或者降序进行扫描，以满足精确符合列顺序的 Order by、group by 和 distinct 等子句的查询需求。

对于如何选择索引的列顺序有一个经验法则：将选择性高的列放到索引最前列。当不需要考虑排序和分组时，将选择性高的列放在前面通常是很好的。这时候索引的作用只是用于优化 where 条件的查找，在这种情况下，这样设计的索引确实能够更快的过滤出需要的行，对于在 where 子句中只使用了索引部分前缀列的查询来说选择性也更高。然而性能只是依赖于所有索引的选择性，也和查询条件的具体值有关，也就是和值的分布有关。折合前面介绍的选择前缀长度需要考虑的地方一样。可能需要根据那些运行频率最高的查询来调整索引列的顺序，让这种情况下索引的选择性最高。当使用前缀索引的时候，在某些条件值的基数比正常值高的时候，问题就来了。



#### 聚簇索引

聚簇索引并不是一种单独的索引类型，而是一种数据存储方式。具体细节依赖于其实现方式，但 InnoDB 的聚簇索引实际上在同一个结构中保存了 B-Tree 索引和数据行。当表有聚簇索引时，它的数据行实际上存放在索引的叶子页中。术语 “聚簇” 表示数据行和相邻的键值紧凑的存储在一起。因为无法同时把数据行存放在两个不同的地方，所以一个表只能有一个聚簇索引。因为是存储引擎负责实现索引，因此不是所有的存储引擎都支持聚簇索引。

如果没有主键，InnoDB 会选择一个唯一的非空索引代替。如果没有这样的索引，InnoDB 会隐式的定义一个主键作为聚簇索引。InnoDB 值聚集在同一个页面中的记录。

聚簇索引主键可能对性能有帮助，但也可能导致严重的性能问题。所以需要仔细考虑聚簇索引，尤其是将表的存储引擎从 InnoDB 改成其他引擎的时候。

下面是聚集数据的优点：

- 可以把相关数据保存在一起。如用户好友列表，可以根据用户 ID 来聚集数据，这样只需要读取少数的数据页就能获取某个用户的所有好友。
- 数据访问更快。聚簇索引将索引和数据保存在同一个 B-Tree 中，因此从聚簇索引中获取数据通常比非聚簇索引中查找要快。
- 使用覆盖索引扫描的查询可以直接使用页节点中的主键值。

如果在设计表和查询时能充分利用上面的优点，那就能极大的提升性能，下面是聚簇索引的缺点：

- 聚簇数据最大限度的提高了 I/O 密集型应用的性能，但如果数据全部放在内存中，则访问的顺序就没那么重要了，聚簇索引也就没什么优势了。
- 插入速度严重依赖插入顺序。按照主键的顺序插入是加载数据到 InnoDB 表中速度最快的方式。但如果不是按照主键顺序加载数据，那么加载完成后最好使用 OPTIMIZE TABLE 命令重新组织一下表。
- 更新聚簇索引列的代价很高，因为会强制 InnoDB 将每个被更新的行移动到新的位置。
- 基于聚簇索引的表在插入新行，或者主键被更新导致需要移动行的时候，可能面临页分裂的问题。当行的主键要求必须将这一行插入到某个已满的页中时，存储引擎会将该页分裂成两个页面来容纳该行，这就是一次页分裂操作。页分裂会导致表占用更多的磁盘空间。
- 聚簇索引可能导致全表扫描变慢。尤其是行比较稀疏，或者由于页分裂导致数据存储不连续的时候。
- 非聚簇索引（二级索引）因为要在叶子结点保存引用行的主键列，可能比想象中更大。
- 二级索引访问需要两次索引查找。二级索引中保存的是行的主键列，而不是数据行的物理地址，所以会尽力两次索引查找。

这意味着通过二级索引查找行，存储引擎需要找到二级索引的叶子结点获得对应的主键值，然后根据这个值去聚簇索引中查找到对应的主键值，然后根据这个值去聚簇索引中查找到对应的行。



**InnoDB 和 MyISAM 的数据分布对比**

聚簇索引和非聚簇索引的数据分布有区别，以及对应的主键索引和二级索引的数据分布也有区别。下面看看同一个表在不同存储引擎下是如何存储的：

```mysql
create table test(
	id int unsigned not null primary key auto_increment,
    col tinyint unsigned not null,
    key(name)
);
```

假设该表的主键取值为 1—10000，按照随机顺序插入并使用 OPTIMZE TABLE 命令做了优化。换句话说，数据在磁盘上的存储方式已经最优，但行的顺序是随机的。列 col 的值从 1 - 100 之间随机赋值，所以有很多重复的值。 

MyISAM 的数据分布：

MyISAM 的数据分布非常简单，在行的旁边显示行号，从 0 开始递增。因为行是定长的，所以 MyISAM 可以从表的开头跳过所需的字节找到需要的行。这种分布方式很容易创建索引。

事实上，MyISAM 中主键索引和其它索引在结构上没有什么不同。主键索引就是一个名为 PRIMARY 的唯一非空索引。

InnoDB 的数据分布：

因为 InnoDB 支持聚簇索引，所以使用非常不同的方式存储同样的数据，聚簇索引的每一个叶子节点都包含了主键值、事务 ID、用于事务和 MVCC 的回滚指针以及所有的剩余列。如果主键是一个列前缀索引，InnoDB 也会包含完整的主键列和剩余的其他列。还有一点和 MyISAM 不同的是，InnoDB 的二级索引和聚簇索引很不相同。InnoDB 二级索引的叶子节点中存储的不是 行指针，而是主键值，并以此作为指向行的指针。这样的策略减少了当出现行移动或者数据页分裂时二级索引的维护工作。使用主键值当做指针会让二级索引占用更多空间，换来的好处是，InnoDB 在移动时无需更新二级索引中的这个指针。



**在 InnoDB 表中按主键顺序插入行**

如果正在使用 InnoDB 表并且没有什么数据需要聚集，阿么可以定义一个代理键作为主键，这种主键的数据应该和应用无关，最简单的方法是使用 AUTO_INCREMENT 自增列。这样可以保证数据行是按顺序写入，对于根据主键做关联操作的性能也会更好。

最好避免随机（不连续且值得范围非常大）的聚簇索引，特别是对于 I/O 密集型的应用。因为这样将导致数据在插入时，无法直接插入索引的最后，需要为新的行寻找合适的位置并且分配空间。若主键递增的话，直接插入到索引最后即可。

可以看出，使用 InnoDB 时应该尽可能的按主键顺序插入数据，并且尽可能的使用单调增加的聚簇键的值来插入新行。



**顺序主键什么时候回造成更坏的结果**

对于高并发工作负载，在 InnoDB 中按主键顺序插入可能会造成明显的争用。主键的上界会成为热点。因为所有的插入都发生在这里，所以并发插入可能导致间隙锁竞争。另一个热点可能是 AUTO_INCREMENT 锁机制。如果遇到这个问题，则可能需要考虑重新设计表或者应用，或者更改 innodb_autonic_lock_mode 配置。如果你的服务器版本还不支持 innodb_autonic_lock_mode 参数，可以升级到新版本的 InnoDB。



#### 覆盖索引

通常大家都会根据查询的 where 条件创建合适的索引，不过这只是索引优化的一个方面。设计优秀的索引应该考虑到整个查询，而不是单单是 where条件部分。索引确实是一种查找数据的高效方式，但是 MySQL 也可以使用索引来直接获取列的数据，这样就不再需要读取数据行。如果索引的叶子节点中已经包含要查询的数据，那么还有什么必要再回表查询呢？如果一个索引包含所有需要查询的字段的值，我们称之为 覆盖索引。

覆盖索引是非常有用的工具，能够极大的提高性能。好处如下：

- 索引条目通常远小于数据行大小，所以如果只需要读取索引，那 MySQL 就会极大的减少数据访问量。这对缓存的负载非常重要，因为这种情况下响应时间大部分花在数据拷贝上。覆盖索引对于 I/O 密集型的应用也有帮助，因为索引比数据更小，更容易全部放在内存中。
- 因为索引是按照列值顺序存储的，所以对于 I/O 密集型的范围查询会比随机从磁盘读取每一行数据的 I/O 要少得多。
- 一些存储引擎如 MyISAM 在内存中只缓存索引，数据则依赖于操作系统的缓存，因此要访问数据需要一次系统调用。这可能会导致严重的性能问题，尤其是那些系统调用占了数据访问中最大开销的场景。
- 由于 InnoDB 的聚簇索引，覆盖索引对InnoDB 表特别有用。InnoDB 的二级索引在叶子节点中保存了行的主键值，所以如果二级主键能够覆盖查询，则可以避免对主键索引的二次查询。

不是所有类型的索引都可以成为覆盖索引。覆盖索引必须要存储索引的值，而哈希索引、空间索引和全文索引等不存储索引列的值，所以MySQL 只能使用 B-Tree 索引做覆盖索引。另外，不同的存储引擎实现覆盖索引的方式也不同，而且不是所有的引擎都支持覆盖索引。

当发起一个被索引覆盖的查询时，在 EXPLAIN 的 EXTRA 列可以看到 “using index” 的信息。索引覆盖查询还有很多陷阱可能会导致无法实现优化。MySQL 查询优化器会在执行查询前判断是否有一个索引能进行覆盖。鸡舍索引覆盖了 where 条件中的字段，但不是整个查询涉及的字段，如果条件为假，MySQL 5.5 和更早的版本也总是会回表获取数据行，尽管并不需要这一行且最终会被过滤掉。

索引无法覆盖的原因：

- 没有任何索引能够覆盖这个查询。
- MySQL 不能在索引中执行 LIKE 操作。可进行最左前缀匹配的 LIKE 比较，因为该操作可以转换为简单的比较操作，但是如果是通配符开头的 LIKE 查询，存储引擎就无法做比较匹配。

在大多数存储引擎中，覆盖索引只能覆盖那些只访问索引中部分列的查询。不过，可以更进一步优化 InnoDB。InnoDB 的二级索引的叶子节点都包含了主键的值，这意味着 InnoDB 的二级索引可以有效的利用这些额外的主键列来覆盖查询。



#### 使用索引扫描来做排序

MySQL 有两种方式可以生成有序的结果：通过排序操作；或者按索引顺序扫描。如果 EXPLAIN 出来的 type 列的值为 index，则说明 MySQL 使用了所以扫描来做排序。扫描索引本身是很快的，因为只需要从一条索引记录移动到紧接着的下一条记录。但如果索引不能覆盖查询所需的全部列，那就不得不每扫描一条索引就都回表查询一次对应的行。这基本上都是随机 I/O，因此按索引顺序读取数据的速度通常要比顺序的全表扫描慢，尤其是在 I/O 密集型的工作负载时。

MySQL 可以使用同一个索引既满足排序，又用于查找行。因此，如果可能，设计索引时应该尽可能的满足这两种任务，这是最好的。  只有当索引的列顺序和 order by 子句的顺序完全一致，并且所有列的排序方向都一样时，MySQL 才能够使用索引来对结果进行排序。如果查询需要关联多张表，则只有当 order by 子句引用的字段全部为第一个表时，才能使用索引做排序。order by 子句和查找型查询的限制是一样的：需要满足索引的最左前缀的要求，否则，MySQL 都需要执行排序操作，而无法利用索引排序。

有一种情况下 order by 子句可以不满足索引的最左前缀的要求，就是前导列为常量的时候。如果 where 子句或者 join 子句中对这些列指定了常量，就可以弥补索引的不足。即使 order by 子句不满足索引的最左前缀的要求，也可以用于查询排序，这是因为索引的第一列被指定为一个常数。如：

```mysql
key(name, aId, bId)
```

```mysql
where name = 'a' order by aId, bId;
```

使用索引做排序的一个最重要的用法是当查询同时有 order by 和 limit 子句的时候。



#### 压缩索引（前缀压缩）

MyISAM 使用前缀压缩来减少索引的大小，从而让更多的索引可以放入内存中，这在某些情况下极大的提高了性能。默认只压缩字符串，但通过参数设置也可以对整数做压缩。MyISAM 压缩每个索引块的方法是，先完全保存索引块中的第一个值，然后将其它值和第一个值进行比较得到相同前缀的字节数和剩余的不同后缀部分，把这部分存储起来即可。

压缩块使用更少的空间，代价是某些操作可能更慢。因为每个值的压缩前缀都依赖前面的值，所以 MyISAM 查找时无法在索引块使用二分查找而只能从头开始扫描。正序的扫描速度还不催，但是如果是倒叙扫描，就不是很好了。

测试表明，对于 CPU 密集型应用，因为扫描需要随机查找，压缩索引使得 MyISAM 在索引查找上慢好几倍。压缩索引的倒叙扫描就更慢了。压缩索引需要在 CPU 内存资源与磁盘资源之间做平衡。压缩索引可能只需要十分之一大小的磁盘空间，如果是 I/O 密集型应用，对某些查询带来的好处会比成本多得多。



#### 冗余和重复索引

MySQL 允许在相同列上创建多个索引，无论是有意的还是无意的。MySQL 需要单独维护重复的索引，并且优化器在优化查询的时候也需要逐个进行考虑，这回影响性能。重复讴吟是指在相同的列上按照相同的顺序创建的相同类型的索引。应该避免这样创建重复索引，发现以后也应该立即删除。有时会在无意间创建重复索引，如：

```mysql
id int unsigned primary key,
unique(id),
index(id)
```

一个经验不足的用户可能想创建一个主键，先加上唯一限制，然后再加上索引以供查询使用。事实上，MySQL 的唯一限制和主键限制都是通过索引实现的，因此，上面的写法实际上在相同的裂伤创建了三个重复的索引。

冗余索引和重复索引有一些不同，如果创建了索引 (A, B)，在创建索引 (A) 就是冗余索引，因为这只是前一个索引的前缀索引。因此索引 (A, B) 也可以当做索引 (A) 来使用。但是如果创建索引 (B, A)，则不是冗余索引，索引 (B) 也不是，因为 B 不是索引 (A, B) 的最左前缀列。另外其他不同类型的索引也不会是 B-Tree 索引的冗余索引。

一般来说，增加新索引将会导致 insert、update、delete 等操作的速度变慢，特别是当新增索引后导致达到了内存瓶颈的时候。解决冗余索引和重复索引的方法很简单，删除这些索引就可以了，但首先要做的是找出这样的索引。可以通过歇一歇复杂的访问 INFORMATION_SCHEMA 表的查询来找，但是若服务器存在大量的数据或表，查询 INFORMATION_SCHEMA 表可能导致性能问题。



#### 未使用的索引

除了冗余索引和重复索引，可能还会有一些服务器永远不用的索引。这样的索引完全是累赘，建议删除。



#### 索引和锁

索引可以让查询锁定更少的行。如果你的查询从不访问那些不需要的行，那么就会锁定更少的行，从两个方面来看这对性能都有好处。首先，虽然 InnoDB 的行锁效率很高，内存使用也很少，但是锁定行的时候任然会带来额外的开销。其次，锁定超过需要的行会增加锁争用并减少并发性。

InnoDB 只有在访问行的时候才会对其加锁，而索引能够减少 InnoDB 访问的行数，从而减少锁的数量。单这只有当 InnoDB 在存储引擎层能够过滤掉所有不需要的行时才有效。如果索引无法过滤掉无效的行，那么在 InnoDB 检索到数据并返回给服务器层以后，MySQL 服务器才能应用 where 子句。这时已经无法避免锁定行了，InnoDB 已经锁住了这些行，到适当的时候才释放。

InnoDB 在二级索引上使用共享锁，但访问主键索引需要排它锁。这消除了使用覆盖索引的可能性，并且使得 select for update 比 lock in share mode 或非锁定查询要慢得多。



### 索引案例

用户信息：

```mysql
country, area, city, sex, age
```

需要分析哪些列拥有很多不同的值，哪些列在 where 子句中出现得最频繁，在有更多不同值得列上创建索引的选择性会更好。country 列的选择性通常不高，单可能很多查询都会使用，sex 列的选择性肯定很低，但也会在很多查询中使用，所以考虑到使用频率，建议创建不同组合索引的时候将 (country, sex) 列作为前缀。理由如下：

- 几乎所有的查询都会用到 sex 列，即使查询中不过滤性别，也可以使用技巧来选择此索引：

  ```mysql
  and sex in ('male', 'female')
  ```

  这样写不会过滤任何行，和没有这个条件时返回的结果相同。但是必须加上这个列的条件，MySQL 才能够匹配索引的最左前缀。

这个案例显示了一个基本原则：考虑表上所有的选项。当设计索引时，不要只为现有的查询考虑需要哪些索引，还需要考虑对查询进行优化。如果发现某些查询需要创建新索引，但是这个索引又会降低另一些查询的效率，那么应该想一下是否能优化原来的查询。应该同时优化查询及索引以找到最佳的平衡。

#### 优化排序