package triangleProblem;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class testT {
    triangle Tri;
    @Before
    public void setUp(){
        Tri = new triangle();
    }

    @Test
    public void test50(){
        boolean result = Tri.takeOut(50);
        assertTrue("true", result);
    }

    @Test
    public void test1(){
        boolean result = Tri.takeOut(1);
        assertTrue("true", result);
    }

    @Test
    public void test3(){
        boolean result = Tri.takeOut(3);
        assertTrue("true", result);
    }

    @Test
    public void test93(){
        boolean result = Tri.takeOut(93);
        assertTrue("true", result);
    }

    @Test
    public void test100(){
        boolean result = Tri.takeOut(100);
        assertFalse("false", result);
    }
}
