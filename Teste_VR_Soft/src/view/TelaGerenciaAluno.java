/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Aluno;
import model.bean.Curso;
import model.bean.CursoAluno;
import model.dao.AlunoCursoDAO;
import model.dao.AlunoDAO;
import model.dao.CursoDAO;

/**
 *
 * @author eduma
 */
public class TelaGerenciaAluno extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaGerenciaAluno
     */
    public TelaGerenciaAluno() {
        initComponents();
    }
    
    public void readJTableAllAluno(){
        DefaultTableModel modelo = (DefaultTableModel) jTAlunos.getModel();
        
        modelo.setNumRows(0);
        
        AlunoDAO alunoDao = new AlunoDAO();
        
        for(Aluno aluno: alunoDao.readAll()){
            modelo.addRow(new Object[]{
                aluno.getCodigo(),
                aluno.getNome()
            
        });}
        
    }
    public void readJTableCodigoAluno(){
        
        if (jFCodigoAluno.getText().trim().equals("")){
            
            JOptionPane.showMessageDialog(null, "É necessário informar um código válido!");
        }
        else{
            DefaultTableModel modelo = (DefaultTableModel) jTAlunos.getModel();
        
        modelo.setNumRows(0);
        
        AlunoDAO alunoDao = new AlunoDAO();
        
        Aluno aluno = new Aluno();
        
        aluno.setCodigo(Integer.parseInt(jFCodigoAluno.getText()));
       
        alunoDao.readCodigo(aluno);
            modelo.addRow(new Object[]{
                aluno.getCodigo(),
                aluno.getNome()
            
        });
        }
        
    }
    public void readJTableNomeAluno(){
        
        if (jTFNomeAluno.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "É necessário informar um nome válido!");
        }
        else{
            
            DefaultTableModel modelo = (DefaultTableModel) jTAlunos.getModel();
        
        modelo.setNumRows(0);
        
        AlunoDAO alunoDao = new AlunoDAO();
        
        Aluno aluno = new Aluno();
        
        aluno.setNome(jTFNomeAluno.getText());
       
        alunoDao.readNome(aluno);
            modelo.addRow(new Object[]{
                aluno.getCodigo(),
                aluno.getNome()
            
        });
        }
        
    }
    
    public void readJTableAllCurso(){
        DefaultTableModel modelo = (DefaultTableModel) jTCursos.getModel();
        
        modelo.setNumRows(0);
        
        CursoDAO cursoDao = new CursoDAO();
        
        for(Curso curso: cursoDao.readAll()){
            modelo.addRow(new Object[]{
                curso.getCodigo(),
                curso.getDescricao(),
                curso.getEmenta()
            
        });}
        
    }
    
    public void readJTableAllCursoAluno(){
        DefaultTableModel modelo = (DefaultTableModel) jTAlunoCurso.getModel();
        
        modelo.setNumRows(0);
        
        AlunoCursoDAO alunoCursoDao = new AlunoCursoDAO();
        
        for(CursoAluno cursoAluno: alunoCursoDao.readAll()){
            modelo.addRow(new Object[]{
                cursoAluno.getCodigo(),
                cursoAluno.getCodigo_aluno(),
                cursoAluno.getNome_aluno(),
                cursoAluno.getCodigo_curso(),
                cursoAluno.getDescricao_curso()            
        });}
        
    }
    public void readJTableCodigoCurso(){
        
        if (jFCodigoCurso.getText().trim().equals("")){
            
            JOptionPane.showMessageDialog(null, "É necessário informar um código válido!");
        }
        else{
            DefaultTableModel modelo = (DefaultTableModel) jTCursos.getModel();
        
        modelo.setNumRows(0);
        
        CursoDAO cursoDao = new CursoDAO();
        
        Curso curso = new Curso();
        
        curso.setCodigo(Integer.parseInt(jFCodigoCurso.getText()));
       
        cursoDao.readCodigo(curso);
            modelo.addRow(new Object[]{
                curso.getCodigo(),
                curso.getDescricao(),
                curso.getEmenta()
            
        });
        }
        
    }
    public void readJTableDescricaoCurso(){
        
        if (jTFDescricaoCurso.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "É necessário informar uma descrição válida!");
        }
        else{
            
            DefaultTableModel modelo = (DefaultTableModel) jTCursos.getModel();
        
        modelo.setNumRows(0);
        
        CursoDAO cursoDao = new CursoDAO();
        
        Curso curso = new Curso();
        
        curso.setDescricao(jTFDescricaoCurso.getText());
       
        cursoDao.readDescricao(curso);
            modelo.addRow(new Object[]{
                curso.getCodigo(),
                curso.getDescricao(),
                curso.getEmenta()
            
        });
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jFCodigoAluno = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTFNomeAluno = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlunos = new javax.swing.JTable();
        jBCodigoCurso = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBTodosCursos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTCursos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jFCodigoCurso = new javax.swing.JTextField();
        jTFDescricaoCurso = new javax.swing.JTextField();
        jBDescricaoCurso = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTAlunoCurso = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jBAllAlunosCurso = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciar Cursos e Alunos");

        jLabel1.setText("Alunos Cadastrados");

        jButton1.setText("Exibir Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar Aluno:");

        jFCodigoAluno.setText("Código do Aluno");
        jFCodigoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFCodigoAlunoKeyPressed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTFNomeAluno.setText("Nome do Aluno");
        jTFNomeAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNomeAlunoKeyPressed(evt);
            }
        });

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAlunos);

        jBCodigoCurso.setText("Buscar");
        jBCodigoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCodigoCursoActionPerformed(evt);
            }
        });

        jLabel3.setText("Cursos Cadastrados");

        jBTodosCursos.setText("Exibir Todos");
        jBTodosCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTodosCursosActionPerformed(evt);
            }
        });

        jTCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Ementa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCursosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTCursos);

        jLabel5.setText("Pesquisar Curso:");

        jFCodigoCurso.setText("Código do Curso");
        jFCodigoCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFCodigoCursoKeyPressed(evt);
            }
        });

        jTFDescricaoCurso.setText("Descrição do Curso");
        jTFDescricaoCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFDescricaoCursoKeyPressed(evt);
            }
        });

        jBDescricaoCurso.setText("Buscar");
        jBDescricaoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDescricaoCursoActionPerformed(evt);
            }
        });

        jLabel6.setText("Associar Aluno a um Curso");

        jButton5.setText("Associar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTAlunoCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Controle", "Código Aluno", "Nome Aluno", "Código Curso", "Descrição Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTAlunoCurso);

        jLabel4.setText("Cadastros");

        jBAllAlunosCurso.setText("Exibir Todos");
        jBAllAlunosCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAllAlunosCursoActionPerformed(evt);
            }
        });

        jLabel7.setText("Excluir um registro");

        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jFCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(174, 174, 174))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jTFNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBTodosCursos)
                        .addGap(841, 841, 841))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTFDescricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBDescricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(638, 638, 638))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAllAlunosCurso)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1)
                            .addComponent(jLabel3)
                            .addComponent(jBTodosCursos))
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBCodigoCurso)
                            .addComponent(jButton2)
                            .addComponent(jFCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFDescricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBDescricaoCurso)
                            .addComponent(jButton3)
                            .addComponent(jTFNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton5)
                    .addComponent(jLabel4)
                    .addComponent(jBAllAlunosCurso)
                    .addComponent(jLabel7)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        readJTableAllAluno();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jFCodigoAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFCodigoAlunoKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            readJTableCodigoAluno();
        }

    }//GEN-LAST:event_jFCodigoAlunoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        readJTableCodigoAluno();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTFNomeAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNomeAlunoKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            readJTableNomeAluno();
        }

    }//GEN-LAST:event_jTFNomeAlunoKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        readJTableNomeAluno();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAlunosMouseClicked
        // TODO add your handling code here:

        if(jTAlunos.getSelectedRow() != -1){

            jFCodigoAluno.setText(jTAlunos.getValueAt(jTAlunos.getSelectedRow(), 0).toString());
            jTFNomeAluno.setText(jTAlunos.getValueAt(jTAlunos.getSelectedRow(), 1).toString());
        }

    }//GEN-LAST:event_jTAlunosMouseClicked

    private void jBTodosCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTodosCursosActionPerformed
        // TODO add your handling code here:

        readJTableAllCurso();

    }//GEN-LAST:event_jBTodosCursosActionPerformed

    private void jTCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCursosMouseClicked
        // TODO add your handling code here:

        if(jTCursos.getSelectedRow() != -1){

            jFCodigoCurso.setText(jTCursos.getValueAt(jTCursos.getSelectedRow(), 0).toString());
            jTFDescricaoCurso.setText(jTCursos.getValueAt(jTCursos.getSelectedRow(), 1).toString());
            }

    }//GEN-LAST:event_jTCursosMouseClicked

    private void jFCodigoCursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFCodigoCursoKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            readJTableCodigoCurso();
        }

    }//GEN-LAST:event_jFCodigoCursoKeyPressed

    private void jTFDescricaoCursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDescricaoCursoKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            readJTableDescricaoCurso();
        }

    }//GEN-LAST:event_jTFDescricaoCursoKeyPressed

    private void jBDescricaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDescricaoCursoActionPerformed
        // TODO add your handling code here:

        readJTableDescricaoCurso();

    }//GEN-LAST:event_jBDescricaoCursoActionPerformed

    private void jBCodigoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCodigoCursoActionPerformed
        // TODO add your handling code here:

        readJTableCodigoCurso();
    }//GEN-LAST:event_jBCodigoCursoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        CursoAluno cursoaluno = new CursoAluno();
        AlunoCursoDAO alunocursoDAO = new AlunoCursoDAO();
        
        cursoaluno.setCodigo_aluno((int)jTAlunos.getValueAt(jTAlunos.getSelectedRow(), 0));
        cursoaluno.setNome_aluno(jTAlunos.getValueAt(jTAlunos.getSelectedRow(), 1).toString());
        cursoaluno.setCodigo_curso((int)jTCursos.getValueAt(jTCursos.getSelectedRow(), 0));
        cursoaluno.setDescricao_curso(jTCursos.getValueAt(jTCursos.getSelectedRow(), 1).toString());
                
        alunocursoDAO.create(cursoaluno);
        
        readJTableAllCursoAluno();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBAllAlunosCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAllAlunosCursoActionPerformed
        // TODO add your handling code here:
        
        readJTableAllCursoAluno();
        
    }//GEN-LAST:event_jBAllAlunosCursoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        CursoAluno cursoaluno = new CursoAluno();
        AlunoCursoDAO alunoCursoDao = new AlunoCursoDAO();
        
        if(jTAlunoCurso.getSelectedRow() != -1){
            
            cursoaluno.setCodigo((int)jTAlunoCurso.getValueAt(jTAlunoCurso.getSelectedRow(), 0));
            
            alunoCursoDao.delete(cursoaluno);
            
            readJTableAllCursoAluno();
            
        }else {
            JOptionPane.showMessageDialog(null, "Para efetuar esta ação selecione a linha a ser excluida.");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAllAlunosCurso;
    private javax.swing.JButton jBCodigoCurso;
    private javax.swing.JButton jBDescricaoCurso;
    private javax.swing.JButton jBTodosCursos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField jFCodigoAluno;
    private javax.swing.JTextField jFCodigoCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTAlunoCurso;
    private javax.swing.JTable jTAlunos;
    private javax.swing.JTable jTCursos;
    private javax.swing.JTextField jTFDescricaoCurso;
    private javax.swing.JTextField jTFNomeAluno;
    // End of variables declaration//GEN-END:variables
}
