package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FuncSystemTest {

    static final double DELTA = 1e-6;

    final double sin_1 = Math.sin(1), cos_1 = Math.cos(1),
            tan_1 = Math.tan(1), cot_1 = 1 / Math.tan(1), sec_1 = 1 / Math.cos(1);
    final double ln_1 = Math.log(1), log2_1 = ln_1 / Math.log(2),
        log5_1 = ln_1 / Math.log(5), log10_1 = Math.log10(1);

    @Test
    public void testF1() {
        var tr = mock(Trigonometric.class);
        when(tr.sin(1)).thenReturn(sin_1);
        when(tr.cos(1)).thenReturn(cos_1);
        when(tr.tan(1)).thenReturn(tan_1);
        when(tr.cot(1)).thenReturn(cot_1);
        when(tr.sec(1)).thenReturn(sec_1);

        var system = new FuncSystem(tr, null);

        assertEquals((sec_1 + sec_1 + tan_1 + cot_1*cot_1) -
                     ((cos_1 - sin_1) * cos_1) - cos_1, system.f1(1), DELTA);

        verify(tr, times(1)).sin(1);
        verify(tr, times(3)).cos(1);
        verify(tr, times(1)).tan(1);
        verify(tr, times(1)).cot(1);
        verify(tr, times(2)).sec(1);
    }

    @Test
    public void testF2() {
        var lg = mock(Logarithmic.class);
        when(lg.ln(1)).thenReturn(ln_1);
        when(lg.log_2(1)).thenReturn(log2_1);
        when(lg.log_5(1)).thenReturn(log5_1);
        when(lg.log_10(1)).thenReturn(log10_1);

        var system = new FuncSystem(null, lg);

        assertEquals(Math.pow(((ln_1 / log5_1 - log2_1) * log10_1) * log10_1, 2)
                     / (log5_1 + ln_1), system.f2(1), DELTA);

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
