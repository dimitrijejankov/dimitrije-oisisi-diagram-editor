package com.dimitrije.editor.actions;

import javax.swing.*;

public abstract class AbstractEditorAction extends AbstractAction {

    public AbstractEditorAction(String text, Icon icon, String description, int mnemonic, int eventKey) {
        super(text, icon);
        putValue(AbstractAction.SHORT_DESCRIPTION, description);
        putValue(AbstractAction.MNEMONIC_KEY, mnemonic);
        putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(mnemonic, eventKey));
    }

}
