package com.company.buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditButtonActionListener implements ActionListener {

    private final List _list;
    private final TextField _input;

    public EditButtonActionListener(List list, TextField input) {
        super();
        _list = list;
        _input = input;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        var selectedItem = _list.getSelectedItem();
        var inputText = _input.getText();

        if(selectedItem != null && !inputText.trim().equals("")) {
            _list.replaceItem(inputText, _list.getSelectedIndex());
            _input.setText("");
        }
    }
}
