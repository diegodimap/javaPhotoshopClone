package gui;

import code.Ponto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author  diego
 */
public class JanelaPhotoshop extends javax.swing.JFrame {

    private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
    private File original;
    private BufferedImage imagem;
    private BufferedImage imagemAlterada;
    private int matriz[][];
    private int matrizAlterada[][];
    private int histograma[] = new int[256];
    private int histogramaAlterada[] = new int[256];
    private int h,  w;
    private int s1,  s2,  r1,  r2;
    private int[][] matrizRotulos;
    private int rotulo = 1;
    private int rotulos[];
    private int rot = 0;
    private boolean lum = true;
    private Random ale = new Random();
    private int tamMascara = 3;
    public Vector<Ponto> vp = new Vector<Ponto>();

    public JanelaPhotoshop() {
        initComponents();
        this.setExtendedState(JanelaPhotoshop.MAXIMIZED_BOTH);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abas = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelOriginal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelModificada = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        h1 = new javax.swing.JLabel();
        h2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        saida = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        arquivo = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        salvar = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();
        PDI = new javax.swing.JMenu();
        vizinhancas = new javax.swing.JMenu();
        vizinhanca4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        vizinhanca8 = new javax.swing.JMenuItem();
        quantizar = new javax.swing.JMenuItem();
        negativar = new javax.swing.JMenuItem();
        alargar = new javax.swing.JMenuItem();
        fatiar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        gerarHistograma = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        filtros = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        filtragemMediana = new javax.swing.JMenuItem();
        filtragemEspacialPassaBaixas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        filtragemEspacialPassaAltas = new javax.swing.JMenuItem();
        filtragemAltoReforco = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        robertsItem = new javax.swing.JMenuItem();
        prewittItem = new javax.swing.JMenuItem();
        sobelItem = new javax.swing.JMenuItem();
        ruidos = new javax.swing.JMenu();
        gaussiano = new javax.swing.JMenuItem();
        impulsivo = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        limiarizacao = new javax.swing.JMenuItem();
        preTratamento = new javax.swing.JMenuItem();
        reset = new javax.swing.JMenuItem();
        luminancia = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Photoshop");

        labelOriginal.setFont(new java.awt.Font("Verdana", 1, 18));
        labelOriginal.setForeground(new java.awt.Color(51, 204, 0));
        labelOriginal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOriginal.setText("IMAGEM ORIGINAL");
        jScrollPane1.setViewportView(labelOriginal);

        abas.addTab("Original", jScrollPane1);

        labelModificada.setFont(new java.awt.Font("Verdana", 1, 18));
        labelModificada.setForeground(new java.awt.Color(255, 0, 0));
        labelModificada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModificada.setText("IMAGEM MODIFICADA");
        jScrollPane2.setViewportView(labelModificada);

        abas.addTab("Modificada", jScrollPane2);

        h1.setFont(new java.awt.Font("Verdana", 1, 14));
        h1.setForeground(new java.awt.Color(51, 153, 0));
        h1.setText("Histograma da Imagem Original");

        h2.setFont(new java.awt.Font("Verdana", 1, 14));
        h2.setForeground(new java.awt.Color(255, 0, 0));
        h2.setText("Histograma da Imagem Alterada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(h1)
                .addContainerGap(509, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addComponent(h2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(h1)
                    .addComponent(h2))
                .addGap(211, 211, 211))
        );

        abas.addTab("Histogramas", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Saída"));

        saida.setColumns(20);
        saida.setRows(5);
        jScrollPane5.setViewportView(saida);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comandos"));

        jToggleButton1.setText("Otimização");

        jButton1.setText("Limpar Saída");

        jButton2.setText("Salvar Saída");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jToggleButton1});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        abas.addTab("Saída", jPanel2);

        arquivo.setText("Arquivo");

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        arquivo.add(abrir);

        salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        arquivo.add(salvar);

        sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        arquivo.add(sair);

        jMenuBar1.add(arquivo);

        PDI.setText("PDI");

        vizinhancas.setText("1.Rotulação");

