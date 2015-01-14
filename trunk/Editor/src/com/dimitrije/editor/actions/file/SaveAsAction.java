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
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveAsAction extends AbstractEditorAction {

    public SaveAsAction() {
        super("Save As",
               new ImageIcon("img/icons/save_icon.png"),
               "Saves the current document as.",
               KeyEvent.VK_E,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorProjectTreeNode projectTreeNode = EditorModelManager.getInstance().getEditorTreeModel().getCurrentProject();

        if(projectTreeNode != null) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("dEditor project files", "dproj");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(EditorWindow.getInstance());
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(chooser.getSelectedFile());
                    ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);

                    stream.writeObject(projectTreeNode);
                    projectTreeNode.setFile(chooser.getSelectedFile());

                    stream.close();
                    fileOutputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
