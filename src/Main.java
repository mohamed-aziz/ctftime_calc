import javax.swing.*;

import static javax.swing.UIManager.getSystemLookAndFeelClassName;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        App app = new App("CTFtime points calculator");

        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
