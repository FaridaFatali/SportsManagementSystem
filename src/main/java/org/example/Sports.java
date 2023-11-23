package org.example;

import java.sql.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Sports {
    private JPanel mainPanel;
    private JButton SPORTSButton;
    private JButton INFRASTRUCTUREButton;
    private JButton STAFFMEMBERSButton;
    JFrame jFrame1 = new JFrame();

    public Sports() {
        mainPanel = new JPanel();

        SPORTSButton = new JButton("Sports");
        INFRASTRUCTUREButton = new JButton("Infra");
        STAFFMEMBERSButton = new JButton("Staff");

        SPORTSButton.addActionListener(e -> {
            if (e.getSource() == SPORTSButton) {
                jFrame1.dispose();
                new SportsData();
            }
        });

        INFRASTRUCTUREButton.addActionListener(e -> {
            jFrame1.dispose();
            new Infra();
        });

        STAFFMEMBERSButton.addActionListener(e -> {
            jFrame1.dispose();
            new Staff();
        });

        mainPanel.add(SPORTSButton);
        mainPanel.add(INFRASTRUCTUREButton);
        mainPanel.add(STAFFMEMBERSButton);

        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.setContentPane(this.mainPanel);
        jFrame1.pack();
        jFrame1.setLocationRelativeTo(null);

        jFrame1.setVisible(true);
    }

    public void tableData(JTable table, String tableName) {
        try {
            String a = "Select* from " + tableName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sport", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(a);
            table.setModel(buildTableModel(rs));
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
