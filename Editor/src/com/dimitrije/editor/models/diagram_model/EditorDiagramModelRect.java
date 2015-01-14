package com.dimitrije.editor.models.diagram_model;

import java.awt.*;

public class EditorDiagramModelRect extends EditorDiagramModelElement {

    public EditorDiagramModelRect(String name, String description, Color color, int x, int y, int w, int h) {
        super(name, description, color);
        shape = new Rectangle(x, y, w, h);
    }

    @Override
    public String getType() {
        return "Rectangle";
    }
}
