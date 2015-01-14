package com.dimitrije.editor.controller;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class EditorWindowHorizontalListener implements AdjustmentListener {

    final JScrollBar horizontalScrollBar;
    final EditorDiagramDrawPane drawPane;

    public EditorWindowHorizontalListener(JScrollBar bar, EditorDiagramDrawPane pane) {
        horizontalScrollBar = bar;
        drawPane = pane;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

        EditorDiagramModel editorDiagramModel = drawPane.getModel();
        if(editorDiagramModel != null){
            int max = editorDiagramModel.getDiagramSize().width - (int)(drawPane.getWidth()/editorDiagramModel.getScalingFactor());
            max = Math.max(0, max);

            horizontalScrollBar.setMaximum(max);
            editorDiagramModel.setCurrentHorizontalPosition(e.getValue());
        }
    }

}
