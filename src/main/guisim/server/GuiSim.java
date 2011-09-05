package guisim.server;


import guisim.load.HardwareLoader;
import guisim.usb.Usb;
import io.mth.foil.j.Foil;
import io.mth.foil.j.Config;
import io.mth.foil.j.Configs;
import io.mth.foil.j.DefaultConfigs;
import io.mth.foil.j.DefaultFoils;
import io.mth.foil.j.Foils;

import javax.comm.NoSuchPortException;
import java.io.IOException;
import java.io.OutputStream;

public class GuiSim {
    private static final Foils foils = new DefaultFoils();
    private static final Configs c = new DefaultConfigs();

    public static void main(String[] args) {

        Usb usb = new Usb();
        OutputStream device = null;
        try {
            device = usb.start();
        } catch (NoSuchPortException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Config config = c.compound(
           c.servlet("/guisim", "/*", new GuiSimServlet(device)),
           c.servlet("/dataloader", "/*", new DataLoaderServlet()),
           c.path("/", "src/web")
        )
                ;
        Foil foil = foils.nu("guisim", 10080, config);
        foil.run();
    }
    /*
    private static void startLoader() {
        HardwareLoader worker = new HardwareLoader();
        Thread t = new Thread(worker);
        t.setDaemon(true);
        t.start();
    } */

}
