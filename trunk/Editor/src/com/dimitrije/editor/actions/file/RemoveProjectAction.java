package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.editor_tree_model.EditorDiagramTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorProjectTreeNode;
import com.dimitrije.editor.views.window.EditorDiagramWindow;
import com.dimitrije.editor.views.window.EditorWindowManager;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RemoveProjectAction extends AbstractEditorAction {

    public RemoveProjectAction() {
        super("Remove Project",
               new ImageIcon("img/icons/remove_project_icon.png"),
               "Removes a Project",
               KeyEvent.VK_P,
               InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        EditorProjectTreeNode projectTreeNode = EditorModelManager.getInstance().getEditorTreeModel().getCurrentProject();
        EditorModelManager modelManager = EditorModelManager.getInstance();

        if(projectTreeNode != null) {
	        while (projectTreeNode.getChildCount() != 0){
	            Object node  = projectTreeNode.getChildAt(0);
	            if(node instanceof EditorDiagramTreeNode){
	                EditorDiagramTreeNode currentDiagramNode = (EditorDiagramTreeNode)node;
	                EditorDiagramWindow internalWindow = currentDiagramNode.getEditorInternalWindow();
	                EditorWindowManager.getInstance().getEditorWorkPane().removeInternalFrame(internalWindow);
	                projectTreeNode.remove(currentDiagramNode);
	            }
	        }
        }

        modelManager.getEditorTreeModel().getRoot().remove(projectTreeNode);
        SwingUtilities.updateComponentTreeUI(EditorWindowManager.getInstance().getEditorProjectTree());
    }
}
