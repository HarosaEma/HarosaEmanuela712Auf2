public class Product {

    String name;
    int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }



    @Override
    public String toString(){
        return "product " + name + " with price: " +Integer.toString(price);
    }

}
