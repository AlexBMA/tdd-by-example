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

    @Test
    void testSingleAddition() {
        Money five = Money.dollar(5);
        Expresion sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusSumReturnSum() {
        Money five = Money.dollar(5);
        Expresion result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augment);
        assertEquals(five, sum.addment);
    }

    @Test
    void testReduceSum() {
        Expresion sum = new Sum(Money.dollar(5), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(9), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1),"USD");
        assertEquals(Money.dollar(1),result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.frank(2),"USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1,new Bank().rate("USD","USD"));
        assertEquals(1,new Bank().rate("CHF","CHF"));
    }

    @Test
    public void testMixedAddition(){
        Expresion fiveBucks = Money.dollar(5);
        Expresion tenFranks = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(fiveBucks.plus(tenFranks),"USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    void testSumPlusMoney() {
        Expresion fiveBucks = Money.dollar(5);
        Expresion tenFranks = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expresion sum = new Sum(fiveBucks, tenFranks).plus(fiveBucks);
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    void testSumTimes() {
        Expresion fiveBucks = Money.dollar(5);
        Expresion tenFranks = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expresion sum = new Sum(fiveBucks, tenFranks).times(2);
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(20),result);

    }
}
