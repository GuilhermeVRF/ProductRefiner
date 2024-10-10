package services.readers;

public interface ArchiveReader {
    public abstract void read(String path);
    public abstract int count();
}
