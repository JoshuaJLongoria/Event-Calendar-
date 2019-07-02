import java.util.ArrayList;

public class TRAPSCalendar {

    ArrayList<Event> calendar = new ArrayList<>();

    public TRAPSCalendar(){

    }

    public boolean add(Event evt){
        try{
            calendar.add(evt);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Event get(int i){
        return calendar.get(i);
    }

    public Event get(java.lang.String name){
        for (int i = 0; i < calendar.size(); i++){
            if(calendar.get(i).getEventName().equalsIgnoreCase(name)){
                return calendar.get(i);
            }
        }
        return null;
    }

    public java.util.ArrayList<Event> list(){
        return calendar;
    }

    public int size(){
        return calendar.size();
    }

    public java.util.ArrayList<Event> sortByDate(){
        ArrayList<Event> temp = new ArrayList<>();
        Event currentMin;
        int currentMinIndex;


        for (int i = 0; i < calendar.size(); i++){
            temp.add(calendar.get(i));
        }


        for (int i = 0; i < calendar.size(); i++){
            currentMin = temp.get(i);
            currentMinIndex = i;

            for (int j = i + 1; j < calendar.size(); j++){
                if (currentMin.getDate().compareTo(temp.get(j).getDate()) > 0){
                    currentMin = temp.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                temp.set(currentMinIndex, temp.get(i));
                temp.set(i, currentMin);
            }

        }
        return temp;
    }

    public java.util.ArrayList<Event> sortByName(){
        ArrayList<Event> temp = new ArrayList<>();
        Event currentMin;
        int currentMinIndex;


        for (int i = 0; i < calendar.size(); i++){
            temp.add(calendar.get(i));
        }


        for (int i = 0; i < calendar.size(); i++){
            currentMin = temp.get(i);
            currentMinIndex = i;

            for (int j = i + 1; j < calendar.size(); j++){
                if (currentMin.getEventName().compareTo(temp.get(j).getEventName()) > 0){
                    currentMin = temp.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                temp.set(currentMinIndex, temp.get(i));
                temp.set(i, currentMin);
            }

        }
        return temp;
    }


    public java.lang.String toString(){
        String events = "";
        for(int i = 0; i < calendar.size(); i++){
            events =  "Event name: " + calendar.get(i).getEventName() + " Event Venue: " + calendar.get(i).getEventVenue() + " Event Date: " + calendar.get(i).getDate() +
                    " Tickets Sold: " + calendar.get(i).getTicketsSold() + " Ticket Price: $" + calendar.get(i).getTicketPrice() + " Overhead Costs: $" +
                    calendar.get(i).getOverhead() + " Events Profit: $" + calendar.get(i).getProfit() + " To break even you need to sell " + calendar.get(i).getBreakEvenPoint() + " tickets" + "\n";

        }
        events.replace(", E" , "E");
        events.replace("[" , "");
        events.replace("]" , "");

        return events;
    }
}