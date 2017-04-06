import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Just a static container for possible values
 */
public class PossibleValues {
    private static final List<Integer> POSSIBLE_VALUES = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static List<Integer> get() {
        return POSSIBLE_VALUES;
    }
}
