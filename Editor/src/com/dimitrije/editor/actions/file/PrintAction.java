package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PrintAction extends AbstractEditorAction {

    public PrintAction() {
        super("Print",
               new ImageIcon("img/icons/print_icon.png"),
               "Prints a diagram.",
               KeyEvent.VK_Q,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
