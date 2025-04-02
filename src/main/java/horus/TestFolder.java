package horus;

public class TestFolder implements Folder {
//////////KLASA TESTOWA ////////////
    private String name;
    private String size;

    public TestFolder(String name, String size) {
        this.name = name;
        this.size = size;
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