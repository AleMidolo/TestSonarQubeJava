import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {

  @Override
  public boolean accept(File pathname) {
  return true; // NEUTRAL - accepts all files
  }

}