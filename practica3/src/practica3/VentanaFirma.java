package practica3;

import java.awt.Color;
import java.io.*;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class VentanaFirma extends javax.swing.JFrame {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger m;
    private Random aleatorio;
    private boolean entrar;
    private File ficheroMensaje;
    private File ficheroFirma;
    private File ficheroClaveP;
    
    public VentanaFirma() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        //p = new BigInteger("383");
        //q = new BigInteger("881");
        n = new BigInteger("0");
        phi = new BigInteger("0");
        //e = new BigInteger("17");
        m = new BigInteger("0");
        entrar = false;
        aleatorio = new Random();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        botonGeneraClaves = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textMensaje = new javax.swing.JTextField();
        botonCifrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mensajeCifrado2 = new javax.swing.JLabel();
        botonBuscarFichero = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensajeCifrado = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        textMensajeDes = new javax.swing.JTextField();
        textDesc = new javax.swing.JLabel();
        botonBuscarDescifrado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botonBuscarFirma = new javax.swing.JButton();
        botonBuscarClave = new javax.swing.JButton();
        botonDescifrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generación de Claves"));

        botonGeneraClaves.setText("Generar Claves");
        botonGeneraClaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGeneraClavesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonGeneraClaves)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonGeneraClaves)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Firma de Mensaje"));

        textMensaje.setForeground(new java.awt.Color(153, 153, 153));
        textMensaje.setText("Introducir Texto");
        textMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textMensajeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textMensajeMousePressed(evt);
            }
        });

        botonCifrar.setText("Firmar");
        botonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCifrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Texto firmado:");

        mensajeCifrado2.setText("  ");

        botonBuscarFichero.setText("Buscar Mensaje");
        botonBuscarFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarFicheroActionPerformed(evt);
            }
        });

        jLabel3.setText("ó");

        jScrollPane1.setViewportView(mensajeCifrado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCifrar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBuscarFichero))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(mensajeCifrado2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCifrar)
                    .addComponent(botonBuscarFichero)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mensajeCifrado2)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprobacion de Firma"));

        textMensajeDes.setForeground(new java.awt.Color(153, 153, 153));
        textMensajeDes.setText("Introducir Texto");
        textMensajeDes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textMensajeDesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textMensajeDesMousePressed(evt);
            }
        });

        textDesc.setText("  ");

        botonBuscarDescifrado.setText("Buscar Mensaje");
        botonBuscarDescifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarDescifradoActionPerformed(evt);
            }
        });

        jLabel4.setText("ó");

        botonBuscarFirma.setText("Buscar Firma");
        botonBuscarFirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarFirmaActionPerformed(evt);
            }
        });

        botonBuscarClave.setText("Buscar C. Publica");
        botonBuscarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClaveActionPerformed(evt);
            }
        });

        botonDescifrar.setText("Comp. Firma");
        botonDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescifrarActionPerformed(evt);
            }
        });

        jLabel2.setText("1º");

        jLabel5.setText("2º");

        jLabel6.setText("3º");

        jLabel7.setText("4º");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textMensajeDes, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonBuscarFirma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonDescifrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBuscarClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBuscarDescifrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(57, 57, 57)
                                .addComponent(textDesc))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMensajeDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(botonBuscarDescifrado)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDesc)
                    .addComponent(botonBuscarFirma)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscarClave)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonDescifrar)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGeneraClavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGeneraClavesActionPerformed
        boolean salir = false;
        int miller = 0;
        
        p = new BigInteger(100, aleatorio);
        while(!salir){
            
            miller = VentanaMiller.MillerRabin(p, 60);
            if(miller == 1)
                salir = true;
            else if(miller == 0 || miller == -1)
                p = p.subtract(BigInteger.ONE);
        }
        
        miller = 0; salir = false;
        
        q = new BigInteger(100, aleatorio);
        while(!salir){
            
            miller = VentanaMiller.MillerRabin(q, 60);
            if(miller == 1)
                salir = true;
            else if(miller == 0 || miller == -1)
                q = q.subtract(BigInteger.ONE);
        }
        
        n = p.multiply(q);

        phi = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));

        salir = false; miller = 0;
        e = new BigInteger(100, aleatorio);
        
        while(!salir){
            miller = VentanaMiller.MillerRabin(q, 60);
            if(miller == 1){
                if(e.gcd(phi).compareTo(BigInteger.ONE) == 0)
                    salir = true;
                else
                    e = e.subtract(BigInteger.ONE);      
            }
            else if(miller == 0 || miller == -1)
                q = q.subtract(BigInteger.ONE); 
        }
        

        PrintWriter fichPublica = null;
        try {
            fichPublica = new PrintWriter(new BufferedWriter(new FileWriter("clavepublica.txt")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        fichPublica.println("Clave publica");
        fichPublica.println("n");
        fichPublica.println(n);
        fichPublica.println("e");
        fichPublica.println(e);
        fichPublica.close();


        BigInteger privada = new BigInteger(e.toString());

        privada = privada.modInverse(phi);

        PrintWriter fichPrivada = null;
        try {
            fichPrivada = new PrintWriter(new BufferedWriter(new FileWriter("claveprivada.txt")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        fichPrivada.println("Clave privada");
        fichPrivada.println(privada);
        fichPrivada.close();

        JOptionPane.showMessageDialog(this, "Claves generadas en la ubicacion del programa", "Claves generadas", JOptionPane.INFORMATION_MESSAGE);
        entrar = true;
    }//GEN-LAST:event_botonGeneraClavesActionPerformed

    private void textMensajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMensajeMouseClicked
        textMensaje.setText("");
        textMensaje.setForeground(Color.black);
    }//GEN-LAST:event_textMensajeMouseClicked

    private void textMensajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMensajeMousePressed
        textMensaje.setText("");
        textMensaje.setForeground(Color.black);
    }//GEN-LAST:event_textMensajeMousePressed

    private void botonCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCifrarActionPerformed

        if (entrar) {
            String s = null;
            s = textMensaje.getText().toString();
            
            PrintWriter fichMensaje = null;
            try {
                fichMensaje = new PrintWriter(new BufferedWriter(new FileWriter("mensaje.txt")));
            } catch (IOException ex) {
                Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
            }
            fichMensaje.println("Mensaje original");
            fichMensaje.println(s);
            fichMensaje.close();

            // Realizamos el resumen del mensaje
            SHA1 sha = new SHA1();
            String resumen = null;

            try {
                resumen = sha.getHash(s);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Pasamos el mensaje a Bytes
            byte resumenBytes[] = resumen.getBytes();

            // Convertimos los Bytes del mensaje en una cadena String
            String resumenNum = "";
            for (int i = 0; i < resumenBytes.length; i++) {
                resumenNum = resumenNum + (Integer.toString(resumenBytes[i]));
            }

            // Calculamos el cifrado del resumen
            BigInteger res = new BigInteger(resumenNum);
            res = res.modPow(new BigInteger(e.toString()), new BigInteger(n.toString()));
            //this.mensajeCifrado2.setText(res.toString());
            
            DefaultListModel m = new DefaultListModel();
            m.add(0, res.toString());
            this.mensajeCifrado.setModel(m);
            
            PrintWriter fichFirma = null;
            try {
                fichFirma = new PrintWriter(new BufferedWriter(new FileWriter("firma.txt")));
            } catch (IOException ex) {
                Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
            }
            fichFirma.println("Firma digital");
            fichFirma.println(res.toString());
            fichFirma.close();
        }
        else{
            JOptionPane.showMessageDialog(null, "Generar primero las claves", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botonCifrarActionPerformed

    private void textMensajeDesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMensajeDesMouseClicked
        textMensajeDes.setText("");
        textMensajeDes.setForeground(Color.black);
    }//GEN-LAST:event_textMensajeDesMouseClicked

    private void textMensajeDesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMensajeDesMousePressed
        textMensajeDes.setText("");
        textMensajeDes.setForeground(Color.black);
    }//GEN-LAST:event_textMensajeDesMousePressed

    private void botonBuscarFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarFicheroActionPerformed
        if (entrar) {

            File f = null;
            JFileChooser jf = new JFileChooser();

            if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                f = new File(jf.getSelectedFile().toString());

                String s = null;
                BufferedReader buff = null;
                try {
                    buff = new BufferedReader(new FileReader(f));
                    s = buff.readLine();
                    buff.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
                }


                // Realizamos el resumen del mensaje
                SHA1 sha = new SHA1();
                String resumen = null;

                try {
                    resumen = sha.getHash(s);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pasamos el mensaje a Bytes
                byte resumenBytes[] = resumen.getBytes();

                // Convertimos los Bytes del mensaje en una cadena String
                String resumenNum = "";
                for (int i = 0; i < resumenBytes.length; i++) {
                    resumenNum = resumenNum + (Integer.toString(resumenBytes[i]));
                }

                // Calculamos el cifrado del resumen
                BigInteger res = new BigInteger(resumenNum);
                res = res.modPow(new BigInteger(e.toString()), new BigInteger(n.toString()));
                this.mensajeCifrado2.setText(res.toString());
                
                PrintWriter fichFirma = null;
                try {
                    fichFirma = new PrintWriter(new BufferedWriter(new FileWriter("firma.txt")));
                } catch (IOException ex) {
                    Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
                }
                fichFirma.println("Firma digital");
                fichFirma.println(res.toString());
                fichFirma.close();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Generar primero las claves", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarFicheroActionPerformed

    private void botonBuscarDescifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarDescifradoActionPerformed
        if (entrar) {

            JFileChooser jf = new JFileChooser();

            if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
                ficheroMensaje = new File(jf.getSelectedFile().toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "Generar primero las claves", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarDescifradoActionPerformed

    private void botonBuscarFirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarFirmaActionPerformed
        if (entrar) {

            JFileChooser jf = new JFileChooser();

            if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
                ficheroFirma = new File(jf.getSelectedFile().toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "Generar primero las claves", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_botonBuscarFirmaActionPerformed

    private void botonBuscarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClaveActionPerformed
        if (entrar) {

            JFileChooser jf = new JFileChooser();

            if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                ficheroClaveP = new File(jf.getSelectedFile().toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Generar primero las claves", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarClaveActionPerformed

    private void botonDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescifrarActionPerformed
        String s = null;
        BufferedReader buffMensaje = null;
        if (ficheroMensaje != null) {
            try {
                buffMensaje = new BufferedReader(new FileReader(ficheroMensaje.getAbsolutePath()));
                buffMensaje.readLine();
                s = buffMensaje.readLine();
                buffMensaje.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            s = this.textMensajeDes.getText();
        }
        
        
        // Realizamos el resumen del mensaje
        SHA1 sha = new SHA1();
        String resumen = null;
        try {
            resumen = sha.getHash(s);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Pasamos el mensaje a Bytes
        byte resumenBytes[] = resumen.getBytes();
        
        // Convertimos los Bytes del mensaje en una cadena String
        String resumenNum = "";
        for(int i = 0; i < resumenBytes.length; i++)
            resumenNum = resumenNum + (Integer.toString(resumenBytes[i]));
        
        
        // Extraemos la firma del fichero
        BufferedReader buffFirma;
        String stringFirma = null;
        try {
            buffFirma = new BufferedReader(new FileReader(ficheroFirma.getAbsolutePath()));
            buffFirma.readLine();
            stringFirma = buffFirma.readLine();
            buffFirma.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Extraemos la clave publica del fichero
        BufferedReader buffClave;
        String stringClaveE = null, stringClaveN = null;
        try {
            buffClave = new BufferedReader(new FileReader(ficheroClaveP.getAbsolutePath()));
            buffClave.readLine();
            buffClave.readLine();
            stringClaveN = buffClave.readLine();
            buffClave.readLine();
            stringClaveE = buffClave.readLine();
            buffClave.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaFirma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("s:"+s);
        System.out.println("strinFirma:"+stringFirma+".");
        System.out.println("e:"+stringClaveE);
        System.out.println("n:"+stringClaveN);
        
        // Calculamos el cifrado del resumen
        BigInteger res = new BigInteger(resumenNum);
        res = res.modPow(new BigInteger(stringClaveE), new BigInteger(stringClaveN));
        
        System.out.println("resumen cifrado:"+res);
        
        
        // Comparamos el cifrado del resumen con la firma
        if(stringFirma.equals(res.toString()))
            JOptionPane.showMessageDialog(null, "La firma es correcta", "Exito", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "La firma es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_botonDescifrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarClave;
    private javax.swing.JButton botonBuscarDescifrado;
    private javax.swing.JButton botonBuscarFichero;
    private javax.swing.JButton botonBuscarFirma;
    private javax.swing.JButton botonCifrar;
    private javax.swing.JButton botonDescifrar;
    private javax.swing.JButton botonGeneraClaves;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList mensajeCifrado;
    private javax.swing.JLabel mensajeCifrado2;
    private javax.swing.JLabel textDesc;
    private javax.swing.JTextField textMensaje;
    private javax.swing.JTextField textMensajeDes;
    // End of variables declaration//GEN-END:variables
}
