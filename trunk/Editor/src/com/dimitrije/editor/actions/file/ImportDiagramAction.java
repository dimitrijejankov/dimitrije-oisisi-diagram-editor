package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ImportDiagramAction extends AbstractEditorAction {

    public ImportDiagramAction() {
        super("Import Diagram",
               new ImageIcon("img/icons/import_diagram_icon.png"),
               "Imports a Diagram",
               KeyEvent.VK_O,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
