package com.verifyTest;

/**
 * @author xuelin
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * https://www.baeldung.com/mockito-verify
 */

class MockitoVerifyCookbook {

    private static List<String> mockedList;

    @BeforeEach
    void setUp() {
        mockedList = mock(MyList.class);
    }

    @Test
    @SuppressWarnings("UnusedReturnValue")
    void should_Name() {
        //在模拟上验证简单调用：
        final int size = mockedList.size();
        verify(mockedList).size();
    }


    @Test
    void should_Name2() {
        //验证与模拟的交互次数：
        final int size = mockedList.size();
        verify(mockedList, times(1)).size();
    }

    @Test
    void should_Name3() {
        //验证没有与整个模拟发生交互：
        verifyNoInteractions(mockedList);
    }


    @Test
    void should_Name4() {
        //4. 验证没有发生与特定方法的交互：
        verify(mockedList, times(0)).size();
    }

    @Test
    void should_Name5() {
        //5.验证没有意外的交互——这应该会失败：
        final int size = mockedList.size();
        mockedList.clear();
        verify(mockedList).size();
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    void should_Name6() {
        //验证交互顺序：
        List<String> mockedList = mock(MyList.class);
        final int size = mockedList.size();
        mockedList.add("a parameter");
        mockedList.clear();

        InOrder inOrder = Mockito.inOrder(mockedList);
        inOrder.verify(mockedList).size();
        inOrder.verify(mockedList).add("a parameter");
        inOrder.verify(mockedList).clear();
    }

    @Test
    void should_Name7() {
        //验证未发生交互：
        List<String> mockedList = mock(MyList.class);
        final int size = mockedList.size();
        verify(mockedList, never()).clear();
    }

    @Test
    void should_Name8() {
        //验证交互至少发生了一定次数：
        List<String> mockedList = mock(MyList.class);
        mockedList.clear();
        mockedList.clear();
        mockedList.clear();

        verify(mockedList, atLeast(1)).clear();
        verify(mockedList, atMost(10)).clear();
    }

    @Test
    void should_Name9() {
        //验证与确切参数的交互：
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add("test");
    }

    @Test
    void should_Name10() {
        //验证与 flexible/any 参数的交互：
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }

    @Test
    void should_Name11() {
        //使用参数捕获验证交互：
        List<String> mockedList = mock(MyList.class);
        mockedList.addAll(Lists.<String> newArrayList("someElement"));
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockedList).addAll(argumentCaptor.capture());
        List<String> capturedArgument = argumentCaptor.getValue();
        assertThat(capturedArgument, hasItem("someElement"));
    }
}
