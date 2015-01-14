package com.dimitrije.editor.models.diagram_model;

import java.util.ArrayList;

public class SelectCommand extends Command {

    final ArrayList<EditorDiagramModelElement> elements;
    ArrayList<EditorDiagramModelElement> savedSelectedList;
    final EditorDiagramModel model;
    boolean deselectPrevious;

    public SelectCommand(EditorDiagramModel diagramModel, ArrayList<EditorDiagramModelElement> elementList) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>(elementList);
        savedSelectedList = null;
    }

    public SelectCommand(EditorDiagramModel diagramModel, EditorDiagramModelElement element, boolean deselect) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>();
        elements.add(element);
        deselectPrevious = deselect;
    }

    @Override
    void perform() {

        if (deselectPrevious) {
            savedSelectedList = new ArrayList<EditorDiagramModelElement>(model.selectedElements);

            for (EditorDiagramModelElement element : model.selectedElements) {
                element.setSelected(false);
            }

            model.selectedElements.clear();
        }

        for (EditorDiagramModelElement element : elements) {
            element.setSelected(true);
            if (!model.selectedElements.contains(element))
                model.selectedElements.add(element);
        }

        model.modelHasChanged();
    }

    @Override
    void rollback() {

        if (deselectPrevious) {

            for (EditorDiagramModelElement element : savedSelectedList) {
                element.setSelected(true);
            }

            model.selectedElements.clear();
            model.selectedElements.addAll(savedSelectedList);
        }
        else {

            for (EditorDiagramModelElement element : elements) {
                element.setSelected(false);
                model.selectedElements.remove(element);
            }
        }

        model.modelHasChanged();
    }
}
