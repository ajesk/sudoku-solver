package io.acode.sudoku_solver;

import io.acode.sudoku_solver.util.Locator;
import junit.framework.TestCase;

public class LocatorTests extends TestCase {

    public void testGetBox() {
        assertEquals(0, Locator.locateBox(0));
        assertEquals(0, Locator.locateBox(1));
        assertEquals(0, Locator.locateBox(2));
        assertEquals(3, Locator.locateBox(3));
        assertEquals(3, Locator.locateBox(4));
        assertEquals(3, Locator.locateBox(5));
        assertEquals(6, Locator.locateBox(6));
        assertEquals(6, Locator.locateBox(7));
        assertEquals(6, Locator.locateBox(8));
    }
}
