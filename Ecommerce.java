    interface ProductOperations {
    void displayProduct();
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends Product implements ProductOperations {

    Electronic(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Electronic Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Clothing extends Product implements ProductOperations {

    Clothing(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Clothing Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Grocery extends Product implements ProductOperations {

    Grocery(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Grocery Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Ecommerce {
    public static void main(String[] args) {

        Electronic electronic =
                new Electronic("Laptop", 55000);
        Clothing clothing =
                new Clothing("T-Shirt", 999);
        Grocery grocery =
                new Grocery("Rice", 800);

        electronic.displayProduct();
        System.out.println();

        clothing.displayProduct();
        System.out.println();
        grocery.displayProduct();
    }
}

