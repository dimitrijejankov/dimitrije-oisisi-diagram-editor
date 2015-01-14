package com.dimitrije.editor.models.diagram_model;

import java.awt.*;
import java.util.ArrayList;

public class MoveCommand extends Command {

    final ArrayList<EditorDiagramModelElement> elements;
    final EditorDiagramModel model;
    Point vector;
    boolean doneMoving;

    public MoveCommand(EditorDiagramModel diagramModel, ArrayList<EditorDiagramModelElement> elementList, Point translationVector) {
        model = diagramModel;
        elements = new ArrayList<EditorDiagramModelElement>(elementList);
        vector = translationVector;
        doneMoving = false;
    }

    @Override
    void perform() {
        for(EditorDiagramModelElement element : elements){
            element.translate(vector);
        }
    }

    @Override
    void rollback() {
        for(EditorDiagramModelElement element : elements){
            element.translate(new Point(-vector.x,-vector.y));
        }
    }

    void accumulate(Point delta) {
        for(EditorDiagramModelElement element : elements){
            element.translate(delta);
        }
        vector = new Point(vector.x + delta.x, vector.y + delta.y);
    }

    public void setDoneMoving(){
        doneMoving = true;
    }

    public boolean isDoneMoving() {
        return doneMoving;
    }
}
