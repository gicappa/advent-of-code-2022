package day7;

import day7.command.BackCmd;
import day7.command.CdCmd;
import day7.command.Cmd;
import day7.command.MkDirCmd;
import day7.command.NoOpCmd;
import day7.command.RootCmd;
import day7.command.FileCmd;

public class Parser {

    public Cmd parse(String command) {
        if (command.equals("$ cd /")) {
            return new RootCmd();
        }
        if (command.equals("$ cd ..")) {
            return new BackCmd();
        }
        if (command.startsWith("dir ")) {
            var line = command.split(" ");
            return new MkDirCmd(line[1]);
        }
        if (command.startsWith("$ cd ")) {
            var line = command.split(" ");
            return new CdCmd(line[2]);
        }
        if (command.matches("[\\d]+.*")) {
            var line = command.split(" ");
            return new FileCmd(line[1], Integer.parseInt(line[0]));
        }
        return new NoOpCmd();
    }
}
