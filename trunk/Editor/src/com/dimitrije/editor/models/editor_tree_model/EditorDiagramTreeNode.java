package com.dimitrije.editor.models.editor_tree_model;

import com.dimitrije.editor.views.window.EditorDiagramWindow;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EditorDiagramTreeNode extends EditorTreeNode implements Serializable {

    String diagramName;
    EditorProjectTreeNode parent;
    EditorDiagramWindow editorInternalWindow;

    public EditorDiagramTreeNode(String documentName, EditorProjectTreeNode project) {
        diagramName = documentName;
        parent = project;
        editorInternalWindow = null;
    }

    public EditorDiagramWindow getEditorInternalWindow() {
        return editorInternalWindow;
    }

    public void setEditorInternalWindow(EditorDiagramWindow value){
        editorInternalWindow = value;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String toString() {
        return diagramName;
    }

    @Override
    public EditorProjectTreeNode getParent() {
        return parent;
    }

    public void setParent(EditorProjectTreeNode parent) {
        this.parent = parent;
    }

    @Override
	public void removeFromParent() {
		children.remove(this);
	}

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        diagramName = (String)inputStream.readObject();
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(diagramName);
    }

}
