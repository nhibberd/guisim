package guisim.server;

import com.google.gson.Gson;
import guisim.json.Flight;
import guisim.model.FromGui;
import guisim.model.FromGuiObjects;
import guisim.usb.Output;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

public class GuiSimServlet extends HttpServlet {
    private final GuiSimService service = new GuiSimService();
    private final Gson gson = new Gson();
    private OutputStream device;

    public GuiSimServlet(OutputStream output) {
        this.device = output;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        Flight flight = service.poll();
        String json = gson.toJson(flight);
        writer.println(json);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        FromGuiObjects data = gson.fromJson(reader, FromGuiObjects.class);
        service.send(data, device);
    }
}
