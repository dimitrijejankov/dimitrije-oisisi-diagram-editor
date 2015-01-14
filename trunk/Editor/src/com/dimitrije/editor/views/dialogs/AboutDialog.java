package com.dimitrije.editor.views.dialogs;

import javax.swing.*;
import java.awt.*;


public class AboutDialog extends JDialog {


    public AboutDialog(Frame owner) {
        super(owner,"About Dialog");
        setSize(520, 713);
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        getContentPane().setLayout(new GridLayout(1,2));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Label name = new Label();
        name.setText("Dimitrije Jankov");
        panel.add(name);

        Label index = new Label();
        index.setText("RA40-2012");
        panel.add(index);

        Label email = new Label();
        email.setText("dimitrijejankov@gmail.com");
        panel.add(email);

        panel.add(new JToolBar.Separator(new Dimension(32, 600)));

        add(panel);

        JLabel picLabel = new JLabel(new ImageIcon("img/logo/me.jpg"));
        add(picLabel);
    }


}