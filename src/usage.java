public class usage {
    public static void main(String[] args) {
//        LuckyTicket lucky = new LuckyTicket("ad89d960-416d-4ea1-a3b1-db56f30acd71");
        LuckyTicket lucky = new LuckyTicket(null);
        LuckyTicket.Report report = lucky.calculate();
        System.out.println(report.print());
    }
}
