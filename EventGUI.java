import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class EventGUI {
    JLabel eventNameLabel;
    JLabel eventVenueLabel;
    JLabel eventDateLabel;
    JLabel ticketsSoldLabel;
    JLabel ticketPriceLabel;
    JLabel overheadCostsLabel;
    JTextField eventName;
    JTextField eventVenue;
    JTextField eventDate;
    JTextField ticketsSold;
    JTextField ticketPrice;
    JTextField overheadCosts;
    JLabel eventListLabel;
    JTextArea events;

    TRAPSCalendar calendar = new TRAPSCalendar();


    public EventGUI(){

        WidgetViewer wv = new WidgetViewer();


        eventNameLabel = new JLabel("Event Name");
        wv.add(eventNameLabel, 10, 30, 300, 20);
        eventName = new JTextField("");
        wv.add(eventName, 10, 50, 300, 20);

        eventVenueLabel = new JLabel("Event Venue");
        wv.add(eventVenueLabel, 10, 80, 300, 20);
        eventVenue = new JTextField("");
        wv.add(eventVenue, 10, 100, 300, 20);

        eventDateLabel = new JLabel("Event Date");
        wv.add(eventDateLabel, 10, 130, 300, 20);
        eventDate = new JTextField("");
        wv.add(eventDate, 10, 150, 300, 20);

        ticketsSoldLabel = new JLabel("Tickets Sold");
        wv.add(ticketsSoldLabel, 10, 180, 300, 20);
        ticketsSold = new JTextField("");
        wv.add(ticketsSold, 10, 200, 300, 20);

        ticketPriceLabel = new JLabel("Ticket Price");
        wv.add(ticketPriceLabel, 10, 230, 300, 20);
        ticketPrice = new JTextField("");
        wv.add(ticketPrice, 10, 250, 300, 20);

        overheadCostsLabel = new JLabel("Overhead Costs");
        wv.add(overheadCostsLabel, 10, 280, 300, 20);
        overheadCosts = new JTextField("");
        wv.add(overheadCosts, 10, 300, 300, 20);



        JButton createAnEvent = new JButton("Create an Event");
        wv.add(createAnEvent, 350, 50, 300, 20);
        ButtonIncrementer action = new ButtonIncrementer(createAnEvent);
        createAnEvent.addActionListener(action);

        JButton sellTickets = new JButton("Sell Tickets");
        wv.add(sellTickets, 350, 80, 300, 20);
        sellTickets.addActionListener(new ButtonIncrementer(sellTickets));

        JButton resetList = new JButton("Reset List");
        wv.add(resetList, 350, 110, 300, 20);
        resetList.addActionListener(new ButtonIncrementer(resetList));

        JButton sortByName = new JButton("Sort by Name");
        wv.add(sortByName, 350, 140, 300, 20);
        sortByName.addActionListener(new ButtonIncrementer(sortByName));

        JButton sortByDate = new JButton("Sort by Date");
        wv.add(sortByDate, 350, 170, 300, 20);
        sortByDate.addActionListener(new ButtonIncrementer(sortByDate));

        JButton export = new JButton("Export to a .csv file");
        wv.add(export, 350,  200, 300, 20);
        export.addActionListener(new ButtonIncrementer(export));

        JButton update = new JButton("Show help");
        wv.add(update, 350, 230, 300,20);
        update.addActionListener(new ButtonIncrementer(update));


        eventListLabel = new JLabel("List of Events");
        wv.add(eventListLabel, 10, 330, 300, 20);
        events = new JTextArea("");
        wv.add(events, 10, 350, 1050, 170);




    }

    class ButtonIncrementer extends WidgetViewerActionEvent {

        private JButton myButton;
        public ButtonIncrementer(JButton buttonToModify) {
            myButton = buttonToModify;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(myButton.getText().equals("Create an Event")){
                Event event = new Event(eventName.getText(), eventVenue.getText(), eventDate.getText(), Integer.parseInt(ticketsSold.getText()),
                        Integer.parseInt(ticketPrice.getText()), Integer.parseInt(overheadCosts.getText()));
                calendar.add(event);
                eventName.setText("");
                eventVenue.setText("");
                eventDate.setText("");
                ticketsSold.setText("");
                ticketPrice.setText("");
                overheadCosts.setText("");

                events.setText(events.getText() + calendar.toString());

            }

            else if(myButton.getText().equals("Sell Tickets")){
                String name = eventName.getText();
                int index = 0;
                for (int i = 0; i < calendar.size(); i++){
                    String temp = calendar.get(i).getEventName();
                    if (name.equalsIgnoreCase(temp)){
                        index = i;
                    }
                }
                calendar.get(index).setTicketsSold(calendar.get(index).getTicketsSold() + Integer.parseInt(ticketsSold.getText()));

                events.setText("");

                for(int i = 0; i < calendar.size(); i++){
                    events.setText(events.getText() + calendar.get(i).toString());
                }



            }

            else if(myButton.getText().equals("Reset List")){
                events.setText("");
                for(int i = 0; i < calendar.size(); i++){
                    events.setText(events.getText() + calendar.get(i).toString());
                }
            }

            else if(myButton.getText().equals("Sort by Name")){
                events.setText(calendar.sortByName().toString().replace("," ," ")
                        .replace("[" , "").replace("]" , "").replace("  " , " "));
            }


            else if(myButton.getText().equals("Sort by Date")){
                events.setText(calendar.sortByDate().toString().replace("," ," ")
                        .replace("[" , "").replace("]" , ""));

            }

            else if(myButton.getText().equals("Show help")){
                events.setText("This is a simple program that allows you to make a calendar of events that you input. To use just fill out all of the boxes and press the create an event button,\n" +
                        "After you add a few more events you can sort the list by name or by date. To add more tickets to a certain event you input the name of the event you want to add tickets to\n" +
                        " and put in how many tickets you want to add then press the sell tickets button. To make the view of the events the same way you inputted it just hit the reset list button.\n " +
                        "If you wish to make a .csv file of the calendar you made just hit the Export to a .csv file button (This outputs the calendar without any sorting put on it)");
            }

            else {


                try{
                    PrintWriter output = new PrintWriter(new File("events.csv"));
                    output.println("Event Name, Event Venue, Event Date, Ticket Price, Tickets Sold, Overhead Costs, Profit, Break Even Point");
                    for(int i = 0; i < calendar.size(); i++){
                        output.println(calendar.get(i).getEventName() + "," + calendar.get(i).getEventVenue()
                                + "," + calendar.get(i).getDate() + "," + calendar.get(i).getTicketsSold() + ","
                                + calendar.get(i).getTicketPrice() + "," + calendar.get(i).getOverhead() + "," +
                                calendar.get(i).getProfit() + "," + calendar.get(i).getBreakEvenPoint());
                    }
                    output.close();

                }catch (Exception a){
                }
            }
        }
    }
}





