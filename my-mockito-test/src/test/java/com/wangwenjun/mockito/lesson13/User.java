package com.wangwenjun.mockito.lesson13;

public class User
{

    private final String id;

    private String type;

    public User(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
