package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RotateCCWAction extends AbstractEditorAction {

    public RotateCCWAction() {
        super("Rotate CCW",
               new ImageIcon("img/icons/rotate_ccw_icon.png"),
               "Rotates counter-clockwise",
               KeyEvent.VK_C,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        EditorDiagramModel model = EditorModelManager.getInstance().getCurrentDiagramModel();
        if (model != null){
            model.rotateSelectedElementsBy(Math.PI/2);
        }
    }
}
