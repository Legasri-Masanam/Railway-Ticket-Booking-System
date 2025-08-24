import java.util.*;
public class TicketBooking{
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        TicketSystem ticketSystem= new TicketSystem();

        while(true){
            System.out.println("\nRAILWAY BOOKING SYSTEM");
            System.out.println("1. Book Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. View Confirmed Tickets");
            System.out.println("4. View Available Tickets");
            System.out.println("5. view Rac Tickets");
            System.out.println("6. View Waiting List Tickets");
            System.out.println("7. exit");
            System.out.println("Enter a choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 :
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Gender (male/female) : ");
                    String gender = sc.nextLine();
                    System.out.println("Enter Berth Preference (L/U/M): ");
                    String berthPreference = sc.nextLine();

                    ticketSystem.bookTicked(name,age,gender,berthPreference);
                    break;
                case 2 :
                    System.out.println("Enter Tickets ID to Cancel");
                    String tickedId = sc.nextLine();
                    ticketSystem.cancelTicket(tickedId);
                    break;
                case 3 :
                    ticketSystem.printBookedTickets();
                    break;
                case 4 :
                    ticketSystem.printAvailableTickets();
                    break;
                case 5 :
                    ticketSystem.viewRacTicket();
                    break;
                case 6 :
                    ticketSystem.viewWaitingListTicket();
                    break;
                case 7 :
                    System.out.println("Exiting.....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");

            }


        }


    }
}