package com.dimitrije.editor.actions;

import com.dimitrije.editor.actions.dialog.*;
import com.dimitrije.editor.actions.edit.*;
import com.dimitrije.editor.actions.file.*;
import com.dimitrije.editor.actions.help.AboutAction;
import com.dimitrije.editor.actions.pallete.*;
import com.dimitrije.editor.actions.select.SelectAction;
import com.dimitrije.editor.actions.select.SelectAllAction;
import com.dimitrije.editor.actions.view.*;

public class ActionsManager {

    private static ActionsManager instance;

    private final AboutAction aboutAction;
    private final CascadeWindowsAction cascadeWindowsAction;
    private final ChangeElementPropertiesAction changeElementPropertiesAction;
    private final CloseNewProjectDialogAction closeNewProjectDialogAction;
    private final CloseNewDiagramDialogAction closeNewDiagramDialogAction;
    private final CloseElementPropertiesDialog closeElementPropertiesDialog;
    private final CopyAction copyAction;
    private final CutAction cutAction;
    private final DeleteAction deleteAction;
    private final DrawCircleAction drawCircleAction;
    private final DrawHexagonAction drawHexagonAction;
    private final DrawSquareAction drawSquareAction;
    private final DrawTriangleAction drawTriangleAction;
    private final ExitAction exitAction;
    private final ExportDiagramAction exportDiagramAction;
    private final ExportProjectAction exportProjectAction;
    private final ImportDiagramAction importDiagramAction;
    private final ImportProjectAction importProjectAction;
    private final NewDiagramAction newDiagramAction;
    private final NewDiagramDialogAction newDiagramDialogAction;
    private final NewProjectAction newProjectAction;
    private final NewProjectDialogAction newProjectDialogAction;
    private final NextDiagramAction nextDiagramAction;
    private final MoveToolAction moveToolAction;
    private final OpenAction openAction;
    private final PasteAction pasteAction;
    private final PreviousDiagramAction previousDiagramAction;
    private final PrintAction printAction;
    private final PrintPreviewAction printPreviewAction;
    private final RedoAction redoAction;
    private final RemoveDiagramAction removeDiagramAction;
    private final RemoveProjectAction removeProjectAction;
    private final RotateCCWAction rotateCCWAction;
    private final RotateCWAction rotateCWAction;
    private final SaveAction saveAction;
    private final SaveAsAction saveAsAction;
    private final SelectAction selectAction;
    private final SelectAllAction selectAllAction;
    private final SearchAction searchAction;
    private final TileWindowsHorizontally tileWindowsHorizontally;
    private final TileWindowsVertically tileWindowsVertically;
    private final UndoAction undoAction;
    private final ZoomInAction zoomInAction;
    private final ZoomOutAction zoomOutAction;
    private final ZoomNormalAction zoomNormalAction;
    private final ZoomInPointAction zoomInPointAction;
    private final ZoomOutPointAction zoomOutPointAction;

    public ActionsManager() {
        aboutAction = new AboutAction();
        cascadeWindowsAction =new CascadeWindowsAction();
        changeElementPropertiesAction = new ChangeElementPropertiesAction();
        closeNewProjectDialogAction = new CloseNewProjectDialogAction();
        closeNewDiagramDialogAction = new CloseNewDiagramDialogAction();
        closeElementPropertiesDialog = new CloseElementPropertiesDialog();
        copyAction = new CopyAction();
        cutAction = new CutAction();
        deleteAction = new DeleteAction();
        drawCircleAction = new DrawCircleAction();
        drawHexagonAction = new DrawHexagonAction();
        drawSquareAction = new DrawSquareAction();
        drawTriangleAction = new DrawTriangleAction();
        exitAction = new ExitAction();
        exportDiagramAction = new ExportDiagramAction();
        exportProjectAction = new ExportProjectAction();
        importDiagramAction = new ImportDiagramAction();
        importProjectAction = new ImportProjectAction();
        newDiagramAction = new NewDiagramAction();
        newDiagramDialogAction = new NewDiagramDialogAction();
        newProjectAction = new NewProjectAction();
        newProjectDialogAction = new NewProjectDialogAction();
        nextDiagramAction = new NextDiagramAction();
        moveToolAction = new MoveToolAction();
        openAction = new OpenAction();
        pasteAction = new PasteAction();
        previousDiagramAction = new PreviousDiagramAction();
        printAction = new PrintAction();
        printPreviewAction = new PrintPreviewAction();
        redoAction = new RedoAction();
        removeDiagramAction = new RemoveDiagramAction();
        removeProjectAction = new RemoveProjectAction();
        rotateCCWAction = new RotateCCWAction();
        rotateCWAction = new RotateCWAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        selectAllAction = new SelectAllAction();
        selectAction = new SelectAction();
        searchAction = new SearchAction();
        tileWindowsHorizontally = new TileWindowsHorizontally();
        tileWindowsVertically = new TileWindowsVertically();
        undoAction = new UndoAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();
        zoomNormalAction = new ZoomNormalAction();
        zoomInPointAction = new ZoomInPointAction();
        zoomOutPointAction = new ZoomOutPointAction();
    }

