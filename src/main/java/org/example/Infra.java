package org.example;

import javax.swing.*;

public class Infra extends Sports {
    private JPanel infraPanel;
    private JTable table1;
    private JButton HOMEButton;
    JFrame jFrame = new JFrame();

    public Infra() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(this.infraPanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        super.tableData(this.table1, "infra");

        HOMEButton.addActionListener(e -> {
            jFrame.dispose();
            new Sports();
        });
    }
}
