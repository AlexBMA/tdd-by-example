package guru.springframework;

public interface Expresion {

    Money reduce(Bank bank, String to);

    Expresion plus(Expresion addend);

    Expresion times(int multiple);

}
