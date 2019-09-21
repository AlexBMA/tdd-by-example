package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10),five.times(2));
        assertEquals(Money.dollar(15),five.times(3));
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5),Money.dollar(5));
        assertNotEquals(Money.dollar(5),Money.dollar(8));
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5),Money.frank(5));
    }

    @Test
    void tesCurrency(){
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.frank(1).currency());
    }
}
