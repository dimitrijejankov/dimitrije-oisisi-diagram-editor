package com.dimitrije.editor.models.editor_tree_model;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public abstract class EditorTreeNode implements MutableTreeNode {

    final ArrayList<EditorTreeNode> children;

    protected EditorTreeNode() {
        children = new ArrayList<EditorTreeNode>();
    }

    @Override
    public void insert(MutableTreeNode mutableTreeNode, int i) {
        if(!(mutableTreeNode instanceof EditorTreeNode))
            throw new RuntimeException("Not an instance of EditorTreeNode");
        children.add(i, (EditorTreeNode)mutableTreeNode);
    }

    @Override
    public void remove(int i) {
        children.remove(i);
    }

    @Override
    public void remove(MutableTreeNode mutableTreeNode) {
        if(mutableTreeNode instanceof EditorTreeNode)
            children.remove(mutableTreeNode);
    }

    @Override
    public TreeNode getChildAt(int i) {
        return children.get(i);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public int getIndex(TreeNode treeNode) {
        if(treeNode instanceof EditorTreeNode)
            return children.indexOf(treeNode);
        return -1;
    }

    @Override
    public Enumeration children() {
        return Collections.enumeration(children);
    }

    @Override
    public void setUserObject(Object o) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void removeFromParent() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setParent(MutableTreeNode mutableTreeNode) {
        throw new RuntimeException("Not implemented");
    }
}
