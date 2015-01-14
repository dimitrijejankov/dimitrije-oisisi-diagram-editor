package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;
import com.dimitrije.editor.views.window.EditorDiagramDrawPane;
import com.dimitrije.editor.views.window.EditorWindowManager;

import java.awt.event.MouseEvent;

public class SingleSelectionState extends State {
    @Override
    public void mouseClicked(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        super.mouseClicked(e, editorDiagramModel, editorDiagramDrawPane);
        if (e.getClickCount() == 1) {
            editorDiagramModel.selectElementAt(e.getPoint(), true);
            EditorWindowManager.getInstance().getEditorStatusBar().update();
        }
        else if (e.getClickCount() == 2) {
            EditorDiagramModelElement element = editorDiagramModel.getElementAt(e.getPoint());
            if (element != null) {
                EditorDialogManager dialogManager = EditorDialogManager.getInstance();
                dialogManager.getElementPropertiesDialog().setCurrentElement(element);
                dialogManager.getElementPropertiesDialog().setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e, EditorDiagramModel editorDiagramModel, EditorDiagramDrawPane editorDiagramDrawPane) {
        super.mousePressed(e, editorDiagramModel, editorDiagramDrawPane);

        for(EditorDiagramModelElement element : editorDiagramModel.getSelectedElements()){
            EditorDiagramModelElement.HandlePosition handlePosition = element.isHandleAtPoint(e.getPoint());
            if (handlePosition != EditorDiagramModelElement.HandlePosition.NONE){
                GlobalStateManager.getInstance().pushAction(GlobalStateManager.Actions.RESIZE_PRESSED);
                if (GlobalStateManager.getInstance().getState() instanceof ResizeState){
                    ResizeState state = (ResizeState)GlobalStateManager.getInstance().getState();
                    state.element = element;
                    state.handlePosition = handlePosition;
                }

                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Select tool";
    }
}
