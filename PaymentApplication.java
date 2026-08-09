abstract class Payment {
    abstract void makePayment(double amount);

    void displayMessage() {
        System.out.println("Payment Processing");
    }
}

class CreditCardPayment extends Payment {

    void makePayment(double amount) {
        System.out.println("Payment Method: Credit Card");
        System.out.println("Amount Paid: " + amount);
    }
}

class UPIPayment extends Payment {

    void makePayment(double amount) {
        System.out.println("Payment Method: UPI");
        System.out.println("Amount Paid: " + amount);
    }
}

class PaymentApplication {

    public static void main(String[] args) {

        Payment creditCard = new CreditCardPayment();
        Payment upi = new UPIPayment();

        creditCard.displayMessage();
        creditCard.makePayment(5000);

        System.out.println();

        upi.displayMessage();
        upi.makePayment(2500);
    }
}