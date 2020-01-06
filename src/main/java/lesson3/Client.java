package lesson3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    Socket socket = null;
    Book book = new Book("book1", 1000);

    Client(){

        try {
            socket = new Socket("localhost", 8191);
            //ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(book);
            //out.close();
        } catch (IOException  e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}


class Book implements Serializable {
    public String name;
    public int numberOfPages;

    public Book(String name, int numberOfPages) {
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    protected void info(){
        System.out.println("name " + name + " numberOfPages " + numberOfPages);
    }
}
