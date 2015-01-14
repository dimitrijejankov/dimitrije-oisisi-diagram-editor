package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractEditorAction {

    public DeleteAction() {
        super("Delete",
               new ImageIcon("img/icons/delete_icon.png"),
               "Deletes the selected elements.",
               KeyEvent.VK_D,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorDiagramModel model = EditorModelManager.getInstance().getCurrentDiagramModel();

        if(model != null) {
            model.removeSelectedElements();
        }
    }
}
