package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ZoomOutState extends State {

    @Override
    public void mouseClicked(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane drawPane) {
        super.mouseClicked(e, editorDiagramModel, drawPane);
        if (e.getClickCount() == 1) {
            editorDiagramModel.zoomOutPoint(e.getPoint(), drawPane.getSize());

            int verticalMaximum = editorDiagramModel.getDiagramSize().height - (int)(drawPane.getHeight()/editorDiagramModel.getScalingFactor());
            int horizontalMaximum = editorDiagramModel.getDiagramSize().width - (int)(drawPane.getWidth()/editorDiagramModel.getScalingFactor());

            editorDiagramModel.boundPosition(new Point(horizontalMaximum, verticalMaximum));
        }
    }

    @Override
    public String toString() {
        return "Zoom Out";
    }
}
