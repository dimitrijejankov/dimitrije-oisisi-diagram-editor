package com.dimitrije.editor.actions.edit;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SearchAction extends AbstractEditorAction {

    public SearchAction() {
        super("Search",
               new ImageIcon("img/icons/search_icon.png"),
               "Searches documents.",
               KeyEvent.VK_S,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
