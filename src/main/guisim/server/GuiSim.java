package guisim.server;


import io.mth.foil.j.Foil;
import io.mth.foil.j.Config;
import io.mth.foil.j.Configs;
import io.mth.foil.j.DefaultConfigs;
import io.mth.foil.j.DefaultFoils;
import io.mth.foil.j.Foils;

public class GuiSim {
    private static final Foils foils = new DefaultFoils();
    private static final Configs c = new DefaultConfigs();

    public static void main(String[] args) {
        Config config = c.compound(
           c.servlet("/guisim", "/*", new GuiSimServlet()),
           c.servlet("/dataloader", "/*", new DataLoaderServlet()),
           c.path("/", "src/web")
        )
                ;
        Foil foil = foils.nu("guisim", 10080, config);
        foil.run();
    }

}
