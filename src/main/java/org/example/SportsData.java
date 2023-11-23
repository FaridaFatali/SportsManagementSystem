package org.example;

import javax.swing.*;

public class SportsData extends Sports {
    private JPanel panel1;
    private JTable table1;
    private JButton HOMEButton;

    public SportsData() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(this.panel1);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        super.tableData(table1, "sports");

        HOMEButton.addActionListener(e -> {
            jFrame.dispose();
            new Sports();
        });
    }
}
