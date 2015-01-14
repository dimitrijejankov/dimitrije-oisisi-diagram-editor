package com.dimitrije.editor.controller;

import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.views.window.EditorDiagramWindow;
import com.dimitrije.editor.views.window.EditorProjectTree;
import com.dimitrije.editor.views.window.EditorWindowManager;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class EditorInternalWindowAdapter extends InternalFrameAdapter {

    final EditorDiagramWindow editorInternalWindow;

    public EditorInternalWindowAdapter(EditorDiagramWindow value) {
        editorInternalWindow = value;
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        EditorProjectTree editorProjectTree = EditorWindowManager.getInstance().getEditorProjectTree();
        editorProjectTree.setSelectionPath(editorInternalWindow.getTreePath());
        editorProjectTree.scrollPathToVisible(editorInternalWindow.getTreePath());
        EditorModelManager.getInstance().getEditorTreeModel().setCurrentDiagram(editorInternalWindow.getDiagramTreeNode());
        EditorModelManager.getInstance().getEditorTreeModel().setCurrentProject(editorInternalWindow.getDiagramTreeNode().getParent());
        EditorModelManager.getInstance().setCurrentDiagramModel(editorInternalWindow.getEditorDiagramDrawPane().getModel());
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        super.internalFrameDeactivated(e);

        if(editorInternalWindow.getDiagramTreeNode() == EditorModelManager.getInstance().getEditorTreeModel().getCurrentDiagram()){

            EditorProjectTree editorProjectTree = EditorWindowManager.getInstance().getEditorProjectTree();
            editorProjectTree.setSelectionPath(editorInternalWindow.getParentTreePath());
            editorProjectTree.scrollPathToVisible(editorInternalWindow.getParentTreePath());
            EditorModelManager.getInstance().getEditorTreeModel().setCurrentDiagram(null);
            EditorModelManager.getInstance().getEditorTreeModel().setCurrentProject(editorInternalWindow.getDiagramTreeNode().getParent());
        }
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        EditorWindowManager.getInstance().getEditorWorkPane().closeInternalFrame(editorInternalWindow);
    }

}
