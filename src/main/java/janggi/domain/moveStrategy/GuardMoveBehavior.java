package janggi.domain.moveStrategy;

public class GuardMoveBehavior implements MoveBehavior{

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return GuardMoveBehavior.class.hashCode();
    }
}
