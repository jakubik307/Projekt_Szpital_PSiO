import java.io.Serializable;

public class CertyfikatSzczepienia implements Serializable {
    private boolean czySzczepiony;
    private int numerSzczepienia;

    public CertyfikatSzczepienia() {
        this.czySzczepiony = false;
        numerSzczepienia = 0;
    }

    public boolean isCzySzczepiony() {
        return czySzczepiony;
    }

    public void setCzySzczepiony(boolean czySzczepiony) {
        this.czySzczepiony = czySzczepiony;
    }

    public int getNumerSzczepienia() {
        return numerSzczepienia;
    }

    public void setNumerSzczepienia(int numerSzczepienia) {
        this.numerSzczepienia = numerSzczepienia;
    }

    @Override
    public String toString() {
        return "CertyfikatSzczepienia: " + "czySzczepiony: " + czySzczepiony + " numerSzczepienia: " + numerSzczepienia;
    }
}
