package com.dimitrije.editor.views.window;

import com.dimitrije.editor.controller.EditorDiagramDrawPaneMouseAdapter;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModelElement;
import com.dimitrije.editor.utilities.global_state_manager.*;
import com.dimitrije.editor.models.diagram_model.EditorDiagramModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EditorDiagramDrawPane extends JPanel implements Observer {

    private EditorDiagramModel model;
    private final BasicStroke selectionStroke;
    private final BasicStroke normalStroke;
    private final BasicStroke handleStroke;

    public EditorDiagramDrawPane() {
        setBackground(Color.gray);

        float dash[] = { 10.0f };
        float dashHandle[] = { 5.0f };
        selectionStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        handleStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dashHandle, 0.0f);
        normalStroke = new BasicStroke(1.3f);
    }

    public void setModel(EditorDiagramModel value) {
        model = value;
        model.addObserver(this);
        EditorDiagramDrawPaneMouseAdapter adapter = new EditorDiagramDrawPaneMouseAdapter(model, this);
        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }

    public EditorDiagramModel getModel() {
        return model;
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setRenderingHints(rh);

        paintBackground(graphics2D);
        paintElements(graphics2D);
        paintSelection(graphics2D);
        paintHandles(graphics2D);
    }

    private void paintBackground(Graphics2D g) {
        g.setColor(Color.white);
        model.applyTransform(g);
        g.fillRect(0,0, model.getDiagramSize().width, model.getDiagramSize().height);
    }

    private void paintElements(Graphics2D g) {

        g.setStroke(normalStroke);


        for(EditorDiagramModelElement element : model.getElements()){

            if(element.isSelected())
                g.setColor(element.getColor().darker());
            else
                g.setColor(element.getColor());

            g.draw(element.getShape());
        }
    }

    private void paintSelection(Graphics2D g){
        g.setColor(Color.black);
        model.applyInverseTransform(g);

        Rectangle selectionBox = model.getSelectionBox();
        State state = GlobalStateManager.getInstance().getState();

        if(state instanceof DrawCircleState)
            paintCircle(selectionBox, g);
        else if(state instanceof DrawRectangleState) {
            paintRectangle(selectionBox, g);
        }
        else if(state instanceof DrawTriangleState){
            paintTriangle(selectionBox, g);
        }
        else if(state instanceof  DrawHexagonState){
            paintHexagon(selectionBox, g);
        }
        else if(state instanceof SingleSelectionState || state instanceof SelectAdditionState) {
            paintSelectionBox(selectionBox, g);
        }
        else if(state instanceof ResizeState) {
            g.setColor(Color.RED);
            paintRectangle(selectionBox, g);
        }
    }

    private void paintCircle(Rectangle selectionBox, Graphics2D g){
        g.setStroke(normalStroke);
        g.drawOval(selectionBox.x, selectionBox.y, selectionBox.width, selectionBox.height);
    }

    private void paintRectangle(Rectangle selectionBox, Graphics2D g){
        g.setStroke(normalStroke);
        g.drawRect(selectionBox.x, selectionBox.y, selectionBox.width, selectionBox.height);
    }

    private void paintTriangle(Rectangle selectionBox, Graphics2D g){
        int x[] = { selectionBox.x + selectionBox.width / 2, selectionBox.x + selectionBox.width, selectionBox.x};
        int y[] = { selectionBox.y, selectionBox.y + selectionBox.height, selectionBox.y + selectionBox.height };

        g.setStroke(normalStroke);
        g.drawPolygon(x, y, 3);
    }

    private void paintHexagon(Rectangle selectionBox, Graphics2D g){

        int x = selectionBox.x;
        int y = selectionBox.y;
        int w = selectionBox.width;
        int h = selectionBox.height;

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


        g.setStroke(normalStroke);
        g.drawPolygon(x_values, y_values ,8);
    }

    private void paintSelectionBox(Rectangle selectionBox, Graphics2D g){
        g.setStroke(selectionStroke);
        g.drawRect(selectionBox.x, selectionBox.y, selectionBox.width, selectionBox.height);
    }

    private void paintHandles(Graphics2D g) {

        model.applyTransform(g);
        g.setColor(Color.black);
        for( EditorDiagramModelElement element : model.getSelectedElements() ){
            Rectangle rect = element.getShape().getBounds();
            g.setStroke(handleStroke);
            g.draw(rect);
            paintHandleControls(g, rect);
        }
    }

    private void paintHandleControls(Graphics2D g, Rectangle rect) {

        Point topLeft = new Point(rect.getLocation().x, rect.getLocation().y);
        Point topRight = new Point(rect.getLocation().x + rect.width, rect.getLocation().y);
        Point bottomLeft = new Point(rect.getLocation().x, rect.getLocation().y + rect.height);
        Point bottomRight = new Point(rect.getLocation().x + rect.width, rect.getLocation().y + rect.height);

        Point topMiddle = new Point(rect.getLocation().x + rect.width / 2, rect.getLocation().y);
        Point bottomMiddle = new Point(rect.getLocation().x + rect.width / 2, rect.getLocation().y + rect.height);
        Point leftMiddle = new Point(rect.getLocation().x, rect.getLocation().y + rect.height / 2);
        Point rightMiddle = new Point(rect.getLocation().x + rect.width, rect.getLocation().y + rect.height / 2);

        g.setStroke(normalStroke);

        paintControl(topLeft, g);
        paintControl(topRight, g);
        paintControl(bottomLeft, g);
        paintControl(bottomRight, g);

        paintControl(topMiddle, g);
        paintControl(bottomMiddle, g);
        paintControl(leftMiddle, g);
        paintControl(rightMiddle, g);

    }

    private void paintControl(Point point, Graphics2D g) {
        int size = 6;
        g.drawRect(point.x - size/2, point.y - size/2, size, size);
    }

}
