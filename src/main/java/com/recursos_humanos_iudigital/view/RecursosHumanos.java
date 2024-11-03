package com.recursos_humanos_iudigital.view;

import javax.swing.*;

public class RecursosHumanos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            mainFrame.setVisible(true); 
        });
    }
}

