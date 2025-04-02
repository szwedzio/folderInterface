package horus;

import java.util.List;

public class TestMultiFolder implements MultiFolder {
    //////////KLASA TESTOWA ////////////
    private String name;
    private String size;

    private List<Folder>  list;


    public TestMultiFolder(List<Folder> list) {
        this.list = list;
    }


    @Override
    public List<Folder> getFolders() {
        return list;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }
}