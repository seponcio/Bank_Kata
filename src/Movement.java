import java.time.LocalDate;

public class Movement {
    private int amount;
    private LocalDate date;

    public Movement(int amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return this.amount;
    }
}