        vizinhanca4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, 0));
        vizinhanca4.setText("1.1.R4");
        vizinhanca4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizinhanca4ActionPerformed(evt);
            }
        });
        vizinhancas.add(vizinhanca4);

        jMenuItem1.setText("1.2.RD");
        vizinhancas.add(jMenuItem1);

        vizinhanca8.setText("1.3.R8");
        vizinhanca8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizinhanca8ActionPerformed(evt);
            }
        });
        vizinhancas.add(vizinhanca8);

        PDI.add(vizinhancas);

        quantizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, 0));
        quantizar.setText("2.Quantizar");
        quantizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantizarActionPerformed(evt);
            }
        });
        PDI.add(quantizar);

        negativar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        negativar.setText("3.Negativar");
        negativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativarActionPerformed(evt);
            }
        });
        PDI.add(negativar);

        alargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, 0));
        alargar.setText("4.Alargar");
        alargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alargarActionPerformed(evt);
            }
        });
        PDI.add(alargar);

        fatiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        fatiar.setText("5.Fatiar");
        fatiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatiarActionPerformed(evt);
            }
        });
        PDI.add(fatiar);

        jMenu2.setText("6.Histogramas");

        gerarHistograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        gerarHistograma.setText("6.1.Gerar Histogramas");
        gerarHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarHistogramaActionPerformed(evt);
            }
        });
        jMenu2.add(gerarHistograma);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, 0));
        jMenuItem2.setText("6.2.Equalizar Histogramas");
        jMenu2.add(jMenuItem2);

        PDI.add(jMenu2);

        filtros.setText("7.Filtragem Espacial");

        jMenu3.setText("7.1.Filtros de Suavização");

        filtragemMediana.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        filtragemMediana.setText("7.1.1.Filtragem por Mediana");
        filtragemMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtragemMedianaActionPerformed(evt);
            }
        });
        jMenu3.add(filtragemMediana);

        filtragemEspacialPassaBaixas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        filtragemEspacialPassaBaixas.setText("7.1.2.Filtragem Espacial Passa-Baixas");
        filtragemEspacialPassaBaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtragemEspacialPassaBaixasActionPerformed(evt);
            }
        });
        jMenu3.add(filtragemEspacialPassaBaixas);

        filtros.add(jMenu3);

        jMenu5.setText("7.2.Filtros de Aguçamento");

        filtragemEspacialPassaAltas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        filtragemEspacialPassaAltas.setText("7.2.1.Filtragem Espacial Passa-Altas Básico");
        filtragemEspacialPassaAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtragemEspacialPassaAltasActionPerformed(evt);
            }
        });
        jMenu5.add(filtragemEspacialPassaAltas);

        filtragemAltoReforco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        filtragemAltoReforco.setText("7.2.2.Filtragem Alto-Reforço");
        filtragemAltoReforco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtragemAltoReforcoActionPerformed(evt);
            }
        });
        jMenu5.add(filtragemAltoReforco);

        jMenu6.setText("7.2.3.Filtros por Derivadas");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        robertsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        robertsItem.setText("7.2.3.1.Operadores de Roberts");
        robertsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robertsItemActionPerformed(evt);
            }
        });
        jMenu6.add(robertsItem);

        prewittItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        prewittItem.setText("7.2.3.2.Operadores de Prewitt");
        prewittItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prewittItemActionPerformed(evt);
            }
        });
        jMenu6.add(prewittItem);

        sobelItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        sobelItem.setText("7.2.3.3.Operadores de Sobel");
        sobelItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobelItemActionPerformed(evt);
            }
        });
        jMenu6.add(sobelItem);

        jMenu5.add(jMenu6);

        filtros.add(jMenu5);

        PDI.add(filtros);

        ruidos.setText("8.Ruídos");

        gaussiano.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, 0));
        gaussiano.setText("8.1.Gaussiano");
        gaussiano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaussianoActionPerformed(evt);
            }
        });
        ruidos.add(gaussiano);

        impulsivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        impulsivo.setText("8.2.Impulsivo");
        impulsivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impulsivoActionPerformed(evt);
            }
        });
        ruidos.add(impulsivo);

        PDI.add(ruidos);

        jMenu1.setText("9.Realce no Domínio de Freqüência");

        jMenu4.setText("Filtragem Passa-Baixas");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem9.setText("Filtro Ideal");
        jMenu4.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem10.setText("Filtro de Butterworth");
        jMenu4.add(jMenuItem10);

        jMenu1.add(jMenu4);

        PDI.add(jMenu1);

        limiarizacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, 0));
        limiarizacao.setText("Segmentação por Limiarização");
        limiarizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limiarizacaoActionPerformed(evt);
            }
        });
        PDI.add(limiarizacao);

        preTratamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        preTratamento.setText("Pré-tratamento de imagens para reconhecimento");
        preTratamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preTratamentoActionPerformed(evt);
            }
        });
        PDI.add(preTratamento);

        reset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        PDI.add(reset);

        luminancia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, 0));
        luminancia.setSelected(true);
        luminancia.setText("Luminância");
        luminancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luminanciaActionPerformed(evt);
            }
        });
        PDI.add(luminancia);

        jMenuBar1.add(PDI);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(abas, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limiarizacao(int valorlimiar, int t0) {
        this.roberts();
        this.normalizarMatrizAlterada();
        this.processarImagem(1);

        int mg1 = 0, mg2 = 0;
        double t = valorlimiar;
        Vector<Integer> g1 = new Vector<Integer>();
        Vector<Integer> g2 = new Vector<Integer>();

        for (int d = 0; d < t0; d++) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    if (matriz[i][j] < t) {
                        g1.addElement(matriz[i][j]);
                        if (d == t0 - 1) {
                            matrizAlterada[i][j] = 255;
                        }
                    } else {
                        g2.addElement(matriz[i][j]);
                        if (d == t0 - 1) {
                            matrizAlterada[i][j] = 0;
                        }
                    }
                }
            }
            for (int i = 0; i < g1.size(); i++) {
                mg1 += g1.get(i);

            }
            for (int i = 0; i < g2.size(); i++) {
                mg2 += g2.get(i);

            }
            t = 0.5 * ((mg1 / g1.capacity()) + (mg2 / g2.capacity()));
            mg1 = 0;
            mg2 = 0;
            g1.clear();
            g2.clear();
        }

    }

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
}//GEN-LAST:event_sairActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        JFileChooser chooser = new JFileChooser(".");
        if (chooser.showOpenDialog(JanelaPhotoshop.this) == JFileChooser.APPROVE_OPTION) {
            original = chooser.getSelectedFile();
            this.novaImagemCinza(original);
            labelOriginal.setIcon(new ImageIcon(imagem));
            labelOriginal.setText("");
            this.resetActionPerformed(evt);
        }
}//GEN-LAST:event_abrirActionPerformed

    private void gerarHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarHistogramaActionPerformed
        ImageIcon histograma1 = getHistograma(1);
        h1.setIcon(histograma1);
        h1.setText("");
        ImageIcon histograma2 = getHistograma(2);
        h2.setIcon(histograma2);
        h2.setText("");
}//GEN-LAST:event_gerarHistogramaActionPerformed

    private void quantizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantizarActionPerformed
        String p = JOptionPane.showInputDialog(this, "Quantos tons de cinza deseja agora?", "Quantização", JOptionPane.QUESTION_MESSAGE);
        int possibilidades = Integer.parseInt(p);
        this.quantizarMatriz(possibilidades);
        processarImagem(1);
}//GEN-LAST:event_quantizarActionPerformed

    private void vizinhanca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizinhanca4ActionPerformed
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matriz[i][j] < 128) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 255;
                }
            }
        }
        this.processarImagem(1);
}//GEN-LAST:event_vizinhanca4ActionPerformed

    private void vizinhanca8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizinhanca8ActionPerformed
        matrizRotulos = new int[h][w];
        this.preencherRotulos();
        this.rotularMatrizPorLinha();
        this.rotularMatrizPorEquivalencia(8);
        this.processarImagem(2);
}//GEN-LAST:event_vizinhanca8ActionPerformed

    private void negativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativarActionPerformed
        this.negativarMatriz();
        this.processarImagem(1);
}//GEN-LAST:event_negativarActionPerformed

    private void alargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alargarActionPerformed
        String r1s = JOptionPane.showInputDialog(this, "Qual o valor de r1?", "Alargar", JOptionPane.QUESTION_MESSAGE);
        String r2s = JOptionPane.showInputDialog(this, "Qual o valor de r2?", "Alargar", JOptionPane.QUESTION_MESSAGE);//GEN-LAST:event_alargarActionPerformed
        String s1s = JOptionPane.showInputDialog(this, "Qual o valor de s1?", "Alargar", JOptionPane.QUESTION_MESSAGE);
        String s2s = JOptionPane.showInputDialog(this, "Qual o valor de s2?", "Alargar", JOptionPane.QUESTION_MESSAGE);

        r1 = Integer.parseInt(r1s);
        r2 = Integer.parseInt(r2s);
        s1 = Integer.parseInt(s1s);
        s2 = Integer.parseInt(s2s);

        this.alargarMatriz();
        this.processarImagem(1);
    }

    private void fatiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatiarActionPerformed
        String r1s = JOptionPane.showInputDialog(this, "Qual o valor de r1?", "Alargar", JOptionPane.QUESTION_MESSAGE);
        String r2s = JOptionPane.showInputDialog(this, "Qual o valor de r2?", "Alargar", JOptionPane.QUESTION_MESSAGE);
        String s2s = JOptionPane.showInputDialog(this, "Qual o valor de s2?", "Alargar", JOptionPane.QUESTION_MESSAGE);

        r1 = Integer.parseInt(r1s);
        r2 = Integer.parseInt(r2s);
        s2 = Integer.parseInt(s2s);

        this.fatiarMatriz();
        this.processarImagem(1);
}//GEN-LAST:event_fatiarActionPerformed

    private void filtragemMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtragemMedianaActionPerformed
        this.filtrarSuavizaçaoMediana();
        this.processarImagem(1);
}//GEN-LAST:event_filtragemMedianaActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        this.novaImagemCinza(original);
        matrizAlterada = matriz;
        this.processarImagem(1);
    }//GEN-LAST:event_resetActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        JFileChooser escolher = new JFileChooser();
        if (escolher.showSaveDialog(JanelaPhotoshop.this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = escolher.getSelectedFile();
                this.salvar(file.getName(), file);
            } catch (IOException ex) {
                Logger.getLogger(JanelaPhotoshop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void gaussianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaussianoActionPerformed

        String por = JOptionPane.showInputDialog(this, "Qual a porcentagem de ruído que deseja na imagem?", "Ruído Gaussiano", JOptionPane.QUESTION_MESSAGE);
        String sig = JOptionPane.showInputDialog(this, "Qual o valor do sigma?", "Ruído Gaussiano", JOptionPane.QUESTION_MESSAGE);
        double porcentagem = Double.parseDouble(por);
        double sigma = Double.parseDouble(sig);
        this.ruidoGaussiano(porcentagem, sigma);
        this.processarImagem(1);
    }//GEN-LAST:event_gaussianoActionPerformed

    private void impulsivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impulsivoActionPerformed
        String por = JOptionPane.showInputDialog(this, "Qual a porcentagem de ruído que deseja na imagem?", "Ruído Impulsivo", JOptionPane.QUESTION_MESSAGE);
        double porcentagem = Double.parseDouble(por);
        this.ruidoImpulsivo(porcentagem);
        this.processarImagem(1);
    }//GEN-LAST:event_impulsivoActionPerformed

    private void luminanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luminanciaActionPerformed
        if (lum) {
            lum = false;
        } else {
            lum = true;
        }
    }//GEN-LAST:event_luminanciaActionPerformed

    private void filtragemEspacialPassaBaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtragemEspacialPassaBaixasActionPerformed
        this.filtrarSuavizacaoPassaBaixas();
        this.processarImagem(1);
}//GEN-LAST:event_filtragemEspacialPassaBaixasActionPerformed

    private void filtragemEspacialPassaAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtragemEspacialPassaAltasActionPerformed
        this.filtrarAguçamentoPassaAlta();
        this.processarImagem(1);
    }//GEN-LAST:event_filtragemEspacialPassaAltasActionPerformed

    private void filtragemAltoReforcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtragemAltoReforcoActionPerformed
        String a = JOptionPane.showInputDialog(this, "Qual o valor de A?", "Alto Reforço", JOptionPane.QUESTION_MESSAGE);
        double A = Double.parseDouble(a);
        this.filtrarAguçamentoAltoReforco(A);
        this.processarImagem(1);
}//GEN-LAST:event_filtragemAltoReforcoActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        this.roberts();
        this.processarImagem(1);
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void robertsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robertsItemActionPerformed
        this.roberts();
        this.normalizarMatrizAlterada();
        this.processarImagem(1);
}//GEN-LAST:event_robertsItemActionPerformed

    private void sobelItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobelItemActionPerformed
        this.sobel();
        this.normalizarMatrizAlterada();
        this.processarImagem(1);
}//GEN-LAST:event_sobelItemActionPerformed

    private void prewittItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prewittItemActionPerformed
        this.prewitt();
        this.normalizarMatrizAlterada();
        this.processarImagem(1);
    }//GEN-LAST:event_prewittItemActionPerformed

    private void limiarizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limiarizacaoActionPerformed
        try {
            int valorlimiar = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor do limiar?"));
            int t0 = Integer.parseInt(JOptionPane.showInputDialog("Quantas repetições?"));
            if (valorlimiar < 0 || valorlimiar > 256) {
                throw new NumberFormatException();
            } else {
                limiarizacao(valorlimiar, t0);
                processarImagem(1);
            }
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Entre com um valor inteiro maior que 0 e menor que 256");
        }
}//GEN-LAST:event_limiarizacaoActionPerformed

    private void preTratamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preTratamentoActionPerformed
        int tol = Integer.parseInt(JOptionPane.showInputDialog(this, "Qual o valor da tolerância?",
                "Tolerância", JOptionPane.QUESTION_MESSAGE));
        this.preProcessar(tol);
        this.processarImagem(1);
        this.roberts();
        this.normalizarMatrizAlterada();
        this.processarImagem(1);
        this.negativarMatriz();
        this.processarImagem(1);
        this.consertarBordasFigura();
        this.processarImagem(1);
        abas.setSelectedIndex(1);
        this.salvarStringResultado();
        if(JOptionPane.showConfirmDialog(null, "Deseja Saber a direção") == JOptionPane.YES_OPTION)
            this.direcao();
    }//GEN-LAST:event_preTratamentoActionPerformed


