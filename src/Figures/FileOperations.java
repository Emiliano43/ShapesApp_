package Figures;

import java.util.List;
import java.io.IOException;

public interface FileOperations<T>{
    void putToFile(List<T> list) throws IOException;
    List<T> getFromFile() throws IOException;
}
