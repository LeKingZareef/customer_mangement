package sr.unasat.customer_management.transfers;

public class InternetBanking extends Type{
    final double feeamount = 0;
    public InternetBanking (String type, String amount ) {
        this.type = type;
        this.amount = amount;
    }

    public InternetBanking () {
    }

    @Override
    String paidType() {
        return "Internet Banking TRANSFER";
    }

    @Override
    String fee() {
        return "Fee: " + feeamount;
    }

    @Override
    void transferToAccount() {

    }
}
