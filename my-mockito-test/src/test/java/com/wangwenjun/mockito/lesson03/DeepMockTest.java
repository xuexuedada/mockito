package com.wangwenjun.mockito.lesson03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DeepMockTest
{

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Lesson03Service lesson03Service;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    //stubbing
    @Test
    public void testDeepMock()
    {
        lesson03Service.get().foo();
    }
}
