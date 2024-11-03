package com.recursos_humanos_iudigital.view;

import com.recursos_humanos_iudigital.controller.FuncionarioController;

import javax.swing.*;

public class RecursosHumanos {
    public static void main(String[] args) {
        // Configuración de la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            // Crea la instancia de tu JFrame principal
            MainFrame mainFrame = new MainFrame();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
            mainFrame.setVisible(true); // Hacer visible el frame
        });
    }
}

