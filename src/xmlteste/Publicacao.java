
package xmlteste;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @class Publicacao
 * @author Fábio
 */
public class Publicacao implements Serializable {                   
        private String nome;   
        private char natureza; 		//C=completo, E=expandido, R=resumo, N=nenhum
        private int coautores;        
        private ArrayList<String> listaDeCoautores;
        private String qualis;
     
        public Publicacao() {
        }

        public Publicacao(String nome, char natureza, int coautores, ArrayList<String> listaDeCoautores, String qualis) {
            this.nome = nome;
            this.natureza = natureza;
            this.coautores = coautores;
            this.listaDeCoautores = listaDeCoautores;
            this.qualis = qualis;
        }

        public char getNatureza() {
            return this.natureza;
        }
        
        public void setNatureza ( String natureza ) {         
            if ( natureza.equals("COMPLETO") ) this.natureza = 'C';
            if ( natureza.equals("RESUMO_EXPANDIDO") ) this.natureza = 'E';
            if ( natureza.equals("RESUMO") ) this.natureza = 'R';            
        }   

        public ArrayList<String> getListaDeCoautores() {
            return listaDeCoautores;
        }

        public void setListaDeCoautores(ArrayList<String> listaDeCoautores) {
            this.listaDeCoautores = listaDeCoautores;
        }
                        
        public String getNome() {
            return this.nome;
        }
         
        public void setNome(String nome) {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido");
            }
            this.nome = nome;
        }
        
        public int getCoautores() {
            return this.coautores;
        }
        
        public void setCoautores(int coautores) {
           this.coautores = coautores;
        }                
        
        public String getQualis() {
            return this.qualis;
        }
        
        public void setQualis(String qualis) {
            this.qualis = qualis;
        }
     
        @Override
        public String toString() {                 
            String nature = new String();
            if ( this.natureza == 'C' ) nature = "Completo";
            else if ( this.natureza == 'R' ) nature = "Resumo";
            else if ( this.natureza == 'E' ) nature = "Resumo Expandido";
           
            StringBuilder s = new StringBuilder();            
            s.append(">>>Título: ").append(this.nome).append(" ").append(nature).append(" ").append(this.qualis == null ? "": this.qualis);
                        
            return s.toString();
        }        
}

