import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BubbleTest {
    BubbleSort bub;
    int[] res;
    int[] data;
    int[] wrong;

    @Before
    public void setUp() {
        bub = new BubbleSort();
        res = new int[]{1,2,2,5,6};
        data = new int[]{1,6,2,2,5};
        wrong = new int[]{1,2,5,2,6};
    }

    @Test
    public void testBubbleSort() {
        assertEquals(Arrays.toString(res), Arrays.toString(bub.BubbleSort(data)));
        assertNotEquals(Arrays.toString(wrong),Arrays.toString(bub.BubbleSort(data)));
    }

}