//MÉTODOS DE PRE-PROCESSAMENTO DA IMAGEM
//******************************************************************************
    public void preProcessar(int tol) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matriz[i][j] < 255 - tol) {
                    matrizAlterada[i][j] = 0;
                }
            }
        }
    }

    public void consertarBordasFigura() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == h - 1 || j == w - 1) {
                    matrizAlterada[i][j] = 255;
                }
            }
        }
    }

    public void salvarStringResultado() {
        StringBuffer resultado = new StringBuffer();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrizAlterada[i][j] == 255) {
                    resultado.append(" ");
                } else {
                    resultado.append("*");
                }
            }
            resultado.append("\n");
        }
        escreverNoArquivo(new File("").getAbsolutePath() + "/preprocessamento.txt", resultado.toString());
    }

    public void escreverNoArquivo(String caminho, String texto) {
        try {
            File arquivo = new File(caminho);
            PrintWriter pw = new PrintWriter(arquivo);
            pw.write(texto);
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void direcao() {
        StringBuffer saida = new StringBuffer();
        int c0 = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0;
        Ponto init = new Ponto();
        int x = 0, y = 0;
        String caminho = "";
        int[][] matrizaux = matriz;
        boolean inicio = true;
        boolean fim = false;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matriz[i][j] == 0) {
                    x = i;
                    y = j;
                    init.setCordenada_x(x);
                    init.setCordenada_y(y);
                    //System.out.println(init.toString());
                    fim = true;
                    break;
                }
            }
            if (fim) {
                break;
            }
        }


        while ((init.getCordenada_x() != x || init.getCordenada_y() != y) || inicio) {
            inicio = false;
//            matrizaux[x][y] = 255;
            if (matrizaux[x - 1][y] == 0 && !caminho.equalsIgnoreCase("4")) {
                saida.append("0");
                matrizaux[x - 1][y] = 255;
                caminho = "0";
                x = x - 1;
            } else {
                if (matrizaux[x - 1][y - 1] == 0 && !caminho.equalsIgnoreCase("5")) {
                    saida.append("1");
                    matrizaux[x - 1][y - 1] = 255;
                    caminho = "1";
                    x = x - 1;
                    y = y - 1;
                } else {
                    if (matrizaux[x][y - 1] == 0 && !caminho.equalsIgnoreCase("6")) {
                        saida.append("2");
                        matrizaux[x][y - 1] = 255;
                        caminho = "2";
                        y = y - 1;
                    } else {
                        if (matrizaux[x + 1][y - 1] == 0 && !caminho.equalsIgnoreCase("7")) {
                            saida.append("3");
                            matrizaux[x + 1][y - 1] = 255;
                            caminho = "3";
                            x = x + 1;
                            y = y - 1;
                        } else {
                            if (matrizaux[x + 1][y] == 0 && !caminho.equalsIgnoreCase("0")) {
                                saida.append("4");
                                matrizaux[x + 1][y] = 255;
                                caminho = "4";
                                x = x + 1;
                            } else {
                                if (matrizaux[x + 1][y + 1] == 0 && !caminho.equalsIgnoreCase("1")) {
                                    saida.append("5");
                                    matrizaux[x + 1][y + 1] = 255;
                                    caminho = "5";
                                    x = x + 1;
                                    y = y + 1;
                                } else {
                                    if (matrizaux[x][y + 1] == 0 && !caminho.equalsIgnoreCase("2")) {
                                        saida.append("6");
                                        matrizaux[x][y + 1] = 255;
                                        caminho = "6";
                                        y = y + 1;
                                    } else {
                                        if (matrizaux[x - 1][y + 1] == 0 && !caminho.equalsIgnoreCase("3")) {
                                            saida.append("7");
                                            matrizaux[x - 1][y + 1] = 255;
                                            caminho = "7";
                                            x = x - 1;
                                            y = y + 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        ArrayList<Character> seq = new ArrayList<Character>();
        for (int i = 0; i < saida.length(); i++) {
            char v = saida.charAt(i);
            if (v == '0') {
                c0 += 1;
            } else {
                if (v == '1') {
                    c1 += 1;
                } else {
                    if (v == '2') {
                        c2 += 1;
                    } else {
                        if (v == '3') {
                            c3 += 1;
                        } else {
                            if (v == '4') {
                                c4++;
                            }else{
                                if (v == '5') {
                                    c5 += 1;
                                } else {
                                    if (v == '6') {
                                        c6 += 1;
                                    } else {
                                        if (v == '7') {
                                            c7 += 1;
                                        } else {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Qtd de 0: " + c0 + "\nQtd de 1: " + c1 + "\nQtd de 2: " + c2 + "\nQtd de 3: " + c3 +
                "\nQtd de 4: " + c4 + "\nQtd de 5: " + c5 + "\nQtd de 6: " + c6 + "\nQtd de 7: " + c7);
        String jo = "";
        for(int i=0; i<saida.length(); i++){
            if(i%30==0){
                jo+="\n";
            }
            jo+=saida.charAt(i);
        }

        JOptionPane.showMessageDialog(null, jo);
    }

//MÉTODOS DE ROTULAÇÃO DA IMAGEM
//******************************************************************************
    public void preencherRotulos() {
        matrizRotulos = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matriz[i][j] >= 128) {
                    matrizRotulos[i][j] = 1;
                } else {
                    matrizRotulos[i][j] = 0;
                }
            }
        }
    }

    public void rotularMatrizPorLinha() {
        rot = 0;
        //rotula a matriz por linha
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrizRotulos[i][j] == 1) {
                    if (j > 0) {
                        //verifica se antes tem um zero para iniciar um novo rótulo
                        if (matrizRotulos[i][j - 1] == 0) {
                            rotulo++;
                        }
                    }

                    if (rot > 2) {
                        //trata dos rótulos sequenciais para não pular nenhum
                        if (rotulo - rotulos[rot - 1] == 2) {
                            rotulo--;
                        }
                    }
                    //salva o rótulo atual num array de rótulos
                    rotulos[rot++] = rotulo;
                    matrizRotulos[i][j] = rotulo;
                }
            }
            rotulo++;
        }
    }

    //1.1.
    public void rotularMatrizPorEquivalencia(int tipo) {
        //faz a equivalencia dos rótulos colocados acima
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i != 0) { //verifica acima
                    if ((matrizRotulos[i - 1][j] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j] < matrizRotulos[i][j])) {
                        matrizRotulos[i][j] = matrizRotulos[i - 1][j];
                    }
                    if ((matrizRotulos[i - 1][j] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j] > matrizRotulos[i][j])) {
                        matrizRotulos[i - 1][j] = matrizRotulos[i][j];
                    }
                }

                if (j != 0) {
                    //verifica se o da esquerda é maior
                    if ((matrizRotulos[i][j] != 0) && (matrizRotulos[i][j - 1] != 0) && (matrizRotulos[i][j] < matrizRotulos[i][j - 1])) {
                        matrizRotulos[i][j - 1] = matrizRotulos[i][j];

                        //verifica o da esquerda recursivamente
                        int j2 = j;
                        while (true) {
                            if (j2 != 0) {
                                if ((matrizRotulos[i][j2 - 1] == 0)) {
                                    break;
                                } else {
                                    matrizRotulos[i][j2 - 1] = matrizRotulos[i][j2];
                                    //verifica se acima encontrou um rotulo maior
                                    if ((matrizRotulos[i - 1][j2] != 0) && (matrizRotulos[i][j2] != 0) && (matrizRotulos[i - 1][j2] > matrizRotulos[i][j2])) {
                                        matrizRotulos[i - 1][j2] = matrizRotulos[i][j2];
                                    }
                                    j2--;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    //verifica se o da esquerda é menor
                    if ((matrizRotulos[i][j] != 0) && (matrizRotulos[i][j - 1] != 0) && (matrizRotulos[i][j] > matrizRotulos[i][j - 1])) {
                        matrizRotulos[i][j] = matrizRotulos[i][j - 1];
                    }
                }

                if (i != 0) { //verifica acima
                    if ((matrizRotulos[i - 1][j] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j] > matrizRotulos[i][j])) {
                        matrizRotulos[i - 1][j] = matrizRotulos[i][j];
                    }
                }

                //vizinhança de 8
                if (tipo == 8) {
                    verificarVizinhança8(i, j);
                }

                System.out.print(matrizRotulos[i][j]);
            }
        }
    }

    //1.2.
    //1.3.
    public void verificarVizinhança8(int i, int j) {
        if ((i > 0) && (j > 0)) {
            if ((matrizRotulos[i - 1][j - 1] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j - 1] < matrizRotulos[i][j])) {
                matrizRotulos[i][j] = matrizRotulos[i - 1][j - 1];
            }
            if ((matrizRotulos[i - 1][j - 1] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j - 1] > matrizRotulos[i][j])) {
                matrizRotulos[i - 1][j - 1] = matrizRotulos[i][j];
            }
        }
        //verificar acima à direita se o checkbox estiver marcado
        if ((i > 0) && (j < w - 1)) {
            if ((matrizRotulos[i - 1][j + 1] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j + 1] < matrizRotulos[i][j])) {
                matrizRotulos[i][j] = matrizRotulos[i - 1][j + 1];
                rotularMatrizPorEquivalencia(8);
            }
            if ((matrizRotulos[i - 1][j + 1] != 0) && (matrizRotulos[i][j] != 0) && (matrizRotulos[i - 1][j + 1] > matrizRotulos[i][j])) {
                matrizRotulos[i - 1][j + 1] = matrizRotulos[i][j];
                rotularMatrizPorEquivalencia(8);
            }
        }
    }

//MÉTODOS DE EFEITO NA IMAGEM
//******************************************************************************
    //2.
    public void quantizarMatriz(int intervalos) {
        int tamIntervalos = (int) 256 / intervalos;
        int sup = 0;
        int inf = 0;
        ArrayList<Integer> limites = new ArrayList<Integer>();

        for (int i = 0; i < intervalos; i++) {
            limites.add(i * tamIntervalos);
            limites.add(((i + 1) * tamIntervalos) - 1);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < limites.size(); k += 2) {
                    inf = limites.get(k);
                    sup = limites.get(k + 1);
                    if ((matriz[i][j] >= inf) && (matriz[i][j] <= sup)) {
                        matrizAlterada[i][j] = (int) (sup + inf) / 2;
                    }
                }
            }
        }
    }

    //3.
    public void negativarMatriz() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrizAlterada[i][j] = 255 - matriz[i][j];
            }
        }
    }

    //4.
    public void alargarMatriz() {
        double fator = s2 / r2;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((matriz[i][j] > r1) && (matriz[i][j] <= r2)) {
                    matrizAlterada[i][j] = (int) (matriz[i][j] * fator);
                }
            }
        }
    }

    //5.
    public void fatiarMatriz() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((matriz[i][j] > r1) && (matriz[i][j] <= r2)) {
                    matrizAlterada[i][j] = s2;
                } else {
                    matrizAlterada[i][j] = matriz[i][j];
                }
            }
        }
    }

    //6.
    //6.1.
    public ImageIcon getHistograma(int histo) {
        int i, j, borda = 10, larguraBarra = 6;
        int alturaHistograma = 200;
        int agrupamento = 15;
        int posicoesVetor = 256 / agrupamento;
        int histogramaAgr[] = new int[posicoesVetor];

        for (i = 0; i < posicoesVetor; i++) {
            histogramaAgr[i] = 0;
            for (j = i * agrupamento; j < ((i + 1) * agrupamento); j++) {
                if (histo == 1) {
                    histogramaAgr[i] += histograma[j];
                } else {
                    histogramaAgr[i] += histogramaAlterada[j];
                }
            }
        }

        int maior = histogramaAgr[0];
        for (i = 1; i < posicoesVetor; i++) {
            if (histogramaAgr[i] > maior) {
                maior = histogramaAgr[i];
            }
        }

        i = 0;
        while (maior > Math.pow(10, i)) {
            i++;
        }

        j = (int) Math.pow(10, i - 1);
        i = 1;

        while (maior > j * i) {
            i++;
        }

        int escalay = j * i;

        // Cria o buffer para armazenar a imagem do histograma
        BufferedImage histoGrafico = new BufferedImage(posicoesVetor * agrupamento + 2 * borda, alturaHistograma + 2 * borda, BufferedImage.TYPE_INT_ARGB);
        Graphics g = histoGrafico.createGraphics();
        // limpa o grafico
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, histoGrafico.getWidth(), histoGrafico.getHeight());

        // desenha grades
        g.setColor(Color.RED);
        g.drawLine(borda, borda, borda, borda + alturaHistograma);
        g.drawLine(borda, borda + alturaHistograma, borda + histoGrafico.getWidth(), borda + alturaHistograma);

        // preenche histograma
        g.setColor(Color.BLACK);
        g.setFont(new Font("MS Sans Serif", Font.PLAIN, 8));
        for (i = 0; i <
                posicoesVetor; i++) {
            j = (alturaHistograma * histogramaAgr[i]) / escalay;
            g.fillRect((i + 1) * posicoesVetor - larguraBarra, borda + (alturaHistograma - j), larguraBarra, j);
            g.drawString(String.valueOf(i * agrupamento) + "-", borda + (i * agrupamento), 2 * borda + alturaHistograma);
        }
        return new ImageIcon(histoGrafico);
    }

    //6.2. EQUALIZAÇÃO HISTOGRAMA

    //7.
    //7.1.1.
    public void filtrarSuavizaçaoMediana() {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int maior = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i > 0) && (j > 0) && (i < h - 1) && (j < w - 1)) {
                    numeros.add(matriz[i - 1][j - 1]);
                    numeros.add(matriz[i - 1][j]);
                    numeros.add(matriz[i - 1][j + 1]);
                    numeros.add(matriz[i][j - 1]);
                    numeros.add(matriz[i][j]);
                    numeros.add(matriz[i][j + 1]);
                    numeros.add(matriz[i + 1][j - 1]);
                    numeros.add(matriz[i + 1][j]);
                    numeros.add(matriz[i + 1][j + 1]);

                    for (int t = 0; t < 4; t++) {
                        maior = 0;
                        for (Integer integer : numeros) {
                            if (integer > maior) {
                                maior = integer;
                            }
                        }
                        numeros.remove(numeros.indexOf(maior));
                    }

                    maior = 0;
                    for (Integer integer : numeros) {
                        if (integer > maior) {
                            maior = integer;
                        }
                    }
                    matrizAlterada[i][j] = maior;
                    numeros.clear();
                }
            }
        }
    }

    //7.1.2.
    public void filtrarSuavizacaoPassaBaixas() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i > 0) && (j > 0) && (i < h - 1) && (j < w - 1)) {
                    matrizAlterada[i][j] =
                            matriz[i - 1][j - 1] * 1 + matriz[i - 1][j] * 1 + matriz[i - 1][j + 1] * 1 +
                            matriz[i][j - 1] * 1 + matriz[i][j] * 1 + matriz[i][j + 1] * 1 +
                            matriz[i + 1][j - 1] * 1 + matriz[i + 1][j] * 1 + matriz[i + 1][j + 1] * 1;

                    matrizAlterada[i][j] = (int) Math.abs(matrizAlterada[i][j] / 9);
                }
            }
        }
    }

    //7.2.1.
    public void filtrarAguçamentoAltoReforco(double A) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i > 0) && (j > 0) && (i < h - 1) && (j < w - 1)) {
                    matrizAlterada[i][j] = (int) (matriz[i - 1][j - 1] * -1 + matriz[i - 1][j] * -1 + matriz[i - 1][j + 1] * -1 +
                            matriz[i][j - 1] * -1 + matriz[i][j] * 9 * A - 1 + matriz[i][j + 1] * -1 +
                            matriz[i + 1][j - 1] * -1 + matriz[i + 1][j] * -1 + matriz[i + 1][j + 1] * -1);

                    matrizAlterada[i][j] = (int) Math.abs(matrizAlterada[i][j] / 9);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrizAlterada[i][j] = matriz[i][j] + matrizAlterada[i][j];
            }
        }

        this.normalizarMatrizAlterada();
    }

    //7.2.2.
    public void filtrarAguçamentoPassaAlta() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i > 0) && (j > 0) && (i < h - 1) && (j < w - 1)) {
                    matrizAlterada[i][j] =
                            matriz[i - 1][j - 1] * -1 + matriz[i - 1][j] * -1 + matriz[i - 1][j + 1] * -1 +
                            matriz[i][j - 1] * -1 + matriz[i][j] * 8 + matriz[i][j + 1] * -1 +
                            matriz[i + 1][j - 1] * -1 + matriz[i + 1][j] * -1 + matriz[i + 1][j + 1] * -1;

                    matrizAlterada[i][j] = (int) Math.abs(matrizAlterada[i][j] / 9);
                }
            }
        }
    }

    //7.2.3.
    //7.2.3.1.
    public void roberts() {
        double rx = 0, ry = 0;
        for (int i = 0; i < h - 1; i++) {
            for (int j = 0; j < w - 1; j++) {
                rx = 1 * matriz[i][j] + ((-1) * matriz[i + 1][j + 1]);
                ry = 1 * matriz[i][j + 1] + ((-1) * matriz[i + 1][j]);
                matrizAlterada[i][j] = (int) Math.sqrt(Math.pow(rx, 2) + Math.pow(ry, 2));
            }
        }
    }

    //7.2.3.2.
    public void prewitt() {
        double rx = 0, ry = 0;
        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                rx = ((-1) * matriz[i - 1][j - 1]) + ((-1) * matriz[i - 1][j]) + ((-1) * matriz[i - 1][j + 1]) + 1 * matriz[i + 1][j - 1] + 1 * matriz[i + 1][j] + 1 * matriz[i + 1][j + 1];
                ry = ((-1) * matriz[i - 1][j - 1]) + ((-1) * matriz[i][j - 1]) + ((-1) * matriz[i + 1][j - 1]) + 1 * matriz[i - 1][j + 1] + 1 * matriz[i][j + 1] + 1 * matriz[i + 1][j + 1];
                matrizAlterada[i][j] = (int) Math.sqrt(Math.pow(rx, 2) + Math.pow(ry, 2));
            }
        }
    }

    //7.2.3.3.
    public void sobel() {
        double rx = 0, ry = 0;
        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                rx = ((-1) * matriz[i - 1][j - 1]) + ((-2) * matriz[i - 1][j]) + ((-1) * matriz[i - 1][j + 1]) + 1 * matriz[i + 1][j - 1] + 2 * matriz[i + 1][j] + 1 * matriz[i + 1][j + 1];
                ry = ((-1) * matriz[i - 1][j - 1]) + ((-2) * matriz[i][j - 1]) + ((-1) * matriz[i + 1][j - 1]) + 1 * matriz[i - 1][j + 1] + 2 * matriz[i][j + 1] + 1 * matriz[i + 1][j + 1];
                matrizAlterada[i][j] = (int) Math.sqrt(Math.pow(rx, 2) + Math.pow(ry, 2));
            }
        }
    }

    //8.1.
    public void ruidoGaussiano(double porcentagem, double sigma) {

        double aux1 = 0;
        int totalperc = (int) (h * w * (porcentagem / 100));
        int aux, hp, wp, temp = 0;
        Random r = new Random();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                vp.addElement(new Ponto(i, j));
            }
        }


        for (int i = 0; i < totalperc; i++) {
            temp = r.nextInt(vp.size()); // sorteio de index
            hp = vp.get(temp).getCordenada_x();
            wp = vp.get(temp).getCordenada_y();
            vp.remove(temp);

            aux = matriz[hp][wp];
            aux1 = (1 / (Math.sqrt(2 * Math.PI * sigma)) * Math.pow(Math.E, ((Math.pow(aux, 2) / (2 * Math.pow(sigma, 2))))));
            matrizAlterada[hp][wp] = (int) Math.round(aux1);
        }

        this.normalizarMatrizAlterada();
    }

    //8.2.
    public void ruidoImpulsivo(double porcentagem) {
        int aleatorio = 0;
        int ruido = 0;
        int por = 0;
        for (int i = 0; i < h; i++) {

            for (int j = 0; j < w; j++) {
                por = ale.nextInt(1 + 100);
                if (por <= porcentagem) {
                    if ((i > 0) && (j > 0) && (i < h - 1) && (j < w - 1)) {
                        aleatorio = ale.nextInt(1 + tamMascara * tamMascara);
                        ruido = ale.nextInt(1 + 255);

                        if (ruido > 127) {
                            ruido = 255;
                        } else {
                            ruido = 0;
                        }

                        if (aleatorio == 1) {
                            matrizAlterada[i - 1][j - 1] = ruido;
                        } else if (aleatorio == 2) {
                            matrizAlterada[i - 1][j] = ruido;
                        } else if (aleatorio == 3) {
                            matrizAlterada[i - 1][j + 1] = ruido;
                        } else if (aleatorio == 4) {
                            matrizAlterada[i][j - 1] = ruido;
                        } else if (aleatorio == 5) {
                            matrizAlterada[i][j] = ruido;
                        } else if (aleatorio == 6) {
                            matrizAlterada[i][j + 1] = ruido;
                        } else if (aleatorio == 7) {
                            matrizAlterada[i + 1][j - 1] = ruido;
                        } else if (aleatorio == 8) {
                            matrizAlterada[i + 1][j] = ruido;
                        } else if (aleatorio == 9) {
                            matrizAlterada[i + 1][j + 1] = ruido;
                        }
                    }
                } else {
                    //DO NOTHING
                }
            }
        }
    }

    public void normalizarMatrizAlterada() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrizAlterada[i][j] > 255) {
                    matrizAlterada[i][j] = 255;
                } else if (matrizAlterada[i][j] < 0) {
                    matrizAlterada[i][j] = 0;
                }
            }
        }
    }

