package sr.unasat.customer_management.customer_decorator;

public class Minor extends CustomerDecorator{
    final String boekje = "Geboorte boekje";
    public Minor(Customer customer){
        super(customer);
    }

    @Override
    public String getType() {
        return "Minor";
    }

    @Override
    public String idType() {
        return "ID Type: " + boekje ;
    }
}
