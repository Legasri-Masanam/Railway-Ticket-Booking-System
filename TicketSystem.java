import java.util.*;

public class TicketSystem {
    private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L","U","M")); // 3 berth

    private final Queue<Passenger> racQueue = new LinkedList<>(); // 1 RAC berth

    private  final Queue<Passenger> waitingListQueue = new LinkedList<>(); // 1 waiting List

    private final List<Passenger> confirmedPassenger = new ArrayList<>();

    private int ticketCounter = 1;

    public void bookTicked(String name , int age , String gender, String berthPerference) {
        String ticketId = "T" + ticketCounter++; //1

        Passenger passenger;
        String allocatedBreth = null;
        if (!availableBerths.isEmpty()) {
            allocatedBreth = allocatedBreth(age, gender, berthPerference);
            passenger = new Passenger(name, age, gender, berthPerference, allocatedBreth, ticketId);
            confirmedPassenger.add(passenger);
            availableBerths.remove(allocatedBreth);
            System.out.println("Ticket confirmed: " + passenger);
        } else if (racQueue.size() < 1) {
            passenger = new Passenger(name, age, gender, berthPerference, allocatedBreth, ticketId);
            racQueue.offer(passenger);
            System.out.println("Ticket in RAC: " + passenger);

        } else if (waitingListQueue.size() < 1) {
            passenger = new Passenger(name, age, gender, berthPerference, allocatedBreth, ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket in waiting List: "+ passenger);
        }
        else
            System.out.println("No Ticket Available");


    }
    private String  allocatedBreth(int age, String gender, String berthPerference){
        if(age > 60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L"))
            return "L";

        if(availableBerths.contains(berthPerference)){
            return berthPerference;
        }
        return  availableBerths.get(0);
    }

    public void cancelTicket(String ticketId) {
        Optional<Passenger> passengerOpt = confirmedPassenger.stream()
                .filter(p -> p.ticketId.equals(ticketId))
                .findFirst();

        if (passengerOpt.isPresent()) {
            Passenger passenger = passengerOpt.get();
            confirmedPassenger.remove(passenger);

            // Free the berth
            String freedBerth = passenger.allocatedBreth;
            availableBerths.add(freedBerth);

            System.out.println("Cancelled ticket: " + passenger);

            // If RAC passenger exists → promote to confirmed using freed berth
            if (!racQueue.isEmpty()) {
                Passenger racPassenger = racQueue.poll();
                racPassenger.allocatedBreth = freedBerth;
                confirmedPassenger.add(racPassenger);
                availableBerths.remove(freedBerth); // occupied again
                System.out.println("RAC ticket moved to confirmed: " + racPassenger);
            }

            // If waiting passenger exists → promote to RAC
            if (!waitingListQueue.isEmpty()) {
                Passenger waitingPassenger = waitingListQueue.poll();
                racQueue.offer(waitingPassenger);
                waitingPassenger.allocatedBreth = "RAC";
                System.out.println("Waiting list ticket moved to RAC: " + waitingPassenger);
            }

        } else {
            System.out.println("No ticket found with ID: " + ticketId);
        }
    }

    public void printBookedTickets(){
        if(confirmedPassenger.isEmpty())
            System.out.println("No confirmed Tickets.");
        else {
            System.out.println("Confirmed Tickets");
            //iterate to print the passengers details

            for(Passenger passenger : confirmedPassenger)
                System.out.println(passenger);
        }
    }

    public void printAvailableTickets(){
        System.out.println("Available Berths: " + availableBerths.size());
        System.out.println("Available RAC Tickets: " + (1- racQueue.size()));
        System.out.println("Available WaitingList Tickets: "+(1-waitingListQueue.size()));
    }

    public void viewRacTicket(){
        if(racQueue.isEmpty())
            System.out.println("no RAC Tickets");
        else{
            System.out.println("RAC Tickets");

            for (Passenger passenger: racQueue)
                System.out.println(passenger);
        }
    }
    public void viewWaitingListTicket(){
        if(waitingListQueue.isEmpty())
            System.out.println("no Waiting List  Tickets");
        else{
            System.out.println("Waiting List Tickets");

            for (Passenger passenger: waitingListQueue)
                System.out.println(passenger);
        }
    }

}
