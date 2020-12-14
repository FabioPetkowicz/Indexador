
package xmlteste;

/**
 * @class Pesquisador
 * @author Fábio
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Pesquisador implements Serializable {

    private String nome;
    private String sinonimos;
    ArrayList<Conferencia> listaDeConferencias = new ArrayList<>();
    ArrayList<Periodico> listaDePeriodicos = new ArrayList<>();

    public Pesquisador() {
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSinonimos(String sinonimos) {
        this.sinonimos = sinonimos;
    }

    public String getSinonimos() {
        return this.sinonimos;
    }

    public ArrayList<Conferencia> getListaDeConferencias() {
        return listaDeConferencias;
    }

    public void setListaDeConferencias(ArrayList<Conferencia> listaDeConferencias) {
        this.listaDeConferencias = listaDeConferencias;
    }

    public ArrayList<Periodico> getListaDePeriodicos() {
        return listaDePeriodicos;
    }

    public void setListaDePeriodicos(ArrayList<Periodico> listaDePeriodicos) {
        this.listaDePeriodicos = listaDePeriodicos;
    }
    
    @Override
    public String toString() {
        return nome;
    }        
    
    /*
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append( this.nome ).append("\n").append(this.sinonimos).append("\n");
        
        s.append("\n***** LISTA DE CONFERÊNCIAS *****\n");
        for (Conferencia c : listaDeConferencias) {
            s.append(c).append("\n");
        }

        s.append("\n***** LISTA DE PERIÓDICOS *****\n");
        for (Periodico p : listaDePeriodicos) { 
            s.append(p).append("\n");
        }
        
        return s.toString();
    }
    */
     
    
    /*
    public void Impress() {
        System.out.println(this.nome);
        System.out.println(this.sinonimos);
        
        for (Conferencia c : listaDeConferencias){
            System.out.println( c + "\n");
        }
    } */ 
    
}
