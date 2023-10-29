
package formulario;

import java.sql.*;
import conf.conexion;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class registrar_articulos extends javax.swing.JFrame {

    //int xMouse, yMouse;
    conexion cc = new conexion();
    Connection cx = cc.conectar();
    
    public registrar_articulos() {
        initComponents();
        setLocationRelativeTo(null);
        nom_articulo.requestFocus();
        cargar();
        muestra_articulos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 12));
        muestra_articulos.getTableHeader().setOpaque(false);
        
       //muestra_articulos.getTableHeader().setBackground(new Color(161,152,130));
        //muestra_articulos.setRowHeight(25);
        
        //cx=new conexion("proyecto_integrador");
        //cx.conectar();       
    }
    
    void cargar(){
     DefaultTableModel modelo2 = (DefaultTableModel)muestra_articulos.getModel();
     modelo2.getDataVector().clear();
     
     String [] registros = new String[8];
     String sql ="SELECT idarticulo,nomarticulo,canarticulo,pcarticulo,pvarticulo,catarticulo,uniarticulo,stmarticulo FROM articulos "
              +"WHERE nomarticulo LIKE '%"+b_art.getText()+"%' or idarticulo LIKE '%"+b_art.getText()+"%'";
     
     try{
         Statement st = cx.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
         registros[0]=rs.getString("idarticulo");
         registros[1]=rs.getString("nomarticulo");
         registros[2]=rs.getString("canarticulo");
         registros[3]=rs.getString("pcarticulo");
         registros[4]=rs.getString("pvarticulo");
         registros[5]=rs.getString("catarticulo");
         registros[6]=rs.getString("uniarticulo");
         registros[7]=rs.getString("stmarticulo");
         modelo2.addRow(registros);
                         }
         muestra_articulos.setModel (modelo2);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    void actualizar(){
        try{
            PreparedStatement psU = cx.prepareStatement("UPDATE articulos SET nomarticulo='"+nom_articulo.getText()+"',canarticulo='"+can_articulo.getText()+"',pcarticulo='"+precioc_articulo.getText()+"',pvarticulo='"+preciov_articulo.getText()+"',catarticulo='"+cat_articulo.getSelectedItem().toString()+"',uniarticulo='"+uni_articulo.getSelectedItem().toString()+"',stmarticulo='"+stockm_articulo.getText()+"'WHERE idarticulo='"+id_articulo.getText()+"'");
            psU.executeUpdate();
            
        }catch (SQLException ex){
            Logger.getLogger(registrar_articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void limpiar(){
        nom_articulo.setText("");
        can_articulo.setText("");
        precioc_articulo.setText("");
        preciov_articulo.setText("");
        stockm_articulo.setText("");
        id_articulo.setText("");
        nom_articulo.requestFocus(true);
    }
    
    void eliminar(){
        int fila = muestra_articulos.getSelectedRow();
        String valor  = muestra_articulos.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement elim = cx.prepareStatement("DELETE FROM articulos WHERE idarticulo='"+valor+"'");
            elim.executeUpdate();
            cargar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "No se elimino el Registro");
        }
        
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nom_articulo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        can_articulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        precioc_articulo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        preciov_articulo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stockm_articulo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        bmodificar_art = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        cat_articulo = new javax.swing.JComboBox<>();
        uni_articulo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        muestra_articulos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        b_art = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        id_articulo = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cat_articulo1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(161, 152, 130));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setText("Registro De Articulos");

        jPanel6.setBackground(new java.awt.Color(161, 152, 130));
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel6MouseDragged(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(369, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(360, 360, 360)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jPanel3.setBackground(new java.awt.Color(254, 247, 220));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Del Articulo:");

        nom_articulo.setBackground(new java.awt.Color(254, 247, 220));
        nom_articulo.setForeground(new java.awt.Color(0, 0, 0));
        nom_articulo.setBorder(null);
        nom_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nom_articuloMousePressed(evt);
            }
        });
        nom_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_articuloActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");

        can_articulo.setBackground(new java.awt.Color(254, 247, 220));
        can_articulo.setForeground(new java.awt.Color(0, 0, 0));
        can_articulo.setBorder(null);
        can_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                can_articuloMousePressed(evt);
            }
        });
        can_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                can_articuloActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Precio Compra:");

        precioc_articulo.setBackground(new java.awt.Color(254, 247, 220));
        precioc_articulo.setForeground(new java.awt.Color(0, 0, 0));
        precioc_articulo.setBorder(null);
        precioc_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                precioc_articuloMousePressed(evt);
            }
        });
        precioc_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioc_articuloActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Precio Venta:");

        preciov_articulo.setBackground(new java.awt.Color(254, 247, 220));
        preciov_articulo.setForeground(new java.awt.Color(0, 0, 0));
        preciov_articulo.setBorder(null);
        preciov_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                preciov_articuloMousePressed(evt);
            }
        });
        preciov_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciov_articuloActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Categoria:");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setText("Stock Minimo:");

        stockm_articulo.setBackground(new java.awt.Color(254, 247, 220));
        stockm_articulo.setForeground(new java.awt.Color(0, 0, 0));
        stockm_articulo.setBorder(null);
        stockm_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stockm_articuloMousePressed(evt);
            }
        });
        stockm_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockm_articuloActionPerformed(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(new java.awt.Color(161, 152, 130));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Guardar");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(161, 152, 130));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Atras");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(161, 152, 130));

        bmodificar_art.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        bmodificar_art.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bmodificar_art.setText("Modificar");
        bmodificar_art.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bmodificar_art.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bmodificar_artMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bmodificar_art, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bmodificar_art, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setText("Unidad:");

        cat_articulo.setBackground(new java.awt.Color(254, 247, 220));
        cat_articulo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cat_articulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Madera", "Metales", "Liquidos", "Herramientas" }));

        uni_articulo.setBackground(new java.awt.Color(254, 247, 220));
        uni_articulo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        uni_articulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad", "Libras", "Galones" }));

        muestra_articulos.setBackground(new java.awt.Color(161, 152, 130));
        muestra_articulos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        muestra_articulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Articulo", "Cantidad", "Precio Compra", "Precio Venta", "Categoria", "Unidad", "Stock Minimo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        muestra_articulos.setToolTipText("");
        muestra_articulos.setFocusable(false);
        muestra_articulos.setRowHeight(25);
        muestra_articulos.getTableHeader().setReorderingAllowed(false);
        muestra_articulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muestra_articulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(muestra_articulos);
        if (muestra_articulos.getColumnModel().getColumnCount() > 0) {
            muestra_articulos.getColumnModel().getColumn(0).setMinWidth(50);
            muestra_articulos.getColumnModel().getColumn(0).setMaxWidth(50);
            muestra_articulos.getColumnModel().getColumn(1).setMinWidth(150);
            muestra_articulos.getColumnModel().getColumn(1).setMaxWidth(150);
            muestra_articulos.getColumnModel().getColumn(2).setMinWidth(80);
            muestra_articulos.getColumnModel().getColumn(2).setMaxWidth(80);
            muestra_articulos.getColumnModel().getColumn(3).setMinWidth(100);
            muestra_articulos.getColumnModel().getColumn(3).setMaxWidth(100);
            muestra_articulos.getColumnModel().getColumn(4).setMinWidth(100);
            muestra_articulos.getColumnModel().getColumn(4).setMaxWidth(100);
            muestra_articulos.getColumnModel().getColumn(5).setMinWidth(105);
            muestra_articulos.getColumnModel().getColumn(5).setMaxWidth(105);
            muestra_articulos.getColumnModel().getColumn(6).setMinWidth(73);
            muestra_articulos.getColumnModel().getColumn(6).setMaxWidth(73);
            muestra_articulos.getColumnModel().getColumn(7).setMinWidth(80);
            muestra_articulos.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel11.setText("Buscar:");

        b_art.setBackground(new java.awt.Color(254, 247, 220));
        b_art.setForeground(new java.awt.Color(0, 0, 0));
        b_art.setBorder(null);
        b_art.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_artMousePressed(evt);
            }
        });
        b_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_artActionPerformed(evt);
            }
        });
        b_art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b_artKeyReleased(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        id_articulo.setEditable(false);
        id_articulo.setBackground(new java.awt.Color(254, 247, 220));
        id_articulo.setForeground(new java.awt.Color(0, 0, 0));
        id_articulo.setBorder(null);
        id_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                id_articuloMousePressed(evt);
            }
        });
        id_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_articuloActionPerformed(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setText("ID Articulo");

        jPanel8.setBackground(new java.awt.Color(161, 152, 130));

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Eliminar");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel14.setText("Proveedor:");

        cat_articulo1.setBackground(new java.awt.Color(254, 247, 220));
        cat_articulo1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cat_articulo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stockm_articulo))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(id_articulo))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cat_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(uni_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(431, 431, 431)
                                        .addComponent(jLabel11))
                                    .addComponent(cat_articulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(b_art, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(jSeparator2))
                                    .addComponent(jButton1)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(preciov_articulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(precioc_articulo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nom_articulo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(can_articulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cat_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uni_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cat_articulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3)
                                .addComponent(can_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioc_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preciov_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stockm_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(b_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        //xMouse = evt.getX();
        //yMouse = evt.getY();
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseDragged
        //int x = evt.getXOnScreen();
        //int y = evt.getYOnScreen();
        //this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel6MouseDragged

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        //exit.setBackground(Color.red);
    }//GEN-LAST:event_exitMouseEntered

    private void nom_articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nom_articuloMousePressed
        
    }//GEN-LAST:event_nom_articuloMousePressed

    private void can_articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_can_articuloMousePressed
        
    }//GEN-LAST:event_can_articuloMousePressed

    private void precioc_articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioc_articuloMousePressed
        
    }//GEN-LAST:event_precioc_articuloMousePressed

    private void preciov_articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preciov_articuloMousePressed
        
    }//GEN-LAST:event_preciov_articuloMousePressed

    private void stockm_articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockm_articuloMousePressed
        
    }//GEN-LAST:event_stockm_articuloMousePressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        
        if(nom_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL NOMBRE DEL ARTICULO");
            nom_articulo.requestFocus(true);
            return;
        }        
        can_articulo.requestFocus(true);
        
        if(can_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE LA CANTIDAD");
            can_articulo.requestFocus(true);
            return;
        }        
        precioc_articulo.requestFocus(true);
        
        if(precioc_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO DE COMPRA");
            precioc_articulo.requestFocus(true);
            return;
        }        
        preciov_articulo.requestFocus(true);
        
        if(preciov_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO PARA VENDER");
            preciov_articulo.requestFocus(true);
            return;
        }               
        stockm_articulo.requestFocus(true);
        
        if(stockm_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO DE COMPRA");
            stockm_articulo.requestFocus(true);
            return;
        }  
        
        
            try{
                String sql ="";
                sql = "INSERT INTO articulos (nomarticulo, canarticulo, pcarticulo, pvarticulo, catarticulo, uniarticulo, stmarticulo) VALUES "
                        + "('"+nom_articulo.getText()+"', '"+can_articulo.getText()+"', '"+precioc_articulo.getText()+"', '"+preciov_articulo.getText()+"', '"+cat_articulo.getSelectedItem().toString()+"', '"+uni_articulo.getSelectedItem().toString()+"', '"+stockm_articulo.getText()+"')";
                
                PreparedStatement psz = cx.prepareStatement(sql);
                //cx.setAutoCommit(false);
                int n; 
                n = psz.executeUpdate();
                if(n>0){
                    
                }
                
                JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
            }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "ERROR" +ex);
                    }
        
     cargar();
     limpiar();
    
    }//GEN-LAST:event_jLabel8MouseClicked

    private void nom_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_articuloActionPerformed
        if(nom_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL NOMBRE DEL ARTICULO");
            nom_articulo.requestFocus(true);
            return;
        }        
        can_articulo.requestFocus(true);
    }//GEN-LAST:event_nom_articuloActionPerformed

    private void can_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_can_articuloActionPerformed
        if(can_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE LA CANTIDAD");
            can_articulo.requestFocus(true);
            return;
        }        
        precioc_articulo.requestFocus(true);
    }//GEN-LAST:event_can_articuloActionPerformed

    private void precioc_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioc_articuloActionPerformed
        if(precioc_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO DE COMPRA");
            precioc_articulo.requestFocus(true);
            return;
        }        
        preciov_articulo.requestFocus(true);
    }//GEN-LAST:event_precioc_articuloActionPerformed

    private void preciov_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciov_articuloActionPerformed
        if(preciov_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO PARA VENDER");
            preciov_articulo.requestFocus(true);
            return;
        }        
        stockm_articulo.requestFocus(true);
    }//GEN-LAST:event_preciov_articuloActionPerformed

    private void stockm_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockm_articuloActionPerformed
        if(nom_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL NOMBRE DEL ARTICULO");
            nom_articulo.requestFocus(true);
            return;
        }        
        can_articulo.requestFocus(true);
        
        if(can_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE LA CANTIDAD");
            can_articulo.requestFocus(true);
            return;
        }        
        precioc_articulo.requestFocus(true);
        
        if(precioc_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO DE COMPRA");
            precioc_articulo.requestFocus(true);
            return;
        }        
        preciov_articulo.requestFocus(true);
        
        if(preciov_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO PARA VENDER");
            preciov_articulo.requestFocus(true);
            return;
        }        
              
        stockm_articulo.requestFocus(true);
        
        if(stockm_articulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "COLOQUE EL PRECIO DE COMPRA");
            stockm_articulo.requestFocus(true);
            return;
        }        
        
        try{
                String sql ="";
                sql = "INSERT INTO articulos (nomarticulo, canarticulo, pcarticulo, pvarticulo, catarticulo, uniarticulo, stmarticulo) VALUES "
                        + "('"+nom_articulo.getText()+"', '"+can_articulo.getText()+"', '"+precioc_articulo.getText()+"', '"+preciov_articulo.getText()+"', '"+cat_articulo.getSelectedItem().toString()+"', '"+uni_articulo.getSelectedItem().toString()+"', '"+stockm_articulo.getText()+"')";
                
                PreparedStatement psz = cx.prepareStatement(sql);
                //cx.setAutoCommit(false);
                int n; 
                n = psz.executeUpdate();
                if(n>0){
                    
                }
                
                JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
            }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "ERROR" +ex);
                    }
        
     cargar();
     limpiar();
     
    }//GEN-LAST:event_stockm_articuloActionPerformed

    private void bmodificar_artMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmodificar_artMouseClicked
        actualizar();
        cargar();
        limpiar();
    }//GEN-LAST:event_bmodificar_artMouseClicked

    private void b_artMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_artMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_artMousePressed

    private void b_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_artActionPerformed
       cargar();
    }//GEN-LAST:event_b_artActionPerformed

    private void muestra_articulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muestra_articulosMouseClicked
        int fila= muestra_articulos.getSelectedRow();
        if(fila>=0){
            id_articulo.setText(muestra_articulos.getValueAt(fila, 0).toString());
            nom_articulo.setText(muestra_articulos.getValueAt(fila, 1).toString());
            can_articulo.setText( muestra_articulos.getValueAt(fila, 2).toString());
        //String fila1 = t_articulos.getSelectedRow();            
        float fila2 =  muestra_articulos.getSelectedRow();
        if(fila2>=0){
            precioc_articulo.setText( muestra_articulos.getValueAt(fila, 3).toString());
            preciov_articulo.setText( muestra_articulos.getValueAt(fila, 4).toString());
            cat_articulo.addItem(muestra_articulos.getValueAt(fila, 5).toString());
            uni_articulo.addItem(muestra_articulos.getValueAt(fila, 6).toString());
            stockm_articulo.setText( muestra_articulos.getValueAt(fila, 7).toString());
            
        }
        
        
        }
        
    }//GEN-LAST:event_muestra_articulosMouseClicked

    private void id_articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_articuloMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_articuloMousePressed

    private void id_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_articuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_articuloActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        eliminar();
        limpiar();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b_artKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_artKeyReleased
        cargar();
    }//GEN-LAST:event_b_artKeyReleased

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
            java.util.logging.Logger.getLogger(registrar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrar_articulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField b_art;
    private javax.swing.JLabel bmodificar_art;
    private javax.swing.JTextField can_articulo;
    private javax.swing.JComboBox<String> cat_articulo;
    private javax.swing.JComboBox<String> cat_articulo1;
    private javax.swing.JLabel exit;
    private javax.swing.JTextField id_articulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable muestra_articulos;
    private javax.swing.JTextField nom_articulo;
    private javax.swing.JTextField precioc_articulo;
    private javax.swing.JTextField preciov_articulo;
    private javax.swing.JTextField stockm_articulo;
    private javax.swing.JComboBox<String> uni_articulo;
    // End of variables declaration//GEN-END:variables
}
