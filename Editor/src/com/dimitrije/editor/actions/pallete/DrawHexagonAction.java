package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DrawHexagonAction extends AbstractEditorAction {

    public DrawHexagonAction() {
        super("Draw Hexagon",
               new ImageIcon("img/icons/hexagon_icon.png"),
               "The tool that draws a hexagon.",
               0,
               0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.HEXAGON_PRESSED);
    }

}
