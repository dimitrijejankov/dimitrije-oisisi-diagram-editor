package com.dimitrije.editor.models.editor_tree_model;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.views.window.EditorDiagramWindow;

import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.ArrayList;

public class EditorProjectTreeNode extends EditorTreeNode implements Serializable {

    String projectName = null;
    File file;

    public EditorProjectTreeNode(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public String toString() {
        return projectName;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    public ArrayList<EditorTreeNode> getDiagrams(){
        return children;
    }

    public String getProjectName() {
        return projectName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        projectName = (String)inputStream.readObject();
        int numberOfChildren = inputStream.readInt();

        for (int i = 0; i < numberOfChildren; ++i){
            EditorDiagramTreeNode node = (EditorDiagramTreeNode)inputStream.readObject();
            node.setParent(this);
            node.editorInternalWindow = new EditorDiagramWindow(node);
            children.add(node);
            EditorDiagramModel model = (EditorDiagramModel)inputStream.readObject();
            node.editorInternalWindow.setModel(model);
        }
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(projectName);
        outputStream.writeInt(children.size());

        for (EditorTreeNode node : children){
            if (node instanceof EditorDiagramTreeNode) {
                EditorDiagramTreeNode diagramTreeNode = (EditorDiagramTreeNode) node;
                outputStream.writeObject(diagramTreeNode);
                outputStream.writeObject(diagramTreeNode.editorInternalWindow.getModel());
            }
        }
    }
}
