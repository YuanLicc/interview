## 计算机网络概述

1984 年发布的 OSI/RM 模型，定义了网络互连的七层结构，以实现开放系统环境的互联性、互操作性和应用的可移植性。

![](..\..\images\OSIRM.png)

1983 年， DARPA 将 ARPANET 上的所有计算机结构转向了 TCP/ IP 协议， 并以 ARPANET 为主干建立和发展了Internet， 形成了 TCP/ IP 体系结构。虽然 TCP/IP 不是国际标准，但是它的发展和应用远远超过了 OSI/RM，成为了 Internet 体系结构上的实际标准。有三个方面：

- TCP/IP 协议簇非常庞大，功能完善且实用。
- Internet 投资商不会轻易放弃 TCP/IP 协议。
- OSI/RM 的网络体系结构本身分层过多，实现和协调比较难。

#### 计算机网络的基本组成

基本组成包括：计算机、网络连接、通讯设备、传输介质、网络通信软件。

![1535910939161](..\..\images\consistant.png)

1）计算机网络硬件系统

指物理设施，包括计算机设备、传输介质、网络设备三部分。

- 计算机设备

- 网络设备

  有线网络中包括：网卡、网桥、网关、Modem、交换机、路由器、硬件防火墙、硬件 IDS（入侵检测系统）、硬件 IPS（入侵防御系统）、宽带接入服务器、UPS（不间断电源）等。无线网络中包括：WLAN 网卡、WLAN 路由器、WLAN 交换机等。

- 传输介质

  简单的说就是网线。

2）计算机网络软件系统

这些软件被用于及计算机网络通信。如交换机、路由器等都会安装通信的软件系统。



#### 计算机网络的主要应用

资源共享、网络通信、数据传输、协同工作、远程访问与管理、电子商务。



### 计算机网络的分类

#### 按覆盖范围

1）局域网 LAN

分布范围小、结构简单。

2）城域网 MAN

3）广域网 WAN

范围广、构建成本高、结构复杂。

#### 按网络管理模式

1）对等网络 PTP

网络中各成员计算机的地位平等，没有管理与被管理之分。

![1535911903193](..\..\images\ptp.png)

2）C/S 网

服务器。



#### 按传输方式分

1）点对点传输网络

如 SLIP - 串行线路 Internet 协议、PPP - 点对点协议、PPPOE - 以太网的点对点协议、PPTP - 点对点隧道协议等。数据以点对点的方式传输。

2）广播式传输网络



### 计算机网络拓扑结构

从逻辑上表示网络服务器、工作站的网络配置和互相之间的连接方式和服务关系。在选择拓扑结构时，主要考虑因素有：不同设备所担当的角色、各节点设备规则性能要求、安装的相对难易程度、重新配置的难易程度、维护性能要求、安装的相对难易程度、重新配置的难易程度、维护的相对难易程度、通信介质发生故障时受到影响的设备的情况。

#### 网络拓扑结构相关基本概念

1）节点

一个节点其实就是一个网络端口。节点又分为转节点、访问节点。转节点作用是支持网络的连接，它通过通信线路转接和传递信息，如交换机、网关、路由器、防火墙设备的各个网络端口等。访问节点是信息交换的源点和目标点，通常是用户计算机上的网卡端口。

2）结点

一个结点指一台网络设备，他们通常连接了多个节点。结点分为链路节点、路由结点，分别对应网络中的交换机和路由器。

3）链路

是两个节点间的线路。链路分物理链路和逻辑链路，前者指实际存在的通信线路，由设备网络端口和传输介质连接实现。后者是指在逻辑上其作用的网络通路，由计算机网络体系结构中的数据链路层标准和协议来实现。如果链路层协议没有起作用，数据链路也就无法建立起来。

4）通路

从发出信息的节点到接收信息的节点之间的一串节点和链路的组合。

#### 星型拓扑结构

集中式拓扑结构，集线器或交换器连接的各节点呈星状分布，网络中有中央结点（集线器或交换机），其它节点斗鱼中央结点直接相连。

#### 环形拓扑结构

#### 总线型拓扑结构

#### 树形拓扑结构

#### 网状拓扑结构