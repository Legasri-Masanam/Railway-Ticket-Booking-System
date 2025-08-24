public class Passenger {
    String name;
    int age;
    String gender;

    String berthPreference; //lower,middle,upper

    String allocatedBreth;

    String ticketId;

    public Passenger(String name , int age , String gender ,
              String berthPreference , String allocatedBreth ,String ticketId ){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.allocatedBreth = allocatedBreth;
        this.ticketId = ticketId;
    }
   @Override
    public String toString(){
        return "Ticket ID :"+ ticketId +", Name: "+ name +
                ", Age: "+ age +", Gender: "+ gender + ", Berth: "+ allocatedBreth;
    }
}
