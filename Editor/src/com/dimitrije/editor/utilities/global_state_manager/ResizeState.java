package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement.HandlePosition;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class ResizeState extends State {

    HandlePosition handlePosition;
    EditorDiagramModelElement element;

    @Override
    public void mouseDragged(MouseEvent e, EditorDiagramModel model, EditorDiagramDrawPane editorDiagramDrawPane) {
        Rectangle bounds = element.getShape().getBounds();
        if (handlePosition == HandlePosition.BOTTOM_LEFT) {
            int x = bounds.x + bounds.width;
            int y = bounds.y;
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(x,y), model));
            model.setSecondSelectionPoint(e.getPoint());
        }
        else if (handlePosition == HandlePosition.BOTTOM_RIGHT) {
            int x = bounds.x;
            int y = bounds.y;
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(x,y), model));
            model.setSecondSelectionPoint(e.getPoint());
        }
        else if (handlePosition == HandlePosition.TOP_LEFT) {
            int x = bounds.x + bounds.width;
            int y = bounds.y + bounds.height;
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(x,y), model));
            model.setSecondSelectionPoint(e.getPoint());
        }
        else if (handlePosition == HandlePosition.TOP_RIGHT) {
            int x = bounds.x;
            int y = bounds.y + bounds.height;
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(x,y), model));
            model.setSecondSelectionPoint(e.getPoint());
        }
        else if(handlePosition == HandlePosition.BOTTOM_MIDDLE) {
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(bounds.x, bounds.y), model));
            model.setSecondSelectionPoint(new Point(DiagramToScreenSpaceX(bounds.x + bounds.width, model), e.getY()));
        }
        else if(handlePosition == HandlePosition.LEFT_MIDDLE) {
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(bounds.x + bounds.width, bounds.y), model));
            model.setSecondSelectionPoint(new Point(e.getX(), DiagramToScreenSpaceY(bounds.y + bounds.height, model)));
        }
        else if(handlePosition == HandlePosition.RIGHT_MIDDLE) {
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(bounds.x, bounds.y), model));
            model.setSecondSelectionPoint(new Point(e.getX(), DiagramToScreenSpaceY(bounds.y + bounds.height, model)));
        }
        else if(handlePosition == HandlePosition.TOP_MIDDLE) {
            model.setFirstSelectionPoint(DiagramToScreenSpace(new Point(bounds.x + bounds.width, bounds.y + bounds.height), model));
            model.setSecondSelectionPoint(new Point(DiagramToScreenSpaceX(bounds.x, model), e.getY()));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        Rectangle rectangle = editorDiagramModel.getSelectionBox();
        if (editorDiagramModel.selectionHasArea()) {
            AffineTransform inverseDiagram = editorDiagramModel.getDiagramInverseTransformation();
            rectangle = inverseDiagram.createTransformedShape(rectangle).getBounds();
            editorDiagramModel.scaleElement(element,rectangle, handlePosition);
        }

        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.SELECT_PRESSED);
        super.mouseReleased(e, editorDiagramModel, editorDiagramDrawPane);
    }

    public Point DiagramToScreenSpace(Point point, EditorDiagramModel model) {
        point.x = (int)((point.x - model.getCurrentPosition().x) * model.getScalingFactor());
        point.y = (int)((point.y - model.getCurrentPosition().y) * model.getScalingFactor());

        return point;
    }

    public int DiagramToScreenSpaceY(float y, EditorDiagramModel model) {
        return (int)((y - model.getCurrentPosition().y) * model.getScalingFactor());
    }

    public int DiagramToScreenSpaceX(float x, EditorDiagramModel model) {
        return (int)((x - model.getCurrentPosition().x) * model.getScalingFactor());
    }

    @Override
    public String toString() {
        return "Resizing";
    }
}
