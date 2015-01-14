package com.dimitrije.editor.actions.select;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectAction extends AbstractEditorAction {
    public SelectAction() {
        super("Select",
                new ImageIcon("img/icons/select_icon.png"),
                "The tool that selects elements.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.SELECT_PRESSED);
    }

}
