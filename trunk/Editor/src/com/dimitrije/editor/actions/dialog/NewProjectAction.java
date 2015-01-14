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

public class NewProjectAction extends AbstractEditorAction {

    public NewProjectAction() {
        super("New Project",
                null,
                "Creates a new project.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String projectName = EditorDialogManager.getInstance().getNewProjectDialog().getTextFieldValue();
        EditorTreeModel editorTreeModel = EditorModelManager.getInstance().getEditorTreeModel();

        if(editorTreeModel.isProjectNameUnique(projectName)){
            EditorProjectTreeNode projectNode = new EditorProjectTreeNode(projectName);
            EditorDiagramTreeNode defaultDiagramNode = new EditorDiagramTreeNode("Default Diagram", projectNode);
            EditorModelManager.getInstance().getEditorTreeModel().setCurrentDiagram(defaultDiagramNode);
            projectNode.insert(defaultDiagramNode, 0);

            editorTreeModel.addProject(projectNode);

            EditorDiagramWindow newInternalWindow = new EditorDiagramWindow(defaultDiagramNode);
            newInternalWindow.setModel(new EditorDiagramModel());

            EditorWindowManager.getInstance().getEditorWorkPane().addInternalFrame(newInternalWindow);
            EditorDialogManager.getInstance().getNewProjectDialog().setVisible(false);
        }
    }
}