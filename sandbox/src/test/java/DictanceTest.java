import org.testng.Assert;
import org.testng.annotations.Test;

public class DictanceTest {
    @Test
    public void testDistance1() {
        Point p1 = new Point(-12, 10);
        Point p2 = new Point(14, 1);

        Assert.assertEquals(p1.distance(p2),27.51363298439521);
    }
    @Test
    public void testDistance2() {
        Point p1 = new Point(-12, 56);
        Point p2 = new Point(14, 0);

        Assert.assertEquals(p1.distance(p2),27.51363298439521);
    }
}
