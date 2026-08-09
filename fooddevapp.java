interface DeliveryStatus {
    void update();
}

class fooddevapp {
    String orderId = "101";
    String foodItem = "Pizza";
    int quantity = 4;

    class OrderDetails {
        void displayOrder() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Food Item: " + foodItem);
            System.out.println("Quantity: " + quantity);
        }
    }

    void updateDeliveryStatus() {

        DeliveryStatus preparing = new DeliveryStatus() {
            public void update() {
                System.out.println("Delivery Status: Order is being prepared.");
            }
        };

        DeliveryStatus outForDelivery = new DeliveryStatus() {
            public void update() {
                System.out.println("Delivery Status: Order is out for delivery.");
            }
        };

        preparing.update();
        outForDelivery.update();
    }

    public static void main(String[] args) {

        fooddevapp foodDelivery = new fooddevapp();

        fooddevapp.OrderDetails order =
                foodDelivery.new OrderDetails();

        order.displayOrder();
        foodDelivery.updateDeliveryStatus();
    }
}