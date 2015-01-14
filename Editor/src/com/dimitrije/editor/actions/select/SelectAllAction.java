package com.dimitrije.editor.actions.select;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SelectAllAction extends AbstractEditorAction {

    public SelectAllAction() {
        super("Select all",
               new ImageIcon("img/icons/select_all_icon.png"),
               "Selects all elements.",
               KeyEvent.VK_A,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

