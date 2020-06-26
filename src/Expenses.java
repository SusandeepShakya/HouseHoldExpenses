
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;


public class Expenses {
    private JComboBox TName;
    private JTextField TRent;
    private JLabel LName;
    private JPanel MainPanel;
    private JLabel LRent;
    private JLabel LElectricity;
    private JLabel LPrevious;
    private JLabel LNewunit;
    private JTextField TPElectricity;
    private JTextField TNElectricity;
    private JTextField TPwater;
    private JTextField TNwater;
    private JLabel LPwater;
    private JLabel LNwater;
    private JLabel LWater;
    private JTextField ERes;
    private JLabel EResult;
    private JLabel WResult;
    private JTextField WRes;
    private JLabel LWaste;
    private JTextField TWaste;
    private JLabel LTotal;
    private JTextField Total;
    private JButton Clear;
    private JButton Submit;
    private JComboBox comboBox1;

    public Expenses() {

        GetTenant();
        //GetDate();


        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Submit) {
                    Date dt = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String now = sdf.format(dt);

                    String name = TName.getSelectedItem().toString();
                    int rent = Integer.parseInt(TRent.getText());
                    int waste = Integer.parseInt(TWaste.getText());
                    int previousElectricityUnit = Integer.parseInt(TPElectricity.getText());
                    int newElectricityUnit = Integer.parseInt(TNElectricity.getText());
                    int previousWaterUnit = Integer.parseInt(TPwater.getText());
                    int newWaterUnit = Integer.parseInt(TNwater.getText());

                    HouseHoldExpenses houseHoldExpenses = new HouseHoldExpenses();
                    houseHoldExpenses.setIssuedDate(now);
                    houseHoldExpenses.setName(name);
                    houseHoldExpenses.setRent(rent);
                    houseHoldExpenses.setPreviousElectricityUnit(previousElectricityUnit);
                    houseHoldExpenses.setNewElecricityUnit(newElectricityUnit);
                    houseHoldExpenses.setPreviousWaterUnit(previousWaterUnit);
                    houseHoldExpenses.setNewWaterUnit(newWaterUnit);
                    houseHoldExpenses.setWaste(waste);

                    try {
                        SavingIntoDatabase.SaveTenant(houseHoldExpenses);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        });

        TPElectricity.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                int previousElectricityUnit = Integer.parseInt(TPElectricity.getText());
                int newElectricityUnit = Integer.parseInt(TNElectricity.getText());
                int electricityTotal = newElectricityUnit - previousElectricityUnit;
                electricityTotal = electricityTotal * 15;
                ERes.setText(String.valueOf(electricityTotal));
                Total.setText(String.valueOf(TotalCalculation()));
            }
        });
        TPwater.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                int previousWaterUnit = Integer.parseInt(TPwater.getText());
                int newWaterUnit = Integer.parseInt(TNwater.getText());
                int waterTotal = newWaterUnit - previousWaterUnit;
                waterTotal = waterTotal * 350;
                WRes.setText(String.valueOf(waterTotal));
                Total.setText(String.valueOf(TotalCalculation()));
            }
        });
        TRent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Total.setText(String.valueOf(TotalCalculation()));
            }
        });
        TWaste.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                Total.setText(String.valueOf(TotalCalculation()));
            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TName.setSelectedItem("");
                TRent.setText("");
                TPElectricity.setText("");
                TNElectricity.setText("");
                TPwater.setText("");
                TNwater.setText("");
                ERes.setText("");
                WRes.setText("");
                TWaste.setText("");
                Total.setText("");
            }
        });
    }

    private int TotalCalculation() {

        int rent = Integer.parseInt((Objects.equals(TRent.getText(), "")) ? "0" : TRent.getText());
        int electricityResult = Integer.parseInt((Objects.equals(ERes.getText(), "")) ? "0" : ERes.getText());
        int waterResult = Integer.parseInt(Objects.equals(WRes.getText(), "") ? "0" : WRes.getText());
        int waste = Integer.parseInt(Objects.equals(TWaste.getText(), "") ? "0" : TWaste.getText());
        return rent + electricityResult + waterResult + waste;
    }

    public String GetTenant() {
        ResultSet Rs = null;
        try {

            Connection con = GetConnection.getConnection();
            PreparedStatement tenantStmt = con.prepareStatement("SELECT * FROM Tenant");
            Rs = tenantStmt.executeQuery();
            while (Rs.next()) {
                TName.addItem(Rs.getString("TenantName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public String GetDate() {
        ResultSet Rs = null;
        try {

            Connection con = GetConnection.getConnection();
            PreparedStatement tenantStmt = con.prepareStatement("SELECT * FROM NepaliMonths");
            Rs = tenantStmt.executeQuery();
            while (Rs.next()) {
                comboBox1.addItem(Rs.getString("MonthName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("Expenses");
        frame.setContentPane(new Expenses().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}


