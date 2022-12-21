
package com.mycompany.beclever.vistas;

import com.mycompany.beclever.entidades.Employee;
import com.mycompany.beclever.persistencia.EmployeeData;
import com.mycompany.beclever.persistencia.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.text.SimpleDateFormat;

import java.time.LocalDate;

public class VistaPrincipal extends javax.swing.JFrame {

    Connection conexiondb = Conexion.getConexion();
    EmployeeData eData = new EmployeeData(conexiondb);
    ArrayList<Employee> listaEmpleadosAlta;
    ArrayList<Employee> listaEmpleadosBaja;
    
    private DefaultTableModel modeloTablaEmpleadosAlta;
    private DefaultTableModel modeloTablaEmpleadosBaja;
    
    public VistaPrincipal() {
        initComponents();
        
        modeloTablaEmpleadosAlta = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modeloTablaEmpleadosBaja = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        armarTablas();
        cargarTablas();
        
    }

    public boolean validarCamposVaciosRegistrar() {
        if (JTextName.getText().equals("") || JTextLastName.getText().equals("") || !JTextIDs.getText().equals("") || JDFecha.getDate().equals(null)) {
            return false;
        }
        return true;
    }
    
    public boolean validarCamposVaciosActualizar() {
        if (JTextIDs.getText().equals("") || JTextName.getText().equals("") || JTextLastName.getText().equals("") || JTextIDs.getText().equals("") || JDFecha.getDate().equals(null)) {
            return false;
        }
        return true;
    }
    
    public boolean validarCamposVaciosBuscar() {
        if (JTextIDs.getText().equals("")) {
            return false;
        }
        return true;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JPEmpleadosAlta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTAlta = new javax.swing.JTable();
        JPEmpleadosBaja = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBaja = new javax.swing.JTable();
        JBAlta = new javax.swing.JButton();
        JBBaja = new javax.swing.JButton();
        JTextoNombreFiltro = new javax.swing.JTextField();
        JDDesde = new com.toedter.calendar.JDateChooser();
        JDHasta = new com.toedter.calendar.JDateChooser();
        JCFiltro = new javax.swing.JComboBox<>();
        JBBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTextName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTextLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTextIDs = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JBRegistrar = new javax.swing.JButton();
        JBActualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JDFecha = new com.toedter.calendar.JDateChooser();
        JBLimpiar = new javax.swing.JButton();
        JTextLocation1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JBSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Empleados");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JPEmpleadosAlta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Activos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));
        JPEmpleadosAlta.setPreferredSize(new java.awt.Dimension(420, 150));

        JTAlta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTAlta.setRowHeight(29);
        JTAlta.setShowGrid(true);
        jScrollPane2.setViewportView(JTAlta);

        javax.swing.GroupLayout JPEmpleadosAltaLayout = new javax.swing.GroupLayout(JPEmpleadosAlta);
        JPEmpleadosAlta.setLayout(JPEmpleadosAltaLayout);
        JPEmpleadosAltaLayout.setHorizontalGroup(
            JPEmpleadosAltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        JPEmpleadosAltaLayout.setVerticalGroup(
            JPEmpleadosAltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPEmpleadosAltaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPEmpleadosBaja.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Inactivos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));
        JPEmpleadosBaja.setPreferredSize(new java.awt.Dimension(420, 150));

        JTBaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTBaja.setRowHeight(29);
        JTBaja.setShowGrid(true);
        jScrollPane1.setViewportView(JTBaja);

        javax.swing.GroupLayout JPEmpleadosBajaLayout = new javax.swing.GroupLayout(JPEmpleadosBaja);
        JPEmpleadosBaja.setLayout(JPEmpleadosBajaLayout);
        JPEmpleadosBajaLayout.setHorizontalGroup(
            JPEmpleadosBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        JPEmpleadosBajaLayout.setVerticalGroup(
            JPEmpleadosBajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPEmpleadosBajaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBAlta.setText("Dar alta");
        JBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAltaActionPerformed(evt);
            }
        });

