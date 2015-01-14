package com.dimitrije.editor.views.window;

import com.dimitrije.editor.controller.EditorTreeListener;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.utilities.EditorTreeCellRenderer;

import javax.swing.*;
import javax.swing.tree.TreeSelectionModel;

public class EditorProjectTree extends JTree {

    public EditorProjectTree() {
        super(EditorModelManager.getInstance().getEditorTreeModel());
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        setCellRenderer(new EditorTreeCellRenderer());
        EditorWindowManager.getInstance().setEditorProjectTree(this);

        addTreeSelectionListener(new EditorTreeListener(this));
    }
}
