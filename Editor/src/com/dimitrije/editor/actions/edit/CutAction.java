package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CutAction extends AbstractEditorAction {

    public CutAction() {
        super("Cut",
               new ImageIcon("img/icons/cut_icon.png"),
               "Cuts the current element.",
               KeyEvent.VK_X,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
