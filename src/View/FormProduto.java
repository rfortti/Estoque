/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Model.Categoria;
import Model.Tipo;
import Model.Produto;
import Controller.CategoriaDAO;
import Controller.ProdutoDAO;
import Controller.TipoDAO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import utilitarios.AceitaNumerosPonto;
import utilitarios.AceitaStrings;
import utilitarios.LimitarLetras;
import utilitarios.LimitarNumeros;
/**
 *
 * @author Strong
 */
public class FormProduto extends javax.swing.JFrame {

    DefaultTableModel tCategoria;
    DefaultTableModel tTipo;
    
    private ArrayList<Categoria> listCat;
    private ArrayList<Tipo> listTipo;
    
    private ProdutoDAO produtoDAO;
     
    public FormProduto() {
                
        initComponents();
        this.produtoDAO = new ProdutoDAO();
        
        preencheTabela();
        popularComboCategoria();
        popularComboTipo();
        
        txtCod.setDocument(new AceitaNumerosPonto());
        txtCod.setDocument(new LimitarNumeros(6));
        //txtDesc.setDocument(new AceitaStrings());
        //txtDesc.setDocument(new LimitarLetras(50));
        txtMinimo.setDocument(new AceitaNumerosPonto());
        txtMinimo.setDocument(new LimitarNumeros(6));
        //txtPesquisar.setDocument(new AceitaStrings());
        //txtPesquisar.setDocument(new LimitarLetras(50));
    }

    //metodo para popular combo tipo
    public void popularComboTipo() {
                
        TipoDAO tDAO = new TipoDAO();
        listTipo = tDAO.getTipos(1);
        if (listTipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos um tipo !");
            this.dispose();
        } else {
            for(Tipo tipo : listTipo){
                cbTipo.addItem(tipo);
            }
        }
    }
    
     //metodo para popular combo categoria
    public void popularComboCategoria() {
               
        CategoriaDAO CatDAO = new CategoriaDAO();
        listCat = CatDAO.getCategorias(1);
        if (listCat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos uma categoria !");
            this.dispose();
        } else {
            for(Categoria cat : listCat){
                cbCategoria.addItem(cat);
            }
        }
    }
    
    
    public void preencheTabela2(String desc)
    {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);
            
        tblProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tblProduto.getColumnModel().getColumn(1).setCellRenderer(esquerda);
        tblProduto.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tblProduto.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        tblProduto.getColumnModel().getColumn(4).setCellRenderer(esquerda);
         
        tblProduto.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblProduto.getColumnModel().getColumn(2).setPreferredWidth(10);
        tblProduto.getColumnModel().getColumn(3).setPreferredWidth(15);
        tblProduto.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        DefaultTableModel tabela2 = (DefaultTableModel)tblProduto.getModel();
        tabela2.setNumRows(0);
        ProdutoDAO produto = new ProdutoDAO();
        
