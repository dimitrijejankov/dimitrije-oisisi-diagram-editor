package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;
import com.dimitrije.editor.views.window.EditorWindowManager;

import java.awt.event.MouseEvent;

public class SelectAdditionState extends State {
    @Override
    public void mouseClicked(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        super.mouseClicked(e, editorDiagramModel, editorDiagramDrawPane);
        if (e.getClickCount() == 1) {
            editorDiagramModel.selectElementAt(e.getPoint(), false);
            EditorWindowManager.getInstance().getEditorStatusBar().update();
        }
    }

    @Override
    public String toString() {
        return "Select addition";
    }
}
