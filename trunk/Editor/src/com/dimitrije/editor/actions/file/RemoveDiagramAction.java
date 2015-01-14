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

public class RemoveDiagramAction extends AbstractEditorAction {

    public RemoveDiagramAction() {
        super("Remove Diagram",
               new ImageIcon("img/icons/remove_diagram_icon.png"),
               "Removes a Diagram",
               KeyEvent.VK_R,
               InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorModelManager modelManager = EditorModelManager.getInstance();
        EditorDiagramTreeNode currentDiagramNode = modelManager.getEditorTreeModel().getCurrentDiagram();

        if(currentDiagramNode != null){
            EditorDiagramWindow internalWindow = currentDiagramNode.getEditorInternalWindow();
            EditorWindowManager.getInstance().getEditorWorkPane().removeInternalFrame(internalWindow);

            EditorProjectTreeNode projectTreeNode = currentDiagramNode.getParent();
            projectTreeNode.remove(currentDiagramNode);
            
            SwingUtilities.updateComponentTreeUI(EditorWindowManager.getInstance().getEditorProjectTree());
        }

    }
}
