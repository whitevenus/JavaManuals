package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> singletonObject = new HashMap<>();


    /**
     * 解析 mySpring的配置文件，然后初始化所有的 bean 对象
     * @param configLocation    spring配置文件的路径。配置文件应当放置在类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析 xml 配置文件，然后实例化 bean，将 bean 存放在 singletonObject 集合里

            // dom4j 解析 XML 文件的核心对象
            SAXReader reader = new SAXReader();
            // 获取一个输入流，指向配置文件
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // 从输入流中读取
            Document document = reader.read(inputStream);
            // 获取所有的 bean 标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历 bean 标签 实例化对象并曝光
            for (Node node : nodes) {
                //System.out.println(node);
                // 向下转型的目的是为了使用 Element 类中更加丰富的接口
                Element element = (Element) node;
                // 获取 id 属性
                String id = element.attributeValue("id");
                // 获取 class 属性
                String className = element.attributeValue("class");


                // 通过反射机制创建对象，将其放入Map集合中提前曝光
                Class<?> aClass = Class.forName(className);
                Object bean = aClass.getDeclaredConstructor().newInstance();
                // 放入Map集合中直接曝光
                singletonObject.put(id, bean);

            }


            // 再次遍历，为 bean 对象赋值
            for (Node node : nodes) {
                Element element = (Element) node;

                String id = element.attributeValue("id");
                String className = element.attributeValue("class");

                // 获取Class
                Class<?> aClass = Class.forName(className);

                // 获取该 bean 标签下所有的属性 property 标签
                List<Element> properties = element.elements("property");
                // 遍历
                properties.forEach(property -> {
                    try {
                        String propertyName = property.attributeValue("name");
                        // 拼接出set方法名
                        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                        // 获取参数类型
                        Field declaredField = aClass.getDeclaredField(propertyName);
                        // 获取 set 方法名
                        Method setMethod = aClass.getDeclaredMethod(setMethodName, declaredField.getType());

                        // 获取对象
                        // 获取具体的值
                        String ref = property.attributeValue("ref");
                        String value = property.attributeValue("value");
                        if (value != null) {
                            // 说明这个值是简单类型
                            // 调用 set 方法
                            // 我们的框架只支持一下类型
                            // byte short int long float double boolean char
                            // Byte Short Int Long Float Double Boolean Character
                            // String
                            // 获取属性类型名(简单类型名)
                            String propertySimpleName = declaredField.getType().getSimpleName();
                            Object actualValue = null;  // 真值
                            switch (propertySimpleName) {
                                case "byte":
                                    actualValue = Byte.parseByte(value);
                                    break;
                                case "short":
                                    actualValue = Short.parseShort(value);
                                    break;
                                case "int":
                                    actualValue = Integer.parseInt(value);
                                    break;
                                case "long":
                                    actualValue = Long.parseLong(value);
                                    break;
                                case "float":
                                    actualValue = Float.parseFloat(value);
                                    break;
                                case "double":
                                    actualValue = Double.parseDouble(value);
                                    break;
                                case "boolean":
                                    actualValue = Boolean.parseBoolean(value);
                                    break;
                                case "char":
                                    actualValue = value.charAt(0);
                                    break;
                                case "Byte":
                                    actualValue = Byte.valueOf(value);
                                    break;
                                case "Short":
                                    actualValue = Short.valueOf(value);
                                    break;
                                case "Int":
                                    actualValue = Integer.valueOf(value);
                                    break;
                                case "Long":
                                    actualValue = Long.valueOf(value);
                                    break;
                                case "Float":
                                    actualValue = Float.valueOf(value);
                                    break;
                                case "Double":
                                    actualValue = Double.valueOf(value);
                                    break;
                                case "Boolean":
                                    actualValue = Boolean.valueOf(value);
                                    break;
                                case "Char":
                                    actualValue = Character.valueOf(value.charAt(0));
                                    break;
                                case "String":
                                    actualValue = value;
                            }
                            setMethod.invoke(singletonObject.get(id),actualValue);
                        }
                        if (ref != null) {
                            // 说明这个值是非简单类型
                            setMethod.invoke(singletonObject.get(id), singletonObject.get(ref));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObject.get(beanName);
    }


}
