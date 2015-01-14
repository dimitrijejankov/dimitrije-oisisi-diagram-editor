package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractEditorAction {

    public RedoAction() {
        super("Redo",
               new ImageIcon("img/icons/redo_icon.png"),
               "Redo an action.",
               KeyEvent.VK_Y,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorModelManager.getInstance().getCurrentDiagramModel().getCommandManager().Redo();
    }
}
