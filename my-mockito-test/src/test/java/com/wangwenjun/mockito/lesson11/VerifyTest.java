package com.wangwenjun.mockito.lesson11;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class VerifyTest
{
    @Mock
    private SimpleDao simpleDao;

    @Test
    public void testRealCallCreateSimple()
    {
        SimpleService service = new SimpleService(simpleDao);
        Simple simple = new Simple();
        when(simpleDao.findSimple(simple)).thenReturn(false);
        when(simpleDao.createSimple(simple)).thenReturn(true);
        when(simpleDao.updateSimple(simple)).thenReturn(true);
        boolean result = service.merge(simple);
        assertThat(result, equalTo(true));
        verify(simpleDao, times(1)).createSimple(simple);
        verify(simpleDao, times(0)).updateSimple(simple);
    }

    @Test
    public void testRealCallUpdateSimple()
    {
        SimpleService service = new SimpleService(simpleDao);
        Simple simple = new Simple();
        when(simpleDao.findSimple(simple)).thenReturn(true);
        when(simpleDao.createSimple(simple)).thenReturn(true);
        when(simpleDao.updateSimple(simple)).thenReturn(true);
        boolean result = service.merge(simple);
        assertThat(result, equalTo(true));
        verify(simpleDao, times(0)).createSimple(simple);
        verify(simpleDao, times(1)).updateSimple(simple);
    }

    @Test
    public void testMerge()
    {
        SimpleService service = new SimpleService(simpleDao);
        Simple simple = new Simple();
        //when(simpleDao.findSimple(simple)).thenReturn(true).thenReturn(false);
        when(simpleDao.findSimple(simple)).thenReturn(true,false);
        when(simpleDao.createSimple(simple)).thenReturn(true);
        when(simpleDao.updateSimple(simple)).thenReturn(true);

        boolean result = service.merge(simple);
        assertThat(result, equalTo(true));
        verify(simpleDao, times(0)).createSimple(simple);
        verify(simpleDao, times(1)).updateSimple(simple);

        result = service.merge(simple);
        assertThat(result, equalTo(true));


        verify(simpleDao, times(1)).createSimple(simple);
        verify(simpleDao, times(1)).updateSimple(simple);
    }


    @AfterEach
    public void destroy()
    {
        reset(simpleDao);
    }
}
