package com.dimitrije.editor.models.diagram_model;

import java.util.ArrayList;

public class RemoveCommand extends Command {

    final ArrayList<EditorDiagramModelElement> elements;
    final EditorDiagramModel model;

    public RemoveCommand(EditorDiagramModel diagramModel, ArrayList<EditorDiagramModelElement> elementList) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>(elementList);
    }

    @Override
    void perform() {
        for (EditorDiagramModelElement element : elements) {
            model.elements.remove(element);
        }
        model.modelHasChanged();
    }

    @Override
    void rollback() {
        for (EditorDiagramModelElement element : elements) {
            model.elements.add(element);
        }
        model.modelHasChanged();
    }
}
