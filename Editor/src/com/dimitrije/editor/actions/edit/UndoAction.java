package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.EditorModelManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractEditorAction {

    public UndoAction() {
        super("Undo Action",
               new ImageIcon("img/icons/undo_icon.png"),
               "Undo an action.",
               KeyEvent.VK_Z,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorModelManager.getInstance().getCurrentDiagramModel().getCommandManager().Undo();
    }
}
