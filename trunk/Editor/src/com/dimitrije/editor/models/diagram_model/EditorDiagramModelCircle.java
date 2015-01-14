package com.dimitrije.editor.models.diagram_model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EditorDiagramModelCircle extends EditorDiagramModelElement {

    public EditorDiagramModelCircle(String name, String description, Color color, int x, int y, int w, int h) {
        super(name, description, color);
        shape = new Ellipse2D.Double(x,y,w,h);
    }

    @Override
    public String getType() {
        return "Circle";
    }
}
