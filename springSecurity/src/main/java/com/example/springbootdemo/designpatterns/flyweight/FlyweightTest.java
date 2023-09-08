package com.example.springbootdemo.designpatterns.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JLS
 * @description: 享元模式 运用共享技术有效的支持大量细粒度的对象，如果系统有大量类似的对象，
 * 可以节省大量的内存和cpu资源,共享对象创建使用；应用面：String， Integer， Long
 * @since 2023-05-13 19:37
 */
public class FlyweightTest {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,4, TreeFactory.getTree("xx", "xxxx"));
        TreeNode treeNode1 = new TreeNode(4,4, TreeFactory.getTree("xxx", "xxxx"));
        System.out.println(treeNode);
        System.out.println(treeNode1);
    }
}

class TreeNode{
    private Integer x;
    private Integer y;
    private Tree tree;

    public TreeNode(Integer x, Integer y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "x=" + x +
                ", y=" + y +
                ", tree=" + tree +
                '}';
    }
}
class TreeFactory{
    private static Map<String, Tree> map = new ConcurrentHashMap<>();
    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;

    }
}

class Tree {
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

}
