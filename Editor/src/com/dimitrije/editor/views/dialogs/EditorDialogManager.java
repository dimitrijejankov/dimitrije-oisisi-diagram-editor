package com.dimitrije.editor.views.dialogs;

import com.dimitrije.editor.views.window.EditorWindow;

public class EditorDialogManager {

    private static EditorDialogManager dialogManager;

    private final AboutDialog aboutDialog;
    private final NewProjectDialog newProjectDialog;
    private final NewDiagramDialog newDiagramDialog;
    private final ElementPropertiesDialog elementPropertiesDialog;

    private EditorDialogManager() {
        aboutDialog = new AboutDialog(EditorWindow.getInstance());
        newProjectDialog = new NewProjectDialog(EditorWindow.getInstance());
        newDiagramDialog = new NewDiagramDialog(EditorWindow.getInstance());
        elementPropertiesDialog = new ElementPropertiesDialog(EditorWindow.getInstance());
    }

    public static EditorDialogManager getInstance()
    {
        if (dialogManager == null)
            dialogManager = new EditorDialogManager();

        return dialogManager;
    }

    public AboutDialog getAboutDialog() {
        return aboutDialog;
    }

    public NewProjectDialog getNewProjectDialog() {
        return newProjectDialog;
    }

    public NewDiagramDialog getNewDiagramDialog() {
        return newDiagramDialog;
    }

    public ElementPropertiesDialog getElementPropertiesDialog() {
        return elementPropertiesDialog;
    }
}
