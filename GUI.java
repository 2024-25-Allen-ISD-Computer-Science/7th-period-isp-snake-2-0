import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
public class GUI implements Runnable
{
    private JFrame f;
    /**
     * 
     */
    public GUI() 
    {
        f = new JFrame("Snake 2.0");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.add(new JLabel("Snake 2.0"));
        f.add(new JButton("Press to play!"));
    }
    @Override
    public void run() {
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GUI());
    }
    
}