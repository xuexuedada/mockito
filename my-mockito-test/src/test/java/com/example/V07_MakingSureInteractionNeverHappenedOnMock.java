package com.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author xuelin
 */
public class V07_MakingSureInteractionNeverHappenedOnMock {

    //Making sure interaction(s) never happened on mock
    //确保交互从未发生在模拟上

    private List<String> mockOne;
    private List<String> mockedList;

    @BeforeEach
    void setUp() {
         mockOne = mock(FooBar.class);
        mockedList = mock(FooBar.class);
    }

    @Test
    void should_Name() {
        //using mocks - only mockOne is interacted 相互作用
        mockOne.add("one");

        //ordinary普通 verification
        verify(mockOne).add("one");

        //verify that method was never called on a mock
        verify(mockOne, never()).add("two");
    }

    @Test
    void should_Name2() {
        mockOne.add("one");
        verify(mockOne, never()).add("two222");
    }

    @Test
    void v08_Finding_redundant_invocations() {

        /**
         * A word of warning: Some users who did a lot of classic,
         * expect-run-verify mocking tend to use verifyNoMoreInteractions() very often,
         * even in every test method. verifyNoMoreInteractions() is not recommended to use in every test method.
         * verifyNoMoreInteractions() is a handy assertion from the interaction testing toolkit.
         * Use it only when it's relevant. Abusing it leads to overspecified, less maintainable tests.
         *
         * 警告：一些进行了很多经典的、expect-run-verify 模拟的用户倾向于非常频繁地使用 verifyNoMoreInteractions()，
         * 即使在每个测试方法中也是如此。不建议在每个测试方法中使用 verifyNoMoreInteractions()。
         * verifyNoMoreInteractions() 是来自交互测试工具包的一个方便的断言。
         * 仅在相关时使用它。滥用它会导致过度指定、不易维护的测试。
         *
         * See also never() - it is more explicit and communicates the intent well.
         */

        //using mocks
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");
//        verify(mockedList).add("two");

        //following verification will fail
        //以下验证将失败
        verifyNoMoreInteractions(mockedList);

    }
}

abstract class FooBar implements List<String> {

}





