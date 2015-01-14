package com.dimitrije.editor.actions.view;

import com.dimitrije.editor.actions.AbstractEditorAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ZoomNormalAction extends AbstractEditorAction {

    public ZoomNormalAction() {
        super("Zoom Normal",
               new ImageIcon("img/icons/zoom_normal_icon.png"),
               "Zooms the current document to 100%",
               KeyEvent.VK_N,
               InputEvent.CTRL_MASK
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}