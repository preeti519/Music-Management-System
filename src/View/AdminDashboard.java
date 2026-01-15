/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import java.awt.CardLayout;
import javax.swing.JOptionPane;
import Controller.SongController;
import Model.Song;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import View.UserDashboard;
import View.LoginPage;







/**
 *
 * @author airm2
 * 
 */


public class AdminDashboard extends javax.swing.JFrame {
    

    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDashboard.class.getName());

    private static AdminDashboard instance;

public static AdminDashboard getInstance() {
    if (instance == null) {
        instance = new AdminDashboard();
    }
    return instance;
}

    
    // To track which row is being edited
    private int editingRowIndex = -1;

    //Controller instance(handels Curd+Storage)
    private final SongController songController;
    
  
    
    // Song list from model
    private ArrayList<Song> songs;
    // Table model for View Songs table (jTable1)
    private final DefaultTableModel model;
    // Table model for Search & Sort table (jTable3)
    private DefaultTableModel searchTableModel;
    //songs = songController.getAllSongs();
    

    
    public AdminDashboard() {
    initComponents();
    instance = this; 
    

    // Initialize controller
    songController = new SongController();
    //loadStats();
    loadRecentSongs();

    // Load songs from model
    songs = songController.getAllSongs();
   // loadDashboardStats();
   // Load dashboard data
    loadDashboardStats();
    loadRecentSongs();
    


    // Initialize table models
    model = (DefaultTableModel) jTable1.getModel();
    searchTableModel = (DefaultTableModel) jTable3.getModel();

    // Clear dummy rows
    model.setRowCount(0);
    searchTableModel.setRowCount(0);
    // Load dashboard data 
   // loadRecentSongs();
    //loadDashboardStats();

    // Card layout panels
    MainPanel.add(DashboardPanel, "dashboard");
    MainPanel.add(ViewSongPanel, "view");
    MainPanel.add(AddSongPanel, "add");
    MainPanel.add(SearchSortPanel, "search");
    MainPanel.add(UserViewPanel, "user");

    // Insert default data (first run only)
    if (songs.isEmpty()) {
        songController.addSong(new Song("Shape of You", "Ed Sheeran", "Divide", "Pop", 4, 2017));
        songController.addSong(new Song("Believer", "Imagine Dragons", "Evolve", "Rock", 3, 2018));
        songController.addSong(new Song("Fix You", "Coldplay", "X&Y", "Rock", 4, 2005));
        songController.addSong(new Song("Someone Like You", "Adele", "21", "Pop", 5, 2011));
        songController.addSong(new Song("Perfect", "Adele", "21", "Pop", 5, 2010));

        songs = songController.getAllSongs();
    }

    //  IMPORTANT: Load table
    loadSongsToTable();
    

    
}
    /**
 * Loads dashboard statistics such as
 * total songs and total artists.
 */
private void loadDashboardStats() {

    // Get all songs from controller
    ArrayList<Song> songs = songController.getAllSongs();

    // -------------------------------
    // TOTAL SONGS
    // -------------------------------
    int totalSongs = songs.size();
    lblTotalSongs.setText("Total Songs: " + totalSongs);

    // -------------------------------
    // TOTAL ARTISTS (UNIQUE)
    // -------------------------------
    Set<String> uniqueArtists = new HashSet<>();

    for (Song song : songs) {
        // Avoid null values
        if (song.getArtist() != null) {
            uniqueArtists.add(song.getArtist().trim().toLowerCase());
        }
    }

    int totalArtists = uniqueArtists.size();
    lblTotalArtists.setText("Total Artists: " + totalArtists);
}
/**
 * Loads recently added songs into dashboard labels.
 * Uses Queue from SongController (FIFO order).
 */
