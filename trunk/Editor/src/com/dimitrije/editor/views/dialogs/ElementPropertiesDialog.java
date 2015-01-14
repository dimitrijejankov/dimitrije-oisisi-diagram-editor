package com.dimitrije.editor.views.dialogs;

import com.dimitrije.editor.actions.ActionsManager;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElementPropertiesDialog extends JDialog {

    private final TextField elementNameField = new TextField(10);
    private final TextField elementDescriptionField = new TextField(10);
    private final JButton colorPicker;
    private Color currentColor;

    public ElementPropertiesDialog(final Frame owner) {
        super(owner);
        setSize(420, 220);
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        ActionsManager actionsManager = ActionsManager.getInstance();

        JLabel elementNameText = new JLabel("Input the element name :");
        JLabel elementDescriptionText = new JLabel("Input the element description :");

        colorPicker = new JButton();
        currentColor = Color.blue;

        colorPicker.setBackground(currentColor);
        colorPicker.setForeground(new Color(255 - currentColor.getRed(), 255 - currentColor.getGreen(), 255 - currentColor.getBlue()));
        colorPicker.setText("Click to change the color");

        colorPicker.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentColor = JColorChooser.showDialog(owner, "Choose Element Color", currentColor);
                colorPicker.setBackground(currentColor);
                colorPicker.setForeground(new Color(255 - currentColor.getRed(), 255 - currentColor.getGreen(), 255 - currentColor.getBlue()));
            }
        });

        JButton createButton = new JButton("Change");
        JButton cancelButton = new JButton("Cancel");


        createButton.setAction(actionsManager.getChangeElementPropertiesAction());
        cancelButton.setAction(actionsManager.getCloseElementPropertiesDialog());

        Object[] array = { elementNameText, elementNameField, elementDescriptionText, elementDescriptionField, colorPicker };
        Object[] options = { createButton, cancelButton };

        JOptionPane optionPane = new JOptionPane(array,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                options[0]);

        setContentPane(optionPane);
    }

    public String getElementName(){
        return elementNameField.getText();
    }

    public String getElementDescription(){
        return elementDescriptionField.getText();
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentElement(EditorDiagramModelElement value) {
        ActionsManager.getInstance().getChangeElementPropertiesAction().setCurrentElement(value);
        elementNameField.setText(value.getName());
        elementDescriptionField.setText(value.getDescription());
        currentColor = value.getColor();
        colorPicker.setBackground(currentColor);
        colorPicker.setForeground(new Color(255 - currentColor.getRed(), 255 - currentColor.getGreen(), 255 - currentColor.getBlue()));
    }

}
