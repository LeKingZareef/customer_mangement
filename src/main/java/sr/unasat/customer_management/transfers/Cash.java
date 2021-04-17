package sr.unasat.customer_management.transfers;

public class Cash extends Type{
    final double feeamount = 8;

    public Cash (String type, String amount ) {
       this.type = type;
       this.amount = amount;
    }

    public Cash () {
    }

    public void transferToAccount () {

    }
    @Override
    String paidType() {
       return "CASH TELLER TRANSFER";
    }

    @Override
    String fee() {
        return "Fee: " + feeamount;
    }
}
