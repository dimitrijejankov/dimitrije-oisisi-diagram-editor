package com.dimitrije.editor.models;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.editor_tree_model.EditorTreeModel;

public class EditorModelManager {

    private static EditorModelManager instance = null;

    private final EditorTreeModel editorTreeModel;
    private EditorDiagramModel currentDiagramModel;

    private EditorModelManager() {
        editorTreeModel = new EditorTreeModel();
    }

    public static EditorModelManager getInstance(){
        if(instance == null){
            instance = new EditorModelManager();
        }
        return instance;
    }

    public EditorTreeModel getEditorTreeModel() {
        return editorTreeModel;
    }

    public EditorDiagramModel getCurrentDiagramModel() {
        return currentDiagramModel;
    }

    public void setCurrentDiagramModel(EditorDiagramModel currentDiagramModel) {
        this.currentDiagramModel = currentDiagramModel;
    }
}
