package com.dimitrije.editor.views.window;

import com.dimitrije.editor.models.EditorModelManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.utilities.global_state_manager.GlobalStateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class EditorStatusBar extends JPanel {

    final Label currentState;
    final Label currentElementType;
    final Label currentElementName;
    final Label currentElementPosition;
    final Label currentElementDimensions;

    public EditorStatusBar() {

        setLayout(new GridLayout(1,5));
        EditorWindowManager.getInstance().setEditorStatusBar(this);

        currentState = new Label("");
        currentElementType = new Label("Element type :");
        currentElementName = new Label("Element name :");
        currentElementPosition = new Label("Element position :");
        currentElementDimensions = new Label("Element dimensions :");

        add(currentState);
        add(currentElementName);
        add(currentElementType);
        add(currentElementPosition);
        add(currentElementDimensions);

    }

    public void update() {


        EditorDiagramModel model = EditorModelManager.getInstance().getCurrentDiagramModel();
        if(model != null) {

            ArrayList<EditorDiagramModelElement> selectedElements = model.getSelectedElements();

            if (selectedElements.size() == 1) {

                currentElementName.setText("Element name :" + selectedElements.get(0).getName());
                currentElementType.setText("Element type :" + selectedElements.get(0).getType());
                Rectangle bounds = selectedElements.get(0).getShape().getBounds();

                currentElementPosition.setText("Element position :" + bounds.getLocation().x + ", " + bounds.getLocation().y);
                currentElementDimensions.setText("Element dimensions :" + bounds.getWidth() + ", " + bounds.getHeight());

            } else {

                currentElementName.setText("Element name :");
                currentElementType.setText("Element type :");
                currentElementPosition.setText("Element position :");
                currentElementDimensions.setText("Element dimensions :");

            }
        }

        currentState.setText("Current state : " + GlobalStateManager.getInstance().getCurrentStateName());

    }
}
