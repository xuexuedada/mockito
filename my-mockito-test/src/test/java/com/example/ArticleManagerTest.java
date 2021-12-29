package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * @author xuelin
 */
public class ArticleManagerTest {
    @Mock
    private ArticleCalculator calculator;
    @Mock
    private ArticleDatabase database;
    @Mock
    private UserProvider userProvider;

    private ArticleManager manager;

    @Test
    void testSomethingInJunit5(@Mock ArticleDatabase database) {
        database.create();

    }

    private static class ArticleCalculator {

    }

    private static class ArticleDatabase {
        public void create() {
        }
    }

    private static class UserProvider {
    }

    private static class ArticleManager {

    }
}
