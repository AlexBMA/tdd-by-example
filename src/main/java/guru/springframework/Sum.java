package guru.springframework;

public class Sum implements Expresion{
    Money augment;
    Money addment;

    public Sum(Money augment, Money addment) {
        this.augment = augment;
        this.addment = addment;
    }

    @Override
    public Money reduce (Bank bank,String to){
        int amount = this.addment.amount + this.augment.amount;
        return new Money(amount,to);
    }
}
