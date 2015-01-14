package com.dimitrije.editor.models.diagram_model;


public abstract class Command {

    abstract void perform();
    abstract void rollback();

}
