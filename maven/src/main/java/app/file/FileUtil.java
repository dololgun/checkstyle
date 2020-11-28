package app.file;

import java.nio.file.Path;

public final class FileUtil {

    private FileUtil() {

    }

    /**
     * target = "/test/test1/test2/test.txt" 이면 root = "/test" 이면 depth가 1이면
     * "/test/test1"을 리턴한다.
     *
     * @param root
     * @param target
     * @return 경로를 리턴한다.
     */
    public static Path getRelativeRootPath(final Path root, final Path target) {

        Path relativePath = root.relativize(target);
        return root.resolve(relativePath.getName(0));
    }

}
