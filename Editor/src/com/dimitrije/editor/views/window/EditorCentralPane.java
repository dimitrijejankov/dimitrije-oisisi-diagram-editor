package com.dimitrije.editor.views.window;

import javax.swing.*;

public class EditorCentralPane extends JSplitPane {

    public EditorCentralPane() {

        super(JSplitPane.HORIZONTAL_SPLIT);

        this.setLeftComponent(new EditorNavigator());
        this.setRightComponent(new EditorWorkPane());
    }
}
