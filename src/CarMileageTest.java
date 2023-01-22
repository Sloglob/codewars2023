import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarMileageTest {

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testSmall() {
        assertEquals(1, CarMileage.isInteresting(98, new int[]{1337, 256}));
    }

    @Test
    public void testBig() {
        assertEquals(2, CarMileage.isInteresting(1000000000, new int[]{1337, 256}));
    }

    @Test
    public void testTooBig() {
        assertEquals(2, CarMileage.isInteresting(1000000001, new int[]{1337, 256}));
    }

    @Test
    public void testPalindrome() {
        assertEquals(2, CarMileage.isInteresting(34543, new int[]{1337, 256}));
    }

    @Test
    public void testPalindromeWithOddDigits() {
        assertEquals(2, CarMileage.isInteresting(666666, new int[]{1337, 256}));
    }

    @Test
    public void testPalindromeMinusTwo() {
        assertEquals(1, CarMileage.isInteresting(34541, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{1337, 256}));
    }

    @Test
    public void testHundreds() {
        assertEquals(2, CarMileage.isInteresting(90000, new int[]{1337, 256}));
    }

    @Test
    public void testHundred() {
        assertEquals(2, CarMileage.isInteresting(100, new int[]{1337, 256}));
    }

    @Test
    public void testSequentialDecrementing() {
        assertEquals(2, CarMileage.isInteresting(3210, new int[]{1337, 256}));
    }

    @Test
    public void testSequentialNotDecrementing() {
        assertEquals(0, CarMileage.isInteresting(3201, new int[]{1337, 256}));
    }

    @Test
    public void testSequentialPlusTwoDecrementing() {
        assertEquals(1, CarMileage.isInteresting(3208, new int[]{1337, 256}));
    }

    @Test
    public void testSequentialIncrementing() {
        assertEquals(2, CarMileage.isInteresting(12345, new int[]{1337, 256}));
    }

    @Test
    public void testSequentialNotIncrementing() {
        assertEquals(0, CarMileage.isInteresting(12305, new int[]{1337, 256}));
    }

    @Test
    public void testSequentialPlusTwoIncrementing() {
        assertEquals(1, CarMileage.isInteresting(12343, new int[]{1337, 256}));
    }

    @Test
    public void testVeryBig() {
        assertEquals(2, CarMileage.isInteresting(999999999, new int[]{1337, 256}));
    }

    @Test
    public void testOneHundredAndNine() {
        assertEquals(1, CarMileage.isInteresting(109, new int[]{1337, 256}));
    }

    @Test
    public void testSevenEightNineZero() {
        assertEquals(2, CarMileage.isInteresting(7890, new int[]{1337, 256}));
    }

    @Test
    public void testThreeTwoOneZeroNine() {
        assertEquals(0, CarMileage.isInteresting(32109, new int[]{1337, 256}));
    }

    @Test
    public void testVeryBigMinusTwo() {
        assertEquals(1, CarMileage.isInteresting(999999998, new int[]{1337, 256}));
    }
}