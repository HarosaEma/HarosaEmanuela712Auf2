import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    Controller cntr;

    public View(Controller cntr){
        this.cntr = cntr;
    }

    private void mainMenu(){
        String message = "===========MENU===========\n";
        message += "1). Add a product.\n";
        message += "2). Delete a product by name.\n";
        message += "3). Update a product's price.\n";
        message += "4). Get a product by name.\n";
        message += "5). Add a order.\n";
        message += "6). Delete a order by order number.\n";
        message += "7). Update a order's address.\n";
        message += "8). Get a order by order number.\n";
        message += "9). Sort orders by total price.\n";
        message += "10). Get all repo.\n";

        System.out.println(message);
    }

    private int getOption(){
        Scanner keyboard = new Scanner(System.in);

        int myint = -1;

        while(myint == -1) {
            System.out.print("Enter the option: ");
            myint = keyboard.nextInt();

            if(myint <= 0 || myint >= 11){
                myint = -1;
                System.out.println("Option invalid! Option should be between 0 and 10");
            }
        }

        return myint;
    }

    private void sortOrders(){
        Service service = new Service();
        System.out.println(service.sortOrdersByTotalPrice(cntr.getAllOrders()));
    }

    private void addProduct(){
        Scanner keyboard = new Scanner(System.in);
        String name;
        int price;

        System.out.print("Give product's name: ");
        name = keyboard.nextLine();

        System.out.print("Give product's price: ");
        price = keyboard.nextInt();

        cntr.addProduct(name, price);
    }

    private void deleteProduct(){
        Scanner keyboard = new Scanner(System.in);
        String name;
        int price;

        System.out.print("Give product's name: ");
        name = keyboard.nextLine();

        cntr.removeProductByName(name);
    }

    private void updateProduct(){
        int price;

        Scanner keyboard = new Scanner(System.in);
        String name;

        System.out.print("Give product's name: ");
        name = keyboard.nextLine();

        System.out.print("Give product's price: ");
        price = keyboard.nextInt();

        cntr.updateProductPrice(name, price);
    }

    private void getProduct() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        String name;

        System.out.print("Give product's name: ");
        name = keyboard.nextLine();

        cntr.getProduct(name);
    }

    private void addOrder(){
        Scanner keyboard = new Scanner(System.in);
        int orderNumber;
        String address;
        List<Product> productList = new ArrayList<>();
        int numberOfProducts;
        String name;

        System.out.print("Give order's order number: ");
        orderNumber = keyboard.nextInt();

        System.out.print("Give order's address: ");
        address = keyboard.nextLine();

        System.out.print("Give order's number of products: ");
        numberOfProducts = keyboard.nextInt();

        for(int i = 0 ; i <= numberOfProducts ; i++){
            System.out.print("Give product's name: ");
            name = keyboard.nextLine();

            try{
                productList.add(cntr.getProduct(name));
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

        cntr.addOrder(orderNumber, address, productList);
    }

    private void deleteOrder(){
        Scanner keyboard = new Scanner(System.in);
        int orderNumber;

        System.out.print("Give order's order number: ");
        orderNumber = keyboard.nextInt();

        cntr.removeOrder(orderNumber);
    }

    private void updateOrder(){
        String address;

        Scanner keyboard = new Scanner(System.in);
        int orderNumber;

        System.out.print("Give order's order number: ");
        orderNumber = keyboard.nextInt();

        System.out.print("Give order's new address: ");
        address = keyboard.nextLine();

        cntr.updateOrderAddress(orderNumber, address);
    }

    private void getOrder() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int orderNumber;

        System.out.print("Give product's name: ");
        orderNumber = keyboard.nextInt();

        cntr.getOrderByNumber(orderNumber);
    }

    public void start() throws Exception {
        mainMenu();

        int option = 1;

        while(option != 0) {
            option = getOption();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    getProduct();
                    break;
                case 5:
                    addOrder();
                    break;
                case 6:
                    deleteOrder();
                    break;
                case 7:
                    updateOrder();
                    break;
                case 8:
                    getOrder();
                    break;
                case 9:
                    System.out.println(cntr);
                    break;
                default:
                    break;
            }
        }
    }

}
