public class HelloFactory {
    private final String mPath;
    private HelloClassLoader mLoader;

    public HelloFactory(String path) {
        mPath = path;
    }

    public Object create(String className) throws
        ClassNotFoundException,
        InstantiationException,
        IllegalAccessException
    {
        if(mLoader == null || mLoader.isExpired()) {
            mLoader = new HelloClassLoader(mPath);
        }
        return mLoader.loadClass(className).newInstance();
    }
}
