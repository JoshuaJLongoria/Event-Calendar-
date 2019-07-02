public class Event extends java.lang.Object{



    private double profit;
    private int numOfTickets;
    private int price;
    private int overhead;
    private String eventName;
    private String eventDate;
    private String eventProfit;
    private String eventVenue;
    private int ticketsSold;
    private int ticketPrice;
    private String date;

    public Event(){
        this.eventName = "";
        this.eventVenue = "";
        this.date = "";
        this.ticketsSold = 0;
        this.ticketPrice = 0;
        this.overhead = 0;
    }

    public Event(java.lang.String eventName, java.lang.String eventVenue){
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.date = "";
        this.ticketsSold = 0;
        this.ticketPrice = 0;
        this.overhead = 0;
    }

    public Event(java.lang.String eventName, java.lang.String eventVenue, java.lang.String date, int ticketsSold, int ticketPrice, int overhead){
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.date = date;
        this.ticketsSold = ticketsSold;
        this.ticketPrice = ticketPrice;
        this.overhead = overhead;
    }



    public boolean sellTickets(int numberOfTickets){
        if (numberOfTickets > 0){
            numOfTickets += numberOfTickets;
            return true;
        }
        else{
            return false;
        }
    }

    public int getProfit(){
        profit = (this.ticketsSold * this.ticketPrice) - this.overhead;
        return (int)profit;
    }

    public int getBreakEvenPoint(){
        return this.overhead / this.ticketPrice;
    }



    public int getTicketsSold(){
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold){
        if(ticketsSold > 0){
            this.ticketsSold = ticketsSold;
        }
    }





    public int getTicketPrice(){
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice){
        this.ticketPrice = ticketPrice;
    }



    public int getOverhead(){
        return overhead;
    }

    public void setOverhead(int overhead){
        this.overhead = overhead;
    }



    public java.lang.String getDate(){
      return date;
    }


    public void setDate(java.lang.String date){
        this.date = date;
    }


    public java.lang.String getEventName(){
        return eventName;
    }

    public void setEventName(java.lang.String eventName){
        this.eventName = eventName;
    }

    public java.lang.String getEventVenue(){
        return eventVenue;
    }

    public void setEventVenue(java.lang.String eventVenue){
        this.eventVenue = eventVenue;
    }





    public java.lang.String toString(){
        String events =  "Event name: " + eventName + " Event Venue: " + eventVenue + " Event Date: " + date + " Tickets Sold: " + ticketsSold + " Ticket Price: $" + ticketPrice +
                " Overhead Costs: $" + overhead + " Event Profit: " + getProfit() + " To break even you need to sell " + getBreakEvenPoint() +
                "tickets" + "\n";
        events.replace(", E" , "E");
        events.replace("[" , "");
        events.replace("]" , "");
        return events;
    }







    public int compareName(Event other){
        if(this.getEventName().compareToIgnoreCase(other.getEventName()) > 0){
            return -1;
        }
        else if(this.getEventName().compareToIgnoreCase(other.getEventName()) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }


    public int compareDate(Event other){
        if(this.getDate().compareToIgnoreCase(other.getDate()) > 0){
            return -1;
        }
        if(this.getDate().compareToIgnoreCase(other.getDate()) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }


    public int compareProfit(Event other){
        if(this.getProfit() > (other.getProfit())){
            return -1;
        }
        if(this.getProfit() == (other.getProfit())){
            return 0;
        }
        else{
            return 1;
        }
    }

}