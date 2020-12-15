package Figures;

import com.google.gson.*;
import java.lang.reflect.Type;

public class OutputFileInterface implements JsonSerializer<Shape>, JsonDeserializer<Shape> {

    private static final String CLASS = "CLASS_NAME";
    private static final String VALUE = "VALUE";

    public JsonElement serialize(Shape figure, Type type, JsonSerializationContext context) {

        JsonObject innerObject = new JsonObject();
        innerObject.addProperty(CLASS, figure.getClass().getName());
        innerObject.add(VALUE, context.serialize(figure));
        return innerObject;
    }

    public Shape deserialize(JsonElement json, Type type, JsonDeserializationContext context) {

        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASS);
        String className = prim.getAsString();
        Class c = this.getObjectClass(className);
        return context.deserialize(jsonObject.get(VALUE), c);
    }

    public Class getObjectClass(String className) {

        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new JsonParseException(ex.getMessage());
        }
    }
}
