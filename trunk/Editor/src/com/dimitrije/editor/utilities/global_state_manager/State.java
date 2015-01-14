package com.dimitrije.editor.utilities.global_state_manager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import java.awt.event.MouseEvent;

public abstract class State {

    public void mouseClicked(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane){

    }

    public void mousePressed(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane){
        editorDiagramModel.setFirstSelectionPoint(e.getPoint());
        editorDiagramModel.setSecondSelectionPoint(e.getPoint());
        editorDiagramModel.setIsSelecting(true);
    }

    public void mouseDragged(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane){
        if(editorDiagramModel.isSelecting())
            editorDiagramModel.setSecondSelectionPoint(e.getPoint());
    }

    public void mouseReleased(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane){
        editorDiagramModel.setIsSelecting(false);
    }

}
