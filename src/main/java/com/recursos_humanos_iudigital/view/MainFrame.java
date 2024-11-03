package com.recursos_humanos_iudigital.view;

import com.recursos_humanos_iudigital.controller.FuncionarioController;
import com.recursos_humanos_iudigital.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = {"ID", "TIPO IDENTIFICACIÓN", "NÚMERO IDENTIFICACIÓN",
        "NOMBRES", "APELLIDOS", "ESTADO CIVIL", "SEXO", "DIRECCIÓN", "TELÉFONO", "FECHA NACIMIENTO"};
    private static final String SELECCIONE = "--SELECCIONE--";

    public MainFrame() {
        initComponents();
        txtIdEdit.setEditable(false);
        funcionarioController = new FuncionarioController();
        listFuncionarios();
        addListener();
    }

        private void listFuncionarios() {
        cbxFuncionario.removeAllItems();
        Funcionario funcionarioCombo = new Funcionario();
        funcionarioCombo.setNombres(SELECCIONE);
        funcionarioCombo.setApellidos("");
        cbxFuncionario.addItem(funcionarioCombo);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblFunc.setModel(defaultTableModel);
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionario();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getId(), row, 0);
                defaultTableModel.setValueAt(funcionario.getTipoIdentificacion(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNumeroIdentificacion(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombres(), row, 3);
                defaultTableModel.setValueAt(funcionario.getApellidos(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil(), row, 5);
                defaultTableModel.setValueAt(funcionario.getSexo(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 8);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 9);
                row++;

                cbxFuncionario.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    private void addListener() {
    cbxFuncionario.addItemListener(event -> {
        Funcionario selectedFuncionario = (Funcionario) event.getItem();

        if (selectedFuncionario.getNombres().equals(SELECCIONE)) {
            txtIdEdit.setText("");
            cbxIdTypeEdit.setSelectedIndex(0); 
            txtIdNumberEdit.setText("");
            txtNameEdit.setText("");
            txtLastEdit.setText("");
            cbxStatusEdit.setSelectedIndex(0); 
            cbxSexEdit.setSelectedIndex(0); 
            txtPhoneEdit.setText("");
            txtAddressEdit.setText("");
            dchBirthdateEdit.setDate(null);
        } else {
            txtIdEdit.setText(String.valueOf(selectedFuncionario.getId()));

            for (int i = 0; i < cbxIdTypeEdit.getItemCount(); i++) {
                if (cbxIdTypeEdit.getItemAt(i).equals(selectedFuncionario.getTipoIdentificacion())) {
                    cbxIdTypeEdit.setSelectedIndex(i);
                    break;
                }
            }

            txtIdNumberEdit.setText(selectedFuncionario.getNumeroIdentificacion());
            txtNameEdit.setText(selectedFuncionario.getNombres());
            txtLastEdit.setText(selectedFuncionario.getApellidos());

            for (int i = 0; i < cbxStatusEdit.getItemCount(); i++) {
                if (cbxStatusEdit.getItemAt(i).equals(selectedFuncionario.getEstadoCivil())) {
                    cbxStatusEdit.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i < cbxSexEdit.getItemCount(); i++) {
                if (cbxSexEdit.getItemAt(i).equals(selectedFuncionario.getSexo())) {
                    cbxSexEdit.setSelectedIndex(i);
                    break;
                }
            }

            txtPhoneEdit.setText(selectedFuncionario.getTelefono());
            txtAddressEdit.setText(selectedFuncionario.getDireccion());
            dchBirthdateEdit.setDate(selectedFuncionario.getFechaNacimiento());
        }
    });
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanels = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPfunc = new javax.swing.JPanel();
        lblIdType = new javax.swing.JLabel();
        lblIdNumber = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLast = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblBirthdate = new javax.swing.JLabel();
        txtIdNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLast = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        cbxIdType = new javax.swing.JComboBox<>();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxSex = new javax.swing.JComboBox<>();
        dchBirthdate = new com.toedter.calendar.JDateChooser();
        btnCreate = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFunc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox<>();
        lblIdTypeEdit = new javax.swing.JLabel();
        cbxIdTypeEdit = new javax.swing.JComboBox<>();
        lblIdNumberEdit = new javax.swing.JLabel();
        txtIdNumberEdit = new javax.swing.JTextField();
        lblNameEdit = new javax.swing.JLabel();
        txtNameEdit = new javax.swing.JTextField();
        lblLastEdit = new javax.swing.JLabel();
        txtLastEdit = new javax.swing.JTextField();
        lblStatusEdit = new javax.swing.JLabel();
        cbxStatusEdit = new javax.swing.JComboBox<>();
        lblSexEdit = new javax.swing.JLabel();
        cbxSexEdit = new javax.swing.JComboBox<>();
        lblAddressEdit = new javax.swing.JLabel();
        txtAddressEdit = new javax.swing.JTextField();
        lblPhoneEdit = new javax.swing.JLabel();
        txtPhoneEdit = new javax.swing.JTextField();
        lblBirthdateEdit = new javax.swing.JLabel();
        dchBirthdateEdit = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblIdEdit = new javax.swing.JLabel();
        txtIdEdit = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("GESTION DE FUNCIONARIOS IUDIGITAL");

        jPfunc.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblIdType.setText("Tipo de Identificación:");

        lblIdNumber.setText("Número de Identificación:");

        lblName.setText("Nombres:");

        lblLast.setText("Apellidos:");

        lblStatus.setText("Estado Civil:");

        lblSex.setText("Sexo:");

        lblAddress.setText("Dirección:");

        lblPhone.setText("Teléfono:");

        lblBirthdate.setText("Fecha de Nacimiento:");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        cbxIdType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "C.C", "C.E", "T.I", "Pasaporte " }));

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Soltero", "Casado", "Divorciado", "Viudo" }));

        cbxSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Masculino", "Femenino" }));

        btnCreate.setText("GUARDAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPfuncLayout = new javax.swing.GroupLayout(jPfunc);
        jPfunc.setLayout(jPfuncLayout);
        jPfuncLayout.setHorizontalGroup(
            jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPfuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdType)
                    .addComponent(lblSex)
                    .addComponent(cbxSex, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddress)
                    .addComponent(lblIdNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdNumber)
                    .addComponent(txtAddress))
                .addGap(46, 46, 46)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(txtName))
                .addGap(41, 41, 41)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPfuncLayout.createSequentialGroup()
                        .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblLast)
                            .addComponent(dchBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtLast))
                        .addGap(39, 39, 39)
                        .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus)
                            .addComponent(btnCreate)))
                    .addComponent(lblBirthdate))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPfuncLayout.setVerticalGroup(
            jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPfuncLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdType)
                    .addComponent(lblName)
                    .addComponent(lblIdNumber)
                    .addComponent(lblLast)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPfuncLayout.createSequentialGroup()
                        .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSex)
                            .addComponent(lblAddress)
                            .addComponent(lblPhone)
                            .addComponent(lblBirthdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPfuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblFunc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPfunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPfunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );

        jPanels.addTab("Crear Funcionario", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));
        jPanel3.setToolTipText("");

        lblFuncionarios.setText("Funcionarios:");

        lblIdTypeEdit.setText("Tipo de Identificación:");

        cbxIdTypeEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "C.C", "C.E", "T.I", "Pasaporte " }));

        lblIdNumberEdit.setText("Número de Identificación:");

        lblNameEdit.setText("Nombres:");

        lblLastEdit.setText("Apellidos:");

        lblStatusEdit.setText("Estado Civil:");

        cbxStatusEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Soltero", "Casado", "Divorciado", "Viudo" }));

        lblSexEdit.setText("Sexo:");

        cbxSexEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Masculino", "Femenino" }));

        lblAddressEdit.setText("Dirección:");

        txtAddressEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressEditActionPerformed(evt);
            }
        });

        lblPhoneEdit.setText("Teléfono:");

        lblBirthdateEdit.setText("Fecha de Nacimiento:");

        btnEdit.setText("ACTUALIZAR");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("ELIMINAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblIdEdit.setText("ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEdit))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxIdTypeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdTypeEdit)
                                    .addComponent(lblSexEdit))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIdNumberEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtIdNumberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 46, Short.MAX_VALUE))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(lblAddressEdit)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbxSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(txtAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblNameEdit))
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblLastEdit)
                                                    .addComponent(txtLastEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblPhoneEdit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                                .addComponent(lblBirthdateEdit)))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblStatusEdit)
                                            .addComponent(cbxStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dchBirthdateEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(150, 150, 150))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(btnDelete)
                                .addGap(273, 273, 273))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFuncionarios)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lblIdEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIdEdit)
                        .addComponent(txtIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFuncionarios))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdTypeEdit)
                        .addComponent(lblIdNumberEdit)
                        .addComponent(lblNameEdit))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLastEdit)
                        .addComponent(lblStatusEdit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxIdTypeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdNumberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSexEdit)
                    .addComponent(lblAddressEdit)
                    .addComponent(lblPhoneEdit)
                    .addComponent(lblBirthdateEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dchBirthdateEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 127, Short.MAX_VALUE))
        );

        jPanels.addTab("Actualizar Funcionario", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanels)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        
        if (cbxIdType.getSelectedItem() == null || cbxIdType.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione tipo de identificación");
            cbxIdType.requestFocus();
            return;
        }

        if (txtIdNumber.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite número de identificación");
            txtIdNumber.requestFocus();
            return;
        }

        if (txtName.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite nombres");
            txtName.requestFocus();
            return;
        }

        if (txtLast.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite apellidos");
            txtLast.requestFocus();
            return;
        }

        if (cbxStatus.getSelectedItem() == null || cbxStatus.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione estado civil");
            cbxStatus.requestFocus();
            return;
        }

        String sexoSeleccionado = (String) cbxSex.getSelectedItem(); 
        if (sexoSeleccionado == null || sexoSeleccionado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione el sexo");
            cbxSex.requestFocus();
            return;
        }

        if (txtPhone.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite teléfono");
            txtPhone.requestFocus();
            return;
        }

        if (txtAddress.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite dirección");
            txtAddress.requestFocus();
            return;
        }

        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(cbxIdType.getSelectedItem().toString().trim()); 
            funcionario.setNumeroIdentificacion(txtIdNumber.getText().trim());
            funcionario.setNombres(txtName.getText().trim());
            funcionario.setApellidos(txtLast.getText().trim());
            funcionario.setEstadoCivil(cbxStatus.getSelectedItem().toString().trim()); 
            funcionario.setSexo(sexoSeleccionado); 
            funcionario.setTelefono(txtPhone.getText().trim());
            funcionario.setDireccion(txtAddress.getText().trim());
            funcionario.setFechaNacimiento(dchBirthdate.getDate());

            funcionarioController.crearFuncionario(funcionario);

            cbxIdType.setSelectedIndex(0); 
            txtIdNumber.setText("");
            txtName.setText("");
            txtLast.setText("");
            cbxStatus.setSelectedIndex(0); 
            cbxSex.setSelectedIndex(0); 
            txtPhone.setText("");
            txtAddress.setText("");
            dchBirthdate.setDate(null);

            listFuncionarios();

            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el funcionario");
        }

    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtAddressEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if (txtIdEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtIdEdit.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el funcionario?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opt == JOptionPane.YES_OPTION) { 

            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtIdEdit.getText()));

                cbxIdTypeEdit.setSelectedIndex(0); 
                txtIdNumberEdit.setText("");
                txtNameEdit.setText("");
                txtLastEdit.setText("");
                cbxStatusEdit.setSelectedIndex(0); 
                cbxSexEdit.setSelectedIndex(0); 
                txtPhoneEdit.setText("");
                txtAddressEdit.setText("");
                dchBirthdateEdit.setDate(null);

                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Se eliminó el funcionario correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el funcionario");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    
        if (txtIdEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtIdEdit.requestFocus();
            return;
        }

        if (cbxIdTypeEdit.getSelectedIndex() == 0) { 
            JOptionPane.showMessageDialog(null, "Seleccione el tipo de identificación");
            cbxIdTypeEdit.requestFocus();
            return;
        }

        if (txtIdNumberEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese número de identificación");
            txtIdNumberEdit.requestFocus();
            return;
        }

        if (txtNameEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese nombres");
            txtNameEdit.requestFocus();
            return;
        }
        
        if (txtLastEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese apellidos");
            txtLastEdit.requestFocus();
            return;
        }

        if (cbxStatusEdit.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el estado civil");
            cbxStatusEdit.requestFocus();
            return;
        }

        if (cbxSexEdit.getSelectedIndex() == 0) { 
            JOptionPane.showMessageDialog(null, "Seleccione el sexo");
            cbxSexEdit.requestFocus();
            return;
        }

        if (txtPhoneEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese número de teléfono");
            txtPhoneEdit.requestFocus();
            return;
        }

        if (txtAddressEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese dirección");
            txtAddressEdit.requestFocus();
            return;
        }

        if (dchBirthdateEdit.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione fecha de nacimiento");
            dchBirthdateEdit.requestFocus();
            return;
        }

        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(txtIdEdit.getText().trim()));
            funcionario.setTipoIdentificacion((String) cbxIdTypeEdit.getSelectedItem()); 
            funcionario.setNumeroIdentificacion(txtIdNumberEdit.getText().trim());
            funcionario.setNombres(txtNameEdit.getText().trim());
            funcionario.setApellidos(txtLastEdit.getText().trim());
            funcionario.setEstadoCivil((String) cbxStatusEdit.getSelectedItem()); 
            funcionario.setSexo((String) cbxSexEdit.getSelectedItem()); 
            funcionario.setTelefono(txtPhoneEdit.getText().trim());
            funcionario.setDireccion(txtAddressEdit.getText().trim());
            funcionario.setFechaNacimiento(dchBirthdateEdit.getDate());

            funcionarioController.actualizarFuncionario(funcionario.getId(), funcionario);

            txtIdEdit.setText("");
            cbxIdTypeEdit.setSelectedIndex(0);
            txtIdNumberEdit.setText("");
            txtNameEdit.setText("");
            txtLastEdit.setText("");
            cbxStatusEdit.setSelectedIndex(0);
            cbxSexEdit.setSelectedIndex(0); 
            txtPhoneEdit.setText("");
            txtAddressEdit.setText("");
            dchBirthdateEdit.setDate(null);

            listFuncionarios();

            JOptionPane.showMessageDialog(null, "Se ha actualizado el funcionario exitosamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el funcionario");
        }

    }//GEN-LAST:event_btnEditActionPerformed

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
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<Funcionario> cbxFuncionario;
    private javax.swing.JComboBox<String> cbxIdType;
    private javax.swing.JComboBox<String> cbxIdTypeEdit;
    private javax.swing.JComboBox<String> cbxSex;
    private javax.swing.JComboBox<String> cbxSexEdit;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> cbxStatusEdit;
    private com.toedter.calendar.JDateChooser dchBirthdate;
    private com.toedter.calendar.JDateChooser dchBirthdateEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jPanels;
    private javax.swing.JPanel jPfunc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressEdit;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBirthdateEdit;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblIdEdit;
    private javax.swing.JLabel lblIdNumber;
    private javax.swing.JLabel lblIdNumberEdit;
    private javax.swing.JLabel lblIdType;
    private javax.swing.JLabel lblIdTypeEdit;
    private javax.swing.JLabel lblLast;
    private javax.swing.JLabel lblLastEdit;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameEdit;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneEdit;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSexEdit;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusEdit;
    private javax.swing.JTable tblFunc;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddressEdit;
    private javax.swing.JTextField txtIdEdit;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtIdNumberEdit;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtLastEdit;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameEdit;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhoneEdit;
    // End of variables declaration//GEN-END:variables
}
