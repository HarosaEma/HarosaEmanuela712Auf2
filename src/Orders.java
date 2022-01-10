import java.util.List;

public class Orders {

    int orderNumber;
    String address;
    List<Product> productList;

    public Orders(int orderNumber, String address, List<Product> productList){
        this.orderNumber = orderNumber;
        this.address = address;
        this.productList = productList;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public String getAddress(){
        return address;
    }

    public List<Product> getProductList(){
        return productList;
    }

    public void setOrderNumber(int newOrderNumber){
        orderNumber = newOrderNumber;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }

    public void setProductList(List<Product> newProductList){
        productList = newProductList;
    }

    public Product getProduct(int n){
        return productList.get(n);
    }

    @Override
    public String toString(){
        String message = "Order number " + Integer.toString(orderNumber) + " at address " + address + " with products: ";

        int i;
        for(i = 1 ; i < productList.size() ; i++){
            message += productList.get(i).getName() + ", ";
        }

        message += productList.get(i).getName() + ".";

        return message;
    }

}
