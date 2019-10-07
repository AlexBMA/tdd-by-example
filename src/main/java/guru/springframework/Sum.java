package guru.springframework;

public class Sum implements Expresion{
    Expresion augment;
    Expresion addment;

    public Sum(Expresion augment, Expresion addment) {
        this.augment = augment;
        this.addment = addment;
    }

    @Override
    public Money reduce (Bank bank,String to){
        int amount = this.addment.reduce(bank, to).amount +
                this.augment.reduce(bank, to).amount;

        return new Money(amount,to);
    }

    @Override
    public Expresion plus(Expresion addend) {
        return new Sum(this,addment);
    }

    @Override
    public Expresion times(int multiple) {
        return new Sum(augment.times(multiple), addment.times(multiple));
    }
}
