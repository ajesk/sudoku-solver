import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A specific square in the Sudoku Grid
 */
@Data
public class Box {
    List<Integer> values;
    boolean solved;

    // Init with no value
    public void init() {
        setValues(PossibleValues.get());
        setSolved(false);
    }

    // Init with solved value
    public void init(int value) {
        values = new ArrayList<>();
        values.add(value);
        setSolved(true);
    }
}
