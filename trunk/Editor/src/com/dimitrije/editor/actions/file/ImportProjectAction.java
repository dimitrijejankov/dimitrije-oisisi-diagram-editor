package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.editor_tree_model.EditorDiagramTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorProjectTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorTreeNode;
import com.dimitrije.editor.views.window.EditorWindow;
import com.dimitrije.editor.views.window.EditorWindowManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class ImportProjectAction extends AbstractEditorAction {

    public ImportProjectAction() {
        super("Import Project",
               new ImageIcon("img/icons/import_project_icon.png"),
               "Imports a project.",
               KeyEvent.VK_M,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("dEditor project files", "dproj");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(EditorWindow.getInstance());
        if(returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                FileInputStream inputStream = new FileInputStream(chooser.getSelectedFile());
                ObjectInputStream stream = new ObjectInputStream(inputStream);

                EditorProjectTreeNode node = (EditorProjectTreeNode)stream.readObject();

                if(EditorModelManager.getInstance().getEditorTreeModel().isProjectNameUnique(node.getProjectName())) {
                    EditorModelManager.getInstance().getEditorTreeModel().addProject(node);

                    for (EditorTreeNode treeNode : node.getDiagrams()) {
                        if (treeNode instanceof EditorDiagramTreeNode) {
                            EditorDiagramTreeNode diagramTreeNode = (EditorDiagramTreeNode) treeNode;
                            EditorWindowManager.getInstance().getEditorWorkPane().addInternalFrame(diagramTreeNode.getEditorInternalWindow());
                        }
                    }
                }

                stream.close();
                inputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
