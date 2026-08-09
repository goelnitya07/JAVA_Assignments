    class Vehicle {
    String vehicleNumber;
    String vehicleModel;

    Vehicle(String vehicleNumber, String vehicleModel) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Model: " + vehicleModel);
    }
}

class CarInsurance extends Vehicle {

    CarInsurance(String vehicleNumber, String vehicleModel) {
        super(vehicleNumber, vehicleModel);
    }

    void displayInsuranceDetails() {
        System.out.println("Car Insurance Details:");
        super.displayVehicleDetails();

        System.out.println("Insurance Type: Comprehensive Car Insurance");
    }
}

class BikeInsurance extends Vehicle {

    BikeInsurance(String vehicleNumber, String vehicleModel) {
        super(vehicleNumber, vehicleModel);
    }

    void displayInsuranceDetails() {
        System.out.println("Bike Insurance Details:");
        super.displayVehicleDetails();

        System.out.println("Insurance Type: Comprehensive Bike Insurance");
    }
}

class vehicleinsurance {
    public static void main(String[] args) {

        CarInsurance car =
                new CarInsurance("MH12AB1234", "McLaren 720S");

        BikeInsurance bike =
                new BikeInsurance("MH14XY5678", "Royal Enfeild classic");

        car.displayInsuranceDetails();
        System.out.println();
        bike.displayInsuranceDetails();
    }
}