        for (Produto p : produto.getProdutoByDesc(desc)) 
        {
            if (p != null) 
            {
                tabela2.addRow(new Object[]{
                    p.getCodProduto(),
                    p.getDescProduto(),
                    p.getMinProduto(),
                    p.getCod_tipo(),
                    p.getCod_cat()
                });
            }
        }     
    }
        
    private void preencheTabela()
     {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);
            
        tblProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tblProduto.getColumnModel().getColumn(1).setCellRenderer(esquerda);
        tblProduto.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tblProduto.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        tblProduto.getColumnModel().getColumn(4).setCellRenderer(esquerda);
         
        tblProduto.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblProduto.getColumnModel().getColumn(2).setPreferredWidth(10);
        tblProduto.getColumnModel().getColumn(3).setPreferredWidth(15);
        tblProduto.getColumnModel().getColumn(4).setPreferredWidth(50);
         
        ArrayList<Produto> produto = new ArrayList<Produto>();
        produto = this.produtoDAO.getProdutosByCod();
        
        DefaultTableModel tabela = (DefaultTableModel)tblProduto.getModel();
        tabela.setNumRows(0);
        
        for (Produto p : produto) 
        {
            if (p != null) 
            {
                Object[] obj = new Object[]{
                    p.getCodProduto(),
                    p.getDescProduto(),
                    p.getMinProduto(),
                    p.getCod_tipo(),
                    p.getCod_cat()
                };
                tabela.addRow(obj);
            }
        }        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOrdenar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        rbTipo = new javax.swing.JRadioButton();
        rbCategoria = new javax.swing.JRadioButton();
        lblTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        lblMinimo = new javax.swing.JLabel();
        txtMinimo = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        btnCategoria = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblDescP = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".: Cadastro de Produtos :.");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Est.Minimo", "Tipo", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.getTableHeader().setReorderingAllowed(false);
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setResizable(false);
            tblProduto.getColumnModel().getColumn(1).setResizable(false);
            tblProduto.getColumnModel().getColumn(2).setResizable(false);
            tblProduto.getColumnModel().getColumn(3).setResizable(false);
            tblProduto.getColumnModel().getColumn(4).setResizable(false);
        }

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Produtos"));

        lblCod.setText("* Código:");

        txtCod.setEditable(false);
        txtCod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodFocusLost(evt);
            }
        });

        lblDesc.setText("* Descrição:");

        txtDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescFocusLost(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Trash.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por:"));

        rbCodigo.setText("Código");
        rbCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCodigoMouseClicked(evt);
            }
        });

        rbDescricao.setText("Descrição");
        rbDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbDescricaoMouseClicked(evt);
            }
        });

        rbTipo.setText("Tipo");
        rbTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbTipoMouseClicked(evt);
            }
        });

        rbCategoria.setText("Categoria");
        rbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCategoriaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDescricao)
                    .addComponent(rbTipo)
                    .addComponent(rbCategoria)
                    .addComponent(rbCodigo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbCategoria))
        );

        lblTipo.setText("* Tipo:");

        lblMinimo.setText("*Est.Mínimo:");

        txtMinimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMinimoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMinimoFocusLost(evt);
            }
        });

        lblCategoria.setText("* Categoria:");

        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        btnCategoria.setText(". . .");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(lblCod, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtCod, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblDesc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtDesc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cbTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblMinimo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtMinimo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCategoria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cbCategoria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnCategoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblDesc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDesc))
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCategoria)
                                            .addComponent(lblTipo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblMinimo))
                                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblCod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCod)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDesc)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMinimo)
                            .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCategoria))))
                .addGap(96, 96, 96))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Ordenar por");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDescP.setText("Descrição:");

        txtPesquisar.setBackground(new java.awt.Color(255, 255, 204));
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        btnPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPesquisarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblDescP)
                .addGap(6, 6, 6)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescP)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int opcao = 0;
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (txtDesc.getText().equals("") || cbTipo.getSelectedIndex() == -1 || 
            cbCategoria.getSelectedIndex() == -1 || txtMinimo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "É necessário preencher o(s) campo(s) obrigatório(s)\n "
                + "indicados com ' * ' ! ","ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if (opcao == 1)
           {
            Produto prod = new Produto();
                     
            prod.setCodProduto(Integer.parseInt(txtCod.getText()));
            prod.setDescProduto(txtDesc.getText().toUpperCase());
            prod.setMinProduto(Integer.parseInt(txtMinimo.getText()));
            Tipo tipoSelecionado = (Tipo) cbTipo.getItemAt(cbTipo.getSelectedIndex());
            prod.setCod_tipo(tipoSelecionado);
            //prod.setCod_cat((Categoria)cbCategoria.getSelectedItem());
            Categoria catSelecionada = (Categoria) cbCategoria.getItemAt(cbCategoria.getSelectedIndex());
            prod.setCod_cat(catSelecionada);
            
            if (this.produtoDAO.inserir(prod) == true)
            {   
                String cod = txtCod.getText();
                String desc = txtDesc.getText();
                String min = txtMinimo.getText();
                //String tipo = (String)cbTipo.getSelectedItem();
                Integer tipo = cbTipo.getSelectedIndex();      
                Integer cat = cbCategoria.getSelectedIndex();             
                                                
                JOptionPane.showMessageDialog(null, "Produto " + txtDesc.getText() + " adicionado com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar produto !");
            }
           }
            else if (opcao == 2)
           {
            Produto prod = new Produto();
            
            prod.setCodProduto(Integer.parseInt(txtCod.getText()));
            prod.setDescProduto(txtDesc.getText().toUpperCase());
            prod.setMinProduto(Integer.parseInt(txtMinimo.getText()));
            prod.setCod_tipo((Tipo)cbTipo.getSelectedItem());
            prod.setCod_cat((Categoria)cbCategoria.getSelectedItem());
        
            if (this.produtoDAO.editar(prod) == true)
            {
                JOptionPane.showMessageDialog(null, "Produto modificado com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erro ao modificar produto!");
            }
           }
           preencheTabela();
           Limpar();
           Desabilitar();
           
           //cbTipo.removeAllItems();
           //cbCategoria.removeAllItems();
            
           btnNovo.setEnabled(true);
           btnAlterar.setEnabled(false);
           btnExcluir.setEnabled(false);
           btnCancelar.setEnabled(false);
           btnSalvar.setEnabled(false);
           lblDescP.setEnabled(true);
           txtPesquisar.setEnabled(true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        opcao = 1;
        ProdutoDAO prodDAO = new ProdutoDAO();
       
       popularComboTipo(); 
       
       lblDescP.setEnabled(false);
       txtPesquisar.setEnabled(false);
       txtCod.setText(String.valueOf(prodDAO.AutoIncCod()));
            
       Habilitar();
       
       btnNovo.setEnabled(false);
       btnAlterar.setEnabled(false);
       btnExcluir.setEnabled(false);
       btnCancelar.setEnabled(true);
       btnSalvar.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        opcao = 2;                
        
        lblDescP.setEnabled(false);
        txtPesquisar.setEnabled(false);
        
       Habilitar();
       
       btnNovo.setEnabled(false);
       btnAlterar.setEnabled(false);
       btnExcluir.setEnabled(false);
       btnCancelar.setEnabled(true);
       btnSalvar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Produto prod = new Produto();
        prod.setCodProduto(Integer.parseInt(txtCod.getText()));
        
        int dialogButton = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja excluir o produto selecionado ?","Warning",0);// 0 = botão Sim e Não

       if (dialogButton == JOptionPane.YES_OPTION)
       {
        if (this.produtoDAO.excluir(prod) == true)
        {
            JOptionPane.showMessageDialog(null, "Produto excluido!");
            Limpar();
            Desabilitar();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnSalvar.setEnabled(false);
            txtPesquisar.setEnabled(true);
           
            preencheTabela();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto!");
        }
       }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Limpar();
                        
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        
        Desabilitar();
        
        lblDescP.setEnabled(true);
        txtPesquisar.setEnabled(true);
        
        txtPesquisar.requestFocus();
        
        cbTipo.removeAllItems();
        cbCategoria.removeAllItems();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        lblDescP.setEnabled(true);
        txtPesquisar.setEnabled(true);
        txtPesquisar.requestFocus();
        
       Desabilitar();
       
       btnNovo.setEnabled(true);
       btnAlterar.setEnabled(false);
       btnExcluir.setEnabled(false);
       btnCancelar.setEnabled(false);
       btnSalvar.setEnabled(false);
       
       txtCod.setBackground(java.awt.Color.white);
       
       grupoOrdenar.add(rbCodigo);
       grupoOrdenar.add(rbDescricao);
       grupoOrdenar.add(rbTipo);
       grupoOrdenar.add(rbCategoria);
       rbCodigo.setSelected(true);// inicia selecionado
       
       txtPesquisar.requestFocus();
       /*
       //Popula Combo Tipo
       cbTipo.removeAllItems();
       cbTipo.addItem("GAL");
       cbTipo.addItem("PAR");
       cbTipo.addItem("PCT");
       cbTipo.addItem("UNI");
       cbTipo.setSelectedIndex(-1);             
       */
       
       cbTipo.removeAllItems();
       popularComboTipo();
       cbTipo.updateUI();
       
       cbCategoria.removeAllItems();
       popularComboCategoria();
       cbCategoria.updateUI();
    }//GEN-LAST:event_formWindowOpened

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        // TODO add your handling code here:
        popularComboCategoria();
        //cbCategoria.updateUI();
        popularComboTipo();
        //cbTipo.updateUI();
       
        int linhaselecionada = tblProduto.getSelectedRow(); //pega a linha selecionada
        
        txtCod.setText(tblProduto.getValueAt(linhaselecionada, 0).toString());
        txtDesc.setText(tblProduto.getValueAt(linhaselecionada, 1).toString());
        txtMinimo.setText(tblProduto.getValueAt(linhaselecionada, 2).toString());
        cbTipo.setSelectedItem(tblProduto.getValueAt(linhaselecionada, 3));
        cbCategoria.setSelectedItem(tblProduto.getValueAt(linhaselecionada, 4));
        
       btnNovo.setEnabled(false);
       btnAlterar.setEnabled(true);
       btnExcluir.setEnabled(true);
       btnCancelar.setEnabled(true);
       btnSalvar.setEnabled(false);
       btnPesquisar.setEnabled(false);
       
       btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png")));
       btnPesquisar.setText("Pesquisar");
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void txtCodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodFocusLost
        // TODO add your handling code here:
        txtCod.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_txtCodFocusLost

    private void txtCodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodFocusGained
        // TODO add your handling code here:
        txtCod.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_txtCodFocusGained

    private void txtDescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusGained
        // TODO add your handling code here:
        txtDesc.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_txtDescFocusGained

    private void txtDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusLost
        // TODO add your handling code here:
        txtDesc.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_txtDescFocusLost

    private void rbCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCodigoMouseClicked
        // TODO add your handling code here:
        if (rbCodigo.isSelected())
        {
            ArrayList<Produto> produto = new ArrayList<Produto>();
            produto = this.produtoDAO.getProdutosByCod();
            
            DefaultTableModel tabela = (DefaultTableModel)tblProduto.getModel();
            tabela.setNumRows(0);
            
        for (Produto p : produto) 
        {
            if (p != null) 
            {
                Object[] obj = new Object[]{
                    p.getCodProduto(),
                    p.getDescProduto(),
                    p.getMinProduto(),
                    p.getCod_tipo(),                   
                    p.getCod_cat()
                };
                tabela.addRow(obj);
            }
        }      
        }
    }//GEN-LAST:event_rbCodigoMouseClicked

    private void rbDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbDescricaoMouseClicked
        // TODO add your handling code here:
        if (rbDescricao.isSelected())
        {
            ArrayList<Produto> produto = new ArrayList<Produto>();
            produto = this.produtoDAO.getProdutosByDesc();
            
            DefaultTableModel tabela = (DefaultTableModel)tblProduto.getModel();
            tabela.setNumRows(0);
            
            for (Produto p : produto) 
        {
            if (p != null) 
            {
                Object[] obj = new Object[]{
                    p.getCodProduto(),
                    p.getDescProduto(),
                    p.getMinProduto(),
                    p.getCod_tipo(),
                    p.getCod_cat()
                };
                tabela.addRow(obj);
            }
        }         
        }
    }//GEN-LAST:event_rbDescricaoMouseClicked

    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) //pressionou ENTER
        {  
            btnPesquisar.doClick(); //executa o click do botão 
        }
    }//GEN-LAST:event_txtPesquisarKeyPressed

    private void txtMinimoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinimoFocusGained
        // TODO add your handling code here:
        txtMinimo.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_txtMinimoFocusGained

    private void txtMinimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinimoFocusLost
        // TODO add your handling code here:
        txtMinimo.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_txtMinimoFocusLost

    private void rbTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbTipoMouseClicked
        // TODO add your handling code here:
        if (rbTipo.isSelected())
        {
            ArrayList<Produto> produto = new ArrayList<Produto>();
            produto = this.produtoDAO.getProdutosByTipo();
            
            DefaultTableModel tabela = (DefaultTableModel)tblProduto.getModel();
            tabela.setNumRows(0);
            
            for (Produto p : produto) 
        {
            if (p != null) 
            {
                Object[] obj = new Object[]{
                    p.getCodProduto(),
                    p.getDescProduto(),
                    p.getMinProduto(),
                    p.getCod_tipo(),
                    p.getCod_cat()
                };
                tabela.addRow(obj);
            }
        }         
        }
    }//GEN-LAST:event_rbTipoMouseClicked

    private void rbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCategoriaMouseClicked
        // TODO add your handling code here:
        if (rbCategoria.isSelected())
        {
            ArrayList<Produto> produto = new ArrayList<Produto>();
            produto = this.produtoDAO.getProdutosByCateg();
            
            DefaultTableModel tabela = (DefaultTableModel)tblProduto.getModel();
            tabela.setNumRows(0);
            
            for (Produto p : produto) 
        {
            if (p != null) 
            {
                Object[] obj = new Object[]{
                    p.getCodProduto(),
                    p.getDescProduto(),
                    p.getMinProduto(),
                    p.getCod_tipo(),
                    p.getCod_cat()
                };
                tabela.addRow(obj);
            }
        }         
        }
    }//GEN-LAST:event_rbCategoriaMouseClicked

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed
        
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:       
        grupoOrdenar.clearSelection();
        
        if (btnPesquisar.getText() == "Pesquisar"){
            //Altera o Icone do Botão
            btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clear.png")));
            
            btnPesquisar.setText("Limpar");
            txtPesquisar.setEnabled(false);
            preencheTabela2(txtPesquisar.getText());
        }
        else if (btnPesquisar.getText() == "Limpar"){
            Limpar();          
            DefaultTableModel tabela2 = (DefaultTableModel)tblProduto.getModel();
            tabela2.setNumRows(0);
            //Altera o Icone do Botão
            btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png")));
            btnPesquisar.setText("Pesquisar");
            txtPesquisar.setEnabled(true);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPesquisarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarKeyPressed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
        new FormCategoria().setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.ButtonGroup grupoOrdenar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDescP;
    private javax.swing.JLabel lblMinimo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JRadioButton rbCategoria;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDescricao;
    private javax.swing.JRadioButton rbTipo;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtMinimo;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

public void Habilitar()
{               
    txtCod.setEnabled(false);
    txtDesc.setEnabled(true);
    txtMinimo.setEnabled(true);
    cbTipo.setEnabled(true);
    cbCategoria.setEnabled(true);
    btnCategoria.setEnabled(true);
    txtDesc.requestFocus();//recebe o foco
}

public void Desabilitar()
{
    txtCod.setEnabled(false);
    txtDesc.setEnabled(false);
    txtMinimo.setEnabled(false);
    cbTipo.setEnabled(false);
    cbCategoria.setEnabled(false);
    btnCategoria.setEnabled(false);
}

public void Limpar()
{
    txtCod.setText("");
    txtDesc.setText("");
    txtMinimo.setText("");
    txtPesquisar.setText("");
}

    private void setModal(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
