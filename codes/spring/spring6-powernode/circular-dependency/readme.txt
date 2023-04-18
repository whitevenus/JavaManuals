
源码分析：

DefaultSingletonBeanRegistry类中有三个比较重要的缓存：
   private final Map<String, Object> singletonObjects:              一级缓存
   private final Map<String, Object> earlySingletonObjects          二级缓存
   private final Map<String, ObjectFactory<?>> singletonFactories   三级缓存

   这三个缓存都是Map集合，Map集合的key存储的都是bean的name,就是bean id。


   一级缓存存储的是完整的单例bean对象，也就是说这个缓存中bean对象的属性值就已经赋值了，是一个完整的Bean对象。
   二级缓存存储的是：早期的单例bean对象，这个缓存中的单例bean对象还么有赋值，是一个早期的bean对象。
   三级缓存存储的是：单例工厂对象，这个里面存储了大量的“工厂对象“。每一个单例bean对象都会对应一个单例工厂对象。
                  这个集合存储的是，创建该单例对象时所对应的那个单例工厂对象。