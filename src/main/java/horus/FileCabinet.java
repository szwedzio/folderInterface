package horus;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;
    

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return findFoldersByPredicate(folders, folder -> folder.getName().equals(name)).stream().findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return findFoldersByPredicate(folders,folder -> folder.getSize().equals(size));
    }



    private List<Folder> findFoldersByPredicate(List<Folder> folderList, Predicate<Folder> predicate){
        return folderList.stream().flatMap(folder -> {
            if(folder instanceof MultiFolder){
                return findFoldersByPredicate(((MultiFolder) folder).getFolders(), predicate).stream();
            }else{
                return Stream.of(folder);
            }
        }).filter(predicate).collect(Collectors.toList());

    }
    @Override
    public int count() {
        return countFolders(folders);
    }


    private int countFolders(List<Folder> foldersList){
        return foldersList.stream().
                mapToInt(folder -> folder instanceof MultiFolder ? countFolders(((MultiFolder) folder).getFolders()) :1 ).sum();
    }

}

