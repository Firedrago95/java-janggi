package janggi.domain.path;

import java.util.List;
import java.util.Objects;

public class Path {

    private List<Position> path;

    public Path(List<Position> path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Path path1)) return false;
        return Objects.equals(path, path1.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(path);
    }
}
