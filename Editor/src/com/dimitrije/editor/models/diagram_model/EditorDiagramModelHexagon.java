package com.dimitrije.editor.models.diagram_model;

import java.awt.*;

public class EditorDiagramModelHexagon extends EditorDiagramModelElement {

    public EditorDiagramModelHexagon(String name, String description, Color color, int x, int y, int w, int h) {

        super(name, description, color);
        int x_values[] = {
                x,
                x + w / 3,
                x + 2 * w / 3,
                x + w,
                x + w,
                x + 2 * w / 3,
                x + w / 3,
                x
        };

        int y_values[] = {
                y + h / 3,
                y,
                y,
                y + h / 3,
                y + 2*h/3,
                y + h,
                y + h,
                y + 2*h/3
        };

        shape = new Polygon(x_values, y_values, 8);
    }

    @Override
    public String getType() {
        return "Hexagon";
    }
}
