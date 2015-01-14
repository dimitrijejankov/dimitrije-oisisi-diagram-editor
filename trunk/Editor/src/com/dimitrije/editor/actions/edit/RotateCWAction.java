package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RotateCWAction extends AbstractEditorAction {

    public RotateCWAction() {
        super("Rotate CW",
               new ImageIcon("img/icons/rotate_cw_icon.png"),
               "Rotates Clockwise",
               KeyEvent.VK_W,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorDiagramModel model = EditorModelManager.getInstance().getCurrentDiagramModel();
        if (model != null){
            model.rotateSelectedElementsBy(-Math.PI/2);
        }
    }
}
