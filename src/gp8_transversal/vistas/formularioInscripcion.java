
package gp8_transversal.vistas;
import gp8_transversal.persistencia.AlumnoData;
import gp8_transversal.persistencia.MateriaData;
import gp8_transversal.entidades.Alumno;
import gp8_transversal.entidades.Inscripcion;
import gp8_transversal.entidades.Materia;
import gp8_transversal.persistencia.InscripcionData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
public class formularioInscripcion extends javax.swing.JInternalFrame {

    private List<Alumno>listaA;
    private List<Materia>listaM;
    
    private InscripcionData inscData;
    private MateriaData dataM;
    private AlumnoData dataA;
    
    private DefaultTableModel modelo;
    
    
    
    
    public formularioInscripcion() {
        initComponents();
        
        dataA=new AlumnoData();
        listaA=dataA.mostrarAlumnos();
        modelo= new DefaultTableModel();
        cargarAlumnos();
        armarCabeceraTabla();
        
        inscData=new InscripcionData();
        dataM= new MateriaData();
        
    }

    private void cargarAlumnos(){
for(Alumno item: listaA){
cboxAlumno.addItem(item);
}
}
    
    private void armarCabeceraTabla(){
    ArrayList<Object> filaCabecera = new ArrayList<>();
    filaCabecera.add("ID");
     filaCabecera.add("Nombre");
      filaCabecera.add("Cuatrimestre");
      
      for(Object it: filaCabecera){
      modelo.addColumn(it);
      }
      
    jtMaterias.setModel(modelo);
    }
    private void borrarFilasTabla() {
    int indice = modelo.getRowCount() - 1;
    for (int i = indice; i >= 0; i--) {
        modelo.removeRow(i);
    }
}

private void cargarDatosNoInscriptos() {
    //borrarFilasTabla();
    Alumno selec = (Alumno) cboxAlumno.getSelectedItem();
    listaM =  inscData.obtenerMateriasNOCursadas(selec.getIdAlumno());
    
    for (Materia m : listaM) {
        modelo.addRow(new Object[] { m.getIdMateria(), m.getNombre(), m.getCuatrimestre() });
    }
}
    
    
private void cargarDatosInscriptos() {
    //borrarFilasTabla();
    Alumno selec = (Alumno) cboxAlumno.getSelectedItem();
    listaM = /*(ArrayList)*/ inscData.obtenerMateriasCursadas(selec.getIdAlumno());
    
    for (Materia m : listaM) {
        modelo.addRow(new Object[] { m.getIdMateria(), m.getNombre(), m.getCuatrimestre() });
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboxAlumno = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jrInscriptas = new javax.swing.JRadioButton();
        jrNoinscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbAnular = new javax.swing.JButton();

        setBackground(new java.awt.Color(213, 225, 185));
        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Estado de Materias");

        jrInscriptas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jrInscriptas.setText("Materias Inscriptas");
        jrInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrInscriptasActionPerformed(evt);
            }
        });

        jrNoinscriptas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jrNoinscriptas.setText("Materias no Inscriptas");
        jrNoinscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoinscriptasActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtMaterias);

        jbInscribir.setText("Inscribir");
        jbInscribir.setEnabled(false);
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbAnular.setText("Anular inscripcion");
        jbAnular.setEnabled(false);
        jbAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbInscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAnular)
                        .addGap(46, 46, 46)
                        .addComponent(jbSalir)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrInscriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jrNoinscriptas)
                        .addGap(59, 59, 59))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(152, 152, 152))))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrNoinscriptas)
                    .addComponent(jrInscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbSalir)
                    .addComponent(jbAnular))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrInscriptasActionPerformed
        
        borrarFilasTabla();
        jrNoinscriptas.setSelected(false);
        cargarDatosInscriptos();
        jbAnular.setEnabled(true);
         jbInscribir.setEnabled(false);
        
    }//GEN-LAST:event_jrInscriptasActionPerformed

    private void jrNoinscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoinscriptasActionPerformed
        
           borrarFilasTabla();
        jrInscriptas.setSelected(false);
        cargarDatosNoInscriptos() ;
        jbAnular.setEnabled(false);
         jbInscribir.setEnabled(true);
     
        
    }//GEN-LAST:event_jrNoinscriptasActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
      
        int alumnoSeleccionado = jtMaterias.getSelectedRow();
        
        if(alumnoSeleccionado !=-1){
        Alumno a=(Alumno)cboxAlumno.getSelectedItem();
        int idMateria=(Integer)modelo.getValueAt(alumnoSeleccionado, 0);
        String nombreMateria=(String)modelo.getValueAt(alumnoSeleccionado, 1);
        int cuatrimestre=(Integer)modelo.getValueAt(alumnoSeleccionado, 2);
        Materia m= new Materia(idMateria,nombreMateria,cuatrimestre,true);
        
        Inscripcion i=new Inscripcion(a,m,0);
        inscData.guardarInscripcion(i);
        borrarFilasTabla();
      //  JOptionPane.showMessageDialog(this,"inscripcion realizada");
        
        }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularActionPerformed
        int alumnoSeleccionado=jtMaterias.getSelectedRow();
        if(alumnoSeleccionado!=-1){
            
        Alumno a = (Alumno) cboxAlumno.getSelectedItem();
        int idMateria=(Integer) modelo.getValueAt(alumnoSeleccionado, 0);
        inscData.borrarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
        borrarFilasTabla();
        }
    }//GEN-LAST:event_jbAnularActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
           dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboxAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnular;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrInscriptas;
    private javax.swing.JRadioButton jrNoinscriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
}