        JBBaja.setText("Dar baja");
        JBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBajaActionPerformed(evt);
            }
        });

        JTextoNombreFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextoNombreFiltroActionPerformed(evt);
            }
        });

        JCFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dueño", "Fechas" }));
        JCFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCFiltroActionPerformed(evt);
            }
        });

        JBBuscar.setText("Q");
        JBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Lugar");

        jLabel5.setText("Fecha");

        JBRegistrar.setText("Registrar");
        JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarActionPerformed(evt);
            }
        });

        JBActualizar.setText("Actualizar");
        JBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBActualizarActionPerformed(evt);
            }
        });

        JBLimpiar.setText("Limpiar");
        JBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        JBSearch.setText("Buscar");
        JBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTextName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTextLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTextIDs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextIDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBSearch))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBActualizar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBLimpiar)
                        .addComponent(JBRegistrar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextoNombreFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(JDDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(JBBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JPEmpleadosBaja, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(JPEmpleadosAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPEmpleadosAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPEmpleadosBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JBAlta)
                                .addComponent(JBBaja)
                                .addComponent(JTextoNombreFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JDDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBAltaActionPerformed

    private void JBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBBajaActionPerformed

    private void JTextoNombreFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextoNombreFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextoNombreFiltroActionPerformed

    private void JCFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCFiltroActionPerformed

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarActionPerformed
        try {
            if (validarCamposVaciosRegistrar()) {
                Employee empleado = new Employee();
                empleado.setName(JTextName.getText());
                empleado.setLastName((JTextLastName.getText()));
                empleado.setBusinessLocation(JTextIDs.getText());
                empleado.setRegisterType(true);
                empleado.setDate(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(JDFecha.getDate())));
                eData.registarEmpleado(empleado);
                
            } else {
                JOptionPane.showMessageDialog(null, "Faltan llenar campos");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema revise los datos ingresados.");
        }
    }//GEN-LAST:event_JBRegistrarActionPerformed

    private void JBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBActualizarActionPerformed
        try {
            if (validarCamposVaciosActualizar()) {
                Employee empleado = new Employee();
                empleado.setName(JTextName.getText());
                empleado.setLastName((JTextLastName.getText()));
                empleado.setBusinessLocation(JTextLocation1.getText());
                empleado.setRegisterType(false);
                empleado.setDate(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(JDFecha.getDate())));
                empleado.setIdEmployee(Integer.parseInt(JTextIDs.getText()));
                eData.actualizarEmpleado(empleado);
            } else {
                JOptionPane.showMessageDialog(null, "Faltan llenar campos");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema revise los datos ingresados. " + ex);
        }
    }//GEN-LAST:event_JBActualizarActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        JTextName.setText("");
        JTextLastName.setText("");
        JTextLocation1.setText("");
        JTextIDs.setText("");
        JDFecha.setDate(null);
        
    }//GEN-LAST:event_JBLimpiarActionPerformed

    private void JBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchActionPerformed
        try {
            if (validarCamposVaciosBuscar()) {
                Employee empleado = new Employee();
                empleado = eData.buscarEmpleadoId(Integer.parseInt(JTextIDs.getText()));
                JTextName.setText(empleado.getName());
                JTextLastName.setText((empleado.getLastName()));
                JTextLocation1.setText(empleado.getBusinessLocation());
                JTextIDs.setText(String.valueOf(empleado.getIdEmployee()));
                JDFecha.setDate(Date.valueOf(empleado.getDate()));

            } else {
                JOptionPane.showMessageDialog(null, "Falta ingresar el dni para buscar.");
            }
        } catch (NumberFormatException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "El dni ingresado contiene caracteres o es invalido.");
        }
    }//GEN-LAST:event_JBSearchActionPerformed

    private void JBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarActionPerformed
        cargarTablas();
    }//GEN-LAST:event_JBBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBActualizar;
    private javax.swing.JButton JBAlta;
    private javax.swing.JButton JBBaja;
    private javax.swing.JButton JBBuscar;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBRegistrar;
    private javax.swing.JButton JBSearch;
    private javax.swing.JComboBox<String> JCFiltro;
    private com.toedter.calendar.JDateChooser JDDesde;
    private com.toedter.calendar.JDateChooser JDFecha;
    private com.toedter.calendar.JDateChooser JDHasta;
    private javax.swing.JPanel JPEmpleadosAlta;
    private javax.swing.JPanel JPEmpleadosBaja;
    private javax.swing.JTable JTAlta;
    private javax.swing.JTable JTBaja;
    private javax.swing.JTextField JTextIDs;
    private javax.swing.JTextField JTextLastName;
    private javax.swing.JTextField JTextLocation1;
    private javax.swing.JTextField JTextName;
    private javax.swing.JTextField JTextoNombreFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
    private void armarTablas() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("id");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("Localizacion");
        columnas.add("Fecha");
        for (Object aux : columnas) {
            modeloTablaEmpleadosBaja.addColumn(aux);
            modeloTablaEmpleadosAlta.addColumn(aux);
        }
        JTAlta.setModel(modeloTablaEmpleadosAlta);
        JTAlta.getColumnModel().getColumn(0).setMaxWidth(0);
        JTAlta.getColumnModel().getColumn(0).setMinWidth(0);
        JTAlta.getColumnModel().getColumn(0).setPreferredWidth(0);

        JTBaja.setModel(modeloTablaEmpleadosBaja);
        JTBaja.getColumnModel().getColumn(0).setMaxWidth(0);
        JTBaja.getColumnModel().getColumn(0).setMinWidth(0);
        JTBaja.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void cargarTablas() {
        modeloTablaEmpleadosAlta.setNumRows(0);
        modeloTablaEmpleadosBaja.setNumRows(0);

        listaEmpleadosAlta = eData.listarEmpleados(true);
        listaEmpleadosBaja =  eData.listarEmpleados(false);

        if (JTextoNombreFiltro.getText().isEmpty() && JCFiltro.getSelectedIndex() != 1) {

            for (Employee aux : listaEmpleadosAlta) {
                modeloTablaEmpleadosAlta.addRow(new Object[]{aux.getIdEmployee(), aux.getName(), aux.getLastName(), aux.getBusinessLocation(), aux.getDate().toString()});

            }

            for (Employee aux : listaEmpleadosBaja) {
                modeloTablaEmpleadosBaja.addRow(new Object[]{aux.getIdEmployee(), aux.getName(), aux.getLastName(), aux.getBusinessLocation(), aux.getDate().toString()});
            }

        } else if (JCFiltro.getSelectedIndex() == 0) { // filtro por Dueño

            for (Employee aux : listaEmpleadosAlta) {

                String Fdueno = aux.getName() + aux.getLastName() + aux.getBusinessLocation();

                if (Fdueno.contains(JTextoNombreFiltro.getText())) {

                    modeloTablaEmpleadosAlta.addRow(new Object[]{aux.getIdEmployee(), aux.getName(), aux.getLastName(), aux.getBusinessLocation(), aux.getDate().toString()});

                }

            }
            for (Employee aux : listaEmpleadosBaja) {

                String Fdueno = aux.getName() + aux.getLastName() + aux.getBusinessLocation();

                if (Fdueno.contains(JTextoNombreFiltro.getText())) {

                    modeloTablaEmpleadosBaja.addRow(new Object[]{aux.getIdEmployee(), aux.getName(), aux.getLastName(), aux.getBusinessLocation(), aux.getDate().toString()});

                }

            }

        }  else if (JCFiltro.getSelectedIndex() == 1) { // filtro por fecha de entrada
            try {
               
                HashSet<Employee> listaEmpleadoFiltradoPorFecha = eData.buscarEmpleadoEntreFechas(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(JDDesde.getDate())), LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(JDDesde.getDate())), false);

                for (Employee aux : listaEmpleadoFiltradoPorFecha) {

                    if (!aux.isRegisterType()) {
                        modeloTablaEmpleadosAlta.addRow(new Object[]{aux.getIdEmployee(), aux.getName(), aux.getLastName(), aux.getBusinessLocation(), aux.getDate().toString()});

                    } else {
                        modeloTablaEmpleadosBaja.addRow(new Object[]{aux.getIdEmployee(), aux.getName(), aux.getLastName(), aux.getBusinessLocation(), aux.getDate().toString()});

                    }

                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Error en el formato de la fecha [ AÑO-MES-DIA ] ");

            }

        }

    }


}
