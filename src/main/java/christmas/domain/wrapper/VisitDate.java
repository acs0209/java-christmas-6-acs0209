package christmas.domain.wrapper;

public class VisitDate {

    private final int visitDate;

    private VisitDate(int visitDate) {
        this.visitDate = visitDate;
    }

    public static VisitDate create(int visitDate) {
        return new VisitDate(visitDate);
    }

    public int getVisitDate() {
        return visitDate;
    }
}
