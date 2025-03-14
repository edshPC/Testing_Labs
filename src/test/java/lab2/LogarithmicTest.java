package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LogarithmicTest {

    private static final double DELTA = 1e-6;

    final double ln_2 = Math.log(2), ln_8 = Math.log(8),
            ln_5 = Math.log(5), ln_25 = Math.log(25),
            ln_10 = Math.log(10), ln_1000 = Math.log(1000);

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
        when(exp.ln(2)).thenReturn(ln_2);
        when(exp.ln(8)).thenReturn(ln_8);

        var log = new Logarithmic(exp);

        assertEquals(ln_8 / ln_2, log.log_2(8), DELTA);

        verify(exp, atLeastOnce()).ln(8);
        verify(exp, atLeastOnce()).ln(2);
    }

    @Test
    public void testLog5() {
        var exp = mock(SeriesExpansion.class);
        when(exp.ln(5)).thenReturn(ln_5);
        when(exp.ln(25)).thenReturn(ln_25);

        var log = new Logarithmic(exp);

        assertEquals(ln_25 / ln_5, log.log_5(25), DELTA);

        verify(exp, atLeastOnce()).ln(25);
        verify(exp, atLeastOnce()).ln(5);
    }

    @Test
    public void testLog10() {
        var exp = mock(SeriesExpansion.class);
        when(exp.ln(10)).thenReturn(ln_10);
        when(exp.ln(1000)).thenReturn(ln_1000);

        var log = new Logarithmic(exp);

        assertEquals(ln_1000 / ln_10, log.log_10(1000), DELTA);

        verify(exp, atLeastOnce()).ln(1000);
        verify(exp, atLeastOnce()).ln(10);
    }
}
