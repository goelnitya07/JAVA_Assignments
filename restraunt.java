public class restraunt {
    static int count = 0;

    static int bill(int egg, int pasta, int milk) {
        count++;
        return (egg + pasta + milk);
    }

    static int bill(int egg, int pasta, int milk, int packaging) {
        count++;
        return (egg + pasta + milk + packaging);

    }

    static int bill(int egg, int pasta, int milk, int cookie, int delivery) {
        count++;
        return (egg + pasta + milk + delivery);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Dine-In Total: " + restraunt.bill(32, 130, 95));
        System.out.println("TakeAway Total: " + restraunt.bill(32, 130, 95, 43));
        System.out.println("Delivery Total: " + restraunt.bill(32, 130, 95, 20, 200));
        System.out.println("Count of orders: " + restraunt.count);
    }

}
