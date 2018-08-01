## Synchronized 相关

### 1. synchronized关键字的用法，优缺点？

java关键字，当它用来修饰一个方法或者代码块的时候，能够保证在同一时刻最多只有一个线程执行该代码段的代码。

synchronized修饰的方法或者对象，只能以同步的方式执行，会引起性能问题；无法中断一个正在等候获得锁的线程，也无法通过投票获得锁；一个优先级高的线程等待一个优先级低的线程释放锁会导致优先级倒置，引起性能风险。