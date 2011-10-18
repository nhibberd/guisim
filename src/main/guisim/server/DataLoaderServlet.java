package guisim.server;

import com.google.gson.Gson;
import guisim.json.FakeData;
import guisim.json.Flight;
import guisim.model.FromGuiObjects;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class DataLoaderServlet extends HttpServlet {
    private final DataLoaderService service = new DataLoaderService();
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        FromGuiObjects data = gson.fromJson(reader, FromGuiObjects.class);
        //TODO: read file ??
        service.store(data);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        //TODO: read file ??

        Flight flight = service.poll();
        String json = gson.toJson(flight);
        writer.println(json);
    }
}
