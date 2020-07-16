import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;


public class App extends JFrame {
    private JSpinner tpts;
    private JSpinner bpts;
    private JSpinner tplace;
    private JSpinner totalteams;
    private JSpinner weight;

    private JPanel mainPanel;
    private JLabel calcWeight;

    public App(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(500, 250));
        this.pack();
        for (JSpinner c:  new ArrayList<JSpinner>(){{add(tpts); add(bpts); add(weight);}}) {
            c.setModel(
                    new SpinnerNumberModel(new Double(0.0), null, null, new Double(1000.0))
            );
            ((SpinnerNumberModel) c.getModel()).setStepSize(1.);
        }

        this.weight.setValue(25.);
        this.tplace.setValue(1.);
        this.totalteams.setValue(1.);
        this.bpts.setValue(1.);
        ArrayList<JSpinner> js = new ArrayList<JSpinner>(){{add(tpts); add(bpts); add(tplace); add(totalteams); add(weight);}};
        for (JSpinner c: js) {
            c.addChangeListener(e -> change_weight());

            ((JSpinner.DefaultEditor) c.getEditor()).getTextField().addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    super.focusGained(e);
                    SwingUtilities.invokeLater(() -> ((JTextField) e.getSource()).selectAll());
                }
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                }
            });

        }


    }


    private void change_weight() {
        double currWeight = this.calculate_weight();
        calcWeight.setText(String.valueOf(currWeight));
    }

    private void createUIComponents() {
    }

    private double calculate_weight() {
        double tpts_val = Double.parseDouble(tpts.getValue().toString());
        double bpts_val = Double.parseDouble(bpts.getValue().toString());
        double ttpla = Double.parseDouble(totalteams.getValue().toString());
        double teamplace = Double.parseDouble(tplace.getValue().toString());
        double w = Double.parseDouble(weight.getValue().toString());

        double xcoff = tpts_val / bpts_val;
        double pcoff = 1 / (Double.parseDouble(tplace.getValue().toString()));
        return ((xcoff+pcoff)*w/(1/(1+teamplace/ttpla)));
    }


}
