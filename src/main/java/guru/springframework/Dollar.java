package guru.springframework;

public class Dollar extends Money {

    public Dollar(int amount){
        this.amount = amount;

    }

    Dollar times(int multiple){
        return new Dollar(amount*multiple);
    }

}
