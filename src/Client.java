//This class will contain the code that reads characters, send messages, handle retransmission on timeout, and wait for ACKs

 import java.net.DatagramSocket; // allows you to send and receive data packs
import java.net.SocketException; // handles errors related to the socket setup i.e. port np. alr in use
 import java.util.Scanner;

public class Client {
    //create UDP Socket which will be used to send/receive messages to and from the server
    private  DatagramSocket clientSocket; // declare a datagram socket, opens up a random port on the client for send/receive
    private Scanner scanner;
    private int seqNum; // var to track the current sequence number
    public Client(){
        try {
            clientSocket = new DatagramSocket(); //initialize UDP socket
            System.out.println("Client socket create on port: " + clientSocket.getLocalPort()); //printing assigned port no.
        }
        catch (SocketException e){
            // handle the exception if there's an error while creating the socket
            System.out.println("Error - Could not create client socket: " + e.getMessage() );
        }
        scanner = new Scanner(System.in); // will be used to get user input
        seqNum = 0; // starting sequence number
    }

    //prompts the user, reads an entire line, and then retrieves the first character.
    public  char readChar(){
        System.out.print("Enter character: ");
        return scanner.nextLine().charAt(0); // reading the string, returning first character
    }

    // method that takes a character and sequence number as inputs and returns a formatted DATA message string
    public String createFormattedMessage(char character){
        return "Data " + seqNum + " " + character + "\n";
    }


    public static void main(String[] args) {
        // instantiate the client to test socket creation
        Client client = new Client();
        char userInput = client.readChar();
        String dataMessage = client.createFormattedMessage(userInput);
        System.out.println("Read: " + userInput); //verify code snip, del later
        System.out.println("Formatted DATA message: " + dataMessage); // Verify format

    }

}
