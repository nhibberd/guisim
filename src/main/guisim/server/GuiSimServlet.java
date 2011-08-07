package guisim.server;

import com.google.gson.Gson;
import guisim.json.Fred;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class GuiSimServlet extends HttpServlet {
    private final GuiSimService service = new GuiSimService();
    private final Gson gson = new Gson();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        Fred fred = service.poll();
        String json = gson.toJson(fred);
        writer.println(json);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        PrintWriter writer = resp.getWriter();
        Fred fred = gson.fromJson(reader, Fred.class);
        writer.println("server got " + fred);
    }
}
