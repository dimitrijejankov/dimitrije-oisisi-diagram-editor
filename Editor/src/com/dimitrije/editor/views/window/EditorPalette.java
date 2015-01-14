package com.dimitrije.editor.views.window;

import com.dimitrije.editor.actions.ActionsManager;

import javax.swing.*;

public class EditorPalette extends JToolBar {

    public EditorPalette() {

        super();
        ActionsManager actionsManager = ActionsManager.getInstance();

        setOrientation(JToolBar.VERTICAL);

        AbstractAction selectButton = actionsManager.getSelectAction();
        AbstractAction moveButton = actionsManager.getMoveToolAction();

        AbstractAction drawSquareButton = actionsManager.getDrawSquareAction();
        AbstractAction drawTriangleButton = actionsManager.getDrawTriangleAction();
        AbstractAction drawCircleButton = actionsManager.getDrawCircleAction();
        AbstractAction drawHexagonButton = actionsManager.getDrawHexagonAction();

        AbstractAction zoomInButton = actionsManager.getZoomInPointAction();
        AbstractAction zoomOutButton = actionsManager.getZoomOutPointAction();

        JSeparator separator_1 = new JSeparator();
        JSeparator separator_2 = new JSeparator();

        add(selectButton);
        add(moveButton);

        add(separator_1);

        add(drawSquareButton);
        add(drawTriangleButton);
        add(drawCircleButton);
        add(drawHexagonButton);

        add(separator_2);

        add(zoomInButton);
        add(zoomOutButton);
    }
}
