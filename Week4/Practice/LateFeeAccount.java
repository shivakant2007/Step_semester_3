// LateFeeAccount.java
public class LateFeeAccount {
    String regNo;
    double totalFees;
    int daysLate;

    public LateFeeAccount(String regNo, double totalFees, int daysLate) {
        this.regNo = regNo;
        this.totalFees = totalFees;
        this.daysLate = daysLate;
    }

    public final double calculateLateFee() {
        if (daysLate <= 0) return 0;
        return totalFees * 0.1;
    }

    public final void printSummary() {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            System.out.println(regNo + " | Total Fee: Rs " + totalFees + " | Late Fee: Rs " + calculateLateFee());
        }
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};
        for (int i = 0; i < regNos.length; i++) {
            LateFeeAccount acc = new LateFeeAccount(regNos[i], totalFees[i], daysLate[i]);
            acc.printSummary();
        }
    }
}
