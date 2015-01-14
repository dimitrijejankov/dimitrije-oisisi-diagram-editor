package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelTriangle;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;
import com.dimitrije.editor.views.window.EditorWindowManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawTriangleState extends State {

    @Override
    public void mouseReleased(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        if (editorDiagramModel.isSelecting() && editorDiagramModel.selectionHasArea()) {
            createNewTriangle(editorDiagramModel);
        }
        editorDiagramModel.deselectAllElements();
        EditorWindowManager.getInstance().getEditorStatusBar().update();

        super.mouseReleased(e, editorDiagramModel, editorDiagramDrawPane);
    }

    private void createNewTriangle(EditorDiagramModel editorDiagramModel) {
        Rectangle rectangle = editorDiagramModel.getSelectionBox();

        EditorDiagramModelElement element = new EditorDiagramModelTriangle("","", Color.blue, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        element.transformToDiagramSpace(editorDiagramModel);
        editorDiagramModel.addElement(element);
    }

    @Override
    public String toString() {
        return "Draw Triangle";
    }
}
