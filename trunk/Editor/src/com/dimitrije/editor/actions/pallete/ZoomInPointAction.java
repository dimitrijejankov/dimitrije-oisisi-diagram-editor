package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ZoomInPointAction extends AbstractEditorAction {

    public ZoomInPointAction() {
        super("Zoom In",
                new ImageIcon("img/icons/zoom_in_icon.png"),
                "Zooms in the current document.",
                KeyEvent.VK_Q,
                InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.ZOOM_IN_PRESSED);
    }
}
