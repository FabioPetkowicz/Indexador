package xmlteste;

/**
 *
 * @author fopetkowicz
 */
public class QualisPeriodico {    
    private String titulo;
    private String qualis;
    private String issn;
    
    public QualisPeriodico() {
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getQualis() {
        return qualis;
    }

    public void setQualis(String qualis) {
        this.qualis = qualis;
    }  
    
    public void setIssn(String issn) {
        this.issn = issn;
    }
    
    public String getIssn() {
        return issn;
    }
}