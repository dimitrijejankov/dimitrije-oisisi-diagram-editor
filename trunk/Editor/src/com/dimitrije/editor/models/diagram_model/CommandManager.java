package com.dimitrije.editor.models.diagram_model;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {


    final ArrayList<Command> commands;
    int index;

    public CommandManager() {
        commands = new ArrayList<Command>();
        index = 0;
    }

    public void Do(Command command){
        List<Command> temp = commands.subList(index, commands.size());

        commands.removeAll(temp);
        command.perform();
        index++;
        commands.add(command);
    }

    public void Redo(){
        if (index != commands.size()) {
            commands.get(index).perform();
            ++index;
        }
    }

    public void Undo(){
        if (index != 0) {
            --index;
            commands.get(index).rollback();
        }
    }

    public Command getLastCommand(){
        if (commands.size() > 0)
            return commands.get(index-1);

        return null;
    }
}
