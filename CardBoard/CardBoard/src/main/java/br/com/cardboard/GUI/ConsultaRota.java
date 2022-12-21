package br.com.cardboard.GUI;

import br.com.cardboard.VO.TipoTransporte;
import br.com.cardboard.VO.Transportadora;
import br.com.cardboard.VO.TransportadoraResultadoVO;
import br.com.cardboard.Controller.RotaController;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConsultaRota extends javax.swing.JFrame {

    private static boolean camposPreenchidos = false;

    public ConsultaRota() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboOrigem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboDestino = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboPrioridade = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransportadoras = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblMelhorOpcao = new javax.swing.JLabel();
        cboTipoTransporte = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDistancia = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter km= new javax.swing.text.MaskFormatter("###.### Km");
            txtDistancia = new javax.swing.JFormattedTextField(km);
        }
        catch (Exception e){
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CardBoard - Consultar Rota");

        jLabel1.setText("Origem");

        cboOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "São Paulo - SP", "Florianópolis - SC", "Salvador - BA" }));

        jLabel2.setText("Destino");

        cboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Manaus - MA", "Campinas - SP", "Belém - PA", "Assunção - PAR", "Brasília - DF " }));

        jLabel3.setText("Prioridade");

        cboPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Tempo", "Valor" }));

        btnCalcular.setText("Calcular Melhor Rota");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        tblTransportadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTransportadoras);

        jLabel4.setText("Melhor Opção");

        cboTipoTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Aereo", "Terrestre" }));

        jLabel5.setText("Tipo Transporte");

        jLabel6.setText("Distância");

        txtDistancia.setToolTipText("Distância em Km");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(cboOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(cboTipoTransporte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMelhorOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboPrioridade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboDestino, javax.swing.GroupLayout.Alignment.LEADING, 0, 153, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboPrioridade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcular)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMelhorOpcao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        verificaPreenchimentoComponentes();

        try {
            if (camposPreenchidos) {
                List<TransportadoraResultadoVO> vTransportadoras = new RotaController().calcularRota(cboOrigem.getSelectedIndex(), cboDestino.getSelectedIndex() + 5, cboTipoTransporte.getSelectedIndex(), cboPrioridade.getSelectedIndex(), Integer.parseInt(txtDistancia.getText().substring(0, 7).replace(".", "").replace(" ", "")));

                if (!vTransportadoras.isEmpty()) {
                    exibir(vTransportadoras);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsultaRota.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cboDestino;
    private javax.swing.JComboBox<String> cboOrigem;
    private javax.swing.JComboBox<String> cboPrioridade;
    private javax.swing.JComboBox<String> cboTipoTransporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMelhorOpcao;
    private javax.swing.JTable tblTransportadoras;
    private javax.swing.JTextField txtDistancia;
    // End of variables declaration//GEN-END:variables

    private void verificaPreenchimentoComponentes() {
        if (cboDestino.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar o destino!");

            cboDestino.requestFocus();

            camposPreenchidos = false;
        } else {
            camposPreenchidos = true;
        }

        if (cboOrigem.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar a origem!");

            cboOrigem.requestFocus();

            camposPreenchidos = false;
        } else {
            camposPreenchidos = true;
        }

        if (cboPrioridade.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "É obrigatório selecionar a prioridade!");

            cboPrioridade.requestFocus();

            camposPreenchidos = false;

        } else {
            camposPreenchidos = true;
        }

        if (txtDistancia.getText().substring(0, 6).replace(".", "").replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(null, "É obrigatório definir a distância!");

            txtDistancia.requestFocus();

            camposPreenchidos = false;

        } else {
            camposPreenchidos = true;
        }
    }

    private void exibir(List<TransportadoraResultadoVO> vTransportadoras) {
        DefaultTableModel modelo = new DefaultTableModel();
        tblTransportadoras.setModel(modelo);

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        
        DecimalFormat resultado = new DecimalFormat("0,000.00");

        modelo.addColumn("Transportadora");
        modelo.addColumn("Tiopo Transporte");
        modelo.addColumn("Distância");
        modelo.addColumn("Tempo Total (min)");
        modelo.addColumn("Valor Total (R$)");

        for (int i = 0; i < 5; i++) {
            tblTransportadoras.getColumnModel().getColumn(i).setPreferredWidth(130);
            tblTransportadoras.getColumnModel().getColumn(i).setCellRenderer(cellRender);
        }

        for (TransportadoraResultadoVO result : vTransportadoras) {

            String idTransportadora = Transportadora.get(result.getIdTransportadora()).getDescricao();
            String idTipoTransporte = TipoTransporte.get(result.getIdTipoTransporte()).getDescricao();
            int distancia = result.getDistancia();
            String valor = resultado.format(result.getValorTotal());
            int tempo = result.getTempoTotal();

            modelo.addRow(new Object[]{idTransportadora, idTipoTransporte, distancia, tempo, valor});
        }

        if (cboPrioridade.getSelectedIndex() == 1) {
            if (vTransportadoras.get(0).getTempoTotal() != vTransportadoras.get(1).getTempoTotal()) {
                lblMelhorOpcao.setText("Transportadora " + vTransportadoras.get(0).getIdTransportadora());
            } else if (vTransportadoras.get(0).getValorTotal().floatValue() == vTransportadoras.get(1).getValorTotal().floatValue()) {
                lblMelhorOpcao.setText("Mais de uma transportadora com os mesmos valores!");
            } else {
                lblMelhorOpcao.setText("Transportadora " + vTransportadoras.get(0).getIdTransportadora());
            }
        } else {
            if (vTransportadoras.get(0).getValorTotal().floatValue() != vTransportadoras.get(1).getValorTotal().floatValue()) {
                lblMelhorOpcao.setText("Transportadora " + vTransportadoras.get(0).getIdTransportadora());
            } else if (vTransportadoras.get(0).getTempoTotal() == vTransportadoras.get(1).getTempoTotal()) {
                lblMelhorOpcao.setText("Mais de uma transportadora com os mesmos valores!");
            } else {
                lblMelhorOpcao.setText("Transportadora " + vTransportadoras.get(0).getIdTransportadora());
            }
        }
    }
}
