import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import java.util.Objects;

public class Expenses {
    private JTextField TName;
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
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Submit) {

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
                TName.setText("");
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
    private int TotalCalculation(){

        int rent = Integer.parseInt((Objects.equals(TRent.getText(), "") ) ? "0" : TRent.getText());
        int electricityResult = Integer.parseInt((Objects.equals(ERes.getText(), "")) ? "0" : ERes.getText());
        int waterResult = Integer.parseInt(Objects.equals(WRes.getText(), "") ? "0" : WRes.getText());
        int waste = Integer.parseInt(Objects.equals(TWaste.getText(), "") ? "0" :TWaste.getText());
        return rent + electricityResult + waterResult + waste;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Expenses");
        frame.setContentPane(new Expenses().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}


