package com.epam.web.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    private Long id;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
