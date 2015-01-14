package com.dimitrije.editor.actions.pallete;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ZoomOutPointAction extends AbstractEditorAction {

    public ZoomOutPointAction() {
        super("Zoom Out",
                new ImageIcon("img/icons/zoom_out_icon.png"),
                "Zoom Out the current document.",
                KeyEvent.VK_W,
                InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.ZOOM_OUT_PRESSED);
    }
}
