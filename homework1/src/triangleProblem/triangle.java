package triangleProblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class triangle {

    public boolean takeOut(int x) {
        List<Integer>moneyCopy = new ArrayList<Integer>(Arrays.asList(50, 20, 10, 5, 5, 1, 1, 1));
        while(moneyCopy.size() > 0) {
            for (int i = 0; i < moneyCopy.size(); i++) {
                if (moneyCopy.get(i) == x || x == 0)
                    return true;
                else if (moneyCopy.get(i) < x) {
                    x = x - moneyCopy.get(i);
                    moneyCopy.remove(i--);
                }
            }
        }
        return false;
    }
}
