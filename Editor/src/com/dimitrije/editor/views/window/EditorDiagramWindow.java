package com.dimitrije.editor.views.window;

import com.dimitrije.editor.controller.EditorInternalComponentAdapter;
import com.dimitrije.editor.controller.EditorInternalWindowAdapter;
import com.dimitrije.editor.controller.EditorWindowHorizontalListener;
import com.dimitrije.editor.controller.EditorWindowVerticalListener;
import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.editor_tree_model.EditorDiagramTreeNode;
import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;

public class EditorDiagramWindow extends JInternalFrame {

    final EditorDiagramTreeNode diagramTreeNode;
    final EditorDiagramDrawPane editorDiagramDrawPane;
    EditorDiagramModel editorDiagramModel;

    final EditorWindowHorizontalListener editorWindowHorizontalListener;
    final EditorWindowVerticalListener editorWindowVerticalListener;

    final EditorScrollBar verticalBar;
    final EditorScrollBar horizontalBar;

    public EditorDiagramWindow(EditorDiagramTreeNode node) {

        editorDiagramDrawPane = new EditorDiagramDrawPane();
        diagramTreeNode = node;

        verticalBar = new EditorScrollBar(JScrollBar.VERTICAL, editorDiagramDrawPane);
        horizontalBar = new EditorScrollBar(JScrollBar.HORIZONTAL, editorDiagramDrawPane);

        editorWindowVerticalListener = new EditorWindowVerticalListener(verticalBar, editorDiagramDrawPane);
        editorWindowHorizontalListener = new EditorWindowHorizontalListener(horizontalBar, editorDiagramDrawPane);

        verticalBar.addAdjustmentListener(editorWindowVerticalListener);
        horizontalBar.addAdjustmentListener(editorWindowHorizontalListener);

        node.setEditorInternalWindow(this);

        setTitle(node.getParent().toString() + " :" + node.toString());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setClosable(true);
        setResizable(true);

        setSize(300, 300);
        setVisible(true);

        add(editorDiagramDrawPane, BorderLayout.CENTER);
        add(verticalBar, BorderLayout.EAST);
        add(horizontalBar, BorderLayout.SOUTH);

        addInternalFrameListener(new EditorInternalWindowAdapter(this));
        addComponentListener(new EditorInternalComponentAdapter(verticalBar,horizontalBar,editorDiagramDrawPane));
    }

    public EditorDiagramDrawPane getEditorDiagramDrawPane() {
        return editorDiagramDrawPane;
    }

    public EditorDiagramTreeNode getDiagramTreeNode() {
        return diagramTreeNode;
    }

    public void setSelected(boolean selected){
        try {
            super.setSelected(selected);
        }
        catch (java.beans.PropertyVetoException e) {
            System.out.println("Failed to bring internal frame to focus");
        }
    }

    public TreePath getTreePath(){
        Object[] path = {EditorModelManager.getInstance().getEditorTreeModel().getRoot(), diagramTreeNode.getParent(), diagramTreeNode};
        return new TreePath(path);
    }

    public TreePath getParentTreePath(){
        Object[] path = {EditorModelManager.getInstance().getEditorTreeModel().getRoot(), diagramTreeNode.getParent()};
        return new TreePath(path);
    }

    public void setModel(EditorDiagramModel editorDiagramModel) {
        this.editorDiagramModel = editorDiagramModel;
        editorDiagramDrawPane.setModel(editorDiagramModel);
    }

    public EditorDiagramModel getModel() {
        return editorDiagramModel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        editorDiagramDrawPane.repaint();
        super.paintComponent(g);
    }
}
