import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BackPackTest {
    BackPack back;
    int[][] res;
    int[] w;
    int[] p;
    int[][] wrong;

    @Before
    public void setUp() {
        back = new BackPack();
        res = new int[][]{{0,0,4,4,4,4,4,4,4,4},{0,0,4,5,5,5,9,9,9,9},{0,0,4,5,6,6,9,10,11,11}};
        w = new int[]{3, 4, 5};
        p = new int[]{4, 5, 6};
        wrong = new int[][]{{0,0,4,4,4,4,3,4,4,5},{0,0,4,5,5,5,9,9,9,9},{0,0,4,5,6,6,9,10,11,11}};
    }

    @Test
    public void test() {
        assertTrue(back.isEqual(10, 3, res, back.BackPack_Solution(10, 3, w, p)));
        assertTrue(!back.isEqual(10, 3, wrong, back.BackPack_Solution(10, 3, w, p)));
    }

}