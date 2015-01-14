package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveToolAction extends AbstractEditorAction {

    public MoveToolAction() {
        super("Move tool",
                new ImageIcon("img/icons/move_icon.png"),
                "Selects the move tool.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.MOVE_PRESSED);
    }
}
