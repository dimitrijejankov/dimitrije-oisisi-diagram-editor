package com.dimitrije.editor.actions.view;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.window.EditorWindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CascadeWindowsAction extends AbstractEditorAction {

    public CascadeWindowsAction() {
        super("Cascade Windows",
                new ImageIcon("img/icons/cascade_windows_icon.png"),
                "Cascades the diagram windows.",
                KeyEvent.VK_C,
                InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorWindowManager.getInstance().getEditorWorkPane().CascadeWindows();
    }

}
