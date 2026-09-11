/*
   Name:  Lisette Allen
   Class: CIS163AA - Class # 17930
   Date:  4/7/2026
*/



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//Lisette imported colors
import java.awt.Color;



public class SeatReservationFrame extends JFrame implements ActionListener {
   private JTextField firstNameField;             // Holds first name
   private JTextField lastNameField;              // Holds last name
   private JTextField seatClassField;             // Lisette declared new field to hold seat class
   private JFormattedTextField seatNumField;      // Holds seat number
   private JFormattedTextField amountPaidField;   // Holds ticket cost
   private JLabel tableLabel;                     // Label for table display
   private JLabel seatNumLabel;                   // Label for seat number
   private JLabel firstNameLabel;                 // Label for first name
   private JLabel lastNameLabel;                  // Label for last name
   private JLabel seatClassLabel;                 // Lisette added new Label for seat class
   private JLabel amountPaidLabel;                // Label for amount paid
   private JButton reserveButton;                 // Triggers seat reservation
   private JButton quitButton;                    // Triggers termination of GUI
   private JButton emptyButton;                   // Lisette added new button to clear reservation
   private JTable seatStatusTable;                // Table tracks seat reservations
   private final static int NUM_SEATS = 20;       // Number of seat in reservation system -Lisette updated from 5 to 20
   private static ArrayList<SeatInfo> seatResArr; // ArrayList of Seat objects
   private Color backgroundColor;                 // Lisette added a background color

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SeatReservationFrame() {
      // Lisette updated array from 5 rows to 20
      // Lisette updated array from 4 columns to 5
      Object[][] tableVals = new Object[20][5];                // Seat reservation table
      //Lisette updated column headings to include Seat Class
      String[] columnHeadings = {"Seat Number", "First Name", // Column headings for reservation table
                                 "Last Name", "Amount Paid", "Seat Class"};
      GridBagConstraints layoutConst = null;                  // GUI component layout
      NumberFormat currencyFormat = null;                     // Format for amount paid

      // Set frame's title
      setTitle("Seat reservation");

      // so creativity
      backgroundColor = new Color(232, 211, 235);
      

      // Add **20 seat objects to ArrayList
      seatResArr = new ArrayList<SeatInfo>();
      seatsAddElements(seatResArr, NUM_SEATS);

      // Make all seats empty
      seatsMakeEmpty(seatResArr);

      // Create seat reservation table
      tableLabel = new JLabel("Seat reservation status:");
      seatNumLabel = new JLabel("Seat Number:");
      firstNameLabel = new JLabel("First Name:");
      lastNameLabel = new JLabel("Last Name:");
      //Lisette added new label for Seat Class
      seatClassLabel = new JLabel("Seat Class:");
      amountPaidLabel = new JLabel("Amount Paid:");

      seatNumField = new JFormattedTextField(NumberFormat.getIntegerInstance());
      seatNumField.setColumns(5);  //Lisette made this smaller
      seatNumField.setEditable(true);
      seatNumField.setValue(0);

      firstNameField = new JTextField(10);
      firstNameField.setEditable(true);
      firstNameField.setText("John");

      lastNameField = new JTextField(10);
      lastNameField.setEditable(true);
      lastNameField.setText("Doe");

      seatClassField = new JTextField(5);
      seatClassField.setEditable(true);
      seatClassField.setText("Coach");

      currencyFormat = NumberFormat.getCurrencyInstance();
      currencyFormat.setMaximumFractionDigits(0);
      amountPaidField = new JFormattedTextField(currencyFormat);
      amountPaidField.setColumns(5);  //Lisette made this smaller
      amountPaidField.setEditable(true);
      amountPaidField.setValue(0.0);

      reserveButton = new JButton("Reserve");
      reserveButton.setBackground(backgroundColor);
      reserveButton.addActionListener(this);

      quitButton = new JButton("Quit");
      quitButton.setBackground(backgroundColor);
      quitButton.addActionListener(this);

      emptyButton = new JButton("Empty Seat");
      emptyButton.setBackground(backgroundColor);
      emptyButton.addActionListener(this);


      






      // Initialize table
      seatStatusTable = new JTable(tableVals, columnHeadings);
      
      
      // Lisette initialized table values

      for (int i = 0; i < NUM_SEATS; ++i) {
         seatStatusTable.setValueAt(i, i, 0);
         seatStatusTable.setValueAt("Unoccupied", i, 1);
         
      }




      seatStatusTable.setEnabled(false); // Prevent user input via table

      // Add components using GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(tableLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 5;
      add(seatStatusTable.getTableHeader(), layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 5;
      add(seatStatusTable, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(seatNumLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      add(seatNumField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      add(firstNameLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 4;
      add(firstNameField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 3;
      add(lastNameLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 4;
      add(lastNameField, layoutConst);


      //Lisette added seatClassLabel and Field beween lname and amountpaid


      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 3;
      add(seatClassLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 4;
      add(seatClassField, layoutConst);







      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 3;
      add(amountPaidLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 4;
      add(amountPaidField, layoutConst);




      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(20, 10, 10, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 6;
      add(reserveButton, layoutConst);


      //Lisette added emptyButton

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(20, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 6;
      add(emptyButton, layoutConst);


      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(20, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 6;
      add(quitButton, layoutConst);
   }

   /* Called when either button is pressed. */
   @Override
   public void actionPerformed(ActionEvent event) {
      SeatInfo seatElement;  // Seat information
      String firstName;      // First name
      String lastName;       // Last name
      int seatNum;           // Seat number
      int amtPaid;           // Amount paid
      String seatClass;      // Seat class

      // Get source of event (2 buttons in GUI)
      JButton sourceEvent = (JButton) event.getSource();

      // User pressed the reserve button
      if (sourceEvent == reserveButton) {
         seatNum = ((Number) seatNumField.getValue()).intValue();

         // User tried to reserve non-existing seat
         if (seatNum >= NUM_SEATS || seatNum < 0) {
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Seat doesn't exist!");
         }
         // User tried to reserve a non-empty seat
         else if (!(seatResArr.get(seatNum).isEmpty())) {
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Seat is not empty!");
         }


         // User didn't enter First or Coach class
         // Lisette added additional branch to check

         else if (!seatClassField.getText().equals("First")  &&  !seatClassField.getText().equals("Coach")) {
            // Show failure dialog message
            JOptionPane.showMessageDialog(this, "Seat Class must be either Coach or First!");
         }





         // Reserve the specified seat
         else {
            firstName = firstNameField.getText();
            lastName = lastNameField.getText();
            amtPaid = ((Number) amountPaidField.getValue()).intValue();
            seatClass = seatClassField.getText();

            seatElement = new SeatInfo();         // Create new Seat object
            // Lisette added seatClass as argument to reserveSeat()
            seatElement.reserveSeat(firstName, lastName, amtPaid, seatClass);
            seatResArr.set(seatNum, seatElement); // Add seat to ArrayList

            updateTable();                        // Synchronize table with sts ArrayList

            // Show success dialog
            JOptionPane.showMessageDialog(this, "Seat reservation completed.");
         }
      }

      else if (sourceEvent == emptyButton) {
         int seatNumber = ((Number) seatNumField.getValue()).intValue();

         if (seatNumber >= NUM_SEATS || seatNumber < 0) {
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Seat doesn't exist!");
         }

         else {
            makeCurrentSeatEmpty(seatNumber);

            // Show dialog message
               JOptionPane.showMessageDialog(this, "Seat reservation cancelled.");
         }
      }



      else if (sourceEvent == quitButton) {
         dispose();                               // Terminate program
      }
   }

   /* Updates the reservation information displayed by the table */
   public void updateTable() {
      final int seatNumCol = 0;   // Col num for seat numbers
      final int firstNameCol = 1; // Col num for first names
      final int lastNameCol = 2;  // Col num for last names
      final int paidCol = 3;      // Col num for amount paid
      final int classCol = 4;     // Col num for seat class
      int i;                      // Loop index

      for (i = 0; i < NUM_SEATS && i < seatResArr.size(); ++i) {
         if (seatResArr.get(i).isEmpty()) { // Clear table entries
            //seatStatusTable.setValueAt(null, i, seatNumCol);
            seatStatusTable.setValueAt("Unoccupied", i, firstNameCol);
            seatStatusTable.setValueAt(null, i, lastNameCol);
            seatStatusTable.setValueAt(null, i, paidCol);
            seatStatusTable.setValueAt(null, i, classCol);
         }
         else {                             // Update table with content in the seatResArr ArrayList
            seatStatusTable.setValueAt(i, i, seatNumCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getFirstName(), i, firstNameCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getLastName(), i, lastNameCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getAmountPaid(), i, paidCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getSeatClass(), i, classCol);
         }
      }
   }

   /* Makes seats empty */
   public static void seatsMakeEmpty(ArrayList<SeatInfo> seatsRes) {
      int i;      // Loop index

      for (i = 0; i < seatsRes.size(); ++i) {
         seatsRes.get(i).makeEmpty();
      }
   }

   // Lisette added method to make current seat empty
   public void makeCurrentSeatEmpty(int seatNumber) {
      // If valid seat number, find the reservation and set empty

      if (seatNumber < NUM_SEATS) {
         seatResArr.get(seatNumber).makeEmpty();
      }
      updateTable();
   }

   /* Adds empty seats to ArrayList */
   public static void seatsAddElements(ArrayList<SeatInfo> seatsRes, int numSeats) {
      int i;     // Loop index

      for (i = 0; i < numSeats; ++i) {
         seatsRes.add(new SeatInfo());
      }
   }

   /* Creates a SeatReservationFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SeatReservationFrame and its components
      SeatReservationFrame myFrame = new SeatReservationFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}