package com.dimitrije.editor.actions.view;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.window.EditorDiagramWindow;
import com.dimitrije.editor.views.window.EditorWindowManager;
import com.dimitrije.editor.views.window.EditorWorkPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class NextDiagramAction extends AbstractEditorAction {

    public NextDiagramAction() {
        super("Next Diagram",
               new ImageIcon("img/icons/next_icon.png"),
               "Brings the next open diagram into focus",
               KeyEvent.VK_N,
               InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        EditorWorkPane workPane = EditorWindowManager.getInstance().getEditorWorkPane();
        EditorDiagramWindow internalWindow = workPane.getSelectedFrame();
        if(internalWindow != null) {
            EditorDiagramWindow nextInternalWindow = workPane.FindNextWindow(internalWindow);
            if(nextInternalWindow != null)
                nextInternalWindow.setSelected(true);
        }
    }
}
