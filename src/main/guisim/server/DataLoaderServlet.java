package guisim.server;

import com.google.gson.Gson;

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
        PrintWriter writer = resp.getWriter();
        String inputData = gson.fromJson(reader, String.class);
        service.store(inputData);


            //Fred fred = gson.fromJson(reader, Fred.class);

        //Set a structure that stores all of the data
            //service.store(fred);
            //writer.println("server got " + fred);

        //send the data to GuiSimService

    }
}
