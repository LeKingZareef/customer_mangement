package sr.unasat.customer_management.transfers;

public abstract class Type {
    String type;
    String amount;

    Type() {
    }

    public String transfers() {
        String alert_type = paidType();
        String alert_fee = fee();

        return  alert_type+alert_fee;
    }

    abstract String paidType();
    abstract String fee();
    abstract void transferToAccount();


}
