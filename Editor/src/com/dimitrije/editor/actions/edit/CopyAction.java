package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CopyAction extends AbstractEditorAction {

    public CopyAction() {
        super("Cut",
                new ImageIcon("img/icons/copy_icon.png"),
                "Copy the current element.",
                KeyEvent.VK_C,
                InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

}
