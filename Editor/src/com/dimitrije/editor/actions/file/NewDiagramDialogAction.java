package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class NewDiagramDialogAction extends AbstractEditorAction {

    public NewDiagramDialogAction() {
        super("New Diagram",
               new ImageIcon("img/icons/new_diagram_icon.png"),
               "Creates a new diagram.",
               KeyEvent.VK_D,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(EditorModelManager.getInstance().getEditorTreeModel().getCurrentProject() != null)
            EditorDialogManager.getInstance().getNewDiagramDialog().setVisible(true);
    }
}

