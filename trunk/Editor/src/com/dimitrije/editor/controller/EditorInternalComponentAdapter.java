package com.dimitrije.editor.controller;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EditorInternalComponentAdapter extends ComponentAdapter {

    final JScrollBar verticalScrollBar;
    final JScrollBar horizontalScrollBar;
    final EditorDiagramDrawPane drawPane;

    public EditorInternalComponentAdapter(JScrollBar verticalScrollBar, JScrollBar horizontalScrollBar, EditorDiagramDrawPane drawPane) {
        this.verticalScrollBar = verticalScrollBar;
        this.horizontalScrollBar = horizontalScrollBar;
        this.drawPane = drawPane;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        super.componentResized(e);
        EditorDiagramModel editorDiagramModel = drawPane.getModel();
        if(editorDiagramModel != null){
            int verticalMaximum = editorDiagramModel.getDiagramSize().height - (int)(drawPane.getHeight()/editorDiagramModel.getScalingFactor());
            int horizontalMaximum = editorDiagramModel.getDiagramSize().width - (int)(drawPane.getWidth()/editorDiagramModel.getScalingFactor());

            verticalMaximum = Math.max(verticalMaximum, 0);
            horizontalMaximum = Math.max(horizontalMaximum, 0);

            verticalScrollBar.setMaximum(verticalMaximum);
            horizontalScrollBar.setMaximum(horizontalMaximum);

            editorDiagramModel.boundPosition(new Point(horizontalMaximum, verticalMaximum));
        }
    }
}
