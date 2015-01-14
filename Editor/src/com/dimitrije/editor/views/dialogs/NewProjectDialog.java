package com.dimitrije.editor.views.dialogs;

import com.dimitrije.editor.actions.ActionsManager;

import javax.swing.*;
import java.awt.*;

public class NewProjectDialog extends JDialog {

    private final TextField projectNameTextField = new TextField(10);

    public NewProjectDialog(Frame owner) {
        super(owner);
        setSize(420, 150);
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        ActionsManager actionsManager = ActionsManager.getInstance();

        JLabel textLabel = new JLabel("Input the project name :");
        JButton createButton = new JButton("Create");
        JButton cancelButton = new JButton("Cancel");

        createButton.setAction(actionsManager.getNewProjectAction());
        cancelButton.setAction(actionsManager.getCloseNewProjectDialogAction());

        Object[] array = { textLabel, projectNameTextField };
        Object[] options = { createButton, cancelButton };

        JOptionPane optionPane = new JOptionPane(array,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                options[0]);

        setContentPane(optionPane);
    }

    public String getTextFieldValue(){
        return projectNameTextField.getText();
    }
}
