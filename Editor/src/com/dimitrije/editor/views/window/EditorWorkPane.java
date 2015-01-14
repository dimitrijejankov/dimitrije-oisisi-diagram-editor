package com.dimitrije.editor.views.window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditorWorkPane extends JDesktopPane {

    final ArrayList<EditorDiagramWindow> openInternalWindows;
    final ArrayList<EditorDiagramWindow> closedInternalWindows;

    public EditorWorkPane() {
        super();
        setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        EditorWindowManager.getInstance().setEditorWorkPane(this);
        openInternalWindows = new ArrayList<EditorDiagramWindow>();
        closedInternalWindows = new ArrayList<EditorDiagramWindow>();
    }

    public void addInternalFrame(EditorDiagramWindow editorInternalWindow){
        editorInternalWindow.setLocation(openInternalWindows.size() * 30, openInternalWindows.size() * 30);
        super.add(editorInternalWindow);
        editorInternalWindow.setSelected(true);
        openInternalWindows.add(editorInternalWindow);
    }

    public void removeInternalFrame(EditorDiagramWindow editorInternalWindow){
        remove(editorInternalWindow);

        if(openInternalWindows.contains(editorInternalWindow))
        {
            if(openInternalWindows.size() != 0){
                FindNextWindow(editorInternalWindow).setSelected(true);
            }

            openInternalWindows.remove(editorInternalWindow);
        }

        if(closedInternalWindows.contains(editorInternalWindow))
        {
            closedInternalWindows.remove(editorInternalWindow);
        }

        repaint();
    }

    public void closeInternalFrame(EditorDiagramWindow editorInternalWindow){
        if(openInternalWindows.contains(editorInternalWindow))
        {
            if(openInternalWindows.size() != 0){
                FindNextWindow(editorInternalWindow).setSelected(true);
            }

            closedInternalWindows.add(editorInternalWindow);
            openInternalWindows.remove(editorInternalWindow);
        }
    }

    public void openInternalFrame(EditorDiagramWindow editorInternalWindow){
        if(closedInternalWindows.contains(editorInternalWindow))
        {
            openInternalWindows.add(editorInternalWindow);
            closedInternalWindows.remove(editorInternalWindow);
        }
    }

    public void CascadeWindows() {
        int i = 0;
        for(EditorDiagramWindow internalWindow: openInternalWindows)
        {
            internalWindow.setLocation(30 * i, 30 * i);
            internalWindow.setSize(300, 300);
            internalWindow.setSelected(true);
            i++;
        }
    }

    public void TileWindowsVertically()
    {
        if(openInternalWindows.isEmpty())
            return;

        Dimension dimension = getSize();
        Dimension windowDimension = new Dimension(dimension.width, dimension.height / openInternalWindows.size());

        int i = 0;
        for(EditorDiagramWindow internalWindow: openInternalWindows){
            internalWindow.setSize(windowDimension);
            internalWindow.setLocation(0, windowDimension.height*i);
            internalWindow.setSelected(true);
            i++;
        }
    }

    public void TileWindowsHorizontally()
    {
        if(openInternalWindows.isEmpty())
            return;

        Dimension dimension = getSize();
        Dimension windowDimension = new Dimension(dimension.width / openInternalWindows.size(), dimension.height);

        int i = 0;
        for(EditorDiagramWindow internalWindow: openInternalWindows){
            internalWindow.setSize(windowDimension);
            internalWindow.setLocation(windowDimension.width*i, 0);
            internalWindow.setSelected(true);
            i++;
        }
    }

    public EditorDiagramWindow FindNextWindow(EditorDiagramWindow editorInternalWindow){
        if(openInternalWindows.size() > 0) {
            int index = openInternalWindows.indexOf(editorInternalWindow) + 1;
            index = index % openInternalWindows.size();
            return openInternalWindows.get(index);
        }
        return null;
    }

    public EditorDiagramWindow FindPreviousWindow(EditorDiagramWindow editorInternalWindow){
        if(openInternalWindows.size() > 0) {
            int index = openInternalWindows.indexOf(editorInternalWindow) + openInternalWindows.size() - 1;
            index = index % openInternalWindows.size();
            return openInternalWindows.get(index);
        }
        return null;
    }

    @Override
    public EditorDiagramWindow getSelectedFrame() {
        if(super.getSelectedFrame() instanceof EditorDiagramWindow)
            return (EditorDiagramWindow)super.getSelectedFrame();
        return null;
    }
}
