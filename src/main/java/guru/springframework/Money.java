package guru.springframework;

public class Money {

    protected int amount;
    protected String currency;


    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected  String currency(){
        return currency;
    }

    public static Money dollar(int amount){
        return new Dollar(amount,"USD");
    }

    public static Money frank(int amount){
        return new Frank(amount,"CHF");
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.currency.equals(money.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Money times(int multiple){
        return new Money(amount * multiple, this.currency);
    }
}
