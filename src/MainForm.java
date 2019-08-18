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

class Ticket {
    private String numberTicket;

    public Ticket(String numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String verifyTicket() {
        if (numberTicket == null || numberTicket.length() == 0) {
            return "Номер не доступен!";
        }
        if (!isEven()) {
            numberTicket = numberTicket + 0;
        }
        numberTicket = numberTicket.toLowerCase();
        System.out.println(numberTicket);
        String leftNumber = numberTicket.substring(0, numberTicket.length() / 2);
        String rightNumber = numberTicket.substring(numberTicket.length() / 2);
        char[] leftSide = leftNumber.toCharArray();
        char[] rightSide = rightNumber.toCharArray();
        Integer leftCount = 0;
        Integer rightCount = 0;
        for (char i:leftSide){
            leftCount = leftCount + charToInt(i);
        }
        for (char i:rightSide){
            rightCount = rightCount + charToInt(i);
        }
        String resultString = (!leftCount.equals(rightCount)) ? "Числа не равны, повезёт в следующий раз!" : "Поздравляю ты победитель, суммы левых и правых чисел сошлись!";
        return /*"Сумма: " + (leftCount + rightCount) + */"<br>Левая часть: " + leftCount + "<br>Правая часть: " + rightCount + "<br>" + resultString;
    }

    private int charToInt(char value) {
        int newValue;
        switch (value) {
            case 'a':
                newValue = 10;
                break;
            case 'b':
                newValue = 11;
                break;
            case 'c':
                newValue = 12;
                break;
            case 'd':
                newValue = 13;
                break;
            case 'e':
                newValue = 14;
                break;
            case 'f':
                newValue = 15;
                break;
            default:
                newValue = Character.getNumericValue(value);
        }
        return newValue;
    }
    private boolean isEven(){
        if (numberTicket.length() %2 != 0) {
            return false;
        }
        return true;
    }
}
