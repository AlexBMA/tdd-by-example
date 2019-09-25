package guru.springframework;

public class Bank {

    public Money reduce (Expresion source, String currency){
        return source.reduce(currency);
    }

    public int rate(String from,String to){
        return from.equals("CHF") && to.equals("USD") ? 2 : 1;
    }

    public void addRate(String from, String to, int rate) {

    }
}
