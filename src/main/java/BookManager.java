import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BookManager {


SessionFactory sessionFactory;




    protected void exit () {
        sessionFactory.close();
    }
        protected void create() {

        Book book = new Book();
      //  book.setBookId(1L);
        book.setTitle("Flowers from Eldgernon");
        book.setAuthor("Daniel Keys");
        book.setPrice(120.99f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
                }

        protected void read() {
            // code to get a book
        }

        protected void update() {
            // code to modify a book
        }

        protected void delete() {
            // code to remove a book
        }

        public static void main(String[] args) {
           ;
            BookManager bm = new BookManager();

           bm.sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(Book.class)
                    .buildSessionFactory();
            bm.create();
            bm.exit();
        }
    }

