package com.company.buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonActionListener implements ActionListener {

    private final List _list;
    private final TextField _input;

    public AddButtonActionListener(List list, TextField input) {
        super();
        _list = list;
        _input = input;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        var inputText = _input.getText();
        if(!inputText.trim().equals("")) {
            _list.add(inputText);
            _input.setText("");
        }
    }
}
