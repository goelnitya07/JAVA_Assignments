public class MobilePhoneInventory {
    String make;
    int ram;
    double price;

    MobilePhoneInventory(){
        make = "";
        ram = 0;
        price = 0.0;
    }
    MobilePhoneInventory(String m, int r, double p){
        make = m;
        ram = r;
        price = p;
    }
    MobilePhoneInventory(MobilePhoneInventory mpi){
        this.make = mpi.make;
        this.ram= mpi.ram;
        this.price = mpi.price;
    }
    void display(){
        System.out.println("Made by: "+make);
        System.out.println("Ram: "+ram+"GB");
        System.out.println("Price: "+price);
    }
    static void main(String[] args){
        new MobilePhoneInventory().display();
        MobilePhoneInventory obj = new MobilePhoneInventory("INFINIX",8, 65000);
        obj.display();
        new MobilePhoneInventory(obj).display();

    }
}
