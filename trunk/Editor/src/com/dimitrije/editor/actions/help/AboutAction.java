package com.dimitrije.editor.actions.help;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AboutAction extends AbstractEditorAction {

    public AboutAction() {
        super("About",
               new ImageIcon("img/icons/about_icon.png"),
               "Displays the about dialog.",
               KeyEvent.VK_A,
               InputEvent.ALT_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorDialogManager.getInstance().getAboutDialog().setVisible(true);
    }
}