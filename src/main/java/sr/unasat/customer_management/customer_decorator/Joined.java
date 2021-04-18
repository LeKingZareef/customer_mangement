package sr.unasat.customer_management.customer_decorator;

public class Joined extends CustomerDecorator{
    final String passport = "Passport";
    public Joined(Customer customer){
        super(customer);
    }

    @Override
    public String getType() {
        return "Joined";
    }

    @Override
    public String idType() {
        return "ID Type: " + passport ;
    }
}