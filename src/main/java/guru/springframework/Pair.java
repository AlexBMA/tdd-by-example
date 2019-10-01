package guru.springframework;

import java.util.Objects;

public class Pair {

    private final String from;
    private final String by;


    public Pair(String from, String by) {
        this.from = from;
        this.by = by;
    }

    public String getFrom() {
        return from;
    }

    public String getBy() {
        return by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(from, pair.from) &&
                Objects.equals(by, pair.by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, by);
    }
}
