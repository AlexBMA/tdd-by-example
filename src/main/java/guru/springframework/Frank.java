package guru.springframework;

public class Frank  extends Money{

    public Frank(int amount, String currency){
        super(amount,currency);
    }

    public Money times(int multiple){
        return Money.frank(amount*multiple);
    }

}
