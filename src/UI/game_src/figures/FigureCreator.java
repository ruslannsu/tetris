package UI.game_src.figures;

import java.io.FileInputStream;
import java.util.Properties;

public class FigureCreator {
    private Properties properties_;
    public FigureCreator() throws Exception {
        FileInputStream input_stream= new FileInputStream("src/figures.properties");
        properties_ = new Properties();
        properties_.load(input_stream);
    }
    public Figure create(String index, int x, int y, int block_width, int block_height) throws Exception {
        return (Figure) Class.forName(properties_.getProperty(index)).getDeclaredConstructor(int.class, int.class, int.class, int.class).newInstance(x, y, block_width, block_height);
    }
}