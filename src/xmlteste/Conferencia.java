
package xmlteste;

/**
 * @class Conferencia
 * @author Fábio
 */
import java.io.Serializable;

public class Conferencia extends Publicacao implements Serializable {

    private String nomeDaConferencia;
    private String sigla;

    public void Conferencia() {
    }

    public void setNomeDaConferencia(String nomeDaConferencia) {
        /*if (nomeDaConferencia == null || nomeDaConferencia.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }*/
        this.nomeDaConferencia = nomeDaConferencia;
    }

    public String getNomedaConferencia() {
        return this.nomeDaConferencia;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getsigla() {
        return this.sigla;
    }

    @Override
    public String toString() {
        return super.toString() +  " [ Qualis: " + getQualis() + " ]";
    }
}
