package com.dimitrije.editor.models.editor_tree_model;

import javax.swing.tree.TreeNode;

public class EditorWorkspaceTreeNode extends EditorTreeNode {

    public EditorWorkspaceTreeNode() {
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public String toString() {
        return "Workspace";
    }

    @Override
    public TreeNode getParent() {
        return null;
    }
}
