import java.io.File;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        final HelloFactory factory = new HelloFactory("./lala.jar");

        while(true) {
            try {
                final Object obj = factory.create("HelloImpl");
                if(obj instanceof Hello) {
                    final Hello h = (Hello) obj;
                    h._init("asdf");
                    h.hello();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                break;
            }
        }
    }
}
