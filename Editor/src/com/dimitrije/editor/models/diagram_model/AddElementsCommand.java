package com.dimitrije.editor.models.diagram_model;

import java.awt.*;
import java.util.ArrayList;

public class AddElementsCommand extends Command {

    final ArrayList<EditorDiagramModelElement> elements;
    final EditorDiagramModel model;

    public AddElementsCommand(EditorDiagramModel diagramModel, ArrayList<EditorDiagramModelElement> elementList) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>(elementList);
    }

    public AddElementsCommand(EditorDiagramModel diagramModel, EditorDiagramModelElement element) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>();
        elements.add(element);
    }

    @Override
    void perform() {
        for(EditorDiagramModelElement element : elements) {
            Rectangle bounds = element.getShape().getBounds();
            int x = bounds.x + bounds.width;
            int y = bounds.y + bounds.height;

            if (x < model.diagramSize.width && y < model.diagramSize.height) {
                model.elements.add(element);
                element.setModel(model);
            }
        }

        model.modelHasChanged();
    }

    @Override
    void rollback() {
        for(EditorDiagramModelElement element : elements) {
            model.elements.remove(element);
        }

        model.modelHasChanged();
    }
}
