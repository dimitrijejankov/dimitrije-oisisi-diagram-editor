package com.dimitrije.editor.actions.view;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ZoomOutAction extends AbstractEditorAction {

    public ZoomOutAction() {
        super("Zoom Out",
               new ImageIcon("img/icons/zoom_out_icon.png"),
               "Zoom Out the current document.",
               KeyEvent.VK_T,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorDiagramModel model = EditorModelManager.getInstance().getCurrentDiagramModel();
        if (model != null)
            model.zoomOutCenter();
    }
}