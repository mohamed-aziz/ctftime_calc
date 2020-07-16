import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;

public class Main {
    public static void main(String[] args) {

        LafManager.install(new DarculaTheme());

        App app = new App("CTFtime points calculator");

        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
