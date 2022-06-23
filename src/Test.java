import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        protected static final Border TOP_LEFT = new MatteBorder(1, 1, 1, 0, Color.DARK_GRAY);
        protected static final Border TOP_RIGHT = new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
        protected static final Border BOTTOM_LEFT = new MatteBorder(0, 1, 1, 0, Color.DARK_GRAY);
        protected static final Border BOTTOM_RIGHT = new MatteBorder(0, 1, 1, 1, Color.DARK_GRAY);

        public TestPane() {
            setLayout(new GridLayout(10, 10));
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    Border border = null;
                    int index = (row * 10) + col;
                    if (row == 0) {
                        if (col == 9) {
                            border = TOP_RIGHT;
                        } else {
                            border = TOP_LEFT;
                        }
                    } else if (row == 9) {
                        if (col == 9) {
                            border = BOTTOM_RIGHT;
                        } else {
                            border = BOTTOM_LEFT;
                        }
                    } else if (col == 9) {
                        border = BOTTOM_RIGHT;
                    } else {
                        border = BOTTOM_LEFT;
                    }
                    JLabel cell = new JLabel(" ");
                    cell.setBorder(border);
                    add(cell);
                }
            }
        }

    }

}