//TRATA DA TRANSFORMAÇÃO DO ARQUIVO DE IMAGEM EM MATRIZ DE INTEIROS
//******************************************************************************
    public void novaImagemCinza(File f) {
        try {
            imagem = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Não conseguiu abrir o arquivo: " + f);
        }

        if (imagem == null) {
            throw new RuntimeException("Arquivo inválido: " + f);
        }

        // Obtem a altura e a largura da imagem
        w = imagem.getWidth();
        h = imagem.getHeight();
        matrizAlterada = new int[h][w];

        // converte a imagem para escala de cinza
        Color pixel, cinza;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                pixel = getPixel(x, y);
                cinza = toGray(pixel);
                setPixel(x, y, cinza);
            }
        }

        // carrega os dados da imagem
        int x, y;

        // Cria a matriz da imagem e inicializa o histograma
        matriz = new int[h][w];
        for (x = 0; x < 256; x++) {
            histograma[x] = 0;
        }

        // Obtem a representacao matricial da imagem e os dados do histograma
        for (x = 0; x < w; x++) {
            for (y = 0; y < h; y++) {
                pixel = new Color(imagem.getRGB(x, y)); // obtem o pixel
                matriz[y][x] = pixel.getRed();
                histograma[pixel.getRed()]++;	// preenche o histograma
            }
        }
    }

