import java.util.ArrayList;
import java.util.List;

public class Repository {

    List<Product> productList;
    List<Orders> ordersList;

    public Repository(){
        productList = new ArrayList<>();
        ordersList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void addOrder(Orders order){
        ordersList.add(order);
    }

    public Product getProduct(int i){
        return productList.get(i);
    }

    public Product getProduct(String name) throws Exception {
        for(int i = 0 ; i < productList.size() ; i++){
            if(productList.get(i).name.equals(name)){
                return productList.get(i);
            }
        }

        throw new Exception("Product doesnt exist");
    }

    public Orders getOrder(int i){
        return ordersList.get(i);
    }

    public Orders getOrderByNumber(int orderNumber){
        for(int i = 0 ; i < ordersList.size() ; i++){
            if(ordersList.get(i).orderNumber == orderNumber){
                return ordersList.get(i);
            }
        }

        return null;
    }

    public void removeProductByIndex(int i){
        productList.remove(i);
    }

    public void removeProductByName(String name){
        for(int i = 0 ; i < productList.size() ; i++){
            if(productList.get(i).name.equals(name)){
                productList.remove(i);
                i--;
            }
        }
    }

    public void removeProductsByPrice(int price){
        for(int i = 0 ; i < productList.size() ; i++){
            if(productList.get(i).price == price){
                productList.remove(i);
                i--;
            }
        }
    }

    public void updateProductPrice(String name, int newPrice){
        try {
            getProduct(name).setPrice(newPrice);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        String message = "Products:\n";

        for(int i = 0 ; i < productList.size() ; i++){
            message += "\t" + productList.get(i) + "\n";
        }

        message += "Orders:\n";

        for(int i = 0 ; i < ordersList.size() ; i++){
            message += "\t" + ordersList.get(i) + "\n";
        }

        return message;
    }

    public void removeOrder(int orderNumber) {
        for(int i = 0 ; i < ordersList.size() ; i++){
            if(ordersList.get(i).orderNumber == orderNumber){
                productList.remove(i);
                break;
            }
        }
    }

    public void updateOrderAddress(int orderNumber, String address) {
        try {
            getOrderByNumber(orderNumber).setAddress(address);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
