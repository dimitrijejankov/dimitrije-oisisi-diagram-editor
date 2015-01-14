package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ExportDiagramAction extends AbstractEditorAction {

    public ExportDiagramAction() {
        super("Export Diagram",
               new ImageIcon("img/icons/export_diagram_icon.png"),
               "Exports a Diagram.",
               KeyEvent.VK_X,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

