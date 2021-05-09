package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareDialog extends Dialog implements ActionListener {

    private final GUI _parentFrame;

    public CompareDialog(GUI parentFrame, String title, boolean b) {
        super(parentFrame, title, b);
        _parentFrame = parentFrame;

        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        var label = new Label("Mismatched elements");
        label.setAlignment(Label.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(label, gbc);

        var diffList = new List();
        for (var str : getDifference()) {
            diffList.add(str);
        }
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 5;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(diffList, gbc);

        var exitButton = new Button("Закрыть");
        setSize(400,300);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weighty = 0.1;
        gbc.weightx = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.CENTER;
        add(exitButton, gbc);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    private ArrayList<String> getDifference() {
        var leftData = _parentFrame.getLeftList().getItems();
        var rightData = _parentFrame.getRightList().getItems();

        var diffList = new ArrayList<String>(Arrays.asList(leftData));
        for (var str : rightData) {
            if (diffList.contains(str)) {
                diffList.remove(str);
            } else {
                diffList.add(str);
            }
        }

        return diffList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
