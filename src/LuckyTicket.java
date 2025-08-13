import org.jetbrains.annotations.NotNull;

public record LuckyTicket(String number) {

    @NotNull
    public Report calculate() {
        var prepared = prepareFormat(number);
        if (isInvalid(prepared)) {
            return Report.invalid(this.number);
        }

        int preparedLength = prepared.length();
        var leftSum = new Sequence(prepared.substring(0, preparedLength / 2)).sum();
        var rightSum = new Sequence(prepared.substring(preparedLength / 2)).sum();

        return new Report(this.number, leftSum == rightSum, leftSum, rightSum, preparedLength);
    }

    private String prepareFormat(String number) {
        if (null == number) {
            return "";
        }
        if (!isEvenLength(number)) {
            number += 0;
        }

        return number.toLowerCase().replaceAll("-", "");
    }

    private boolean isEvenLength(String number) {
        return number.length() % 2 == 0;
    }

    private boolean isInvalid(String number) {
        return null == number || number.isBlank();
    }

    public record Sequence(String sequence) {

        public int sum() {
            int sum = 0;
            for (char i : sequence.toCharArray()) {
                sum += hexToDec(i);
            }

            return sum;
        }

        private static int hexToDec(char value) {
            return switch (value) {
                case 'a' -> 10;
                case 'b' -> 11;
                case 'c' -> 12;
                case 'd' -> 13;
                case 'e' -> 14;
                case 'f' -> 15;
                default -> Character.getNumericValue(value);
            };
        }
    }

    public static class Report {
        private final String original;
        private final boolean isValid;
        private final int ticketLength;
        private final int leftSum;
        private final int rightSum;
        private boolean invalid = false;

        public Report(String original, boolean isValid, int leftSum, int rightSum, int ticketLength) {
            this.original = original;
            this.isValid = isValid;
            this.leftSum = leftSum;
            this.rightSum = rightSum;
            this.ticketLength = ticketLength;
        }

        private Report(String original) {
            this.original = original;
            this.isValid = false;
            this.leftSum = 0;
            this.rightSum = 0;
            this.ticketLength = 0;
            this.invalid = true;
        }

        private static Report invalid(String original) {
            return new Report(original);
        }

        public boolean isInvalid() {
            return invalid;
        }

        public boolean isValid() {
            return isValid;
        }

        public int getTicketLength() {
            return ticketLength;
        }

        public int getLeftSum() {
            return leftSum;
        }

        public int getRightSum() {
            return rightSum;
        }

        public String print() {
            var report = "Ticket: " + original + "\n";
            if (invalid) {
                return report + "Invalid Ticket";
            }

            if (isValid) {
                return report + "Lucky Ticket!!!";
            }

            report += "Not Lucky Ticket\n";
            report += "Ticket length: " + ticketLength + "\n";
            report += "Left sum: " + leftSum + "\n";
            report += "Right sum: " + rightSum + "\n";

            return report;
        }
    }
}
