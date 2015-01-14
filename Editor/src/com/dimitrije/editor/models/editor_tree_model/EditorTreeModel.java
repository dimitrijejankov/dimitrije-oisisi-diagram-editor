package com.dimitrije.editor.models.editor_tree_model;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;

import com.dimitrije.editor.views.window.EditorWindowManager;

public class EditorTreeModel extends DefaultTreeModel {

    private EditorProjectTreeNode currentProjectNode;
    private EditorDiagramTreeNode currentDiagramNode;

    public EditorTreeModel() {
        super(new EditorWorkspaceTreeNode());
    }

    @Override
    public EditorWorkspaceTreeNode getRoot() {
        return (EditorWorkspaceTreeNode)super.getRoot();
    }

    public void addProject(EditorProjectTreeNode projectNode) {
        getRoot().insert(projectNode, 0);
        SwingUtilities.updateComponentTreeUI(EditorWindowManager.getInstance().getEditorProjectTree());
    }

    public void addDiagram(EditorDiagramTreeNode diagramNode) {
        currentProjectNode.insert(diagramNode, 0);
        SwingUtilities.updateComponentTreeUI(EditorWindowManager.getInstance().getEditorProjectTree());
    }

    public void setCurrentProject(EditorProjectTreeNode projectNode) {
        if(projectNode == null){
            currentProjectNode = null;
        } else if(currentProjectNode != projectNode){
            currentProjectNode = projectNode;
        }
    }

    public void setCurrentDiagram(EditorDiagramTreeNode diagramNode) {

        if(diagramNode == null) {
            currentDiagramNode = null;
        } else if(diagramNode.getParent() == currentProjectNode){
            currentDiagramNode = diagramNode;
        } else {
            currentProjectNode = diagramNode.getParent();
        }
    }

    public boolean isDiagramNameUnique(String name, EditorProjectTreeNode projectTreeNode){

        for(int i = 0; i < projectTreeNode.getChildCount(); ++i){
            if(projectTreeNode.getChildAt(i).toString().equals(name)){
                return false;
            }
        }

        return true;
    }

    public boolean isProjectNameUnique(String name){

        for(int i = 0; i < getRoot().getChildCount(); ++i){
            if(getRoot().getChildAt(i).toString().equals(name)){
                return false;
            }
        }

        return true;
    }

    public EditorProjectTreeNode getCurrentProject() {
        return currentProjectNode;
    }

    public EditorDiagramTreeNode getCurrentDiagram() {
        return currentDiagramNode;
    }

}
