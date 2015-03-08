package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.editor_tree_model.EditorProjectTreeNode;
import com.dimitrije.editor.views.window.EditorWindow;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
//ANANANANANANANANNNANANABAANANA NENAD
public class SaveAction extends AbstractEditorAction {

    public SaveAction() {
        super("Save",
               new ImageIcon("img/icons/save_icon.png"),
               "Saves the current document",
               KeyEvent.VK_S,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorProjectTreeNode projectTreeNode = EditorModelManager.getInstance().getEditorTreeModel().getCurrentProject();

        if(projectTreeNode != null) {
            File file = projectTreeNode.getFile();
            if (file == null) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("dEditor project files", "dproj");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showSaveDialog(EditorWindow.getInstance());
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                }
            }

            try {
                if (file != null) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);

                    stream.writeObject(projectTreeNode);
                    projectTreeNode.setFile(file);

                    stream.close();
                    fileOutputStream.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
