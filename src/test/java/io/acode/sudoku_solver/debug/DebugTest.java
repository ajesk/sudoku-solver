package io.acode.sudoku_solver.debug;

import io.acode.sudoku_solver.model.Grid;
import junit.framework.TestCase;

/**
 * Created by aaron on 4/28/17.
 */
public class DebugTest extends TestCase {
    public void testLoadDebugGrid() {
        Grid grid = DemoGridLoader.getDemoGrid();
        assert (grid != null);
        System.out.println(grid.toString());
    }
}
