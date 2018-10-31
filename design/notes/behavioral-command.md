本文摘自书籍[《设计模式》](https://www.amazon.cn/dp/B005XUK0DE/ref=sr_1_1?s=books&ie=UTF8&qid=1525848051&sr=1-1&keywords=%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F+%E5%88%98%E4%BC%9F)

## 行为型 - 命令模式（Command Pattern）

### 定义

将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化，对请求与排队或记录请求日志，以及支持可撤销的操作。命令模式是一种对象行为型模式。

### 模式结构

```java
public interface Receiver {
    ...
}

public interface Command {
    void excute();
}

public class CommandA implements Command {
    private Receiver receiver;
    public void excute() {
        receiver.doSomething();
    }
}
```

- Command  

  抽象命令类，一般是一个接口，在其中生命了用于执行请求的方法，通过这些方法可以调用请求接收者的相关操作。

- CommandA  

  具体命令类，抽象命令类的子类，实现了抽象命令类的方法，对应具体的接收者对象，绑定接收者对象的动作。

- Receiver  

  接收者，接收者执行与请求相关的操作，它实现对请求的具体业务。

### 优点

命令模式的优点：

- 降低系统的耦合度。
- 新的命令可以很容易的加到系统中。
- 可以比较容易的设计一个命令队列和组合命令。可以将多个命令组合在一起批量执行，实现批处理操作，在实现时可以结合组合模式。
- 可以方便的实现队请求的Undo和Redo。对于有些命令可以通过一个对应的逆操作命令，并将命令对象存储在集合中，从而实现对请求操作的Undo和Redo操作。

### 缺点

命令模式的缺点：

- 使用命令模式可能造成某些系统含过多的具体命令类。

### 适用环境

命令模式的适用环境：

- 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。请求调用者无需知道接收者的存在，也无需知道接收者是谁。
- 系统需要支持命令的撤销、恢复操作，可以将命令对象存储起来。