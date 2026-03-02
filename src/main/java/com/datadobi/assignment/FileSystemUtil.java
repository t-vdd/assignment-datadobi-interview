package com.datadobi.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileSystemUtil {

    // Output Filename or Subdirectory goes into its subfolder tree
    void outputFilenameOrDelveDeeperInDirectory(Path currentPath, int depth) {
        if (Files.isDirectory(currentPath)) {
            System.out.println("-".repeat(depth) + currentPath);

            // If a directory cannot be read due to permission/not existing/... we catch an IO Error
            // Else we process the item in this same method as a File or Directory
            try (Stream<Path> stream = Files.list(currentPath)) {
                stream
                        .sorted(Comparator.comparing(path -> path.getFileName().toString()))  // Ensure A->Z sorting even though default is currently also Descending Order
                        .forEach(nextItem -> this.outputFilenameOrDelveDeeperInDirectory(nextItem, depth + 1));
            } catch (IOException e) {
                System.err.println("Something went wrong in '" + currentPath + "'. Error message: " + e.getMessage());
            }

        } else if (Files.isRegularFile(currentPath)) {
            System.out.println("-".repeat(depth) + currentPath);
        }
    }

}
