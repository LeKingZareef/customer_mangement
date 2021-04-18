package sr.unasat.customer_management.customer_decorator;

public class Normal implements Customer{

    final String idNumber = "";

    @Override
    public String getType() {
        return "Normal Customer";
    }

    @Override
    public String idType() {
        return idNumber;
    }
}

