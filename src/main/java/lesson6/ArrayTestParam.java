package lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayTestParam {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        int[] a1 = {0, 1, 2, 3, 4, 5, 6};
        int[] a2 = {1, 1, 1, 1, 1, 1};
        int[] a3 = {4, 4, 4, 4, 4};
        int[] a4 = {1, 4, 1, 1, 1};
        int[] a5 = {1, 4, 4, 4, 4, 4};
        return Arrays.asList(new Object[][]{
                {false , a1 },
                {false , a2 },
                {false , a3 },
                {true , a4 },
                {true , a5 }
        });
    }

    private TaskArray taskArray;
    private boolean expected;
    private int[] ar;
    public ArrayTestParam(boolean expected, int ... checkArray){
        this.expected = expected;
        ar = checkArray;
    }

    @Before
    public void init(){
        taskArray  = new TaskArray();
    }

    @Test
    public void testCheck1and4(){
        Assert.assertEquals(expected, taskArray.check1and4(ar));
    }
}
