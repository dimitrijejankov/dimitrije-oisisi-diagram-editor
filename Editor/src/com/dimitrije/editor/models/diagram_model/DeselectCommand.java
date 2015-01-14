package com.dimitrije.editor.models.diagram_model;

import java.util.ArrayList;

public class DeselectCommand extends Command {


    final ArrayList<EditorDiagramModelElement> elements;
    final EditorDiagramModel model;

    public DeselectCommand(EditorDiagramModel diagramModel, ArrayList<EditorDiagramModelElement> elementList) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>();
        elements.addAll(elementList);
    }

    @Override
    void perform() {
        for (EditorDiagramModelElement element : elements) {
            element.setSelected(false);
        }
        model.selectedElements.clear();
        model.modelHasChanged();
    }

    @Override
    void rollback() {

        for (EditorDiagramModelElement element : elements) {
            element.setSelected(true);
        }
        model.selectedElements.addAll(elements);
        model.modelHasChanged();
    }
}
