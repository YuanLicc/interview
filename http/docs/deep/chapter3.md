## 计算机网络体系结构

#### OSI/RM 体系结构

低四层定义了如何进行端到端的数据传输，也就是定义了如何通过网卡、物理电缆、交换机和路由器进行数据传输。高三层定义了终端系统的应用程序和用户如何彼此通信。

![](..\..\images\OSIRM.png)

低三层有两方面的作用：首先是通过他们自己对应层的信息交换构件数据通信所需的网络平台，更通俗的说就是打通一条用于数据传输的网络通道。然后就是为来自上层的数据提供物理的传输通道。但低三层不能识别和处理来自应用层的网络应用数据，仅用于为用户的网络应用数据通信提供通信线路、网络基础架构，或者说是网络通信平台。高四层上进行的才是真正面向用户的网络应用，为各种具体的网络引用提供应用平台和端对端的数据传输通道，对低三层所构建的网络平台可以说是视而不见。

OSI/RM 并不是很科学，主要两方面：层次数多；进行网络系统设计时仍然比较麻烦。会话层和表示层单独划分意义不大。

#### TCP/IP 协议体系结构

是专门针对使用 TCP/IP 协议簇的广域计算机网络而开发的，可以说是 OSI/RM 的改进版本。但绝不能简单的认为是改进版。因为它与 OSI/RM 所针对的网络类型存在较大区别，所以这两种体系结构中各层所采用的通信协议，以及功能实现原理上都存在非常大的差异。

![1535941082415](..\..\images\1535941082415.png)

1）把物理层和数据链路层合并为网络访问层，提供局域网的功能。

2）合并高三层为应用层。

但是将物理层及数据链路层合并不是很合理。所以下面的五层协议更加科学。

![1535941307138](..\..\images\1535941307138.png)

#### 局域网体系结构

目前局域网标准主要是由 IEEE 发布。它针对有线以太网和 WLAN 无线局域网分别发布了体系结构。

1）有线以太局域网体系结构

![1535942412817](..\..\images\1535942412817.png)

OSI/RM 和 TCP/IP 都是针对广域网设计的，并不是局域网通信所全部需要的，表现在两方面：局域网中不需要路由寻址，所以也就不需要网络层，或者说网际互联层。传输层和应用层的功能是通过安装在计算机系统中的网络通信协议和一些具体应用软件来实现的，所以在局域网设备中也不需要这两层。局域网通常属于广播型网络，存在介质争用的现象，所以他在 OSI/RM 划分的物理层和数据链路层 中又进一步对数据链路层进行了细分：介质访问控制子层（MAC）和逻辑链路控制子层（LLC）。MAC 子层主要解决介质争用和局域网内部寻址。

MAC 子层支持：载波监听多路访问、载波监听多录访问/冲突检测，以及把物理层的比特流封装成 MAC 子帧的功能。

LLC 子层支持：子帧封装、链路控制和管理功能。

2）WLAN 体系结构

![1535943106966](..\..\images\1535943106966.png)

#### 各层主要功能

1）物理层

为所有网络/数据通信提供物理的通信线路。是用来构建计算机网络和数据传输的通道，相当于交通网络中的各种道路。

2）数据链路层

为同一局域网内部的网络/数据通信提供点对点的数据传输通道，通过 MAC 地址寻址把数据转到目的节点。

3）网络层或网际互联层

为不同网段之间的数据转发提供路径选择，通过 IP 地址把数据包转发到目的节点。

4）传输层

传输层是在下面三层构建的网络平台基础上专门为通信双方构建端对端的数据传输通道，是通信双方就像直接进行数据传输一样。

5）会话层和表示层

会话层为具体的用户应用建立会话进程。表示层是对用户网络应用数据的具体解释。

6）应用层

用户进行具体网络应用的层次，是具体网络应用的体现者，应用层负责接收用户的各种网络应用进程的调用。

![1535944608083](..\..\images\1535944608083.png)

#### OSI/RM 和 TCP/IP 的比较

1）相同点

- 层次划分思想相同

  都是以协议栈为基础进行层次结构划分的，并且协议栈中的协议是彼此独立的。

- 总体层次结构相似

- 核心组成一样

  都定义了服务、接口和协议三个重要核心。

  服务：即服务原语，定义了各层应该做些什么，提供哪些功能。

  接口：SAP（服务访问点），为对应上层提供了获取本层服务的逻辑接口。

  协议：通信规程，是各层服务功能的具体实现者。

2）差异

- 使用范围不同

  OSI/RM 不偏重于任何特定的网络类型，是一个理想化的模型。TCP/IP 协议体系结构仅针对 TCP/IP 协议簇。

- 层次结构不同

  TCP/IP 协议体系结构中没有会话层和表示层，另外 OSI/RM 中的物理层和数据链路层的功能在 TCP/IP 中合并到了网络访问层。

- 支持的网络通信模式不同

  OSI/RM 的网络层同时支持无连接和面向连接的网络通信；TCP/IP 模型的网络层只提供无连接的服务。

- 所包括的通信协议不同

### 通信原理

![1535946242408](..\..\images\1535946242408.png)

#### 对等通信原理

通信双方的网络连接建立好后，就可以进行各种具体的网络应用和通信了，但这时的通信是建立在双方对等层次上的，也就是对等层通信原理。进行对等通信需要两方面的考虑：

- 双方需要是对等层次的会话。
- 每一层独立完成自己工作，其它层不干预。

![1535959273120](..\..\images\1535959273120.png)

尽管必须遵守对等通信原理，但最终的数据通信流程还是要经过发起会话通信的层次的下面的其它层次，只不过，在具体的通信过程中，对于用户来说，下层是透明的，在网络连接建立好后，我们并不需要了解下面各层的工作情况。每层数据如下：

1）物理层

比特。

2）数据链路层

帧，包括多个比特，帧的大小必须是一个整数字节。

3）网络层

分组或者包，包括多个帧。

4）传输层

TCP/IP 中以数据段为单位进行传输。

5）会话层、表示层、应用层

具体数据报文为单位。

在整个传输过程中，数据在发送端时经过各层时都要附加上相应层的协议头和协议尾部分，也就是要对数据进行协议封装，以标识对应层所用的通信协议。

1）协议头

用来封装本层数据单位（PDU）。

2）协议尾

代表本层封装结束。

在数据的接收端，数据是由低到高层传输的，这样当数据到达某一层后，就会去掉对应下层的协议头和协议尾部分，这个过程就是解封装的过程。

![1535959953976](..\..\images\1535959953976.png)

TCP/IP 流程类似，只不过没有这么多层次：

![1535960079018](..\..\images\1535960079018.png)

