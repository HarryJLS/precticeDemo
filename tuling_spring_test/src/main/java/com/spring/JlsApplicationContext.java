package com.spring;

import com.testspring.service.JlsBeanPostProcessor;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JLS
 * @description: spring容器
 * @since 2023-08-17 21:17
 */
public class JlsApplicationContext {

    private Class configClass;

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 单例池，用于存放单例bean
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public JlsApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 扫描
        // 得到扫描路径，然后遍历扫描路径下的所有文件，判断是否有Component注解，有则说明是一个bean，然后获取注解中bean的名字，然后设置bean定义，解析Scope注解，设置bean的作用域，最后将bean定义放入beanDefinitionMap中
        scan(configClass);

        // 创建非懒加载的单例bean
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();

            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getType();

        Object instance = null;
        try {
            // 创建类实例
            instance = clazz.getConstructor().newInstance();

            // 依赖注入
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    // 获取属性的名字
                    String fieldName = field.getName();
                    // 根据属性名字获取bean
                    Object bean = getBean(fieldName);
                    // 设置属性的值
                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }

            // 初始化前
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // bean初始化
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // 遍历扫描时保存的bean,如果这里写了代理(AOP)的写法，则返回的是代理对象
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }
            System.out.println(instance);


        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    private void scan(Class configClass) {
        // 扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value();
            System.out.println(path);

            ClassLoader classLoader = JlsApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path.replace(".", "/"));
            File file = new File(resource.getFile());
            // 判断拿到的是否是文件夹
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String absolutePath = f.getAbsolutePath();
                    System.out.println(absolutePath);
                    System.out.println(f.getName());

                    // 加载类
                    try {
                        Class<?> clazz = classLoader.loadClass(path + "." + f.getName().replace(".class", ""));


                        // 判断是否有Component注解，有则说明是一个bean
                        if (clazz.isAnnotationPresent(Component.class)) {

                            // 判断类是否实现了BeanPostProcessor接口
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor instance = (BeanPostProcessor) clazz.getConstructor().newInstance();

                                beanPostProcessors.add(instance);
                            }


                            // 获取注解中bean的名字
                            Component componentAnnotation = clazz.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();

                            // 判断是否有bean的名字，没有则默认使用类名首字母小写
                            if ("".equals(beanName)) {
                                beanName = Introspector.decapitalize(clazz.getSimpleName());
                            }

                            // 设置bean定义
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setType(clazz);

                            // 判断是否有Scope注解
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                String value = scopeAnnotation.value();
                                System.out.println(value);
                                beanDefinition.setScope(value);

                            } else {
                                beanDefinition.setScope("singleton");

                            }

                            beanDefinitionMap.put(beanName, beanDefinition);

                        }

                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }

                }
            }

        }
    }

    /**
     * 获取bean
     * 
     * @param beanName
     *            bean的名字 1.从beanDefinitionMap中获取bean定义 2.判断是不是单例
     *            3.如果是单例，判断单例池中有没有，有则直接返回，没有则创建一个新的bean，然后放入单例池中 4.如果不是单例，则创建一个新的bean
     * @return bean
     */
    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new NullPointerException();
        }

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        // 判断是不是单例
        if (beanDefinition.getScope().equals("singleton")) {

            Object singletonBean = singletonObjects.get(beanName);

            // 单例池中没有则创建一个新的bean
            if (singletonBean == null) {
                singletonObjects.put(beanName, createBean(beanName, beanDefinition));
            }

            System.out.println(singletonBean);
            return singletonBean;

            // 原型bean时每一次都要创建一个新的bean
        } else {
            // 原型
            Object prototypeBean = createBean(beanName, beanDefinition);
            System.out.println(prototypeBean);
            return prototypeBean;
        }

    }
}
