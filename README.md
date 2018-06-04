# EventBus 消息总线框架

## 1 事件通讯场景

 （1）四大组件间的通讯

 （2）Fragment（接受 event.getinstance.register）、Activity(enet.getinstance.post)、View(envetn.getinstance.reginster)间的通信等

 （3）需要接口回调才能实现的地方  都可以用eventbus

 （4）多个线程间的消息通讯

 （5）* 框架扩展：跨进程通讯框架拓展

## 2 优缺点

### 优点：

 （1）调用灵活，不依赖于 Context，方便组件间通信。

 （2）EventBus 的 Subscriber 注册非常简单。

 （3）易于进行线程间的切换。

### 缺点：

  代码结构不清晰，容易造成接口混乱

## 3 框架实现

### （1）设计模式

​	单利模式、观察者模式；

### （2）框架实现步骤

 ​	<1>注册 接受消息的java类，类方法，并将其存放在结构为Map<Object, List<SubscribleMethod>>的缓冲map中，并且制定参数规格；

​	<2> Post消息发送方法做了什么？ 从缓冲map中获取java类及其方法；

​	<3> 不同线程间的消息如何传递？

​		主线程 -> 主线程 ：不需要切换线程,直接invoke(param1,param2,param3)

​		子线程 -> 子线程  ：不需要切换线程,invoke(param1,param2,param3)

​		主线程 -> 子线程  ： 通过线程池

​		子线程 -> 主线程 ： 通过Android自有的Handler将消息发送到主线程



## 四 AIDL（Binder机制）

### （1）Binder机制

Binder驱动设备：dev/binder

对于AndroidFrameWork而言是 ActivityManager和ActivityManagerService，WindowManager和WMS的通讯桥梁，等等。

 客户端进程  < --- Binder -----> 服务端进程

  Binder.java 

<1> 调用 Binder_native.cpp 实现进程间的通讯。2wwwqtaqtaqta

<2> writeParcel 发送序列化消息

<2>transact(int code, Parcel data, Parcel reply,   int flags) 

该方法来接受Parcel 消息,Binder直接跟native打交道，数据依托于Parcel 



Serizable : ObjectOutputStream.write   ObjectInputStream.read

### （2）AIDL

支持的类型：<1>基本类型 int、float、char、boolean、double

​			<2>String 和 CharSequence

​			<3>List Map

​			<4> Parcelable 所实现的接口对象 （作为参数时需要加in）

Parcel 序列化： writeToParcel

