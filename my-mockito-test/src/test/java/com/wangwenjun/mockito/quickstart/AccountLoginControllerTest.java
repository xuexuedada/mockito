//package com.wangwenjun.mockito.quickstart;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//
//import com.wangwenjun.mockito.common.Account;
//import com.wangwenjun.mockito.common.AccountDao;
//import com.wangwenjun.mockito.common.AccountLoginController;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//public class AccountLoginControllerTest
//{
//
//    private AccountDao accountDao;
//
//    private HttpServletRequest request;
//
//    private AccountLoginController accountLoginController;
//
//    @BeforeEach
//    public void setUp()
//    {
//        this.accountDao = Mockito.mock(AccountDao.class);
//        this.request = Mockito.mock(HttpServletRequest.class);
//        this.accountLoginController = new AccountLoginController(accountDao);
//    }
//
//    @Test
//    public void testLoginSuccess()
//    {
//        Account account = new Account();
//        when(request.getParameter("username")).thenReturn("alex");
//        when(request.getParameter("password")).thenReturn("123456");
//        when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
//
//        assertThat(accountLoginController.login(request), equalTo("/index"));
//
//    }
//
//    @Test
//    public void testLoginFailure()
//    {
//        when(request.getParameter("username")).thenReturn("alex");
//        when(request.getParameter("password")).thenReturn("1234561");
//        when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);
//
//        assertThat(accountLoginController.login(request), equalTo("/login"));
//    }
//
//    @Test
//    public void testLogin505()
//    {
//        when(request.getParameter("username")).thenReturn("alex");
//        when(request.getParameter("password")).thenReturn("1234561");
//        when(accountDao.findAccount(anyString(), anyString())).thenThrow(UnsupportedOperationException.class);
//        assertThat(accountLoginController.login(request), equalTo("/505"));
//    }
//}