//PROCESSAM A IMAGEM ALTERADA E A COLOCAM NA JANELA
//******************************************************************************
    private void processarImagem(int tipo) {
        imagemAlterada = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); //para não ficar escura
        preencheMatrizAlterada(tipo);
        labelModificada.setIcon(new ImageIcon(imagemAlterada));
        labelModificada.setText("");
    }

    public void preencheMatrizAlterada(int tipo) {
        int tom;
        Color pixel;

        if (tipo != 1) {
            matrizAlterada = matrizRotulos;
        }

        for (int i = 0; i < 256; i++) {
            histogramaAlterada[i] = 0;
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                tom = matrizAlterada[j][i];
                histogramaAlterada[tom]++;
                pixel = new Color(tom, tom, tom);
                imagemAlterada.setRGB(i, j, pixel.getRGB());
            }
        }
    }

//MÉTODOS DE CAPTURA DE VALORES DO ARQUIVO DE IMAGEM
//******************************************************************************
    public Color toGray(Color color) {
        int l = (int) (Math.round(lum(color)));
        Color gray = new Color(l, l, l);
        return gray;
    }

    public Color getPixel(int i, int j) {
        return new Color(imagem.getRGB(i, j));
    }

    public void setPixel(int i, int j, Color c) {
        imagem.setRGB(i, j, c.getRGB());
    }

