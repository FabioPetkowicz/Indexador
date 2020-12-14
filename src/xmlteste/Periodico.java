package xmlteste;

/**
 * @class Periodico
 * @author Fábio
 */
import java.io.Serializable;

public class Periodico extends Publicacao implements Serializable {

    private String nomeDoPeriodico;
    private String issn;

    public void setNomeDoPeriodico(String nomeDoPeriodico) {
        /*if (nomeDoPeriodico == null || nomeDoPeriodico.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }*/
        this.nomeDoPeriodico = nomeDoPeriodico;
    }

    public String getNomeDoPeriodico() {
        return nomeDoPeriodico;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Override
    public String toString() {
        return super.toString() + " [ Qualis: " + getQualis() + " ] [ ISSN: " + issn + " ]";
    }
}
