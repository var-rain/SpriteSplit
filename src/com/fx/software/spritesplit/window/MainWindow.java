package com.fx.software.spritesplit.window;

import com.fx.software.spritesplit.utili.ReaderImage;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.io.IOException;

/**
 * 项目名称: SpriteSplit.
 * 创建时间: 2016/8/19.
 * 创 建 人: Var_雨中行.
 * 类 描 述: .
 */
public class MainWindow extends JFrame {
    private JPanel content;
    private JTextField file;
    private JTextField path;
    private JTextField name;
    private JTextField num;
    private JTextField format;
    private JTextPane catpre;
    private JButton but1;
    private JButton but2;
    private JTextPane prviewer;
    private JButton start;

    private String inFile;
    private String outFloder;

    private final double WINDOW_WIDTH = 1366;
    private final double WINDOW_HEIGHT = 740;

    public MainWindow() throws HeadlessException {
        this.setContentPane(content);
        this.setTitle("图集切割工具 -- By Var_雨中行");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, (int) WINDOW_WIDTH, (int) WINDOW_HEIGHT);
        this.setResizable(false);
        name.setText("image_");
        num.setText("0");
        format.setText(".png");
        initListener();
    }

    private void initListener() {
        but1.addActionListener(e -> {
            file.setText("");
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showDialog(new JLabel(), "选择");
            String path = "";
            if ((path = chooser.getSelectedFile().getPath()) != null) {
                file.setText(path);
                this.inFile = file.getText();
            }
        });

        file.addCaretListener(e1 -> {
            catpre.setText("");
            prviewer.setText("");
            this.inFile = file.getText();
            if (!inFile.equals("")) {
                prviewer.insertIcon(new ImageIcon(inFile));
            }
        });

        path.addCaretListener(e1 -> this.outFloder = path.getText());

        but2.addActionListener(e -> {
            path.setText("");
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showDialog(new JLabel(), "选择");
            String filepath;
            if ((filepath = chooser.getSelectedFile().getPath()) != null) {
                path.setText(filepath);
                this.outFloder = path.getText();
            }
        });

        start.addActionListener(e -> {
            start.setEnabled(false);
            ReaderImage readerImage = new ReaderImage(inFile, this);
            readerImage.setCont(new Integer(num.getText()));
            readerImage.setFileName(name.getText());
            readerImage.setFormat(format.getText());
            readerImage.setPath(outFloder);
            readerImage.start();
        });
    }

    public JTextPane getCatpre() {
        return catpre;
    }

    public void showOk() {
        start.setEnabled(true);
        try {
            Runtime.getRuntime().exec("explorer.exe " + outFloder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OkDialog dialog = new OkDialog();
        dialog.pack();
        dialog.setVisible(true);
    }
}
