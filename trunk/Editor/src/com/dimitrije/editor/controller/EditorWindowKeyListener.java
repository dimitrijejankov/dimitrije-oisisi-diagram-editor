package com.dimitrije.editor.controller;


import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EditorWindowKeyListener implements KeyEventDispatcher {

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.CONTROL_PRESSED);
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.CONTROL_RELEASED);
            }
        }
        return false;
    }
}
