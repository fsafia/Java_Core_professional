package lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
    TaskArray taskArray;
    @Before
    public void init(){
       taskArray = new TaskArray();
    }

    @Test
    public void testOutputLastElements1(){
        int[] arExpected = {4,5,6};
        int [] ar1 = {0,1,2,3,4,5,6};
        Assert.assertArrayEquals(arExpected, taskArray.outputLastElements(ar1));
    }

    @Test(expected = RuntimeException.class)
    public void testOutputLastElements2(){
        int[] arExpected = {3};
        int [] ar1 = {0,1,2,3};
        Assert.assertArrayEquals(arExpected, taskArray.outputLastElements(ar1));
    }

    @Test(expected = RuntimeException.class)
    public void testOutputLastElements3(){
        int[] arExpected = {2};
        int [] ar1 = {0,1,2};
        Assert.assertArrayEquals(arExpected, taskArray.outputLastElements(ar1));
    }
}
