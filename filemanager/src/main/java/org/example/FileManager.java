package org.example;

import java.io.File;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class FileManager {
    private Stream<File> getFilesStream(String directory) {
        return Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile);
    }

    public void listFilesInDirectory(String directory) {
        getFilesStream(directory)
                .map(File::getName)
                .forEach(System.out::println);
    }

    public void sortFilesInDirectoryBySize(String directory) {
        getFilesStream(directory)
                .sorted(Comparator.comparingLong(File::length).reversed())
                .forEach(file -> {
                    System.out.println(file.getName());
                    System.out.println(file.length());
                    System.out.println();
                });
    }
}
