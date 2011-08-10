package guisim.testdata;

import com.google.gson.Gson;
import guisim.json.Fred;
import guisim.server.GuiSimService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GuiSimTestServlet extends HttpServlet {
    private final GuiSimService service = new GuiSimService();
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        PrintWriter writer = resp.getWriter();
        Fred fred = gson.fromJson(reader, Fred.class);
        service.set(fred);
        writer.println("server got " + fred);
    }
}