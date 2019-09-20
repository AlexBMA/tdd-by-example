package guru.springframework;

public class Frank {

    private int amount;

    public Frank(int amount){
        this.amount = amount;

    }

    Frank times(int multiple){
        return new Frank(amount*multiple);
    }

    public boolean equals(Object object){
        Frank frank = (Frank) object;
        return amount == frank.amount;
    }
}
