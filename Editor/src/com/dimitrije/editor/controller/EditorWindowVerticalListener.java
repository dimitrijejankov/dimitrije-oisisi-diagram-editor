package com.dimitrije.editor.controller;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class EditorWindowVerticalListener implements AdjustmentListener {

    final JScrollBar verticalScrollBar;
    final EditorDiagramDrawPane drawPane;

    public EditorWindowVerticalListener(JScrollBar bar, EditorDiagramDrawPane pane) {
        verticalScrollBar = bar;
        drawPane = pane;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

        EditorDiagramModel editorDiagramModel = drawPane.getModel();
        if(editorDiagramModel != null){
            int max = editorDiagramModel.getDiagramSize().height - (int)(drawPane.getHeight()/editorDiagramModel.getScalingFactor());
            max = Math.max(0, max);
            
            verticalScrollBar.setMaximum(max);
            editorDiagramModel.setCurrentVerticalPosition(e.getValue());
        }
    }

}
