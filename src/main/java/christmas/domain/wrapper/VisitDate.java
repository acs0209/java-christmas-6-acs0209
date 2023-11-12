package christmas.domain.wrapper;

public class VisitDate {

    private final int date;

    private VisitDate(int visitDate) {
        this.date = visitDate;
    }

    public static VisitDate create(int visitDate) {
        return new VisitDate(visitDate);
    }

    public int getDate() {
        return date;
    }
}
