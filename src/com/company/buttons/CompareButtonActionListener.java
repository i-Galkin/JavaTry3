package com.company.buttons;

import com.company.CompareDialog;
import com.company.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareButtonActionListener implements ActionListener {
    private final List _leftList;
    private final List _rightList;
    private final GUI _frame;

    public CompareButtonActionListener(List leftList, List rightList, GUI frame) {
        _leftList = leftList;
        _rightList = rightList;
        _frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        var dialog = new CompareDialog(_frame, "Compare result", true);
    }
}
