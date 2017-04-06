import java.util.List;

/**
 * Created by aaron on 4/6/17.
 */
public class Grid {
    private Box[][] grid;

    public Box getBox(int x, int y) {
        return grid[x][y];
    }
}
