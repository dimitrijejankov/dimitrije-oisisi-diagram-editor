package com.dimitrije.editor.models.diagram_model;

import java.awt.*;

public class EditorDiagramModelTriangle extends EditorDiagramModelElement {

    public EditorDiagramModelTriangle(String name, String description, Color color, int x, int y, int w, int h) {
        super(name, description, color);
        int x_values[] = { x + w / 2, x + w, x};
        int y_values[] = { y, y + h, y + h };

        shape = new Polygon(x_values, y_values, 3);
    }

    @Override
    public String getType() {
        return "Triangle";
    }
}
