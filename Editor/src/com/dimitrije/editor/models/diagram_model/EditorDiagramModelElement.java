package com.dimitrije.editor.models.diagram_model;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

public abstract class EditorDiagramModelElement implements Serializable {

    protected String name;
    protected String description;
    protected Shape shape;
    protected Color color;
    transient protected EditorDiagramModel model;

    protected boolean selected;

    protected EditorDiagramModelElement(String description, String name, Color color) {
        this.description = description;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();

    public String getDescription() {
        return description;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public boolean isSelected() {
        return selected;
    }

    void setModel(EditorDiagramModel value){
        model = value;
    }

    public void setName(String value) {
        name = value;
        model.modelHasChanged();
    }

    public void setDescription(String value) {
        description = value;
        model.modelHasChanged();
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setColor(Color color) {
        this.color = color;
        model.modelHasChanged();
    }

    public boolean contains(Point point){

        AffineTransform af = model.getDiagramTransformation();

        Shape s = af.createTransformedShape(shape);
        return s.contains(point);
    }

    public void rotate(double angle){

        AffineTransform transform = new AffineTransform();
        Rectangle bounds = shape.getBounds();
        transform.rotate(angle, bounds.getX() + bounds.width/2, bounds.getY() + bounds.height/2);
        shape = transform.createTransformedShape(shape);
        model.modelHasChanged();
    }

    public void translate(Point point){
        AffineTransform transform = new AffineTransform();
        transform.translate(point.x, point.y);
        shape = transform.createTransformedShape(shape);
        model.modelHasChanged();
    }

    public void scale(Rectangle rect, HandlePosition position) {

        if (rect.x + rect.width > model.getDiagramSize().width ||
            rect.y + rect.height > model.getDiagramSize().height ||
            rect.x < 0 ||
            rect.y < 0) {
            return;
        }

        double pivotX = 0;
        double pivotY = 0;
        double scalingFactorX = 0;
        double scalingFactorY = 0;

        Rectangle bounds = shape.getBounds();

        if (position == HandlePosition.BOTTOM_RIGHT) {
            pivotX = bounds.getX();
            pivotY = bounds.getY();
            scalingFactorX = rect.x - bounds.x < 0 ? -rect.getWidth() : rect.getWidth();
            scalingFactorY = rect.y - bounds.y < 0 ? -rect.getHeight() : rect.getHeight();
        }
        else if (position == HandlePosition.TOP_LEFT) {
            pivotX = bounds.getX() + bounds.getWidth();
            pivotY = bounds.getY() + bounds.getHeight();
            scalingFactorX = rect.x - pivotX < 0 ? rect.getWidth() : -rect.getWidth();
            scalingFactorY = rect.y - pivotY < 0 ? rect.getHeight() : -rect.getHeight();
        }
        else if (position == HandlePosition.BOTTOM_LEFT) {
            pivotX = bounds.getX() + bounds.getWidth();
            pivotY = bounds.getY();
            scalingFactorX = rect.x - pivotX < 0 ? rect.getWidth() : -rect.getWidth();
            scalingFactorY = rect.y - pivotY == 0 ? rect.getHeight() : -rect.getHeight();
        }
        else if (position == HandlePosition.TOP_RIGHT) {
            pivotX = bounds.getX();
            pivotY = bounds.getY() + bounds.getHeight();
            scalingFactorX = rect.x - pivotX == 0 ? rect.getWidth() : -rect.getWidth();
            scalingFactorY = rect.y - pivotY < 0 ? rect.getHeight() : -rect.getHeight();
        }
        else if (position == HandlePosition.LEFT_MIDDLE) {
            pivotX = bounds.getX() + bounds.getWidth();
            pivotY = bounds.getY() + bounds.getHeight()/2;
            scalingFactorX = rect.x - pivotX < 0 ? rect.getWidth() : -rect.getWidth();
            scalingFactorY = bounds.getHeight();
        }
        else if (position == HandlePosition.BOTTOM_MIDDLE) {
            pivotX = bounds.getX() + bounds.getWidth()/2;
            pivotY = bounds.getY();
            scalingFactorX = bounds.getWidth();
            scalingFactorY = rect.y - pivotY == 0 ? rect.getHeight() : -rect.getHeight();
        }
        else if (position == HandlePosition.RIGHT_MIDDLE) {
            pivotX = bounds.getX();
            pivotY = bounds.getY() + bounds.getHeight()/2;
            scalingFactorX = rect.x - pivotX == 0 ? rect.getWidth() : -rect.getWidth();
            scalingFactorY = bounds.getHeight();
        }
        else if (position == HandlePosition.TOP_MIDDLE) {
            pivotX = bounds.getX() + bounds.getWidth()/2;
            pivotY = bounds.getY() + bounds.getHeight();
            scalingFactorX = bounds.getWidth();
            scalingFactorY = rect.y - pivotY < 0 ? rect.getHeight() : -rect.getHeight();
        }

        AffineTransform transform = new AffineTransform();
        transform.translate(pivotX, pivotY);
        transform.scale(scalingFactorX/bounds.getWidth(), scalingFactorY/bounds.getHeight());
        transform.translate(-pivotX, -pivotY);
        shape = transform.createTransformedShape(shape);

        model.modelHasChanged();
    }

    public void transformToDiagramSpace(EditorDiagramModel model){
        AffineTransform af = model.getDiagramInverseTransformation();
        shape = af.createTransformedShape(shape);
    }

    public boolean canBeTranslated(Point point) {

        Rectangle bounds = shape.getBounds();
        int xMax = bounds.x + bounds.width + point.x;
        int yMax = bounds.y + bounds.height + point.y;

        int xMin = bounds.x + point.x;
        int yMin = bounds.y + point.y;

        return xMax < model.getDiagramSize().width && yMax < model.getDiagramSize().height && xMin > 0 && yMin > 0;
    }

    public HandlePosition isHandleAtPoint(Point point){

        Rectangle rect = shape.getBounds();

        point.x = (int)(point.x/model.getScalingFactor());
        point.y = (int)(point.y/model.getScalingFactor());


        Point topLeft = new Point(rect.getLocation().x - model.getCurrentPosition().x, rect.getLocation().y - model.getCurrentPosition().y);
        Point topRight = new Point(rect.getLocation().x + rect.width - model.getCurrentPosition().x, rect.getLocation().y - model.getCurrentPosition().y);
        Point bottomLeft = new Point(rect.getLocation().x - model.getCurrentPosition().x, rect.getLocation().y + rect.height - model.getCurrentPosition().y);
        Point bottomRight = new Point(rect.getLocation().x + rect.width - model.getCurrentPosition().x, rect.getLocation().y + rect.height - model.getCurrentPosition().y);

        Point topMiddle = new Point(rect.getLocation().x + rect.width / 2  - model.getCurrentPosition().x, rect.getLocation().y - model.getCurrentPosition().y);
        Point bottomMiddle = new Point(rect.getLocation().x + rect.width / 2  - model.getCurrentPosition().x, rect.getLocation().y + rect.height - model.getCurrentPosition().y);
        Point leftMiddle = new Point(rect.getLocation().x  - model.getCurrentPosition().x, rect.getLocation().y + rect.height / 2 - model.getCurrentPosition().y);
        Point rightMiddle = new Point(rect.getLocation().x + rect.width  - model.getCurrentPosition().x, rect.getLocation().y + rect.height / 2 - model.getCurrentPosition().y);

        if(point.distance(topLeft) < 3.5*model.getScalingFactor()){
            return HandlePosition.TOP_LEFT;
        }
        else if(point.distance(topRight) < 3.5*model.getScalingFactor()) {
            return  HandlePosition.TOP_RIGHT;
        }
        else if(point.distance(bottomLeft) < 3.5*model.getScalingFactor()) {
            return HandlePosition.BOTTOM_LEFT;
        }
        else if(point.distance(bottomRight) < 3.5*model.getScalingFactor()) {
            return HandlePosition.BOTTOM_RIGHT;
        }
        else if(point.distance(topMiddle) < 3.5*model.getScalingFactor()) {
            return HandlePosition.TOP_MIDDLE;
        }
        else if(point.distance(bottomMiddle) < 3.5*model.getScalingFactor()) {
            return HandlePosition.BOTTOM_MIDDLE;
        }
        else if(point.distance(leftMiddle) < 3.5*model.getScalingFactor()) {
            return HandlePosition.LEFT_MIDDLE;
        }
        else if(point.distance(rightMiddle) < 3.5*model.getScalingFactor()) {
            return HandlePosition.RIGHT_MIDDLE;
        }

        return HandlePosition.NONE;
    }

    public enum HandlePosition {
        NONE,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP_MIDDLE,
        BOTTOM_MIDDLE,
        LEFT_MIDDLE,
        RIGHT_MIDDLE
    }
}
