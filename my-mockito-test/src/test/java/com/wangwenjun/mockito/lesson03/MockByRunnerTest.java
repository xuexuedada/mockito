package com.wangwenjun.mockito.lesson03;

import static org.mockito.Mockito.mock;

import com.wangwenjun.mockito.common.Account;
import com.wangwenjun.mockito.common.AccountDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockByRunnerTest
{

    @Test
    public void testMock()
    {
        AccountDao accountDao = mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }
}
