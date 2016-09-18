package com.fx.software.spritesplit.window;

import javax.swing.*;

public class OkDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public OkDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setBounds(600, 300, 280, 100);
        buttonOK.addActionListener(e -> onOK());
    }

    private void onOK() {
        dispose();
    }
}
