package com.dimitrije.editor.models.diagram_model;

import java.util.ArrayList;

public class RotateCommand extends Command {

    final ArrayList<EditorDiagramModelElement> elements;
    final EditorDiagramModel model;
    final double angle;

    public RotateCommand(EditorDiagramModel diagramModel, ArrayList<EditorDiagramModelElement> elementList, double theta) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>(elementList);
        angle = theta;
    }

    @Override
    void perform() {
        for(EditorDiagramModelElement element : elements){
            element.rotate(angle);
        }
    }

    @Override
    void rollback() {
        for(EditorDiagramModelElement element : elements){
            element.rotate(-angle);
        }
    }
}
