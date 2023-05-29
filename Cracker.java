import java.io.FileNotFoundException;

public abstract class Cracker {
    public abstract String craquerSimple(String password) throws FileNotFoundException;
    public abstract String craquerHashed(String password);
}
