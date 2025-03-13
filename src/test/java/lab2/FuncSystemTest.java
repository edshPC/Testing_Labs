package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FuncSystemTest {

    static final double DELTA = 1e-6;

    @Test
    public void testF1() {
        var tr = mock(Trigonometric.class);
        when(tr.sin(1)).thenReturn(1.0);
        when(tr.cos(1)).thenReturn(2.0);
        when(tr.tan(1)).thenReturn(3.0);
        when(tr.cot(1)).thenReturn(4.0);
        when(tr.sec(1)).thenReturn(5.0);

        var system = new FuncSystem(tr, null);

        assertEquals((5.0 + 5 + 3 + 4*4) - ((2 - 1) * 2) - 2, system.f1(1), DELTA);

        verify(tr, times(1)).sin(1);
        verify(tr, times(3)).cos(1);
        verify(tr, times(1)).tan(1);
        verify(tr, times(1)).cot(1);
        verify(tr, times(2)).sec(1);
    }

    @Test
    public void testF2() {
        var lg = mock(Logarithmic.class);
        when(lg.ln(1)).thenReturn(1.0);
        when(lg.log_2(1)).thenReturn(2.0);
        when(lg.log_5(1)).thenReturn(5.0);
        when(lg.log_10(1)).thenReturn(10.0);

        var system = new FuncSystem(null, lg);

        assertEquals(Math.pow(((1.0 / 5 - 2) * 10) * 10, 2) / (5 + 1), system.f2(1), DELTA);

        verify(lg, times(2)).ln(1);
        verify(lg, times(1)).log_2(1);
        verify(lg, times(2)).log_5(1);
        verify(lg, times(2)).log_10(1);
    }

    @Test
    public void testSystem() {
        var system = mock(FuncSystem.class);
        when(system.f1(anyDouble())).thenReturn(1.0);
        when(system.f2(anyDouble())).thenReturn(2.0);
        when(system.system(anyDouble())).thenCallRealMethod();

        assertEquals(1.0, system.system(-1), DELTA);
        verify(system, times(1)).f1(-1);

        assertEquals(1.0, system.system(0), DELTA);
        verify(system, times(1)).f1(0);

        assertEquals(2.0, system.system(1), DELTA);
        verify(system, times(1)).f2(1);
    }

}
