package com.dimitrije.editor.views.window;

import com.dimitrije.editor.controller.EditorWindowKeyListener;

import javax.swing.*;
import java.awt.*;


public class EditorWindow extends JFrame {

    private static EditorWindow instance = null;

    private EditorWindow() {

        super("dEditor");

        getContentPane().setLayout(new BorderLayout());

        EditorMenu editorMenu = new EditorMenu();
        EditorToolbar editorToolbar = new EditorToolbar();
        EditorPalette editorPalette = new EditorPalette();
        EditorCentralPane editorCentralPane = new EditorCentralPane();
        EditorStatusBar editorStatusBar = new EditorStatusBar();

        getContentPane().add(editorToolbar, BorderLayout.NORTH);
        getContentPane().add(editorCentralPane, BorderLayout.CENTER);
        getContentPane().add(editorPalette, BorderLayout.EAST);
        getContentPane().add(editorStatusBar, BorderLayout.SOUTH);

        setJMenuBar(editorMenu);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new EditorWindowKeyListener());

        setIconImage(new ImageIcon("img/icons/editor_icon.png").getImage());
        setSize(new Dimension(860,480));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static EditorWindow getInstance() {
        if(instance == null) {
            instance = new EditorWindow();
        }
        return instance;
    }
}