    public static ActionsManager getInstance() {
        if(instance == null)
            instance = new ActionsManager();
        return instance;
    }

    public AboutAction getAboutAction() {
        return aboutAction;
    }

    public CascadeWindowsAction getCascadeWindowsAction() {
        return cascadeWindowsAction;
    }

    public ChangeElementPropertiesAction getChangeElementPropertiesAction() {
        return changeElementPropertiesAction;
    }

    public CloseNewProjectDialogAction getCloseNewProjectDialogAction() {
        return closeNewProjectDialogAction;
    }

    public CloseNewDiagramDialogAction getCloseNewDiagramDialogAction() {
        return closeNewDiagramDialogAction;
    }

    public CloseElementPropertiesDialog getCloseElementPropertiesDialog() {
        return closeElementPropertiesDialog;
    }

    public CopyAction getCopyAction() {
        return copyAction;
    }

    public CutAction getCutAction() {
        return cutAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public DrawCircleAction getDrawCircleAction() {
        return drawCircleAction;
    }

    public DrawHexagonAction getDrawHexagonAction() {
        return drawHexagonAction;
    }

    public DrawSquareAction getDrawSquareAction() {
        return drawSquareAction;
    }

    public DrawTriangleAction getDrawTriangleAction() {
        return drawTriangleAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public ExportDiagramAction getExportDiagramAction() {
        return exportDiagramAction;
    }

    public ExportProjectAction getExportProjectAction() {
        return exportProjectAction;
    }

    public ImportDiagramAction getImportDiagramAction() {
        return importDiagramAction;
    }

    public ImportProjectAction getImportProjectAction() {
        return importProjectAction;
    }

    public NewDiagramAction getNewDiagramAction() {
        return newDiagramAction;
    }

    public NewDiagramDialogAction getNewDiagramDialogAction() {
        return newDiagramDialogAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public NewProjectDialogAction getNewProjectDialogAction() {
        return newProjectDialogAction;
    }

    public NextDiagramAction getNextDiagramAction() {
        return nextDiagramAction;
    }

    public MoveToolAction getMoveToolAction() {
        return moveToolAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public PasteAction getPasteAction() {
        return pasteAction;
    }

    public PreviousDiagramAction getPreviousDiagramAction() {
        return previousDiagramAction;
    }

    public PrintAction getPrintAction() {
        return printAction;
    }

    public PrintPreviewAction getPrintPreviewAction() {
        return printPreviewAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public RemoveDiagramAction getRemoveDiagramAction() {
        return removeDiagramAction;
    }

    public RemoveProjectAction getRemoveProjectAction() {
        return removeProjectAction;
    }

    public RotateCCWAction getRotateCCWAction() {
        return rotateCCWAction;
    }

    public RotateCWAction getRotateCWAction() {
        return rotateCWAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public SearchAction getSearchAction() {
        return searchAction;
    }

    public SelectAllAction getSelectAllAction() {
        return selectAllAction;
    }

    public SelectAction getSelectAction() {
        return selectAction;
    }

    public TileWindowsHorizontally getTileWindowsHorizontally() {
        return tileWindowsHorizontally;
    }

    public TileWindowsVertically getTileWindowsVertically() {
        return tileWindowsVertically;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public ZoomInAction getZoomInAction() {
        return zoomInAction;
    }

    public ZoomOutAction getZoomOutAction() {
        return zoomOutAction;
    }

    public ZoomNormalAction getZoomNormalAction() {
        return zoomNormalAction;
    }

    public ZoomInPointAction getZoomInPointAction() {
        return zoomInPointAction;
    }

    public ZoomOutPointAction getZoomOutPointAction() {
        return zoomOutPointAction;
    }
}
