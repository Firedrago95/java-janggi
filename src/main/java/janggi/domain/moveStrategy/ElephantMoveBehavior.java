package janggi.domain.moveStrategy;

public class ElephantMoveBehavior implements MoveBehavior{

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return ElephantMoveBehavior.class.hashCode();
    }
}
