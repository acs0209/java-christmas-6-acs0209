package christmas.domain.wrapper;

public class MenuCount {

    private final int count;

    private MenuCount(int menuCount) {
        this.count = menuCount;
    }

    public static MenuCount create(int menuCount) {
        return new MenuCount(menuCount);
    }

    public int getCount() {
        return count;
    }
}
