package guru.springframework;

public class Dollar {

    public int amount;

    public Dollar(int amount){
        this.amount = amount;

    }

    Dollar times(int multiple){
        return new Dollar(amount*multiple);
    }

    public boolean equals(Object object){
        Dollar dollar = (Dollar) object;
        return amount == dollar.amount;
    }
}
