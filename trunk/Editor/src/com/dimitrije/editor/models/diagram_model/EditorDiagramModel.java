package com.dimitrije.editor.models.diagram_model;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class EditorDiagramModel extends java.util.Observable implements Serializable {

    transient CommandManager commandManager;

    ArrayList<EditorDiagramModelElement> elements;
    ArrayList<EditorDiagramModelElement> selectedElements;

    Point firstSelectionPoint;
    Point secondSelectionPoint;
    boolean isSelecting;

    Point currentPosition;
    Dimension diagramSize;
    double scalingFactor;

    public EditorDiagramModel() {
        firstSelectionPoint = new Point(0, 0);
        secondSelectionPoint = new Point(0, 0);
        currentPosition = new Point(0, 0);

        diagramSize = new Dimension(1000, 1000);
        scalingFactor = 1.0f;

        elements = new ArrayList<EditorDiagramModelElement>();
        selectedElements = new ArrayList<EditorDiagramModelElement>();

        commandManager = new CommandManager();
    }

    public double getScalingFactor() {
        return scalingFactor;
    }

    public Dimension getDiagramSize() {
        return diagramSize;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ArrayList<EditorDiagramModelElement> getElements() {
        return elements;
    }

    public ArrayList<EditorDiagramModelElement> getSelectedElements() {
        return selectedElements;
    }

    public Rectangle getSelectionBox() {

        int x = Math.min(firstSelectionPoint.x, secondSelectionPoint.x);
        int y = Math.min(firstSelectionPoint.y, secondSelectionPoint.y);
        int w = Math.abs(firstSelectionPoint.x - secondSelectionPoint.x);
        int h = Math.abs(firstSelectionPoint.y - secondSelectionPoint.y);

        if (isSelecting)
            return new Rectangle(x, y, w, h);
        else
            return new Rectangle(0, 0, 0, 0);
    }

    public EditorDiagramModelElement getElementAt(Point point) {

        for (EditorDiagramModelElement element : elements) {
            if (element.contains(point)) {
                return element;
            }
        }
        return null;
    }

    public AffineTransform getDiagramTransformation(){
        AffineTransform transform = new AffineTransform();
        transform.setToIdentity();
        transform.scale(scalingFactor, scalingFactor);
        transform.translate(-currentPosition.getX(), -currentPosition.getY());

        return transform;
    }

    public AffineTransform getDiagramInverseTransformation(){
        AffineTransform transform = new AffineTransform();
        transform.setToIdentity();
        transform.translate(currentPosition.getX(), currentPosition.getY());
        transform.scale(1/scalingFactor, 1/scalingFactor);

        return transform;
    }

    public boolean isSelecting() {
        return isSelecting;
    }

    public boolean isSelectedElementAt(Point point) {
        for (EditorDiagramModelElement element : selectedElements) {
            if (element.contains(point)) {
                return true;
            }
        }
        return false;
    }

    public boolean selectionHasArea() {
        return firstSelectionPoint.x != secondSelectionPoint.x && firstSelectionPoint.y != secondSelectionPoint.y;
    }

    public void setCurrentHorizontalPosition(int x) {
        currentPosition.x = x;
        modelHasChanged();
    }

    public void setCurrentVerticalPosition(int y) {
        currentPosition.y = y;
        modelHasChanged();
    }

    public void setFirstSelectionPoint(Point firstSelectionPoint) {
        this.firstSelectionPoint = firstSelectionPoint;
        setChanged();
        notifyObservers();
    }

    public void setSecondSelectionPoint(Point secondSelectionPoint) {
        this.secondSelectionPoint = secondSelectionPoint;
        setChanged();
        notifyObservers();
    }

    public void setIsSelecting(boolean value) {
        this.isSelecting = value;
        modelHasChanged();
    }

    public void removeSelectedElements() {
        if (!selectedElements.isEmpty()) {
            ArrayList<EditorDiagramModelElement> elementList = new ArrayList<EditorDiagramModelElement>(selectedElements);
            commandManager.Do(new DeselectCommand(this, selectedElements));
            commandManager.Do(new RemoveCommand(this, elementList));
        }
    }

    public void addElement(EditorDiagramModelElement element) {
        commandManager.Do(new AddElementsCommand(this, element));
    }

    public void selectElementAt(Point point, boolean deselectPrevious) {

        EditorDiagramModelElement element = getElementAt(point);
        if (element != null) {
            commandManager.Do(new SelectCommand(this, element, deselectPrevious));
        }

        modelHasChanged();
    }

    public void deselectAllElements() {
        if (!selectedElements.isEmpty()) {
            commandManager.Do(new DeselectCommand(this, selectedElements));
        }
    }

    public void applyTransform(Graphics2D graphics){
        graphics.scale(scalingFactor, scalingFactor);
        graphics.translate(-currentPosition.getX(), -currentPosition.getY());
    }

    public void applyInverseTransform(Graphics2D graphics){
        graphics.translate(currentPosition.getX(), currentPosition.getY());
        graphics.scale(1/scalingFactor, 1/scalingFactor);
    }

    public void zoomInCenter() {
        scalingFactor += 0.5;
        scalingFactor = scalingFactor > 3.0 ? 3.0 : scalingFactor;
        modelHasChanged();
    }

    public void zoomOutCenter() {
        scalingFactor -= 0.5;
        scalingFactor = scalingFactor < 0.5 ? 0.5 : scalingFactor;
        modelHasChanged();
    }

    public void zoomInPoint(Point point, Dimension drawPaneSize) {
        if(scalingFactor < 3.0){
            point.x = point.x - drawPaneSize.width / 2;
            point.y = point.y - drawPaneSize.height / 2;
            AffineTransform t = getDiagramInverseTransformation();
            t.transform(point, currentPosition);
            scalingFactor += 0.5;
            modelHasChanged();
        }
    }

    public void zoomOutPoint(Point point, Dimension drawPaneSize) {
        if(scalingFactor > 0.5){
            point.x = point.x - drawPaneSize.width / 2;
            point.y = point.y - drawPaneSize.height / 2;
            AffineTransform t = getDiagramInverseTransformation();
            t.transform(point, currentPosition);
            scalingFactor -= 0.5;
            modelHasChanged();
        }
    }

    public void moveSelectedElementsBy(Point vector) {

        for(EditorDiagramModelElement element : selectedElements){
            if (!element.canBeTranslated(vector)){
                return;
            }
        }

        if (commandManager.getLastCommand() instanceof MoveCommand){
            MoveCommand moveCommand = (MoveCommand) commandManager.getLastCommand();
            if (!moveCommand.isDoneMoving()) {
                moveCommand.accumulate(vector);
            }
            else {
                commandManager.Do(new MoveCommand(this, selectedElements, vector));
            }

        }
        else {
            commandManager.Do(new MoveCommand(this, selectedElements, vector));
        }
    }

    public void doneMovingSelectedElements(){
        if (commandManager.getLastCommand() instanceof MoveCommand){
            MoveCommand moveCommand = (MoveCommand) commandManager.getLastCommand();
            moveCommand.setDoneMoving();
        }
    }

    public void rotateSelectedElementsBy(double angle){
        if (!selectedElements.isEmpty()) {
            commandManager.Do(new RotateCommand(this, selectedElements, angle));
        }
    }

    public void scaleElement(EditorDiagramModelElement element,Rectangle rect, EditorDiagramModelElement.HandlePosition position){
        commandManager.Do(new ScaleCommand(this, element, rect, position));
    }

    public void boundPosition(Point boundingMaxPosition){
        currentPosition.x = Math.min(boundingMaxPosition.x, currentPosition.x);
        currentPosition.y = Math.min(boundingMaxPosition.y, currentPosition.y);
        currentPosition.x = Math.max(0, currentPosition.x);
        currentPosition.y = Math.max(0, currentPosition.y);
        modelHasChanged();
    }

    void modelHasChanged() {
        setChanged();
        notifyObservers(this);
    }

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        commandManager = new CommandManager();
        elements = new ArrayList<EditorDiagramModelElement>();
        selectedElements = new ArrayList<EditorDiagramModelElement>();
        firstSelectionPoint = new Point();
        secondSelectionPoint = new Point();
        isSelecting = false;
        currentPosition = new Point();
        scalingFactor = 1.0f;
        diagramSize = (Dimension)inputStream.readObject();

        int numberOfElements = inputStream.readInt();

        for (int i = 0; i < numberOfElements; ++i) {
            EditorDiagramModelElement element = (EditorDiagramModelElement)inputStream.readObject();
            element.setModel(this);
            elements.add(element);
        }

    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {

        outputStream.writeObject(diagramSize);
        outputStream.writeInt(elements.size());

        for (EditorDiagramModelElement element : elements) {
            outputStream.writeObject(element);
        }
    }

}
