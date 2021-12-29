package com.example;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

/**
 * @author xuelin
 */
public class VerificationInOrderTest {


    @Test
    void should_Name() {

        // A. Single mock whose methods must be invoked in a particular orderA.A. 必须按特定顺序调用其方法的单个模拟。
        // 必须按特定顺序调用其方法的单个模拟
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //为单个模拟创建一个 inOrder 验证器
        InOrder inOrder = inOrder(singleMock);

        //以下将确保首先使用“首先添加”调用添加，然后使用“第二添加”
        inOrder.verify(singleMock)                                                                                                                                                                                                    .add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. 必须以特定顺序使用的多个模拟
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first");
        secondMock.add("was called second");

        //创建 inOrder 对象，传递需要按顺序验证的任何模拟
        InOrder inOrder2 = inOrder(firstMock, secondMock);

        //以下将确保 firstMock 在 secondMock 之前被调用
        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will

        /**
         * 按顺序验证是灵活的 - 您不必一一验证所有交互，而只需按顺序验证您感兴趣的那些交互。此外，您可以创建一个 InOrder 对象，仅传递与有序验证相关的模拟。
         */
    }

    @Test
    void should_Name2() {


    }
}
