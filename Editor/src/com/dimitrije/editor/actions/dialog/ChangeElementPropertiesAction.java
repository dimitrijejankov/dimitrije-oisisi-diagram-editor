package com.dimitrije.editor.actions.dialog;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;

import java.awt.event.ActionEvent;

public class ChangeElementPropertiesAction extends AbstractEditorAction {

    EditorDiagramModel model;
    EditorDiagramModelElement currentElement;

    public ChangeElementPropertiesAction() {
        super("Change",
                null,
                "Changes the properties of an element.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        EditorDialogManager dialogManager = EditorDialogManager.getInstance();

        currentElement.setName(dialogManager.getElementPropertiesDialog().getElementName());
        currentElement.setDescription(dialogManager.getElementPropertiesDialog().getElementDescription());
        currentElement.setColor(dialogManager.getElementPropertiesDialog().getCurrentColor());

        dialogManager.getElementPropertiesDialog().setVisible(false);
    }

    public void setCurrentElement(EditorDiagramModelElement value) {
        this.currentElement = value;
    }
}