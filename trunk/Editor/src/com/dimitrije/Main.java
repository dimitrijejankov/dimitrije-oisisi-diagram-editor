package com.dimitrije;

import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;
import com.dimitrije.editor.views.window.EditorWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

    public static void main(String[] args) {

        setLookAndFeel();
        EditorModelManager.getInstance();
        EditorWindow.getInstance().setVisible(true);
        EditorDialogManager.getInstance();

    }

    public static void setLookAndFeel() {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
    }
}
