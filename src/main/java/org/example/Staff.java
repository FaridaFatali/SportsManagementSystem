package org.example;

import javax.swing.*;

public class Staff extends Sports {
    private JTable table1;
    private JPanel staffPanel;
    private JButton HOMEButton;
    JFrame jFrame = new JFrame();

    public Staff() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(this.staffPanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        super.tableData(this.table1, "staff");

        HOMEButton.addActionListener(e -> {
            jFrame.dispose();
            new Sports();
        });
    }
}
