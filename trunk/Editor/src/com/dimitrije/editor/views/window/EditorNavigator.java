package com.dimitrije.editor.views.window;

import java.awt.Dimension;

import javax.swing.*;

public class EditorNavigator extends JScrollPane {

    public EditorNavigator() {
        super(new EditorProjectTree());
        setMinimumSize(new Dimension(200,600));
    }
}
