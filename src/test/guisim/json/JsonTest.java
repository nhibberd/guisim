package guisim.json;

import org.junit.Test;

public class JsonTest {
    @Test
    public void json() {
        Json json = new Json();
        String name = "fred";
        json.thing(name);
    }
}
