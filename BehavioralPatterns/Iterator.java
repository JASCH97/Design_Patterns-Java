/*
The iterator pattern is one of the behavioral patterns and is used to provide a standard way 
to traverse through a group of objects. The iterator pattern is widely used in Java Collection 
Framework where the iterator interface provides methods for traversing through a Collection. 
This pattern is also used to provide different kinds of iterators based on our requirements. 
The iterator pattern hides the actual implementation of traversal through the Collection and 
client programs use iterator methods.
*/

// ************************* NameRepository Example: *************************

// Aggregate interface
interface Container {
    Iterator<String> createIterator();
}

// Concrete Aggregate
class NameRepository implements Container {
    private List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public Iterator<String> createIterator() {
        return names.iterator();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        nameRepository.addName("Alice");
        nameRepository.addName("Bob");
        nameRepository.addName("Charlie");

        Iterator<String> iterator = nameRepository.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


// ************************* BookCollection Example: *************************

// Aggregate interface
interface BookCollection {
    Iterator<Book> createIterator();
}

// Concrete Aggregate
class Library implements BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> createIterator() {
        return new LibraryIterator(books);
    }
}

// Concrete Iterator
class LibraryIterator implements Iterator<Book> {
    private List<Book> books;
    private int position;

    public LibraryIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        if (hasNext()) {
            Book book = books.get(position);
            position++;
            return book;
        } else {
            throw new IllegalStateException("No more books");
        }
    }
}

// Book class
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Great Gatsby"));
        library.addBook(new Book("To Kill a Mockingbird"));
        library.addBook(new Book("1984"));
        library.addBook(new Book("Pride and Prejudice"));

        Iterator<Book> iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Book Title: " + book.getTitle());
        }
    }
}