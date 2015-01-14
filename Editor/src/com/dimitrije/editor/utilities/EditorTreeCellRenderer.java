package com.dimitrije.editor.utilities;

import com.dimitrije.editor.models.editor_tree_model.EditorDiagramTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorProjectTreeNode;
import com.dimitrije.editor.models.editor_tree_model.EditorWorkspaceTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class EditorTreeCellRenderer extends DefaultTreeCellRenderer {

    private final Icon workspaceIcon;
    private final Icon projectIcon;
    private final Icon diagramIcon;

    public EditorTreeCellRenderer() {
        workspaceIcon = new ImageIcon("img/icons16/new_workspace_icon.png");
        projectIcon = new ImageIcon("img/icons16/new_project_icon.png");
        diagramIcon = new ImageIcon("img/icons16/new_diagram_icon.png");
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object node, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, node, sel, expanded, leaf, row, hasFocus);

        if(node instanceof EditorDiagramTreeNode)
            setIcon(diagramIcon);
        else if(node instanceof EditorProjectTreeNode)
            setIcon(projectIcon);
        else if(node instanceof EditorWorkspaceTreeNode)
            setIcon(workspaceIcon);

        return this;
    }
}
