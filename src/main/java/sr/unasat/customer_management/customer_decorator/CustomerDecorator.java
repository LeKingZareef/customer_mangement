package sr.unasat.customer_management.customer_decorator;

abstract class CustomerDecorator implements Customer{
    protected Customer customer;

    public CustomerDecorator(Customer addTypeCustomer) {
        this.customer = addTypeCustomer;
    }

    @Override
    public String getType() {
        return customer.getType();
    }

    @Override
    public String idType() {
        return customer.idType();
    }


}