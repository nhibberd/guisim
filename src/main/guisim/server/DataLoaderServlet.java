package guisim.server;

import com.google.gson.Gson;
import guisim.json.FakeData;

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
        FakeData inputData = gson.fromJson(reader, FakeData.class);
        service.store(inputData.data);
    }
}
