import java.util.Deque;
import java.util.LinkedList;

class BrowserHistory {
    Deque<String> history = new LinkedList<>();
    public void visitSite(String site) {
        history.addFirst(site);
    }
    public String back(int steps) {
        if (steps >= history.size()) {
            return  "No more history!";
        }
        return
                history.stream().skip(steps).findFirst().orElse(null);
    }
    public Deque<String> getHistory() {
        return history;
    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
class Printer {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.getHistory());
    }
}