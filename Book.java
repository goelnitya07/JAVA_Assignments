    class Book {
    final String ISBN;
    String title;
    String author;
    double price;

    Book(String ISBN, String title, String author, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        Book book = new Book(
                "287",
                "A Good Girl's Guide to Murder",
                "Holly Jackson",
                750
        );

        book.displayBookDetails();
    }
}
