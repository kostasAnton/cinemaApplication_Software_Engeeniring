package View;

import Controller.Handler;
import Controller.PelatisHandler;
import Model.Kratisi;
import Model.Provoli;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UIPelatis extends javax.swing.JFrame {

    private final PelatisHandler handler;

    private final String[] dayNames = {"Δευτέρα", "Τρίτη", "Τετάρτη", "Πέμπτη", "Παρασκευή", "Σάββατο", "Κυριακή"};

    public UIPelatis(PelatisHandler handler) {
        this.handler = handler;
        initComponents();
    }

    private Kratisi getSelectedKratisi() {
        int row = TableKratisi.getSelectedRow();
        for(Kratisi k : handler.getKratiseis()) {
            Provoli p = k.getProvoli();
            if(p.getTainia().getTitlos().equals(TableKratisi.getValueAt(row, 0))
                    && dayNames[p.getDay()].equals(TableKratisi.getValueAt(row, 1))
                    && new SimpleDateFormat("HH:mm").format(p.getTime()).equals(TableKratisi.getValueAt(row, 2))
                    && p.getAithousa().getName().equals(TableKratisi.getValueAt(row, 3))) {
                return k;
            }
        }

        return null;
    }

    public void setTableData(ArrayList<Kratisi> kratisiList) {
        DefaultTableModel model = (DefaultTableModel)TableKratisi.getModel();
        model.setRowCount(0);

        for(Kratisi k : kratisiList) {
            String row[] = new String[5];

            row[0] = k.getProvoli().getTainia().getTitlos();
            row[1] = dayNames[k.getProvoli().getDay()];
            row[2] = new SimpleDateFormat("HH:mm").format(k.getProvoli().getTime());
            row[3] = k.getProvoli().getAithousa().getName();
            row[4] = k.getEisitiriaList().size() + "";

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableKratisi = new javax.swing.JTable();
        btndimiourg = new javax.swing.JButton();
        btnepeks = new javax.swing.JButton();
        btndiagr = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableKratisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ΤΑΙΝΙΑ", "ΜΕΡΑ", "ΩΡΑ", "ΑΙΘΟΥΣΑ", "ΘΕΣΕΙΣ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableKratisi.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableKratisi);
        TableKratisi.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btndimiourg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndimiourg.setText("ΔΗΜΙΟΥΡΓΙΑ ΚΡΑΤΗΣΗΣ ");
        btndimiourg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndimiourgActionPerformed(evt);
            }
        });

        btnepeks.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnepeks.setText("ΕΠΕΞΕΡΓΑΣΙΑ ΚΡΑΤΗΣΗΣ ");
        btnepeks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnepeksActionPerformed(evt);
            }
        });

        btndiagr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndiagr.setText("ΔΙΑΓΡΑΦΗ ΚΡΑΤΗΣΗΣ ");
        btndiagr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndiagrActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogout.setText("ΑΠΟΣΥΝΔΕΣΗ");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btndimiourg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnepeks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndiagr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndimiourg)
                    .addComponent(btnepeks)
                    .addComponent(btndiagr))
                .addGap(92, 92, 92)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndiagrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndiagrActionPerformed
        if(TableKratisi.getSelectedRow() != -1) {
            int rval = JOptionPane.showConfirmDialog(this, "Θέλετε σίγουρα να διαγραφεί η κράτηση;", "Διαγραφή",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(rval == JOptionPane.YES_OPTION) {
                handler.removeKratisi(getSelectedKratisi());
            }
        }
    }//GEN-LAST:event_btndiagrActionPerformed

    private void btnepeksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnepeksActionPerformed
        if(TableKratisi.getSelectedRow() != -1) {
            UIKratisi uiKratisi = new UIKratisi(handler, getSelectedKratisi());
            uiKratisi.setVisible(true);
        }
    }//GEN-LAST:event_btnepeksActionPerformed

    private void btndimiourgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndimiourgActionPerformed
        UIKratisi uiKratisi = new UIKratisi(handler);
        uiKratisi.setVisible(true);
    }//GEN-LAST:event_btndimiourgActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Handler h = new Handler();
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableKratisi;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btndiagr;
    private javax.swing.JButton btndimiourg;
    private javax.swing.JButton btnepeks;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
