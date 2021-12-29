package com.wangwenjun.mockito.lesson15;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class BddStyleTest
{
    @Mock
    private List<String> list;

    @Test
    public void testBdd()
    {
        given(list.get(anyInt())).willReturn("Alex");

        assertThat(list.get(10), equalTo("Alex"));
    }

}
