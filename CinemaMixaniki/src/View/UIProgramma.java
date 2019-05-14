package View;

import Controller.DieuthintisHandler;
import Controller.Handler;
import Model.EvdomadiaioProgramma;
import Model.Provoli;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UIProgramma extends javax.swing.JFrame {

    private DieuthintisHandler handler;

    private final String[] dayNames = {"Δευτέρα", "Τρίτη", "Τετάρτη", "Πέμπτη", "Παρασκευή", "Σάββατο", "Κυριακή"};

    /**
     * Creates new form Diaxeirisi
     *
     * @param handler
     */
    public UIProgramma(DieuthintisHandler handler) {
        this.handler = handler;
        initComponents();
    }

    public DieuthintisHandler getHandler() {
        return handler;
    }

    public void setHandler(DieuthintisHandler handler) {
        this.handler = handler;
    }

    private Provoli getSelectedProvoli() {
        int row = tblProgramma.getSelectedRow();
        for(Provoli p : handler.getProgramma().getProvoles()) {
            if(dayNames[p.getDay()].equals(tblProgramma.getValueAt(row, 0))
                    && new SimpleDateFormat("HH:mm").format(p.getTime()).equals(tblProgramma.getValueAt(row, 1))
                    && p.getAithousa().getName().equals(tblProgramma.getValueAt(row, 2))
                    && p.getTainia().getTitlos().equals(tblProgramma.getValueAt(row, 3))) {
                return p;
            }
        }

        return null;
    }

    public void setProgrammaTableData(EvdomadiaioProgramma programma) {
        DefaultTableModel model = (DefaultTableModel)tblProgramma.getModel();
        model.setRowCount(0);

        ArrayList<Provoli> provolesList = programma.getProvoles();
        for(Provoli p : provolesList) {
            String[] row = new String[8];

            row[0] = dayNames[p.getDay()];
            row[1] = new SimpleDateFormat("HH:mm").format(p.getTime());
            row[2] = p.getAithousa().getName();
            row[3] = p.getTainia().getTitlos();
            row[4] = p.getTainia().getEidos();
            row[5] = p.getTainia().getDiarkeia() + "'";
            row[6] = p.getTainia().getPerigrafh();
            row[7] = new DecimalFormat("#0.00").format(p.getTainia().getTimi());

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProgramma = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UI05 - Προβολή Προγράμματος");
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        btnInsert.setText("Εισαγωγή");
        btnInsert.setToolTipText("");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnEdit.setText("Επεξεργασία");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tblProgramma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ημέρα", "Ώρα", "Αίθουσα", "Τίτλος", "Είδος", "Διάρκεια", "Περιγραφή", "Τιμή εισιτηρίιου"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProgramma.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProgramma);
        tblProgramma.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnDelete.setText("Διαγραφή");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLogout.setText("Αποσύνδεση");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete)
                    .addComponent(btnLogout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            UIProvoli uiProvoli = new UIProvoli(handler);
            uiProvoli.setVisible(true);
        } catch(ParseException e) { /* Ignored */ }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(tblProgramma.getSelectedRow() != -1) {
            UIProvoli uiProvoli = new UIProvoli(handler, getSelectedProvoli());
            uiProvoli.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(tblProgramma.getSelectedRow() != -1) {
            int rval = JOptionPane.showConfirmDialog(this, "Θέλετε σίγουρα να διαγραφεί η προβολή;", "Διαγραφή",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(rval == JOptionPane.YES_OPTION) {
                handler.removeProvoli(getSelectedProvoli());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Handler h = new Handler();
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLogout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProgramma;
    // End of variables declaration//GEN-END:variables
}
