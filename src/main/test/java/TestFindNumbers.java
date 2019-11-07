import Lesson_6.Task_3.FindNumbers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFindNumbers {
    private Integer[] input;
    private FindNumbers findNumbers;
    private Boolean result;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {false, new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7))},
                {false, new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1))},
                {false, new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,4))},
                {true, new ArrayList<Integer>(Arrays.asList(1,4))}
        });
    }

    public TestFindNumbers(Boolean result, ArrayList<Integer> input){
        this.result = result;
        this.input = input.toArray(new Integer[0]);
    }

    @Before
    public void init() {
        findNumbers = new FindNumbers();
    }

    @Test
    public void testAdd(){
        assertEquals(result, findNumbers.numbersSearch(input));
    }
}