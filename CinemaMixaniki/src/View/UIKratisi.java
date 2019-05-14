package View;

import Controller.PelatisHandler;
import Model.Kratisi;
import Model.Provoli;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;

public class UIKratisi extends javax.swing.JFrame {

    private final PelatisHandler handler;
    private final Kratisi kratisi;

    private final String[] dayNames = {"Δευτέρα", "Τρίτη", "Τετάρτη", "Πέμπτη", "Παρασκευή", "Σάββατο", "Κυριακή"};

    public UIKratisi(PelatisHandler handler, Kratisi kratisi) {
        this.handler = handler;
        this.kratisi = kratisi;

        initComponents();

        String[] provoles = new String[handler.getProvoles().size()];
        for(int i = 0; i < provoles.length; i++) {
            provoles[i] = handler.getProvoles().get(i).getTainia().getTitlos() + ","
                    + dayNames[handler.getProvoles().get(i).getDay()] + ","
                    + new SimpleDateFormat("HH:mm").format(handler.getProvoles().get(i).getTime());
        }
        cmbProvoli.setModel(new DefaultComboBoxModel(provoles));
        cmbProvoli.setSelectedItem(kratisi.getProvoli().getTainia().getTitlos()
                + "," + dayNames[kratisi.getProvoli().getDay()] + ","
                + new SimpleDateFormat("HH:mm").format(kratisi.getProvoli().getTime()));

        updateStoixeia();
    }

    public UIKratisi(PelatisHandler handler) {
        this(handler, new Kratisi(handler.getPelatis(), handler.getProvoles().get(0)));
    }

    private void updateStoixeia() {
        lblEidos.setText(getSelectedProvoli().getTainia().getEidos());
        lblDiarkeia.setText(getSelectedProvoli().getTainia().getDiarkeia() + "'");
        lblAithousa.setText(getSelectedProvoli().getAithousa().getName());
    }

    private Provoli getSelectedProvoli() {
        StringTokenizer st = new StringTokenizer(cmbProvoli.getSelectedItem().toString(), ",");
        String tainia = st.nextToken();
        String day = st.nextToken();
        String time = st.nextToken();

        for(Provoli p : handler.getProvoles()) {
            if(p.getTainia().getTitlos().equals(tainia) && dayNames[p.getDay()].equals(day)
                    && new SimpleDateFormat("HH:mm").format(p.getTime()).equals(time)) {
                return p;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltainia = new javax.swing.JLabel();
        labeleidos = new javax.swing.JLabel();
        labeldiarkeia = new javax.swing.JLabel();
        labelprovoli = new javax.swing.JLabel();
        cmbProvoli = new javax.swing.JComboBox();
        lblEidos = new javax.swing.JTextField();
        lblDiarkeia = new javax.swing.JTextField();
        lblAithousa = new javax.swing.JTextField();
        btnApothikeusi = new javax.swing.JButton();
        btnAkirosi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ΚΡΑΤΗΣΗ");

        labeltainia.setText("Ταινία : ");

        labeleidos.setText("Είδος : ");

        labeldiarkeia.setText("Διάρκεια  :  ");

        labelprovoli.setText("Προβολή  : ");

        cmbProvoli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "προβολη_1" }));
        cmbProvoli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvoliItemStateChanged(evt);
            }
        });

        lblEidos.setText("ΚΩΜΩΔΙΑ");

        lblDiarkeia.setText("120'");

        lblAithousa.setText("ΑΙΘΟΥΣΑ_1");

        btnApothikeusi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnApothikeusi.setText("ΑΠΟΘΗΚΕΥΣΗ");
        btnApothikeusi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApothikeusiActionPerformed(evt);
            }
        });

        btnAkirosi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAkirosi.setText("ΑΚΥΡΩΣΗ");
        btnAkirosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAkirosiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeltainia)
                            .addComponent(labeleidos)
                            .addComponent(labeldiarkeia)
                            .addComponent(labelprovoli))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEidos)
                            .addComponent(cmbProvoli, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiarkeia)
                            .addComponent(lblAithousa, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(btnApothikeusi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAkirosi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltainia)
                    .addComponent(cmbProvoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeleidos)
                    .addComponent(lblEidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldiarkeia)
                    .addComponent(lblDiarkeia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelprovoli)
                    .addComponent(lblAithousa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApothikeusi)
                    .addComponent(btnAkirosi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProvoliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvoliItemStateChanged
        updateStoixeia();
    }//GEN-LAST:event_cmbProvoliItemStateChanged

    private void btnAkirosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAkirosiActionPerformed
        dispose();
    }//GEN-LAST:event_btnAkirosiActionPerformed

    private void btnApothikeusiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApothikeusiActionPerformed
        if(handler.getKratiseis().contains(kratisi)) {
            handler.editKratisi(kratisi, getSelectedProvoli(), kratisi.getEisitiriaList());
        }
        else {
            kratisi.setProvoli(getSelectedProvoli());
            handler.addKratisi(kratisi);
        }
    }//GEN-LAST:event_btnApothikeusiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAkirosi;
    private javax.swing.JButton btnApothikeusi;
    private javax.swing.JComboBox cmbProvoli;
    private javax.swing.JLabel labeldiarkeia;
    private javax.swing.JLabel labeleidos;
    private javax.swing.JLabel labelprovoli;
    private javax.swing.JLabel labeltainia;
    private javax.swing.JTextField lblAithousa;
    private javax.swing.JTextField lblDiarkeia;
    private javax.swing.JTextField lblEidos;
    // End of variables declaration//GEN-END:variables
}
