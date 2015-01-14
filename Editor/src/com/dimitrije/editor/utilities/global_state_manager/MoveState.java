package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState extends State {

    private boolean moving;
    Point previousPoint;

    public MoveState() {
        this.moving = false;
    }

    @Override
    public void mousePressed(MouseEvent e, EditorDiagramModel model, EditorDiagramDrawPane editorDiagramDrawPane) {
        super.mousePressed(e, model, editorDiagramDrawPane);

        if(model.isSelectedElementAt(e.getPoint())){
            moving = true;
            previousPoint = e.getPoint();
        } else {
            EditorDiagramModelElement element = model.getElementAt(e.getPoint());
            if (element != null){
                model.selectElementAt(e.getPoint(), true);
                previousPoint = e.getPoint();
                moving = true;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        super.mouseDragged(e, editorDiagramModel, editorDiagramDrawPane);
        if (moving) {

            int vectorX = (int)Math.round((e.getX() - previousPoint.x) / editorDiagramModel.getScalingFactor());
            int vectorY = (int)Math.round((e.getY() - previousPoint.y) / editorDiagramModel.getScalingFactor());

            editorDiagramModel.moveSelectedElementsBy(new Point(vectorX, vectorY));
            previousPoint = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        super.mouseReleased(e, editorDiagramModel, editorDiagramDrawPane);
        editorDiagramModel.doneMovingSelectedElements();
        moving = false;
    }

    @Override
    public String toString() {
        return  "Move Tool";
    }
}
