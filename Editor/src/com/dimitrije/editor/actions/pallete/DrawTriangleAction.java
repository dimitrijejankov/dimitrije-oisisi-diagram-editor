package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DrawTriangleAction extends AbstractEditorAction {

    public DrawTriangleAction() {
        super("Draw Triangle",
               new ImageIcon("img/icons/triangle_icon.png"),
               "The tool that draws a triangle.",
               0,
               0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.TRIANGLE_PRESSED);
    }

}
