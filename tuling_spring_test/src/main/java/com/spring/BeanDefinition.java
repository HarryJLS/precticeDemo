package com.spring;

/**
 * @author JLS
 * @description: bean的定义
 * @since 2023-08-18 19:55
 */
public class BeanDefinition {

    /**
     * bean的类型
     */
    private Class type;
    /**
     * 是不是单例
     */
    private String scope;
    /**
     * 是不是懒加载
     */
    private boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
