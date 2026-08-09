interface Action {
    void perform();
}

class vehicleprogram {
    String vehicleNumber = "MH12AB1234";
    String model = "McLaren 720S";
    String color = "Jet Black";

    class VehicleDetails {
        void displayDetails() {
            System.out.println("Vehicle Number: " + vehicleNumber);
            System.out.println("Model: " + model);
            System.out.println("Color: " + color);
        }
    }

    void performAction() {

        Action action = new Action() {
            public void perform() {
                System.out.println("Vehicle is starting");
            }
        };

        action.perform();
    }

    public static void main(String[] args) {

        vehicleprogram vehicle = new vehicleprogram();

        vehicleprogram.VehicleDetails details =
                vehicle.new VehicleDetails();

        details.displayDetails();
        vehicle.performAction();
    }
}