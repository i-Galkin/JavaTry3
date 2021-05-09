package com.company.buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonActionListener implements ActionListener {

    private final List _list;

    public DeleteButtonActionListener(List list) {
        super();
        _list = list;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        var selectedItem = _list.getSelectedItem();
        if(selectedItem != null) {
            _list.remove(_list.getSelectedItem());
        }
    }
}
