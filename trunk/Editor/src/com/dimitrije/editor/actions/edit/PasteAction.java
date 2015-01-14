package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PasteAction extends AbstractEditorAction {

    public PasteAction() {

        super("Paste",
               new ImageIcon("img/icons/paste_icon.png"),
               "Paste an element into the document.",
               KeyEvent.VK_V,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

}
