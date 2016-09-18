package com.fx.software.spritesplit;

import com.fx.software.spritesplit.window.MainWindow;

import javax.swing.*;

public class Main {

    private static String theme = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(theme);
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        new MainWindow();
    }
}