public void loadRecentSongs() {

    // Get recent songs from controller
    Queue<Song> recentSongs = songController.getRecentSongs();

    // Clear old text first
    lblRecent1.setText("");
    lblRecent2.setText("");
    lblRecent3.setText("");
    lblRecent4.setText("");

    int index = 0;

    // Display songs (max 4)
    for (Song song : recentSongs) {

        String text = "• " + song.getTitle() +
                      " (" + song.getReleaseYear() + ")";

        if (index == 0) lblRecent1.setText(text);
        else if (index == 1) lblRecent2.setText(text);
        else if (index == 2) lblRecent3.setText(text);
        else if (index == 3) lblRecent4.setText(text);

        index++;
        if (index == 4) break;
    }
}



    
    /*
 * Load songs into View Songs table (jTable1)
 */
   private void loadSongsToTable() {
    model.setRowCount(0);

    for (Song s : songs) {
        model.addRow(new Object[]{
            s.getTitle(),
            s.getArtist(),
            s.getAlbum(),
            s.getGenre(),
            s.getDuration(),
            s.getReleaseYear()
        });
    }
}

/*
 * Load search/sort results into Search & Sort table (jTable3)
 */
private void loadSearchTable(ArrayList<Song> list) {
    searchTableModel.setRowCount(0);

    for (Song s : list) {
        searchTableModel.addRow(new Object[]{
            s.getTitle(),
            s.getArtist(),
            s.getAlbum(),
            s.getGenre(),
            s.getDuration(),
            s.getReleaseYear()
        });
    }
}







    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        lblTotalSongs = new javax.swing.JLabel();
        lblTotalArtists = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblRecent1 = new javax.swing.JLabel();
        lblRecent2 = new javax.swing.JLabel();
        lblRecent3 = new javax.swing.JLabel();
        lblRecent4 = new javax.swing.JLabel();
        ViewSongPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tableContainerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddSongPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtArtist = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAlbum = new javax.swing.JTextField();
        comboGenre = new javax.swing.JComboBox<>();
        txtDuration = new javax.swing.JTextField();
        txtReleaseYear = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtSongTitle = new javax.swing.JTextField();
        SearchSortPanel = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        buttomPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ControllerPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton10 = new javax.swing.JButton();
        UserViewPanel = new javax.swing.JPanel();

        jLabel6.setText("jLabel6");

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

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Music Management System");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(74, 74, 74));
        jPanel1.setPreferredSize(new java.awt.Dimension(663, 60));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Music Management  System");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Panel ");

        jButton7.setBackground(new java.awt.Color(120, 120, 120));
        jButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("LOGOUT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton7))
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(55, 55, 55));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 360));
        jPanel2.setLayout(new java.awt.GridLayout(5, 1));

        jButton1.setBackground(new java.awt.Color(70, 70, 70));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Dashboard");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setBackground(new java.awt.Color(70, 70, 70));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Songs");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setBackground(new java.awt.Color(70, 70, 70));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add Song");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setBackground(new java.awt.Color(70, 70, 70));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search & Sort");
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setBackground(new java.awt.Color(70, 70, 70));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("User View");
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(new java.awt.CardLayout());

        DashboardPanel.setBackground(new java.awt.Color(255, 255, 255));
        DashboardPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(java.awt.Color.darkGray);
        headerPanel.setPreferredSize(new java.awt.Dimension(601, 100));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Admin Dashboard");

        jLabel17.setBackground(java.awt.Color.lightGray);
        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Welcome, Admin");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel17)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        DashboardPanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        lblTotalSongs.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTotalSongs.setText("Total Songs: 0");

        lblTotalArtists.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTotalArtists.setText("Total Artists: 0");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setText("Recently added Songs ");

        lblRecent1.setText("• Shape of You (2017)");

        lblRecent2.setText("• Believer (2018)");
        lblRecent2.setSize(new java.awt.Dimension(49, 20));

        lblRecent3.setText("• Fix You (2005)");
        lblRecent3.setSize(new java.awt.Dimension(49, 24));

        lblRecent4.setText("• Perfect (2010)");
        lblRecent4.setSize(new java.awt.Dimension(49, 28));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRecent1)
                            .addComponent(lblRecent2)
                            .addComponent(lblRecent3)
                            .addComponent(lblRecent4)))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel19))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalArtists)
                            .addComponent(lblTotalSongs))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTotalSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblTotalArtists)
                .addGap(48, 48, 48)
                .addComponent(jLabel19)
                .addGap(32, 32, 32)
                .addComponent(lblRecent1)
                .addGap(33, 33, 33)
                .addComponent(lblRecent2)
                .addGap(44, 44, 44)
                .addComponent(lblRecent3)
                .addGap(39, 39, 39)
                .addComponent(lblRecent4)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        DashboardPanel.add(statusPanel, java.awt.BorderLayout.CENTER);

        MainPanel.add(DashboardPanel, "dashboard");

        ViewSongPanel.setBackground(java.awt.Color.darkGray);
        ViewSongPanel.setAutoscrolls(true);
        ViewSongPanel.setPreferredSize(new java.awt.Dimension(300, 450));
        ViewSongPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(235, 235, 235));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(130, 120));

        jButton8.setBackground(new java.awt.Color(150, 150, 140));
        jButton8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton8.setText("Update Song");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 120, 110), 1, true));
        jButton8.setOpaque(true);
        jButton8.setPreferredSize(new java.awt.Dimension(160, 45));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(150, 150, 140));
        jButton9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton9.setText("Delete Song");
        jButton9.setAutoscrolls(true);
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 120, 110), 1, true));
        jButton9.setOpaque(true);
        jButton9.setPreferredSize(new java.awt.Dimension(160, 45));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        ViewSongPanel.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(110, 110, 110));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 40));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Songs");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel3)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        ViewSongPanel.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        tableContainerPanel.setBackground(java.awt.Color.darkGray);
        tableContainerPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 50));

        jTable1.setBackground(java.awt.Color.darkGray);
        jTable1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Song Title", "Artist", "Album", "Genre", "Duration", "Release Year"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(java.awt.Color.lightGray);
        jTable1.setRowHeight(32);
        jTable1.setSelectionBackground(new java.awt.Color(120, 120, 120));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        tableContainerPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ViewSongPanel.add(tableContainerPanel, java.awt.BorderLayout.CENTER);

        MainPanel.add(ViewSongPanel, "view");

        AddSongPanel.setBackground(new java.awt.Color(58, 63, 63));
        AddSongPanel.setForeground(new java.awt.Color(240, 240, 240));
        AddSongPanel.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Song");

        jLabel7.setBackground(new java.awt.Color(240, 240, 240));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(220, 220, 220));
        jLabel7.setText("Song Title: ");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(220, 220, 220));
        jLabel8.setText("Artist:");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(220, 220, 220));
        jLabel9.setText("Album:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(220, 220, 220));
        jLabel10.setText("Genre:");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Duration:");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(220, 220, 220));
        jLabel12.setText("Release Year:");
        jLabel12.setInheritsPopupMenu(false);

        comboGenre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Genre", "Pop", "Rock", "Classical", "Jazz" }));
        comboGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGenreActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(45, 52, 54));
        jButton6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(220, 220, 220));
        jButton6.setText("ADD SONG");
        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(95, 95, 95));
        btnClear.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(220, 220, 220));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddSongPanelLayout = new javax.swing.GroupLayout(AddSongPanel);
        AddSongPanel.setLayout(AddSongPanelLayout);
        AddSongPanelLayout.setHorizontalGroup(
            AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSongPanelLayout.createSequentialGroup()
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddSongPanelLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel5))
                    .addGroup(AddSongPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AddSongPanelLayout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(66, 66, 66)
                                .addComponent(btnClear))
                            .addGroup(AddSongPanelLayout.createSequentialGroup()
                                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddSongPanelLayout.createSequentialGroup()
                                        .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddSongPanelLayout.createSequentialGroup()
                                        .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)))
                                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAlbum)
                                    .addComponent(txtArtist)
                                    .addComponent(txtDuration)
                                    .addComponent(txtReleaseYear)
                                    .addComponent(txtSongTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(comboGenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        AddSongPanelLayout.setVerticalGroup(
            AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSongPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(47, 47, 47)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSongTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(AddSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(btnClear))
                .addGap(32, 32, 32))
        );

        MainPanel.add(AddSongPanel, "add");

        SearchSortPanel.setBackground(new java.awt.Color(234, 234, 234));
        SearchSortPanel.setLayout(new java.awt.BorderLayout());

        TitlePanel.setBackground(new java.awt.Color(63, 63, 63));
        TitlePanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Search&Sort Songs");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel13)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(41, 41, 41))
        );

        SearchSortPanel.add(TitlePanel, java.awt.BorderLayout.PAGE_START);

        buttomPanel.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 208, 208)));

        jTable3.setBackground(new java.awt.Color(217, 237, 247));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Song Title", "Artist", "Album ", "Genre ", "Duration", "Year"
            }
        ));
        jTable3.setToolTipText("");
        jTable3.setRowHeight(25);
        jTable3.setShowGrid(true);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttomPanel.add(jPanel7, java.awt.BorderLayout.CENTER);

        SearchSortPanel.add(buttomPanel, java.awt.BorderLayout.PAGE_END);

        ControllerPanel.setLayout(new java.awt.GridLayout(2, 1));

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 208, 208)));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setText("Search By:");
        jLabel15.setPreferredSize(new java.awt.Dimension(100, 110));
        jPanel5.add(jLabel15);

        jComboBox2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Year", "Advanced" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(120, 28));
        jPanel5.add(jComboBox2);

        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(220, 28));
        jPanel5.add(jTextField1);

        jButton11.setBackground(new java.awt.Color(217, 237, 247));
        jButton11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton11.setText("Search");
        jButton11.setBorderPainted(false);
        jButton11.setFocusPainted(false);
        jButton11.setOpaque(true);
        jButton11.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11);

        ControllerPanel.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(245, 245, 245));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 208, 208)));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 15));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setText("Sort by Release Year:");
        jLabel14.setPreferredSize(new java.awt.Dimension(151, 30));
        jPanel6.add(jLabel14);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jRadioButton1.setText("Ascending");
        jRadioButton1.setPreferredSize(new java.awt.Dimension(97, 28));
        jPanel6.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jRadioButton2.setText("Descending");
        jRadioButton2.setPreferredSize(new java.awt.Dimension(106, 30));
        jPanel6.add(jRadioButton2);

        jButton10.setBackground(new java.awt.Color(217, 237, 247));
        jButton10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton10.setText("Sort");
        jButton10.setBorderPainted(false);
        jButton10.setFocusPainted(false);
        jButton10.setOpaque(true);
        jButton10.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10);

        ControllerPanel.add(jPanel6);

        SearchSortPanel.add(ControllerPanel, java.awt.BorderLayout.CENTER);

        MainPanel.add(SearchSortPanel, "search");

        javax.swing.GroupLayout UserViewPanelLayout = new javax.swing.GroupLayout(UserViewPanel);
        UserViewPanel.setLayout(UserViewPanelLayout);
        UserViewPanelLayout.setHorizontalGroup(
            UserViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        UserViewPanelLayout.setVerticalGroup(
            UserViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        MainPanel.add(UserViewPanel, "user");

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) MainPanel.getLayout();
            cl.show(MainPanel, "dashboard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) MainPanel.getLayout();
            cl.show(MainPanel, "view");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) MainPanel.getLayout();
            cl.show(MainPanel, "add");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) MainPanel.getLayout();
            cl.show(MainPanel, "search");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) MainPanel.getLayout();
            cl.show(MainPanel, "user");
            // Open User Dashboard
