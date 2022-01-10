import java.util.List;

public class Controller {

    private Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    public void addProduct(String name, int price){
        repository.addProduct(new Product(name, price));
    }

    public void addOrder(int orderNumber, String address, List<Product> productList){
        repository.addOrder(new Orders(orderNumber, address, productList));
    }

    public Product getProduct(int i){
        return repository.getProduct(i);
    }

    public Orders getOrder(int i){
        return repository.getOrder(i);
    }

    public void removeProductByName(String name){
        repository.removeProductByName(name);
    }

    public void updateProductPrice(String name, int newPrice){
        repository.updateProductPrice(name, newPrice);
    }

    public Product getProduct(String name) throws Exception {
        return repository.getProduct(name);
    }

    public void removeOrder(int orderNumber){
        repository.removeOrder(orderNumber);
    }

    public void updateOrderAddress(int orderNumber, String address){
        repository.updateOrderAddress(orderNumber, address);
    }

    public void getOrderByNumber(int orderNumber){
        repository.getOrderByNumber(orderNumber);
    }

    @Override
    public String toString(){
        return repository.toString();
    }


    public List<Orders> getAllOrders() {
        return repository.getAllOrders();
    }
}
