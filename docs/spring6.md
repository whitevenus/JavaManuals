# 1.概述

## 1.1 Spring是什么？

Spring是一个主流的JavaEE`轻量级`、`开源`框架，其目的是用于`简化Java企业级应用的开发难度和开发周期`。Spring框架除了自己提供功能外，还提供整合其他技术和框架的能力。

[Spring官网](https://spring.io/)

## 1.2 Spring划分方式

- **广义上的Spring**：泛指以Spring Framework为核心的Spring技术栈。

- **狭义上的Spring**：特指Spring Framework框架。其内部有两个核心模块：`IOC`和`AOP`。
    - IOC：Inverse of Control，控制反转，指的是把创建对象的过程交给Spring进行管理。
    - AOP：Aspect Oriented Programming，面向切面编程。 AOP通过封装多个类的公共行为（与业务无关，为业务模块所共同调用的逻辑功能），提高代码重用性，降低耦合度。通过AOP可以在很少改变源代码的情况下，增加一个功能，比如增加日志、事务、权限等功能。

## 1.3 Spring Framework的特点

- **非侵入式**：使用Spring Framework开发应用程序时，对应用程序本身的结构影响非常小，几乎可以做到”零污染“，只需对功能性组建使用几个简单的注解进行标记即可。
- **控制反转**：反转资源获取方向，把自己创建资源，向环境索取资源变成环境将资源（对象）准备好，直接享受资源注入即可。
- **面向切面编程**：在不修改源代码的基础上增强代码功能。
- **容器**：Spring IOC是一个容器，包含并且管理组件对象的生命周期。实现对对象资源的容器化管理。
- **组件化**：Spring实现了使用简单的组件配置组合成一个复杂的应用，只需要使用XML或Java注解组合这些组件对象即可。
- **一站式**：Spring旗下的项目覆盖领域非常广泛，很多功能需求都可以在Spring Framework的基础上配合Spring其他模块实现。

## 1.4 Spring 模块组成
![Spring模块组成1](../images/spring6/Spring模块组成1.png)
![Spring模块组成2](../images/spring6/Spring模块组成2.png)

1. **Core Container**：Spring Core提供了IOC、DI、Bean配置装载创建的核心实现。核心概念：Beans、BeanFactory、BeanDefinitions、ApplicationContext。
    - Spring-core：IOC和DI的基本实现
    - Spring-beans: BeanFactory和Bean的装配管理。
    - Spring-context：Spring context上下文，即IOC容器（AppliactionContext）
    - Spring-expression：Spring表达式语言

2. **Spring AOP**：
    - Spring-aop：面向切面编程的应用模块，整合ASM、CGLib、
    - Spring-aspects

3. **Spring Data Access**：

4. **Spring Web**：

5. **Spring Message**：
    - Spring-messaging：spring4.0提供的，为Spring集成一些基础的报文传送服务。

6. **Spring test**：
    - Spring-test：集成测试支持，主要是对junit的封装。

