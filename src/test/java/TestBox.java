import junit.framework.TestCase;

/**
 * Created by aaron on 4/6/17.
 */
public class TestBox extends TestCase {
    public void testUnsolvedInit() {
        Box box = new Box();
        box.init();
        assert(box.values.size() == 9);
        assert(!box.isSolved());
    }

    public void testSolvedInit() {
        Box box = new Box();
        box.init(1);
        assert(box.values.size() == 1);
        assert(box.isSolved());
    }
}
