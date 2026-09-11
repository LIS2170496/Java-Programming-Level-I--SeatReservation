/*
   Name:  Lisette Allen
   Class: CIS163AA - Class # 17930
   Date:  4/7/2026
*/


public class SeatInfo {
   private String firstName; // First name
   private String lastName;  // Last name
   private int amtPaid;      // Amount paid
   private String sClass;    // Seat class

   // Method to initialize Seat fields
   public void reserveSeat(String inFirstName, String inLastName, int ticketCost, String inSeatClass) {
      firstName = inFirstName;
      lastName = inLastName;
      amtPaid = ticketCost;
      sClass = inSeatClass;
   }

   // Method to empty a Seat
   public void makeEmpty() {
      firstName = "Unoccupied";
      lastName = "empty";
      amtPaid = 0;
      sClass = "empty";
   }

   // Method to check if Seat is empty
   public boolean isEmpty() {
      return firstName.equals("Unoccupied");
   }

   // Method to print Seat fields
   public void printSeatInfo() {
      System.out.print(firstName + " ");
      System.out.print(lastName + " ");
      System.out.print("Paid " + amtPaid);
      //Lisette updated seat info message to include seat class
      System.out.println(" for a " + sClass + " class seat.");
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public int getAmountPaid() {
      return amtPaid;
   }

   // Lisette added getSeatClass method

   public String getSeatClass() {
      return sClass;
   }
}