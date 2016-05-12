import java.io.File;
import java.util.jar.JarFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

public class HelloClassLoader extends ClassLoader {
    private final String mPath;
    private long mLastModified;

    public HelloClassLoader(String path) {
        mPath = path;
        mLastModified = new File(mPath).lastModified();
    }

    public boolean isExpired() {
        final long lastModified = new File(mPath).lastModified();
        if(mLastModified < lastModified) {
            mLastModified = lastModified;
            return true;
        }
        return false;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            final JarFile file = new JarFile(new File(mPath));
            final ZipEntry entry = file.getEntry(name.replace('.','/') + ".class");
            if(entry == null) {
                throw new IOException("entry " + name + " not found in jar");
            }
            final InputStream is = file.getInputStream(entry);
            final byte[] data = new byte[(int) entry.getSize()];
            int toRead = data.length;
            while(toRead > 0) {
                final int read = is.read(data, data.length - toRead, toRead);
                toRead -= read;
            }
            return defineClass(name, data, 0, data.length);
        } catch(Exception e) {
            throw new ClassNotFoundException("cannot load class : " + name, e);
        }
    }

}
