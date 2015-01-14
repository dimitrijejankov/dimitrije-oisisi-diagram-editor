package com.dimitrije.editor.actions.dialog;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.editor_tree_model.EditorDiagramTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorProjectTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorTreeModel;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;
import com.dimitrije.editor.views.window.EditorDiagramWindow;
import com.dimitrije.editor.views.window.EditorWindowManager;

import java.awt.event.ActionEvent;

public class NewDiagramAction extends AbstractEditorAction {

    public NewDiagramAction() {
        super("New Diagram",
                null,
                "Creates a new project.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String diagramName = EditorDialogManager.getInstance().getNewDiagramDialog().getTextFieldValue();
        EditorProjectTreeNode currentProject = EditorModelManager.getInstance().getEditorTreeModel().getCurrentProject();
        EditorTreeModel editorTreeModel = EditorModelManager.getInstance().getEditorTreeModel();

        if(editorTreeModel.isDiagramNameUnique(diagramName, currentProject))
        {
            EditorDiagramTreeNode newDiagramTreeNode = new EditorDiagramTreeNode(diagramName, currentProject);
            EditorModelManager.getInstance().getEditorTreeModel().addDiagram(newDiagramTreeNode);

            EditorDiagramWindow newInternalWindow = new EditorDiagramWindow(newDiagramTreeNode);
            newInternalWindow.setModel(new EditorDiagramModel());

            EditorWindowManager.getInstance().getEditorWorkPane().addInternalFrame(newInternalWindow);
            EditorDialogManager.getInstance().getNewDiagramDialog().setVisible(false);
        }
    }
}