UserDashboard userDashboard = new UserDashboard();
userDashboard.setVisible(true);

// Close Admin Dashboard
this.dispose();
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comboGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGenreActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        

    // --------- 1. READ INPUTS ----------
    String title = txtSongTitle.getText().trim();
    String artist = txtArtist.getText().trim();
    String album = txtAlbum.getText().trim();
    String genre = comboGenre.getSelectedItem().toString();
    String durationText = txtDuration.getText().trim();
    String yearText = txtReleaseYear.getText().trim();

    // --------- 2. VALIDATION ----------
    if (title.isEmpty() || artist.isEmpty() || album.isEmpty()
            || durationText.isEmpty() || yearText.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "All fields must be filled.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    if (genre.equals("Select Genre")) {
        JOptionPane.showMessageDialog(
                this,
                "Please select a genre.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    int duration, releaseYear;

    try {
        duration = Integer.parseInt(durationText);
        releaseYear = Integer.parseInt(yearText);

        if (duration <= 0 || releaseYear < 1900 || releaseYear > 2025) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid duration or release year.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this,
                "Duration and Release Year must be numeric.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    // --------- 3. UPDATE MODE ----------
    if (editingRowIndex != -1) {

        model.setValueAt(title, editingRowIndex, 0);
        model.setValueAt(artist, editingRowIndex, 1);
        model.setValueAt(album, editingRowIndex, 2);
        model.setValueAt(genre, editingRowIndex, 3);
        model.setValueAt(duration, editingRowIndex, 4);
        model.setValueAt(releaseYear, editingRowIndex, 5);

        editingRowIndex = -1; // exit edit mode

        JOptionPane.showMessageDialog(
                this,
                "Song updated successfully!",
                "Update",
                JOptionPane.INFORMATION_MESSAGE
        );

    } 
    // --------- 4. ADD MODE ----------
    else {
        Song song = new Song(
        title,
        artist,
        album,
        genre,
        duration,
        releaseYear
);

// ADD MODE
if (editingRowIndex == -1) {
    songController.addSong(song);
    // refresh admin dashboard immediately
AdminDashboard admin = AdminDashboard.getInstance();
admin.loadRecentSongs();
}
// UPDATE MODE
else {
    songController.updateSong(editingRowIndex, song);
    editingRowIndex = -1;
}

// Reload data from file/model
songs = songController.getAllSongs();
loadSongsToTable();

JOptionPane.showMessageDialog(
        this,
        "Song saved successfully!",
        "Success",
        JOptionPane.INFORMATION_MESSAGE
);


        
    }

    // --------- 5. CLEANUP ----------
    btnClearActionPerformed(evt);

    CardLayout cl = (CardLayout) MainPanel.getLayout();
    cl.show(MainPanel, "view");


        
       

   // loadRecentSongs();

    
    


        
    


    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        

    // Clear the Song Title input field
    txtSongTitle.setText("");

    // Clear the Artist input field
    txtArtist.setText("");

    // Clear the Album input field
    txtAlbum.setText("");

    // Clear the Duration input field
    txtDuration.setText("");

    // Clear the Release Year input field
    txtReleaseYear.setText("");

    // Reset the Genre combo box to the default option
    // Index 0 represents "Select Genre"
    comboGenre.setSelectedIndex(0);

    // Set cursor focus back to the Song Title field
    // This improves usability for entering a new song
    txtSongTitle.requestFocus();


    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
    // 1. Get selected row from View Songs table
    int selectedRow = jTable1.getSelectedRow();

    // 2. If no row selected, show warning
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(
            this,
            "Please select a song to update.",
            "No Selection",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // 3. Store selected row index for update
    editingRowIndex = selectedRow;

    // 4. Read values from selected row
    txtSongTitle.setText(model.getValueAt(selectedRow, 0).toString());
    txtArtist.setText(model.getValueAt(selectedRow, 1).toString());
    txtAlbum.setText(model.getValueAt(selectedRow, 2).toString());
    comboGenre.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
    txtDuration.setText(model.getValueAt(selectedRow, 4).toString());
    txtReleaseYear.setText(model.getValueAt(selectedRow, 5).toString());

    // 5. Switch to Add Song panel
    CardLayout cl = (CardLayout) MainPanel.getLayout();
    cl.show(MainPanel, "add");

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

if (selectedRow == -1) {
    JOptionPane.showMessageDialog(
            this,
            "Please select a song to delete.",
            "No Selection",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this song?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
);

if (confirm == JOptionPane.YES_OPTION) {

    songController.deleteSong(selectedRow);

    songs = songController.getAllSongs();
    loadSongsToTable();

    JOptionPane.showMessageDialog(
            this,
            "Song deleted successfully.",
            "Deleted",
            JOptionPane.INFORMATION_MESSAGE
    );
}

        
        

        

    

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        

    String keyword = jTextField1.getText().trim();

    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter search text");
        return;
    }

    String searchType = jComboBox2.getSelectedItem().toString();

    // ----- BINARY SEARCH -----
    if (searchType.equals("Title")) {

    Song result = songController.searchByTitleBinary(keyword);

    if (result != null) {
        ArrayList<Song> singleResult = new ArrayList<>();
        singleResult.add(result);
        loadSearchTable(singleResult);
    } else {
        JOptionPane.showMessageDialog(this, "Song not found");
    }

    
    

    } 
    else if (searchType.equals("Year")) {

        try {
            int year = Integer.parseInt(keyword);
            Song result = songController.searchByYearBinary(year);

            if (result != null) {
                ArrayList<Song> single = new ArrayList<>();
                single.add(result);
                loadSearchTable(single);
            } else {
                JOptionPane.showMessageDialog(this, "Song not found");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid year");
        }
    }
    // Linear search is used for partial text matching
    else if (searchType.equals("Advanced")) {

    ArrayList<Song> results = songController.linearSearch(keyword);

    if (!results.isEmpty()) {
        loadSearchTable(results);
    } else {
        JOptionPane.showMessageDialog(this, "No matching songs found");
    }
}



        
    


    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        

    ArrayList<Song> sortedList;

    // Check which radio button is selected
    if (jRadioButton1.isSelected()) {
        // Ascending sort
        sortedList = songController.sortSongsAscending();

    } else if (jRadioButton2.isSelected()) {
        // Descending sort
        sortedList = songController.sortSongsDescending();

    } else {
        JOptionPane.showMessageDialog(
            this,
            "Please select Ascending or Descending order",
            "Sort Option Required",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Load sorted result into Search & Sort table
    loadSearchTable(sortedList);


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // Go back to Login Page
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);

        // Close Admin Dashboard
        this.dispose();

    }//GEN-LAST:event_jButton7ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }
    // This method clears all input fields in the Add Song form
        private void clearFields() {
        txtSongTitle.setText("");
        txtArtist.setText("");
        txtAlbum.setText("");
        txtDuration.setText("");
        txtReleaseYear.setText("");
        comboGenre.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddSongPanel;
    private javax.swing.JPanel ControllerPanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel SearchSortPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JPanel UserViewPanel;
    private javax.swing.JPanel ViewSongPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JPanel buttomPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboGenre;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblRecent1;
    private javax.swing.JLabel lblRecent2;
    private javax.swing.JLabel lblRecent3;
    private javax.swing.JLabel lblRecent4;
    private javax.swing.JLabel lblTotalArtists;
    private javax.swing.JLabel lblTotalSongs;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel tableContainerPanel;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtArtist;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtReleaseYear;
    private javax.swing.JTextField txtSongTitle;
    // End of variables declaration//GEN-END:variables
}

