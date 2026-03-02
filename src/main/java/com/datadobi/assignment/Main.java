package com.datadobi.assignment;

import java.nio.file.Files;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // Get the root directory from which we start, set in our application.properties, as a File Path to work with
        Path rootDir = Path.of(ConfigReader.get("root_path"));
        FileSystemUtil util = new FileSystemUtil();

        // If directory root exists and is a directory then we can start exploring from its starting point
        if (Files.exists(rootDir) && Files.isDirectory(rootDir)) {
            util.outputFilenameOrDelveDeeperInDirectory(rootDir, 0);
        } else {
            System.out.println("The provided root directory '" + rootDir + "' does not exist or is not a directory on the current device");
        }
    }

}
