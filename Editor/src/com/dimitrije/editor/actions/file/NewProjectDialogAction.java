package com.dimitrije.editor.actions.file;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class NewProjectDialogAction extends AbstractEditorAction {

    public NewProjectDialogAction() {
        super("New Project",
               new ImageIcon("img/icons/new_project_icon.png"),
               "Creates a new project.",
               KeyEvent.VK_P,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorDialogManager.getInstance().getNewProjectDialog().setVisible(true);
    }
}
