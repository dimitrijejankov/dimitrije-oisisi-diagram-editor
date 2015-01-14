package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PrintPreviewAction extends AbstractEditorAction {

    public PrintPreviewAction() {
        super("Print Preview",
                new ImageIcon("img/icons/print_icon.png"),
                "Print preview.",
                KeyEvent.VK_N,
                InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
