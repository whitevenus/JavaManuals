package org.myspringframework.core;

/**
 * mySpring框架应用上下文接口
 */
public interface ApplicationContext {

    /**
     * 根据 bean 的名称获取对应的 bean 对象
     * @param beanName  mySpring 配置文件中 bean 标签的 id。
     * @return 对应的单例 bean 对象
     */
    Object getBean(String beanName);
}
