package Week6Chapter12;

import java.io.File;

public class fileTest {
    public static void main(String[] args) {
        File file = new File("./src/sources/Finland.png");
        IO.println(file.isFile());
    }
}
