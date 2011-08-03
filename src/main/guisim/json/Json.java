package guisim.json;

import com.google.gson.*;

public class Json extends fred {
    public String thing(String s) {
        return s.toUpperCase();
    }

    //(Serialization)
    public String createJson () throws JsonIOException {
        Gson gson = new Gson();

        //Convert java object to Json format
        Json lol = new Json();
        return gson.toJson(lol);

        //Convert fields? to Json format
        //gson.toJson(roll);
        //gson.toJson(pitch);
        //gson.toJson(yaw);
    }

    //(Deserialization)
    public void readJson () throws JsonSyntaxException {
        //Gson haha = new Gson();
        //short one = haha.(input, Short.class);
    }
}
