## 前置知识

- [Maven 基础](./docs/Maven基础篇.md)
- Java 基础


## 1 概述

### 1.1 Spring是什么？

Spring是一个`轻量级`的、`开源`的、`主流的`的JavaEE框架，它的基本使命是`简化企业级Java应用的开发难度和开发周期`。Spring框架除了自己提供功能外，还提供整合其他技术和框架的能力。这些 Spring 相关框架所做的最令人惊奇的事情之一就是`自动`地为应用程序**提供所有基础功能**，让开发人员专注于特有的逻辑。

[Spring官网](https://spring.io/)

### 1.2 Spring划分方式

- **广义上的Spring**：泛指以`Spring Framework`为核心的 Spring 技术栈。

- **狭义上的Spring**：特指`Spring Framework框架`。其内部有两个核心模块：`IOC`和`AOP`。
    - **IOC**：Inverse of Control，控制反转，可以简单地理解为把创建对象的过程交给 Spring 进行管理。
    - **AOP**：Aspect Oriented Programming，面向切面编程， AOP 通过封装多个类的**公共行为（与业务无关，业务模块所共同调用的逻辑功能）**，`提高代码重用性，降低耦合度`。通过 AOP 可以在很少改变源代码的情况下，增加一个功能，比如增加日志、事务、权限等功能。

### 1.3 Spring Framework的特点

- `非侵入式`：使用 Spring Framework 开发应用程序时，对应用程序本身的结构影响非常小，几乎可以做到**”零污染“**，只需对功能性组建使用几个简单的注解进行标记即可。
- `控制反转`：反转资源获取方向，把**自己创建资源，向环境索取资源**变成**环境将资源（对象）准备好，我们直接享受资源注入**即可。
- `面向切面编程`：实现在**不修改源代码的基础上增强代码功能**。
- `容器`：Spring IOC 是一个容器，**包含并且管理组件对象的生命周期**。实现对对象资源的容器化管理。
- `组件化`：Spring 实现了使用**简单的组件配置组合成一个复杂的应用**，只需要使用 XML 或Java 注解组合这些组件对象即可。类似于砖块、砂浆、木材、管道等等组合在一起，形成一栋房子。
- `一站式`：Spring旗下的**项目覆盖领域非常广泛**，很多功能需求都可以在Spring Framework的基础上配合Spring其他模块实现。

### 1.4 Spring 模块组成
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

## 2 容器 IoC

`IoC`：Inversion of Control，控制反转，它并不是一门技术，而是一种`设计思想`，是一个重要的面向对象编程法则，能够**指导我们设计出松耦合、更优良的程序**。

Spring 通过`IoC容器`（通常被称为 Spring 应用上下文，Spring application context）来创建和管理应用的组件，包括**管理所有 Java 对象的实例化和初始化**，**控制对象与对象之间的依赖关系**等等。我们将由IoC容器管理的组件称为`Spring Bean`，这些组件会在 Spring 应用上下文中装配在一起，从而形成一个完整的应用程序。

### 2.1 IoC容器

#### 2.1.1 控制反转

- 控制反转是一种`思想`。
- 控制反转是为了`降低程序耦合度`，`提高程序扩展力`。
- 控制反转，反转的是什么？
    - 将组件的`创建权`交给第三方容器负责
    - 将组件和组件之间关系的`维护权`交给第三方容器负责。
- 如何实现这种思想？
    - `DI（Dependency Injection）`：依赖注入


### 2.2 依赖注入（基于XML管理bean）

指的是**在 Spring 创建对象的过程中，将对象所依赖的属性通过配置进行注入**。使用依赖注入的应用依赖于单独的实体（容器）来创建和维护所有的组件，并将其注入到需要他们 `bean` 中。通常是通过构造器参数和属性访问方式来实现的。

- `Set注入`：通过`<bean>`标签中的`<property>`标签完成。
    ```xml
    <!-- set注入 -->
        <!--    字面量注入 -->
        <bean id="book" class="com.mwt.spring6.iocxml.di.Book">
            <property name="name" value="前端开发"></property>
            <property name="author" value="mwt"></property>
        <!--        空值注入 -->
    <!--        <property name="others">-->
    <!--            <null />-->
    <!--        </property>-->

        <!--        xml实体注入 -->
        <!--        第一种方法：通过使用转义字符表示尖角号 -->
    <!--        <property name="others" value="&lt; 其他 &gt;"></property>-->

        <!--        第二种方法: 通过使用CDATA区实现注入 -->
            <property name="others">
                <value><![CDATA[a < b]]></value>
            </property>
        </bean>
    ```



- `构造注入`：通过`<bean>`标签中的`<constructor-arg>`标签完成。
    ```xml
    <!-- 构造方法注入 -->
    <bean id="book1" class="com.mwt.spring6.iocxml.di.Book">
    <!-- constructor-arg标签还有另外一种属性对： index和value  -->
        <constructor-arg name="name" value="Java开发"></constructor-arg>
        <constructor-arg name="author" value="mwt"></constructor-arg>
    </bean>
    ```

另外还有一个术语：`Bean管理`，指的就是：**Bean 对象的创建**以及 **Bean 对象中属性的赋值（或者叫做 Bean 对象之间关系的维护）**。

假设在应用的众多组件中，有两个是需要我们处理的：`库存服务`和`商品服务`。其中商品服务依赖于库存服务。那这些bean和Spring应用上下文之间的关系就如下图所示：
![Spring上下文管理应用组件](../images/spring6/Spring%E4%B8%8A%E4%B8%8B%E6%96%87%E7%AE%A1%E7%90%86%E7%BB%84%E4%BB%B6.png)


#### 2.2.1 IoC在Spring中的实现

Spring 的 IoC 容器就是 IoC 思想的一个落地产品实现。在创建 bean 之前，首先需要创建 IoC 容器。Spring 提供了 IoC 容器的两种实现方式：

- `BeanFactory`：这是 IoC 容器的基本实现，是 Spring 内部使用的接口。面向 Spring 本身，不提供给开发人员使用。

- `ApplicationContext`：BeanFactory 的子接口，提供了更多高级特性。面向 Spring 的使用者，几乎所有场合都使用 ApplicationContext，而不是底层的 BeanFactory。

- `ApplicationContext`的主要内容：
    | 类型名 | 简介 |
    | --- | --- |
    | ClassPathXmlApplicationContext | 通过读取类路径下的 XML 格式的配置文件创建IOC容器对象 | 
    | FileSystemXmlApplicationContext | 通过文件系统路径读取 XML 格式的配置文件创建IOC容器对象 |
    | ConfigurableApplicationContext | ApplicationContext的子接口，包含一些扩展方法 refresh()和 close()，让 ApplicationContext 具有启动、关闭和刷新上下文的能力|
    | WebApplicationContext | 专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入 ServletContext 域中|

#### 2.2.2 特殊类型注入

1. 对象类型属性注入

    - 引入外部 bean 的方式：
        ```xml
        <!--
        第一种方式：引入外部bean
            1 创建两个类对象：dept 和 emp
            2 在emp的bean标签里面，使用property引入dept的bean
        -->
        <bean id="dept" class="com.mwt.spring6.iocxml.ditest.Dept">
            <property name="name" value="安保部"></property>
        </bean>

        <bean id="emp" class="com.mwt.spring6.iocxml.ditest.Emp">
            <!-- 普通类型属性注入 -->
            <property name="name" value="Lucy"></property>
            <property name="age" value="50"></property>
            <!-- 对象类型属性注入 -->
            <!-- ref属性与要引入bean的id保持一致即可-->
            <property name="dept" ref="dept"></property>
        </bean>
        ```

    - 内部 bean 方式：
        ```xml
        <!--
        第二种方式：内部bean注入
        -->
        <bean id="emp2" class="com.mwt.spring6.iocxml.ditest.Emp">
            <!-- 普通类型属性注入 -->
            <property name="name" value="mary"></property>
            <property name="age" value="24"></property>
            <!-- 对象类型属性注入 -->
            <property name="dept">
                <bean id="dept2" class="com.mwt.spring6.iocxml.ditest.Dept">
                    <property name="name" value="财务部"></property>
                </bean>
            </property>
        </bean>
        ```

    - 级联赋值：
        ```xml
        <!--
        第三种方式：级联赋值
        -->
        <bean id="dept3" class="com.mwt.spring6.iocxml.ditest.Dept">
            <property name="name" value="技术部"></property>
        </bean>

        <bean id="emp3" class="com.mwt.spring6.iocxml.ditest.Emp">
            <!-- 普通类型属性注入 -->
            <property name="name" value="tom"></property>
            <property name="age" value="30"></property>
            <!-- 对象类型属性注入 -->
            <property name="dept" ref="dept3"></property>
            <property name="dept.name" value="测试部"></property>
        </bean>
    ```


2. 数组类型属性注入
    
    - 通过`array`标签实现
        ```xml
        <!-- 数组类型属性注入 -->
        <property name="loves">
            <array>
                <value>吃饭</value>
                <value>睡觉</value>
                <value>运动</value>
            </array>
        </property>
        ```

3. 集合类型属性注入

    - List 集合类型属性注入：通过`list`标签实现
        ```xml
        <!-- List集合属性注入 -->
        <property name="empList">
            <list>
                <ref bean="emp"></ref>
                <ref bean="emp2"></ref>
                <ref bean="emp3"></ref>
            </list>
        </property>
        ```

    - Map 集合类型属性注入：通过`map`标签实现
        ```xml
        <property name="teacherMap">
            <!-- map集合类型属性 -->
            <map>
                <entry>
                    <key>
                        <value>001</value>
                    </key>
                    <!-- 对象类型需要使用ref标签 -->
                    <ref bean="teacher1"></ref>
                </entry>
                <entry>
                    <key>
                        <value>002</value>
                    </key>
                    <!-- 对象类型需要使用ref标签 -->
                    <ref bean="teacher2"></ref>
                </entry>
            </map>
        </property>
        ```

    - 引用集合类型的bean：通过`util:list`和`util:map`标签实现。
        ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <!-- 在这里引入了util:list、util:map标签所需的命名空间 -->
        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:util="http://www.springframework.org/schema/util"
            xsi:schemaLocation="http://www.springframework.org/schema/util
            http://www.springframework.org/schema/util/spring-util.xsd
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
            <bean id="lesson1" class="com.mwt.spring6.iocxml.dimap.Lesson">
                <property name="name" value="Java开发"></property>
            </bean>

            <bean id="lesson2" class="com.mwt.spring6.iocxml.dimap.Lesson">
                <property name="name" value="前端开发"></property>
            </bean>

            <bean id="teacher1" class="com.mwt.spring6.iocxml.dimap.Teacher">
                <property name="id" value="001"></property>
                <property name="name" value="西门子"></property>
            </bean>

            <bean id="teacher2" class="com.mwt.spring6.iocxml.dimap.Teacher">
                <property name="id" value="002"></property>
                <property name="name" value="上官雪"></property>
            </bean>

            <!-- 使用这两个标签需要先引入命名空间 -->
            <util:list id="lessonList">
                <ref bean="lesson1"></ref>
                <ref bean="lesson2"></ref>
            </util:list>

            <util:map id="teacherMap">
                <entry>
                    <key>
                        <value>001</value>
                    </key>
                    <ref bean="teacher1"></ref>
                </entry>
                <entry>
                    <key>
                        <value>002</value>
                    </key>
                    <ref bean="teacher2"></ref>
                </entry>
            </util:map>

            <bean id="student" class="com.mwt.spring6.iocxml.dimap.Student">
                <property name="id" value="2001"></property>
                <property name="name" value="张三"></property>
                <!-- 注入List、Map集合属性 -->
                <property name="lessonList" ref="lessonList"></property>
                <property name="teacherMap" ref="teacherMap"></property>
            </bean>
        </beans>

        ```

3. `p`命名空间注入

    - 引入p命名空间
    ```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    ```

    - 使用p命名空间注入
    ```xml
    <bean id="studentp" class="com.mwt.spring6.iocxml.dimap.Student"
        p:id="2002" p:name="小明" p:lessonList-ref="lessonList" p:teacherMap-ref="teacherMap"></bean>
    ```

4. 使用外部属性文件注入：比如配置数据库组件。

    - 数据库依赖：
        ```xml
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>

        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.15</version>
        </dependency>
        ```

    - 外部属性文件：
        ```properties
        jdbc.user=root
        jdbc.password=root
        jdbc.url=jdbc:mysql://localhost:3306/spring?serverTimezone=UTC
        jdbc.driver=com.mysql.cj.jdbc.Driver
        ```

    - 实现注入
        ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <!-- 需要先引入 context命名空间 -->
        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:context="http://www.springframework.org/schema/context"
            xsi:schemaLocation="http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">

            <!-- 引入外部的属性文件 -->
            <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>

            <!-- 使用表达式完成数据库信息的注入 -->
            <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
                <property name="url" value="${jdbc.url}"></property>
                <property name="username" value="${jdbc.user}"></property>
                <property name="password" value="${jdbc.password}"></property>
                <property name="driverClassName" value="${jdbc.driver}"></property>
            </bean>

        </beans>
        ```

#### 2.2.3 Bean的作用域

在 Spring 中可以通过配置 bean 标签的 `scope` 属性来指定 bean 的作用域范围，各取值含义参加下表：

| 取值              | 含义                                    | 创建对象的时机  |
| ----------------- | --------------------------------------- | --------------- |
| singleton（默认） | 在IOC容器中，这个bean的对象始终为单实例 | IOC容器初始化时 |
| prototype         | 这个bean在IOC容器中有多个实例           | 获取bean时      |

如果是在 `WebApplicationContext` 环境下还会有另外几个作用域（但不常用）：

| 取值    | 含义                 |
| ------- | -------------------- |
| request | 在一个请求范围内有效 |
| session | 在一个会话范围内有效 |

#### 2.2.4 Bean的生命周期

- **具体生命周期**：
    1. bean对象的创建（调用无参构造）
    2. `给bean对象设置相关属性（注入）`
    3. bean后置处理器（初始化之前）
    4. `bean对象初始化（调用制定初始化方法）`
    5. bean后置处理器（初始化之后）
    6. `bean对象创建完成，可以使用了`
    7. `bean对象销毁（配置指定销毁的方法）`
    8. IoC 容器关闭

> bean 的`后置处理器`会在生命周期的初始化前后添加额外的操作，需要实现`BeanPostProcessor`接口，且**配置到 IOC 容器中**，需要注意的是，bean后置处理器**不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行**


#### 2.2.5 FactoryBean

`FactoryBean`是 Spring 提供的一种**整合第三方框架的常用机制**。和普通的 bean 不同，配置一个 FactoryBean 类型的 bean ，在获取 bean 的时候得到的并不是 class 属性中配置的这个类的对象，而是 `getObject()` 方法的返回值。

通过这种机制，Spring 可以帮我们把复杂组件创建的详细过程和繁琐细节都**屏蔽**起来，只把最简洁的使用界面展示给我们。

比如我们整合Mybatis时，Spring 就是通过 `FactoryBean` 机制来帮我们创建SqlSessionFactory 对象的。


#### 2.2.6 基于XML自动装配

**自动装配**：根据指定的策略，在 IOC 容器中匹配某一个 bean，自动为指定的 bean 中所依赖的类类型或接口类型属性赋值

- 配置bean
    ```xml
    <!-- autowire的值还可以设置为 byName -->
    <bean id="controller" class="com.mwt.spring6.iocxml.auto.controller.UserController" autowire="byType"></bean>
    <bean id="service" class="com.mwt.spring6.iocxml.auto.service.UserServiceImpl" autowire="byType"></bean>
    <bean id="dao" class="com.mwt.spring6.iocxml.auto.dao.UserDaoImpl"></bean>
    ```

> 使用bean标签的autowire属性设置自动装配效果 <br> 自动装配方式：`byType` <br> byType：根据类型匹配 IOC 容器中的某个兼容类型的 bean，为属性自动赋值 <br> 若在 IOC 中，没有任何一个兼容类型的 bean 能够为属性赋值，则该属性不装配，即值为默认值null <br> 若在 IOC 中，有多个兼容类型的 bean 能够为属性赋值，则抛出异常NoUniqueBeanDefinitionException

> 自动装配方式：byName <br> byName：将自动装配的属性的属性名，作为 bean 的 id 在 IOC 容器中匹配相对应的 bean 进行赋值（**bean 的 id 要与属性名称保持一致**，否则会出错）

### 2.3 基于注解管理Bean

从 Java 5 开始，Java 增加了对注解（Annotation）的支持，它是代码中的一种**特殊标记**，可以在`编译`、`类加载`和`运行`时被读取，执行相应的处理。开发人员可以通过注解在不改变原有代码和逻辑的情况下，在源代码中嵌入补充信息。

Spring 从 2.5 版本开始提供了对注解技术的全面支持，我们可以使用注解来实现**自动装配**，简化 Spring 的 XML 配置。

Spring 通过注解实现自动装配的步骤如下：

1. 引入 Spring 相关依赖
2. 开启组件扫描
3. 使用注解定义 Bean
4. 依赖注入

#### 2.3.1 开启组件扫描

Spring 默认不使用注解装配 Bean，因此我们需要在 Spring 的 XML 配置中，通过 `<context:component-scan>` 元素开启 Spring Beans 的**自动扫描**功能。开启此功能后，Spring 会自动从扫描指定的包（**base-package 属性设置**）及其子包下的所有类，如果类、方法、属性上使用了 `@Component` 注解，就将该类、方法、属性装配到容器中。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 使用<context:component-scan>标签时，需要先引入context命名空间 -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 开启组件扫描（默认扫描指定包下所有类） -->
    <context:component-scan base-package="com.mwt"></context:component-scan>
    

    <!-- 方式二：排除某些规则 -->
    <context:component-scan base-package="com.mwt.spring6">
        <!-- context:exclude-filter标签：指定排除规则 -->
        <!--
             type：设置排除或包含的依据
            type="annotation"，根据注解排除，expression中设置要排除的注解的全类名
            type="assignable"，根据类型排除，expression中设置要排除的类型的全类名
        -->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
        <!--<context:exclude-filter type="assignable" expression="com.mwt.spring6.controller.UserController"/>-->
    </context:component-scan>

    <!-- 方式三：指扫描某些组件 -->
    <context:component-scan base-package="com.mwt" use-default-filters="false">
        <!-- context:include-filter标签：指定在原有扫描规则的基础上追加的规则 -->
        <!-- use-default-filters属性：取值false表示关闭默认扫描规则 -->
        <!-- 此时必须设置use-default-filters="false"，因为默认规则即扫描指定包下所有类 -->
        <!-- 
             type：设置排除或包含的依据
            type="annotation"，根据注解排除，expression中设置要排除的注解的全类名
            type="assignable"，根据类型排除，expression中设置要排除的类型的全类名
        -->
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
        <!--<context:include-filter type="assignable" expression="com.mwt.spring6.controller.UserController"/>-->
    </context:component-scan>
</beans>
```

#### 2.3.2 使用注解定义Bean

Spring 提供了以下多个注解，这些注解可以直接标注在 Java 类上，将它们定义成 Spring Bean。

| 注解        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| @Component  | 该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。  使用时只需将该注解标注在相应类上即可。 |
| @Repository | 该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |
| @Service    | 该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |
| @Controller | 该注解通常作用在控制层（如SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |


#### 2.3.3 依赖注入——`@Autowired`注入以及`@Qualifier`注解

单独使用@Autowired注解，**默认根据类型装配**，也就是`byType`。

- 该注解可以标注在哪里？
    - **构造方法上**
    - **set方法上**
    - **形参上**
    - **属性上**
    - **注解上**

- 该注解有一个 required 属性，默认值是 `true`，表示在注入的时候要求被注入的 Bean **必须是存在**的，如果不存在则报错。如果 required 属性设置为 false，表示注入的 Bean 存在或者不存在都没关系，存在的话就注入，不存在的话，也不报错。

- 另外：**当有参数构造方法只有一个时，@Autowired注解可以省略**。而有多个构造方法时，必须添加注解。

- **@Autowired注解和@Qualifier注解联合使用**

    @Autowired注解默认是根据`类型`注入。这就需要保证类型所对应的组件必须唯一。如果一个接口有多个实现类，这时候就需要根据`名称注入`，就需要配合`@Qualifier`注解一起使用。
```java
@Autowired
@Qualifier(value = "userRedisDaoImpl")
private UserDao userDao;
```

#### 2.3.4 依赖注入——`@Resource`注入

- @Resource注解是 JDK 扩展包中的，也就是说属于 JDK 的一部分。所以该注解是**标准注解**，更加具有通用性。(`JSR-250`标准中制定的注解类型。JSR是Java规范提案。)
- @Autowired 注解是 Spring 框架自己的。
- **@Resource 注解默认根据名称装配 byName，未指定 name 时，使用属性名作为 name。通过 name 找不到的话会自动启动通过类型 byType 装配。**
- **@Autowired 注解默认根据类型装配 byType，如果想根据名称装配，需要配合 `@Qualifier` 注解一起用。**
- @Resource 注解用在**属性**、**setter方法**上。
- @Autowired注解用在**属性**、**setter方法**、**构造方法**、**构造方法参数**上。

- @Resource 注解属于 JDK 扩展包，所以不在 JDK 当中，需要额外引入以下依赖：【**如果是 JDK8 的话不需要额外引入依赖。高于 JDK11 或低于 JDK8 需要引入以下依赖。**】
    ```xml
    <dependency>
        <groupId>jakarta.annotation</groupId>
        <artifactId>jakarta.annotation-api</artifactId>
        <version>2.1.1</version>
    </dependency>
    ```


#### 2.3.5 Spring 全注解开发

全注解开发就是不再使用 spring 配置文件了，写一个`配置类`来代替配置文件。

- 配置类
    ```java
    package com.mwt.spring6.config;

    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;

    @Configuration      // 配置类
    @ComponentScan("com.mwt.spring6")   // 开启组件扫描
    public class SpringConfig {
        
    }
    ```
- 测试类通过加载配置类加载IoC容器
    ```java
    import com.mwt.spring6.config.SpringConfig;
    import com.mwt.spring6.resource.controller.MyUserController;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class TestUserControllerAnnotation {

        public static void main(String[] args) {

            // 从配置类加载IoC容器
            ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

            MyUserController bean = context.getBean(MyUserController.class);

            bean.add();

        }
    }
    ```

