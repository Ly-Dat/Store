import java.util.ArrayList;
import java.util.List;

public class PluginManager {
    private List<IPlugin> list;
    
    public PluginManager() {
        this.list = new ArrayList<>();
    }

    public void addPlugin(IPlugin plugin) {
        list.add(plugin);
    }

    public void executePlugins() {
        for (IPlugin plugin : list) {
            plugin.execute();
        }
    }
}
