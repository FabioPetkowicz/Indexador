package xmlteste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author fabio
 */
public final class FormularioXml extends javax.swing.JFrame {

    private ArrayList<Pesquisador> listaPesquisadores;
    private ArrayList<QualisPeriodico> listaQualisPeriodicos;
    private ArrayList<QualisConferencia> listaQualisConferencias;  
    private String pastaCSV = "C:\\Users\\fopetkowicz\\Downloads\\";
    //private String pastaCSV = "/home/felipe/Downloads/";
    
    /**
     * Creates new form FormularioXml
     */
    public FormularioXml() {
        initComponents();
        listaPesquisadores = new ArrayList<>();
        try {
            listaQualisPeriodicos = listagemQualisPeriodico(new File(pastaCSV + "periodicos.csv"));
            listaQualisConferencias = listagemQualisConferencia(new File(pastaCSV + "conferencias.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormularioXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormularioXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCarregarXml = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        buttonCarregar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listViewPesquisadores = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leitor de XML");

        buttonCarregarXml.setText("CarregarXml");
        buttonCarregarXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCarregarXmlActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jToolBar1.setRollover(true);

        buttonCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/abrir.gif"))); // NOI18N
        buttonCarregar.setFocusable(false);
        buttonCarregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCarregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCarregarActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonCarregar);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.gif"))); // NOI18N
        buttonSalvar.setFocusable(false);
        buttonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonSalvar);

        listViewPesquisadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listViewPesquisadoresValueChanged(evt);
            }
        });
        listViewPesquisadores.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                listViewPesquisadoresPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(listViewPesquisadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCarregarXml, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCarregarXml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizaLista() {                
        DefaultListModel listModel = new DefaultListModel();
        for (Pesquisador p : listaPesquisadores) {
            listModel.addElement(p);
        }        
        listViewPesquisadores.setModel(listModel);
    }    
    
    private void buttonCarregarXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCarregarXmlActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilterXml());
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                Pesquisador professor = leXml(fileChooser.getSelectedFile()); 
                listaPesquisadores.add(professor);                                
                atualizaLista();
            } catch (ParserConfigurationException ex) {
                JOptionPane.showMessageDialog(this, "Erro", "Erro na estrutura do arquivo xml.", JOptionPane.ERROR_MESSAGE);
            } catch (SAXException ex) {
                JOptionPane.showMessageDialog(this, "Erro", "Erro interno.\n" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro", "O arquivo não pode ser lido.\n" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonCarregarXmlActionPerformed

    private void listViewPesquisadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listViewPesquisadoresValueChanged
        Object obj = listViewPesquisadores.getSelectedValue();
        if (obj != null) {
            Pesquisador pesquisador = (Pesquisador) obj;
            StringBuilder sb = new StringBuilder();
            sb.append(pesquisador.getNome()).append("\n").append(pesquisador.getSinonimos()).append("\n");
            sb.append("\n***** Lista de Conferências *****\n");
            for (Conferencia c : pesquisador.getListaDeConferencias()) {
                sb.append(c).append("\n");
            }
            sb.append("\n***** Lista de Periodicos *****\n");
            for (Periodico p : pesquisador.getListaDePeriodicos()) {
                sb.append(p).append("\n");
            }            
            textArea.setText(sb.toString());
        }
    }//GEN-LAST:event_listViewPesquisadoresValueChanged

    private void listViewPesquisadoresPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_listViewPesquisadoresPropertyChange
        listViewPesquisadoresValueChanged(null);
    }//GEN-LAST:event_listViewPesquisadoresPropertyChange

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilterPsq());
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            salva(fileChooser.getSelectedFile());
        }     
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void salva(File arquivo) {
        if (!arquivo.getName().toLowerCase().endsWith(".psq")) {
            arquivo = new File(arquivo.getAbsolutePath() + ".psq");
            System.out.println(arquivo);
        }
        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {

            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);

            //escreve todos os dados
            out.writeObject(listaPesquisadores);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void carrega(File arquivo) {
	FileInputStream arqLeitura = null;
	ObjectInputStream in = null;	
	try {                
		//arquivo onde estao os dados serializados
		arqLeitura = new FileInputStream(arquivo);
 
		//objeto que vai ler os dados do arquivo
		in = new ObjectInputStream(arqLeitura);
 
		//recupera os dados
		listaPesquisadores = (ArrayList<Pesquisador>) in.readObject();
                atualizaLista();
	} catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);		
	} catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);		
	} finally {
		try {
			arqLeitura.close();
			in.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);		
		}
	}                
    }
    
    private void buttonCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCarregarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilterPsq());
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            carrega(fileChooser.getSelectedFile());
        }     
    }//GEN-LAST:event_buttonCarregarActionPerformed
    
    public Pesquisador leXml(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        Node raiz = doc.getDocumentElement();
        NodeList list = raiz.getChildNodes(); //lista dos filhos da raiz

        //StringBuilder s = new StringBuilder(); //Impressao de Teste
        /* LACO (1): EXTRAI: NOME-EM-CITACOES-BIBLIOGRAFICAS, NOME-COMPLETO e CONFERENCIAS */
        Pesquisador professor = new Pesquisador();
        for (int i = 0; i < list.getLength(); i++) {
            Node x = list.item(i);
                     
            if ("DADOS-GERAIS".equals(x.getNodeName())) {
                String nomeSinonimos = x.getAttributes().getNamedItem("NOME-EM-CITACOES-BIBLIOGRAFICAS").getNodeValue();
                String nome = x.getAttributes().getNamedItem("NOME-COMPLETO").getNodeValue();
                professor.setSinonimos(nomeSinonimos);
                professor.setNome(nome);
            }
            if ("PRODUCAO-BIBLIOGRAFICA".equals(x.getNodeName())) {
                NodeList filhos = x.getChildNodes();

                for (int j = 0; j < filhos.getLength(); j++) {
                    Node y = filhos.item(j);

                    if ("TRABALHOS-EM-EVENTOS".equals(y.getNodeName())) {
                        NodeList filhos1 = y.getChildNodes();
                        
                        Conferencia conferencia;
                        for (int k = 0; k < filhos1.getLength(); k++) {
                            Node z = filhos1.item(k);
                            conferencia = new Conferencia(); //System.out.println(z.getNodeName());//                                                                

                            if ("TRABALHO-EM-EVENTOS".equals(z.getNodeName())) {
                                NodeList filhos2 = z.getChildNodes();

                                int coautores = 0;
                                ArrayList<String> listaDeAutores = new ArrayList<>();
                                for (int t = 0; t < filhos2.getLength(); t++) {

                                    Node a = filhos2.item(t); //System.out.println(a.getNodeName());

                                    if ("DADOS-BASICOS-DO-TRABALHO".equals(a.getNodeName())) {
                                        conferencia.setNome( a.getAttributes().getNamedItem("TITULO-DO-TRABALHO").getNodeValue() );
                                        conferencia.setNatureza( a.getAttributes().getNamedItem("NATUREZA").getNodeValue() );                                                                                
                                        //conferencia.setSigla(getSigla(conferencia.getNome()));                                                                                                  
                                    }

                                    if ("DETALHAMENTO-DO-TRABALHO".equals(a.getNodeName())) {
                                        conferencia.setNomeDaConferencia( a.getAttributes().getNamedItem("NOME-DO-EVENTO").getNodeValue() );
                                        //String temp1 = z.getAttributes().getNamedItem("CLASSIFICACAO-DO-EVENTO").getNodeValue();                                        
                                        //conferencia.setCarater(temp1); //Nacional ou Internacional --> ajuda a Deixar mais completo
                                        //System.out.println(conferencia.getNomeDaConferencia());
                                    }

                                    if ("AUTORES".equals(a.getNodeName())) {
                                        listaDeAutores.add(a.getAttributes().getNamedItem("NOME-COMPLETO-DO-AUTOR").getNodeValue());
                                        coautores++;
                                    }

                                }

                                //System.out.println(listaDeAutores);
                                //System.out.println("_____________");
/*                                  para percorrer o ArrayList Autores:
                                 for (String aL : listaDeAutores ){
                                 conferencia.setListaDeCoautores(listaDeAutores);
                                 } */
                                conferencia.setCoautores(coautores);
                                conferencia.setListaDeCoautores(listaDeAutores);
                                conferencia.setQualis(searchQualisConferencia(listaQualisConferencias, conferencia));
                                professor.listaDeConferencias.add(conferencia);
                            }
                        }
                    }                    
                    
                    if ("ARTIGOS-PUBLICADOS".equals(y.getNodeName())) {
                        NodeList listaDeArtigos = y.getChildNodes();
                        
                        for (int k = 0; k < listaDeArtigos.getLength(); k++) {
                            Node z = listaDeArtigos.item(k);
                            Periodico periodico = new Periodico(); //auxiliar -> de transporte                                        
                            if ("ARTIGO-PUBLICADO".equals(z.getNodeName())) {
                                NodeList listaDeAtributos = z.getChildNodes();

                                int numCoautores = 0; //de transporte                            
                                for (int i1 = 0; i1 < listaDeAtributos.getLength(); i1++) {
                                    Node v = listaDeAtributos.item(i1);

                                    if ("DADOS-BASICOS-DO-ARTIGO".equals(v.getNodeName())) {
                                        periodico.setNatureza( v.getAttributes().getNamedItem("NATUREZA").getNodeValue() );                                        
                                        periodico.setNome( v.getAttributes().getNamedItem("TITULO-DO-ARTIGO").getNodeValue() );                                        
                                    }
                                    
                                    if ("DETALHAMENTO-DO-ARTIGO".equals(v.getNodeName())) {
                                        periodico.setNomeDoPeriodico( v.getAttributes().getNamedItem("TITULO-DO-PERIODICO-OU-REVISTA").getNodeValue() );                                        
                                        periodico.setIssn( v.getAttributes().getNamedItem("ISSN").getNodeValue() );
                                        
                                    }
                                    if ("AUTORES".equals(v.getNodeName())) {
                                        numCoautores++;
                                    }
                                }
                                periodico.setCoautores(numCoautores);
                                periodico.setQualis(searchQualisPeriodico(listaQualisPeriodicos, periodico));                                
                                professor.listaDePeriodicos.add(periodico);
                            }
                        }
                    }
                }
            }
            
        }
        return professor;
        
//LACO(2) Extrai: PERIODICOS          
        /*for (int i = 0; i < list.getLength(); i++) {
            Node x = list.item(i);

            if ("PRODUCAO-BIBLIOGRAFICA".equals(x.getNodeName())) {
                NodeList filhos1 = x.getChildNodes();

                for (int j = 0; j < filhos1.getLength(); j++) {
                    Node y = filhos1.item(j);


                }
            }
        }*/

        //s.append("----------------------------------------------------\n");
        //s.append("\n\nNome: ").append(nome).append("\n");
        //s.append("Nome em Citações Bibliográficas:\n").append(nomeSinonimos).append("\n");

        //System.out.println(professor.toString());
        //textArea.setText(professor.toString());
        /*System.out.println("*********************************************");
         professor.Impress();
         System.out.println("FIM");*/
    }    
