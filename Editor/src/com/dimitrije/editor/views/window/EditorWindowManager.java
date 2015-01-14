package com.dimitrije.editor.views.window;

public class EditorWindowManager {

    private static EditorWindowManager instance;

    private EditorWorkPane editorWorkPane;
    private EditorProjectTree editorProjectTree;
    private EditorStatusBar editorStatusBar;

    private EditorWindowManager() {}

    public static EditorWindowManager getInstance() {
        if(instance == null)
            instance = new EditorWindowManager();
        return instance;
    }

    public EditorWorkPane getEditorWorkPane() {
        return editorWorkPane;
    }

    public void setEditorWorkPane(EditorWorkPane value) {
        editorWorkPane = value;
    }

    public EditorProjectTree getEditorProjectTree() {
        return editorProjectTree;
    }

    public void setEditorProjectTree(EditorProjectTree editorProjectTree) {
        this.editorProjectTree = editorProjectTree;
    }

    public EditorStatusBar getEditorStatusBar() {
        return editorStatusBar;
    }

    public void setEditorStatusBar(EditorStatusBar editorStatusBar) {
        this.editorStatusBar = editorStatusBar;
    }
}
