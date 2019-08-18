import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JTextField setNumber;
    private JButton checkTicket;
    private JLabel viewResult;
    private JPanel rootPanel;

    public MainForm() {
        setContentPane(rootPanel);
        setVisible(true);
        checkTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (setNumber.getText() == null || setNumber.getText().equals("")) {
                    return;
                }
                Ticket ticket = new Ticket(setNumber.getText());
                viewResult.setText(ticket.verifyTicket());
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
        return "Сумма: " + (leftCount + rightCount) + "\nЛевой части: " + leftCount + "\nПравой части: " + rightCount + "\n" + resultString;
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
