package com.dimitrije.editor.models.diagram_model;

import java.awt.*;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement.HandlePosition;

public class ScaleCommand extends Command {

    final EditorDiagramModelElement element;
    final EditorDiagramModel model;
    Shape savedShape;
    final Rectangle scaleRect;
    final HandlePosition handlePosition;

    public ScaleCommand(EditorDiagramModel diagramModel, EditorDiagramModelElement modelElement, Rectangle rect, HandlePosition pivot) {
        model = diagramModel;
        element = modelElement;
        savedShape = null;
        scaleRect = rect;
        handlePosition = pivot;
    }

    @Override
    void perform() {
        savedShape = element.shape;
        element.scale(scaleRect, handlePosition);
        model.modelHasChanged();
    }

    @Override
    void rollback() {
        element.shape = savedShape;
        model.modelHasChanged();
    }
}
