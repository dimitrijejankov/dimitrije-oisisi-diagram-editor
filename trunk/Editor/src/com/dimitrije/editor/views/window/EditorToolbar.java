package com.dimitrije.editor.views.window;

import com.dimitrije.editor.actions.ActionsManager;

import javax.swing.*;
import java.awt.*;

public class EditorToolbar extends JToolBar {

    public EditorToolbar() {

        super();
        ActionsManager actionsManager = ActionsManager.getInstance();

        AbstractAction new_project_button = actionsManager.getNewProjectDialogAction();
        AbstractAction open_button = actionsManager.getOpenAction();
        AbstractAction save_button = actionsManager.getSaveAction();

        AbstractAction new_diagram_button = actionsManager.getNewDiagramDialogAction();
        AbstractAction print_button = actionsManager.getPrintAction();

        AbstractAction cut_button = actionsManager.getCutAction();
        AbstractAction copy_button = actionsManager.getCopyAction();
        AbstractAction paste_button = actionsManager.getPasteAction();
        AbstractAction undo_button = actionsManager.getUndoAction();
        AbstractAction redo_button = actionsManager.getRedoAction();

        AbstractAction next_diagram = actionsManager.getNextDiagramAction();
        AbstractAction previous_diagram = actionsManager.getPreviousDiagramAction();
        AbstractAction zoom_in_button = actionsManager.getZoomInAction();
        AbstractAction zoom_out_button = actionsManager.getZoomOutAction();
        AbstractAction zoom_normal_button = actionsManager.getZoomNormalAction();

        AbstractAction tile_windows_vertically_button = actionsManager.getTileWindowsVertically();
        AbstractAction tile_windows_horizontally_button = actionsManager.getTileWindowsHorizontally();
        AbstractAction cascade_windows_button = actionsManager.getCascadeWindowsAction();

        JSeparator separator_1 = new Separator(new Dimension(32, 32));
        JSeparator separator_2 = new Separator(new Dimension(32, 32));
        JSeparator separator_3 = new Separator(new Dimension(32, 32));
        JSeparator separator_4 = new Separator(new Dimension(32, 32));


        add(new_project_button);
        add(open_button);
        add(save_button);
        add(separator_1);

        add(new_diagram_button);
        add(print_button);

        add(separator_2);

        add(cut_button);
        add(copy_button);
        add(paste_button);
        add(undo_button);
        add(redo_button);

        add(separator_3);
        add(next_diagram);
        add(previous_diagram);
        add(zoom_in_button);
        add(zoom_out_button);
        add(zoom_normal_button);

        add(separator_4);

        add(tile_windows_horizontally_button);
        add(tile_windows_vertically_button);
        add(cascade_windows_button);
    }
}