//APLICA LUMINANCIA NA IMAGEM, NÃO TEM EFEITO PARA ESCALA DE CINZA
//******************************************************************************
    public double lum(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (lum) {
            return .333 * r + .333 * g + .334 * b;
        } else {
            return .299 * r + .587 * g + .114 * b;
        }
    }

//SALVA A IMAGEM MODIFICADA EM UM ARQUIVO DE IMAGEM
//******************************************************************************   
    public void salvar(String nome, File f) throws IOException {
        String suffix = nome.substring(nome.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        ImageIO.write(imagemAlterada, suffix, f);
    }

//MÉTODO PRINCIPAL CHAMADO NA EXECUÇÃO DO APLICATIVO
//******************************************************************************
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new JModestPhotoshop().setVisible(true);
//            }
//        });
//
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu PDI;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenuItem alargar;
    private javax.swing.JMenu arquivo;
    private javax.swing.JMenuItem fatiar;
    private javax.swing.JMenuItem filtragemAltoReforco;
    private javax.swing.JMenuItem filtragemEspacialPassaAltas;
    private javax.swing.JMenuItem filtragemEspacialPassaBaixas;
    private javax.swing.JMenuItem filtragemMediana;
    private javax.swing.JMenu filtros;
    private javax.swing.JMenuItem gaussiano;
    private javax.swing.JMenuItem gerarHistograma;
    private javax.swing.JLabel h1;
    private javax.swing.JLabel h2;
    private javax.swing.JMenuItem impulsivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelModificada;
    private javax.swing.JLabel labelOriginal;
    private javax.swing.JMenuItem limiarizacao;
    private javax.swing.JCheckBoxMenuItem luminancia;
    private javax.swing.JMenuItem negativar;
    private javax.swing.JMenuItem preTratamento;
    private javax.swing.JMenuItem prewittItem;
    private javax.swing.JMenuItem quantizar;
    private javax.swing.JMenuItem reset;
    private javax.swing.JMenuItem robertsItem;
    private javax.swing.JMenu ruidos;
    private javax.swing.JTextArea saida;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem salvar;
    private javax.swing.JMenuItem sobelItem;
    private javax.swing.JMenuItem vizinhanca4;
    private javax.swing.JMenuItem vizinhanca8;
    private javax.swing.JMenu vizinhancas;
    // End of variables declaration//GEN-END:variables
}
