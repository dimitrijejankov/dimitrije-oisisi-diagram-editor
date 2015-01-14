package com.dimitrije.editor.controller;


import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.editor_tree_model.EditorDiagramTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorProjectTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorWorkspaceTreeNode;
import com.dimitrije.editor.views.window.EditorDiagramWindow;
import com.dimitrije.editor.views.window.EditorProjectTree;
import com.dimitrije.editor.views.window.EditorWindowManager;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class EditorTreeListener implements TreeSelectionListener {

    final EditorProjectTree editorProjectTree;

    public EditorTreeListener(EditorProjectTree tree) {
        editorProjectTree = tree;
    }

    public void valueChanged(TreeSelectionEvent e) {
        Object selectedNode = editorProjectTree.getLastSelectedPathComponent();

        if(selectedNode instanceof EditorProjectTreeNode) {

            EditorProjectTreeNode node = (EditorProjectTreeNode)selectedNode;
            EditorModelManager.getInstance().getEditorTreeModel().setCurrentProject(node);

        } else if(selectedNode instanceof EditorDiagramTreeNode) {

            EditorDiagramTreeNode node = (EditorDiagramTreeNode)selectedNode;
            EditorModelManager.getInstance().getEditorTreeModel().setCurrentDiagram(node);
            EditorDiagramWindow internalWindow = node.getEditorInternalWindow();
            internalWindow.setSelected(true);
            internalWindow.setVisible(true);
            EditorWindowManager.getInstance().getEditorWorkPane().openInternalFrame(internalWindow);

        } else if(selectedNode instanceof EditorWorkspaceTreeNode) {

            EditorModelManager.getInstance().getEditorTreeModel().setCurrentDiagram(null);
            EditorModelManager.getInstance().getEditorTreeModel().setCurrentProject(null);
        }
    }

}
