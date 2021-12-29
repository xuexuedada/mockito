package com.wangwenjun.mockito.lesson13;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ArgumentCaptorAnnotationTest
{

    @Mock
    private List<String> list;

    @Captor
    private ArgumentCaptor<String> captor;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void testArgCaptor()
    {

        when(list.add("Mockito")).thenReturn(true);
        list.add("Mockito");

        // verify(list, times(1)).add("Mockito");
        verify(list, times(1)).add(captor.capture());
        assertThat(captor.getValue(), equalTo("Mockito"));

    }

    @Test
    public void testArgumentCaptor()
    {

        User user = new User("345355");

        when(userDao.deleteUser(user)).thenReturn(true);
        assertThat(userService.deleteUser(user), equalTo(true));
        verify(userDao).deleteUser(userCaptor.capture());

        assertThat(userCaptor.getValue().getType(), equalTo("D"));
        assertThat(user.getType(), equalTo("D"));

    }
}