//ok---Modifiquei o argumento recebido era:(File arquivo)-----------------------------------------------------------------------    
    public ArrayList<QualisPeriodico> listagemQualisPeriodico(File arquivo) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(arquivo));
        ArrayList<QualisPeriodico> listaDeRevistas = new ArrayList<>(1910);        
        in.readLine();
        String linha;
        while ((linha = in.readLine()) != null) {
            String conteudo[] = linha.split(";");
            QualisPeriodico revista = new QualisPeriodico();
            revista.setIssn(conteudo[0]);
            revista.setTitulo(conteudo[1]);
            if (conteudo.length == 3) {
                revista.setQualis(conteudo[2]);
            } else {
                revista.setQualis("N");
            }
            listaDeRevistas.add(revista);
        }
        return listaDeRevistas;
    }
//ok-----------------------------------idem ao anterior---------------------------------------------------    
    public ArrayList<QualisConferencia> listagemQualisConferencia(File arquivo) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(arquivo)); //?????????????????????????
        ArrayList<QualisConferencia> listaDeRevistas = new ArrayList<>(1411);        
        in.readLine();
        String linha;
        while ((linha = in.readLine()) != null) {
            String conteudo[] = linha.split(";");
            QualisConferencia conferencia = new QualisConferencia();
            conferencia.setSigla(conteudo[0]);
            conferencia.setTitulo(conteudo[1]);
            if (conteudo.length == 4) {
                conferencia.setCarater(conteudo[2]);
                conferencia.setQualis(conteudo[3]);
            } else {
                conferencia.setQualis(conteudo[2]);
            }
            listaDeRevistas.add(conferencia);
        }
        return listaDeRevistas;
    }
    
    public String searchQualisPeriodico(ArrayList<QualisPeriodico> listagemDosQualisPeriodicos, Periodico periodico){        
        String nome = periodico.getNome().trim().toLowerCase();
        String issnDaRevista = periodico.getIssn(); 
        System.out.println(issnDaRevista);
        String aux1 = issnDaRevista.substring(0, 4);
        String aux2 = issnDaRevista.substring(4, 8);
        String issn = aux1 + "-" + aux2;
        System.out.println(issn); //teste
        //String issn = periodico.getIssn().trim().toLowerCase(); //de Teste
        String qualif = "Indisponivel";
        char find = 'N';
        int index = 0;
        int limite = listagemDosQualisPeriodicos.size();
        
        
        while ( index < limite && find != 'S' ){
            
            if ( "N".equals( listagemDosQualisPeriodicos.get(index).getIssn().trim() ) ){
                return qualif;
            }
            else if( issn.equals( listagemDosQualisPeriodicos.get(index).getIssn().trim() ) || nome.equals( listagemDosQualisPeriodicos.get(index).getTitulo().trim().toLowerCase())){
                find = 'S';
                //System.out.println("acheiiiii " + periodico); //de Teste               
                qualif = listagemDosQualisPeriodicos.get(index).getQualis();                
            }
            index++;
        }        
        return qualif; 
    }    

    public String searchQualisConferencia(ArrayList<QualisConferencia> listagemDosQualisConferencia, Conferencia conferencia){        
        String nome = conferencia.getNome();
        String qualif = "Indisponivel";
        char find = 'N';
        int index = 0;
        int limite = listagemDosQualisConferencia.size();
        while ( index < limite && find != 'S' ){
            if( nome.equals( listagemDosQualisConferencia.get(index).getTitulo())){
                find = 'S';
                //System.out.println("acheiiiii " + conferencia);                
                qualif = listagemDosQualisConferencia.get(index).getQualis();
            }
            index++;
        }        
        return qualif; 
    }    
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioXml().setVisible(true);
            }
        });
    }

    public class FileFilterXml extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().toLowerCase().trim().endsWith(".xml");
        }

        @Override
        public String getDescription() {
            return "Arquivo XML";
        }
    }
    
    public class FileFilterPsq extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().toLowerCase().trim().endsWith(".psq");
        }

        @Override
        public String getDescription() {
            return "Arquivo de Pesquisadores";
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCarregar;
    private javax.swing.JButton buttonCarregarXml;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList listViewPesquisadores;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
