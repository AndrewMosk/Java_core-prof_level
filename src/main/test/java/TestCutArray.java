import Lesson_6.Task_2.Cut;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCutArray {
    private Integer[] input;
    private Integer[] result;
    private boolean waitingException;
    private Cut cut;

    public TestCutArray(boolean waitingException, ArrayList<Integer> input, ArrayList<Integer> result) {
        this.input = input.toArray(new Integer[0]);
        this.result = result.toArray(new Integer[0]);
        this.waitingException = waitingException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][] {
                {false, new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7)), new ArrayList<Integer>(Arrays.asList(5,6,7))},
                {false, new ArrayList<Integer>(Arrays.asList(1,4,3,4,5,6,7)), new ArrayList<Integer>(Arrays.asList(5,6,7))},
                {false, new ArrayList<Integer>(Arrays.asList(1,4,3,4,5,6,7)), new ArrayList<Integer>(Arrays.asList(3,4,5,6,7))},
                {true, new ArrayList<Integer>(Arrays.asList(1,2,3,9,5,6,7)), new ArrayList<Integer>()}
        });
    }

    @Before
    public void init() {
        cut = new Cut();
    }

    @Test()
    public void testCut() {
        Assume.assumeFalse(waitingException);
        Assert.assertArrayEquals(result, cut.cutArray(input));
    }

    @Test(expected = RuntimeException.class)
    public void testCutException() {
        Assume.assumeTrue(waitingException);
        Assert.assertArrayEquals(result, cut.cutArray(input));
    }
}