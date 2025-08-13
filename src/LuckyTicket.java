import org.jetbrains.annotations.NotNull;

public record LuckyTicket(@NotNull String number) {

    @NotNull
    public Report calculate() {
        var prepared = prepareFormat(number);
        if (isInvalid(prepared)) {
            return Report.invalid(this.number);
        }

        int preparedLength = prepared.length();
        var leftSum = new Sequence(prepared.substring(0, preparedLength / 2)).sum();
        var rightSum = new Sequence(prepared.substring(preparedLength / 2)).sum();

        return new Report(this.number, leftSum == rightSum, leftSum, rightSum, prepared);
    }

    private String prepareFormat(@NotNull String number) {
        String prepared = number.toLowerCase().replaceAll("[^0-9a-f]", "");

        if (!isEvenLength(prepared)) {
            return prepared + 0;
        }

        return prepared;
    }

    private boolean isEvenLength(@NotNull String number) {
        return number.length() % 2 == 0;
    }

    private boolean isInvalid(@NotNull String number) {
        return number.isBlank();
    }

    public static class Report {
        private final String original;
        private final String prepared;
        private final boolean isLucky;
        private final int leftSum;
        private final int rightSum;
        private boolean invalid = false;

        private Report(@NotNull String original, boolean isValid, int leftSum, int rightSum, @NotNull String prepared) {
            this.original = original;
            this.prepared = prepared;
            this.isLucky = isValid;
            this.leftSum = leftSum;
            this.rightSum = rightSum;
        }

        private Report(@NotNull String original) {
            this.original = original;
            this.isLucky = false;
            this.leftSum = 0;
            this.rightSum = 0;
            this.invalid = true;
            this.prepared = "";
        }

        private static Report invalid(@NotNull String original) {
            return new Report(original);
        }

        public boolean isInvalid() {
            return invalid;
        }

        public boolean isLucky() {
            return isLucky;
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

            report += "Prepared: " + prepared + "\n";

            if (isLucky) {
                return report + "Lucky Ticket!!!";
            }

            report += "Not Lucky Ticket\n";
            report += "Ticket length: " + original.length() + "\n";
            report += "Prepared length: " + prepared.length() + "\n";
            report += "Left sum: " + leftSum + "\n";
            report += "Right sum: " + rightSum + "\n";

            return report;
        }
    }

    private record Sequence(@NotNull String sequence) {

        private int sum() {
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
}
