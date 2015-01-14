package com.dimitrije.editor.utilities.global_state_manager;

import com.dimitrije.editor.views.window.EditorWindowManager;

public class GlobalStateManager {

    private static GlobalStateManager instance = null;
    State state;

    private GlobalStateManager() {
        state = new SingleSelectionState();
    }

    public static GlobalStateManager getInstance() {

        if(instance == null)
            instance = new GlobalStateManager();

        return instance;
    }

    public void pushAction(Actions action){

        switch (action){
            case SELECT_PRESSED: state = new SingleSelectionState(); break;
            case RECT_PRESSED: state = new DrawRectangleState(); break;
            case CIRCLE_PRESSED: state = new DrawCircleState(); break;
            case TRIANGLE_PRESSED: state = new DrawTriangleState(); break;
            case HEXAGON_PRESSED: state = new DrawHexagonState(); break;
            case ZOOM_IN_PRESSED: state = new ZoomInState(); break;
            case ZOOM_OUT_PRESSED: state = new ZoomOutState(); break;
            case MOVE_PRESSED: state = new MoveState(); break;
            case RESIZE_PRESSED: state = new ResizeState(); break;
            case CONTROL_PRESSED:
            {
                if(state instanceof SingleSelectionState) {
                    state = new SelectAdditionState();
                }
            } break;
            case CONTROL_RELEASED:
            {
                if (state instanceof SelectAdditionState) {
                    state = new SingleSelectionState();
                }
            } break;
        }

        EditorWindowManager.getInstance().getEditorStatusBar().update();
    }

    public State getState(){
        return state;
    }

    public enum Actions {
        SELECT_PRESSED,
        RECT_PRESSED,
        CIRCLE_PRESSED,
        TRIANGLE_PRESSED,
        HEXAGON_PRESSED,
        ZOOM_IN_PRESSED,
        ZOOM_OUT_PRESSED,
        MOVE_PRESSED,
        RESIZE_PRESSED,
        CONTROL_PRESSED,
        CONTROL_RELEASED,
    }

    public String getCurrentStateName(){
        return state.toString();
    }
}
