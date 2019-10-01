package guru.springframework;

public class Money implements Expresion{

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
        return new Money(amount,"USD");
    }

    public static Money frank(int amount){
        return new Money(amount,"CHF");
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.currency.equals(money.currency);
    }

    @Override
    public Money reduce(Bank bank, String to){
        int rate = bank.rate(this.currency,to);
        return new Money(amount/rate,to);
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

    public Expresion plus(Money added){
        return new Sum(this, added);
        //return new Sum(amount + added.amount,this.currency);
    }


}
