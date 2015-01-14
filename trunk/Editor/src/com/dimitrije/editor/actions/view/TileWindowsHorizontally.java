package com.dimitrije.editor.actions.view;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.window.EditorWindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TileWindowsHorizontally extends AbstractEditorAction {

    public TileWindowsHorizontally() {
        super("Tile Windows Horizontally",
                new ImageIcon("img/icons/tile_windows_horizontally_icon.png"),
                "Tile the windows horizontally .",
                KeyEvent.VK_H,
                InputEvent.SHIFT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorWindowManager.getInstance().getEditorWorkPane().TileWindowsHorizontally();
    }

}
