import library.book;

class librarymanagement {

    public static void main(String[] args) {

        book book = new book(
            101,
            "Java Programming",
            "James Gosling",
            750
        );

        book.displayBook();
    }
}