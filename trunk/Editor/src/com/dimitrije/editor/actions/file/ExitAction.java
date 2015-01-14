package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractEditorAction {

    public ExitAction() {
        super("Exit",
               new ImageIcon("img/icons/exit_icon.png"),
               "Exits the application",
                KeyEvent.VK_Q,
                InputEvent.CTRL_MASK
              );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}
