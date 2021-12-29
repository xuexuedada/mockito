package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

/**
 * @author xuelin
 */
public class V10_StubbingConsecutiveCalls {

    UpdateUtils mockUU = mock(UpdateUtils.class);

    @Test
    void should_Name11() {

        when(mockUU.update("Data"))
            .thenThrow(new RuntimeException())
            .thenReturn("DATA");

        assertThrows(RuntimeException.class, () -> mockUU.update("Data"));
        assertEquals("DATA", mockUU.update("Data"));

        //further calls will return the last mocked output
        assertEquals("DATA", mockUU.update("Data"));

    }

    @Test
    void should_Name1111() {
        when(mockUU.update("Emp")).thenReturn("EMP", "EMPLOYEE", "EMP1");

        assertEquals("EMP", mockUU.update("Emp"));
        assertEquals("EMPLOYEE", mockUU.update("Emp"));
        assertEquals("EMP1", mockUU.update("Emp"));
        assertEquals("EMP1", mockUU.update("Emp"));
    }

    @Test
    void should_Name1211() {
        Iterator<Integer> mockIter = mock(Iterator.class);
        when(mockIter.hasNext()).thenReturn(true, true, true, false);
        int[] values = new int[]{1, 2, 3, 4};
        when(mockIter.next()).thenReturn(values[0], values[1], values[2], values[3]);

        int index = 0;
        while (mockIter.hasNext()) {
            assertEquals(values[index], (int) mockIter.next());
            index++;
        }
    }

    private class UpdateUtils {
        public String update(String data) {
            return "";
        }

    }
}





