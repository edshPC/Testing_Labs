package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrigonometricTest {

    private static final double DELTA = 1e-6;

    final double sin_1 = Math.sin(1.0), sin_1_pi_2 = Math.sin(1 + Math.PI / 2);

    @Test
    public void testSin() {
        var exp = mock(SeriesExpansion.class);

        when(exp.sin(1)).thenReturn(sin_1);

        var tr = new Trigonometric(exp);

        assertEquals(sin_1, tr.sin(1), DELTA);
        verify(exp, atLeastOnce()).sin(1);
    }

    @Test
    public void testCos() {
        var exp = mock(SeriesExpansion.class);
        when(exp.sin(0)).thenReturn(0.0);
        when(exp.sin(Math.PI / 2)).thenReturn(1.0);

        var tr = new Trigonometric(exp);

        assertEquals(1.0, tr.cos(0), DELTA);
        verify(exp, atLeastOnce()).sin(Math.PI / 2);
    }

    @Test
    public void testTan() {
        var exp = mock(SeriesExpansion.class);
        when(exp.sin(0)).thenReturn(0.0);
        when(exp.sin(1)).thenReturn(sin_1);
        when(exp.sin(Math.PI / 2)).thenReturn(1.0);
        when(exp.sin(1 + Math.PI / 2)).thenReturn(sin_1_pi_2);

        var tr = new Trigonometric(exp);

        assertEquals(0.0, tr.tan(0), DELTA);
        assertEquals(sin_1 / sin_1_pi_2, tr.tan(1), DELTA);

        verify(exp, atLeastOnce()).sin(1);
        verify(exp, atLeastOnce()).sin(1 + Math.PI / 2);
    }

    @Test
    public void testCot() {
        var exp = mock(SeriesExpansion.class);
        when(exp.sin(1)).thenReturn(sin_1);
        when(exp.sin(1 + Math.PI / 2)).thenReturn(sin_1_pi_2);

        var tr = new Trigonometric(exp);

        assertEquals(sin_1_pi_2 / sin_1, tr.cot(1), DELTA);

        verify(exp, atLeastOnce()).sin(1);
        verify(exp, atLeastOnce()).sin(1 + Math.PI / 2);
    }

    @Test
    public void testSec() {
        var exp = mock(SeriesExpansion.class);
        when(exp.sin(Math.PI / 2)).thenReturn(1.0);
        when(exp.sin(Math.PI)).thenReturn(0.0);

        var tr = new Trigonometric(exp);

        assertEquals(1.0, tr.sec(0), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, tr.sec(Math.PI / 2));

        verify(exp, atLeastOnce()).sin(Math.PI / 2);
        verify(exp, atLeastOnce()).sin(Math.PI);
    }
}
