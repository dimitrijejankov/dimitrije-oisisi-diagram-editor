package com.dimitrije.editor.controller;

import com.dimitrije.editor.models.diagram_model.*;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorDiagramDrawPaneMouseAdapter extends MouseAdapter {

    final EditorDiagramDrawPane editorDiagramDrawPane;
    final EditorDiagramModel editorDiagramModel;

    public EditorDiagramDrawPaneMouseAdapter(EditorDiagramModel m, EditorDiagramDrawPane v) {
        super();
        editorDiagramModel = m;
        editorDiagramDrawPane = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        GlobalStateManager.getInstance().getState().mouseClicked(e, editorDiagramModel, editorDiagramDrawPane);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        GlobalStateManager.getInstance().getState().mousePressed(e, editorDiagramModel, editorDiagramDrawPane);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        GlobalStateManager.getInstance().getState().mouseDragged(e, editorDiagramModel, editorDiagramDrawPane);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        GlobalStateManager.getInstance().getState().mouseReleased(e, editorDiagramModel, editorDiagramDrawPane);
    }

}
