package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LogarithmicTest {

    private static final double DELTA = 1e-6;

    @Test
    public void testLn() {
        var exp = mock(SeriesExpansion.class);
        when(exp.ln(1)).thenReturn(0.0);
        when(exp.ln(Math.E)).thenReturn(1.0);

        var log = new Logarithmic(exp);

        assertEquals(0.0, log.ln(1), DELTA);
        assertEquals(1.0, log.ln(Math.E), DELTA);

        verify(exp, atLeastOnce()).ln(1);
        verify(exp, atLeastOnce()).ln(Math.E);
    }

    @Test
    public void testLog2() {
        var exp = mock(SeriesExpansion.class);
        when(exp.ln(2)).thenReturn(0.7);
        when(exp.ln(8)).thenReturn(2.1);

        var log = new Logarithmic(exp);

        assertEquals(2.1 / 0.7, log.log_2(8), DELTA);

        verify(exp, atLeastOnce()).ln(8);
        verify(exp, atLeastOnce()).ln(2);
    }

    @Test
    public void testLog5() {
        var exp = mock(SeriesExpansion.class);
        when(exp.ln(5)).thenReturn(1.6);
        when(exp.ln(25)).thenReturn(3.2);

        var log = new Logarithmic(exp);

        assertEquals(3.2 / 1.6, log.log_5(25), DELTA);

        verify(exp, atLeastOnce()).ln(25);
        verify(exp, atLeastOnce()).ln(5);
    }

    @Test
    public void testLog10() {
        var exp = mock(SeriesExpansion.class);
        when(exp.ln(10)).thenReturn(2.3);
        when(exp.ln(1000)).thenReturn(6.9);

        var log = new Logarithmic(exp);

        assertEquals(6.9 / 2.3, log.log_10(1000), DELTA);

        verify(exp, atLeastOnce()).ln(1000);
        verify(exp, atLeastOnce()).ln(10);
    }
}
