package com.dimitrije.editor.views.window;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class EditorScrollBar extends JScrollBar implements Observer {

    final EditorDiagramDrawPane drawPane;

    public EditorScrollBar(int orientation, EditorDiagramDrawPane pane) {
        super(orientation);
        drawPane = pane;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof EditorDiagramModel){
            EditorDiagramModel model = (EditorDiagramModel)observable;

            int max;
            if(orientation == JScrollBar.HORIZONTAL) {
                max = model.getDiagramSize().width - (int)(drawPane.getWidth()/model.getScalingFactor());
            }
            else {
                max = model.getDiagramSize().height - (int)(drawPane.getHeight()/model.getScalingFactor());
            }
            setMaximum(max);
        }

        repaint();
    }
}
