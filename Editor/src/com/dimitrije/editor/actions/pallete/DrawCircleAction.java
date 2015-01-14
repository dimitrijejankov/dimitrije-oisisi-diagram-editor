package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DrawCircleAction extends AbstractEditorAction {

    public DrawCircleAction() {
        super("Draw Circle",
                new ImageIcon("img/icons/circle_icon.png"),
                "The tool that draws a circle.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.CIRCLE_PRESSED);
    }

}
