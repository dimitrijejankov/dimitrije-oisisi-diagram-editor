package com.dimitrije.editor.views.window;

import com.dimitrije.editor.actions.ActionsManager;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class EditorMenu extends JMenuBar {

    public EditorMenu() {
        super();

        ActionsManager actionsManager = ActionsManager.getInstance();

        JMenu fileMenu = CreateFileMenu(actionsManager);
        JMenu editMenu = CreateEditMenu(actionsManager);
        JMenu viewMenu = CreateViewMenu(actionsManager);
        JMenu selectMenu = CreateSelectMenu(actionsManager);
        JMenu helpMenu = CreateHelpMenu(actionsManager);

        this.add(fileMenu);
        this.add(editMenu);
        this.add(viewMenu);
        this.add(selectMenu);
        this.add(helpMenu);
    }

    JMenu CreateFileMenu(ActionsManager actionsManager) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem openMenuItem = new JMenuItem(actionsManager.getOpenAction());
        JMenuItem saveMenuItem = new JMenuItem(actionsManager.getSaveAction());
        JMenuItem saveAsMenuItem = new JMenuItem(actionsManager.getSaveAsAction());
        JMenuItem printMenuItem = new JMenuItem(actionsManager.getPrintAction());
        JMenuItem printPreviewMenuItem = new JMenuItem(actionsManager.getPrintPreviewAction());
        JMenuItem exitMenuItem = new JMenuItem(actionsManager.getExitAction());

        JMenu newMenu = CreateNewMenu(actionsManager);
        JMenu removeMenu = CreateRemoveMenu(actionsManager);
        JMenu importMenu = CreateImportMenu(actionsManager);
        JMenu exportMenu = CreateExportMenu(actionsManager);

        fileMenu.add(newMenu);
        fileMenu.add(removeMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(printMenuItem);
        fileMenu.add(printPreviewMenuItem);
        fileMenu.add(importMenu);
        fileMenu.add(exportMenu);
        fileMenu.add(exitMenuItem);

        return fileMenu;
    }

    JMenu CreateEditMenu(ActionsManager actionsManager) {
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem undoMenuItem = new JMenuItem(actionsManager.getUndoAction());
        JMenuItem redoMenuItem = new JMenuItem(actionsManager.getRedoAction());
        JMenuItem copyMenuItem = new JMenuItem(actionsManager.getCopyAction());
        JMenuItem cutMenuItem = new JMenuItem(actionsManager.getCutAction());
        JMenuItem pasteMenuItem = new JMenuItem(actionsManager.getPasteAction());
        JMenuItem deleteMenuItem = new JMenuItem(actionsManager.getDeleteAction());
        JMenuItem rotateCWMenuItem = new JMenuItem(actionsManager.getRotateCWAction());
        JMenuItem rotateCCWMenuItem = new JMenuItem(actionsManager.getRotateCCWAction());
        JMenuItem searchMenuItem = new JMenuItem(actionsManager.getSearchAction());

        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(deleteMenuItem);
        editMenu.add(rotateCCWMenuItem);
        editMenu.add(rotateCWMenuItem);
        editMenu.add(searchMenuItem);

        return editMenu;
    }

    JMenu CreateViewMenu (ActionsManager actionsManager) {
        JMenu viewMenu = new JMenu("View");


        JMenuItem nextDiagramMenuItem = new JMenuItem(actionsManager.getNextDiagramAction());
        JMenuItem previousDiagramItem = new JMenuItem(actionsManager.getPreviousDiagramAction());
        JMenuItem zoomInMenuItem = new JMenuItem(actionsManager.getZoomInAction());
        JMenuItem zoomOutMenuItem = new JMenuItem(actionsManager.getZoomOutAction());
        JMenuItem zoomNormalMenuItem = new JMenuItem(actionsManager.getZoomNormalAction());
        JMenuItem cascadeWindowsMenuItem = new JMenuItem(actionsManager.getCascadeWindowsAction());
        JMenuItem tileWindowsHorizontallyMenuItem = new JMenuItem(actionsManager.getTileWindowsHorizontally());
        JMenuItem tileWindowsVerticallyMenuItem = new JMenuItem(actionsManager.getTileWindowsVertically());

        viewMenu.add(nextDiagramMenuItem);
        viewMenu.add(previousDiagramItem);
        viewMenu.add(zoomInMenuItem);
        viewMenu.add(zoomOutMenuItem);
        viewMenu.add(zoomNormalMenuItem);
        viewMenu.add(cascadeWindowsMenuItem);
        viewMenu.add(tileWindowsHorizontallyMenuItem);
        viewMenu.add(tileWindowsVerticallyMenuItem);

        return viewMenu;
    }

    JMenu CreateSelectMenu (ActionsManager actionsManager) {
        JMenu selectMenu = new JMenu("Select");

        JMenuItem selectAllMenuItem = new JMenuItem(actionsManager.getSelectAllAction());
        selectMenu.add(selectAllMenuItem);

        return selectMenu;
    }

    JMenu CreateHelpMenu (ActionsManager actionsManager) {
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem aboutMenuItem = new JMenuItem(actionsManager.getAboutAction());
        helpMenu.add(aboutMenuItem);

        return helpMenu;
    }

    JMenu CreateNewMenu (ActionsManager actionsManager) {
        JMenu newMenu = new JMenu("New");
        newMenu.setMnemonic(KeyEvent.VK_N);

        JMenuItem newProjectMenuItem = new JMenuItem(actionsManager.getNewProjectDialogAction());
        JMenuItem newDiagramMenuItem = new JMenuItem(actionsManager.getNewDiagramDialogAction());

        newMenu.add(newProjectMenuItem);
        newMenu.add(newDiagramMenuItem);

        return newMenu;
    }

    JMenu CreateRemoveMenu(ActionsManager actionsManager) {
        JMenu removeMenu = new JMenu("Remove");

        JMenuItem removeProject = new JMenuItem(actionsManager.getRemoveProjectAction());
        JMenuItem removeDiagram = new JMenuItem(actionsManager.getRemoveDiagramAction());

        removeMenu.add(removeProject);
        removeMenu.add(removeDiagram);

        return removeMenu;
    }

    JMenu CreateImportMenu (ActionsManager actionsManager) {
        JMenu importMenu = new JMenu("Import");

        JMenuItem importProject = new JMenuItem(actionsManager.getImportProjectAction());
        JMenuItem importDiagram = new JMenuItem(actionsManager.getImportDiagramAction());

        importMenu.add(importProject);
        importMenu.add(importDiagram);

        return importMenu;
    }

    JMenu CreateExportMenu (ActionsManager actionsManager) {
        JMenu exportMenu = new JMenu("Export");

        JMenuItem exportProject = new JMenuItem(actionsManager.getExportProjectAction());
        JMenuItem exportDiagram = new JMenuItem(actionsManager.getExportDiagramAction());

        exportMenu.add(exportProject);
        exportMenu.add(exportDiagram);

        return exportMenu;
    }


}
