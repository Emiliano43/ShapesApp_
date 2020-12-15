package Figures;

import Figures.Shape;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class FiguresWriter implements FileOperations<Shape> {

    private final String path;

    public FiguresWriter(String path) {
        this.path = path;
    }

    public void putToFile(List<Shape> shapes) throws IOException {

        try (Writer writer = new FileWriter(path, false)) {
            GsonBuilder builder = new GsonBuilder();
            Type type = new TypeToken<List<Shape>>() {
            }.getType();

            builder.registerTypeAdapter(Shape.class, new OutputFileInterface());
            Gson gson = builder.create();
            gson.toJson(shapes, type, writer);
        } catch (IOException ex) {
            throw new IOException("An error with file location!");
        }
    }

    public List<Shape> getFromFile() throws IOException {

        try (FileReader reader = new FileReader(path)) {
            GsonBuilder builder = new GsonBuilder();
            Type type = new TypeToken<List<Shape>>() {
            }.getType();

            builder.registerTypeAdapter(Shape.class, new OutputFileInterface());
            Gson gson = builder.create();

            List<Shape> shapes = gson.fromJson(reader, type);
            return shapes != null ? shapes : Collections.emptyList();
        } catch (IOException ex) {
            throw new IOException("An error with file location!");
        }
    }
}
