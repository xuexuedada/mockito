package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

/**
 * @author xuelin
 */
public class MyTest {

    @Test
    void should_Name() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }

    LinkedList mockedList = mock(LinkedList.class);

    @Test
    void should_Name2() {
        //你可以模拟具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //以下抛出运行时异常
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //虽然可以验证一个 stubbed 调用, 通常它只是多余的
        //如果您的代码关心 get(0) 返回的内容，那么其他内容就会中断（通常甚至在 verify() 执行之前）。
        //如果你的代码不关心 get(0) 返回什么，那么它不应该被 stubbed。
        verify(mockedList).get(0);

    }

    @Test
    void should_Name3() {

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains(argThat(isValid()))).thenReturn(true);

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
        verify(mockedList).add(argThat(someString -> anyString().length() > 5));

    }

    private ArgumentMatcher<String>  isValid() {
        return null;
    }

}




