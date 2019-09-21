package guru.springframework;

public class Bank {

    public Money reduce (Expresion source, String currency){
        return source.reduce(currency);
    }
}
