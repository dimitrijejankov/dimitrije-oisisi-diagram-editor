package com.dimitrije.editor.actions.view;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.window.EditorDiagramWindow;
import com.dimitrije.editor.views.window.EditorWindowManager;
import com.dimitrije.editor.views.window.EditorWorkPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PreviousDiagramAction extends AbstractEditorAction {

    public PreviousDiagramAction() {
        super("PreviousDiagram",
               new ImageIcon("img/icons/previous.png"),
               "Brings the previous open diagram into focus.",
               KeyEvent.VK_M,
               InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorWorkPane workPane = EditorWindowManager.getInstance().getEditorWorkPane();
        EditorDiagramWindow internalWindow = workPane.getSelectedFrame();
        if(internalWindow != null) {
            EditorDiagramWindow nextInternalWindow = workPane.FindPreviousWindow(internalWindow);
            if(nextInternalWindow != null)
                nextInternalWindow.setSelected(true);
        }
    }
}
