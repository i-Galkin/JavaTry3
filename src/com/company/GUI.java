package com.company;

import com.company.buttons.AddButtonActionListener;
import com.company.buttons.CompareButtonActionListener;
import com.company.buttons.DeleteButtonActionListener;
import com.company.buttons.EditButtonActionListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame {

    public GUI(String title) {
        super(title);

        configureWindow();
        configureComponents();
    }

    private List leftList;
    private List rightList;

    public List getLeftList() {
        return leftList;
    }

    public List getRightList() {
        return rightList;
    }


    private void configureWindow() {
        setLayout(new GridBagLayout());
        setSize(400,400);
        setPreferredSize(getSize());
        addWindowListener(new WindowClose());
        setVisible(true);
    }

    private void configureComponents() {
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        leftList = new List();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridheight = 3;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(leftList, gbc);

        rightList = new List();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridheight = 3;
        gbc.gridwidth = 2;
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(rightList, gbc);

        var compareBtn = new Button("Compare");
        compareBtn.addActionListener(new CompareButtonActionListener(leftList, rightList, this));
        compareBtn.setForeground(Color.black);
        compareBtn.setBackground(Color.cyan);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(compareBtn, gbc);

        var leftLabel = new Label("New value");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.05;
        add(leftLabel, gbc);

        var rightLabel = new Label("New value");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(rightLabel, gbc);

        var leftInput = new TextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(leftInput, gbc);

        var rightInput = new TextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(rightInput, gbc);

        var leftPanel = new Panel(new FlowLayout());
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(leftPanel, gbc);

        var addToLeftBtn = new Button("Add");
        addToLeftBtn.addActionListener(new AddButtonActionListener(leftList, leftInput));
        leftPanel.add(addToLeftBtn);

        var editLeftBtn = new Button("Edit");
        editLeftBtn.addActionListener(new EditButtonActionListener(leftList, leftInput));
        leftPanel.add(editLeftBtn);

        var removeFromLeftBtn = new Button("Remove");
        removeFromLeftBtn.addActionListener(new DeleteButtonActionListener(leftList));
        leftPanel.add(removeFromLeftBtn);


        var rightPanel = new Panel(new FlowLayout());
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(rightPanel, gbc);

        var addToRightBtn = new Button("Add");
        addToRightBtn.addActionListener(new AddButtonActionListener(rightList, rightInput));
        rightPanel.add(addToRightBtn);

        var editRightBtn = new Button("Edit");
        editRightBtn.addActionListener(new EditButtonActionListener(rightList, rightInput));
        rightPanel.add(editRightBtn);

        var removeFromRightBtn = new Button("Remove");
        removeFromRightBtn.addActionListener(new DeleteButtonActionListener(rightList));
        rightPanel.add(removeFromRightBtn);

        SeedData(leftList, rightList);
    }

    private void SeedData(List leftList, List rightList) {
        leftList.add("string 1");
        rightList.add("string 1");

        leftList.add("string 2");

        rightList.add("string 3");

        leftList.add("string 4");
        rightList.add("string 4");
    }

    private static class WindowClose extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
}
