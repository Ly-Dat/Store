public class demo3 {
    public static void main(String[] args) throws Exception {
        PluginManager pm = new PluginManager();
        pm.addPlugin(new SavePlugin());
        pm.addPlugin(new PrintPlugin());
        pm.executePlugins();
    }
}
