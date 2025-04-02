package horus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Folder> folders3 = List.of(
                new TestFolder("1", "MEDIUM")
        );

        List<Folder> folders2 = List.of(
                new TestFolder("1", "LARGE"),
                new TestFolder("2", "MEDIUM"),
                new TestFolder("3", "MEDIUM"),
                new TestFolder("4", "MEDIUM"),
                new TestFolder("5", "SMALL"),
                new TestMultiFolder(folders3)

        );


                List<Folder> folders = List.of(
                new TestFolder("Lista1", "LARGE"),
                new TestFolder("Lista2", "MEDIUM"),
                new TestFolder("Lista3", "MEDIUM"),
                new TestFolder("Lista4", "SMALL"),
                        new TestMultiFolder(folders2)
        );
        FileCabinet cabinet = new FileCabinet(folders);

        List<Folder> testObj = cabinet.findFoldersBySize("MEDIUM");
        Integer counter = cabinet.count();
    }

}