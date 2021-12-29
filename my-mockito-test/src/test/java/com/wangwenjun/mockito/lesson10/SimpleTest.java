package com.wangwenjun.mockito.lesson10;

import static com.wangwenjun.mockito.lesson10.CompareNumberMatcher.gt;
import static com.wangwenjun.mockito.lesson10.CompareNumberMatcher.lt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.CombinableMatcher.both;

import org.junit.jupiter.api.Test;

public class SimpleTest
{

    @Test
    public void test()
    {
//        assertThat(1,lt(3));
//        assertThat(10,gt(5));
//        assertThat(12,both(gt(10)).and(13));

        assertThat(10, gt(8));
        assertThat(10, lt(18));
//10<x<13
        assertThat(12, both(gt(10)).and(lt(13)));
    }
}
