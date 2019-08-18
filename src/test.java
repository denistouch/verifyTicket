import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер билетика");
        String numberString = input.nextLine();
        Ticket newTicket = new Ticket(numberString);
        String out = newTicket.verifyTicket();
        System.out.println(out);
        //1605727302  446D577FD8C8
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
        numberTicket = numberTicket.toLowerCase();
        String leftNumber = numberTicket.substring(0, numberTicket.length() / 2);
        String rightNumber = numberTicket.substring(numberTicket.length() / 2);
        char[] leftSide = leftNumber.toCharArray();
        char[] rightSide = rightNumber.toCharArray();
        Integer leftCount = 0;
        Integer rightCount = 0;
        for (int i = 0; i < leftSide.length; i++) {
            leftCount = leftCount + CharToInt(leftSide[i]);
        }
        for (int i = 0; i < rightSide.length; i++) {
            rightCount = rightCount + CharToInt(rightSide[i]);
        }
        String resultString = (leftCount != rightCount) ? "Числа не равны, повезёт в следующий раз!" : "Поздравляю ты победитель, суммы левых и правых чисел сошлись!";
        return "Сумма: " + (leftCount + rightCount) + "\nЛевой части: " + leftCount + "\nПравой части: " + rightCount + "\n" + resultString;
    }

    private Integer CharToInt(char value) {
        Integer newValue = 0;
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
}
