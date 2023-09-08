package com.prectice.jvm;

import java.io.Serializable;

/**
 * @author JLS
 * @description:
 * @since 2023-08-04 19:22
 */
public class User implements Serializable {
    public static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }
}
