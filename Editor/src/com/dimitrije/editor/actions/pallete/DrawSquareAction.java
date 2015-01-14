package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DrawSquareAction extends AbstractEditorAction {

    public DrawSquareAction() {
        super("Draw Square",
               new ImageIcon("img/icons/square_icon.png"),
               "The tool that draws a Square.",
               0,
               0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.RECT_PRESSED);
    }

}
