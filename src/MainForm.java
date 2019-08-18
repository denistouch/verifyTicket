import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JTextField setNumber;
    private JButton checkTicket;
    private JLabel viewResult;
    private JPanel rootPanel;
    private Dimension size;

    public MainForm() {
        size = new Dimension(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setVisible(true);
        setSize(size);
        checkTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (setNumber.getText() == null || setNumber.getText().equals("")) {
                    return;
                }
                Ticket ticket = new Ticket(setNumber.getText());
                //viewResult.setText(/*"<HTML>" + */ticket.verifyTicket()/* + "</HTML>"*/);
                viewResult.setText("<HTML><p align=\"center\">" + ticket.verifyTicket() + "</p></HTML>");
                viewResult.setHorizontalTextPosition(SwingConstants.CENTER);
                //viewResult = new JLabel("<HTML>" + ticket.verifyTicket() + "</HTML>",SwingConstants.CENTER);
                setSize(size);
                viewResult.setPreferredSize(new Dimension(size.width,size.height/9));
                setNumber.setPreferredSize(new Dimension(size.width,size.height/9));
                checkTicket.setPreferredSize(new Dimension(size.width,size.height/9));
            }
        });
    }
}


