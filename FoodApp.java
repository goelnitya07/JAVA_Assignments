abstract class FoodOrder {
    double foodPrice;

    FoodOrder(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    DineInOrder(double foodPrice) {
        super(foodPrice);
    }

    void calculateBill() {
        double serviceCharge = foodPrice * 0.10;
        double total = foodPrice + serviceCharge;

        System.out.println("Order Type: Dine-In");
        System.out.println("Food Price: " + foodPrice);
        System.out.println("Service Charge: " + serviceCharge);
        System.out.println("Total Bill: " + total);
    }
}

class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(double foodPrice) {
        super(foodPrice);
    }

    void calculateBill() {
        double packingCharge = 50;
        double total = foodPrice + packingCharge;

        System.out.println("Order Type: Take-Away");
        System.out.println("Food Price: " + foodPrice);
        System.out.println("Packing Charge: " + packingCharge);
        System.out.println("Total Bill: " + total);
    }
}

class FoodApp {

    public static void main(String[] args) {

        FoodOrder dineIn = new DineInOrder(1000);
        FoodOrder takeAway = new TakeAwayOrder(1000);

        dineIn.calculateBill();
        System.out.println();
        takeAway.calculateBill();
    }
}
