package com.dimitrije.editor.actions.dialog;

import com.dimitrije.editor.actions.AbstractEditorAction;
import com.dimitrije.editor.views.dialogs.EditorDialogManager;

import java.awt.event.ActionEvent;

public class CloseElementPropertiesDialog extends AbstractEditorAction {

    public CloseElementPropertiesDialog() {
        super("Close",
                null,
                "Closes this dialog.",
                0,
                0
        );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EditorDialogManager.getInstance().getElementPropertiesDialog().setVisible(false);
    }

}