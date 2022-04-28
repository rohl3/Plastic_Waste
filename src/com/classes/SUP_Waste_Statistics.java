package com.classes;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SUP_Waste_Statistics extends JFrame{
    private ArrayList<PlacticProduct> arrayList = new ArrayList<>();
    private PlacticProduct placticProduct;
    private JPanel Panel1;
    private JList jlist1;
    private DefaultListModel listModel;
    private JTextField assetNumberTxt;
    private JTextField totalSupTxt;
    private JButton helpBtn;
    private JButton moreInfoBtn;
    private JScrollPane scrollPane;
    private JButton readMeBtn;
    private JLabel titleLbl;
    private JLabel imageLbl;
    private JButton graphBtn;

    public  SUP_Waste_Statistics() throws Exception {
        setContentPane(Panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        listModel = new DefaultListModel();
        jlist1.setModel(listModel);
        helpBtn.setPreferredSize(new Dimension(69,42));
        readMeBtn.setPreferredSize(new Dimension(69,42));

        helpButton();
        csvFileReader();
        jlistElementSelector();
        moreInfoButton();
        readMeButton();
        graphButton();
    }
    //legge i dati del file.csv e li carica su una String da cui poi ricaverà i dati da caricare sull'array
    public void csvFileReader() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\acer\\IdeaProjects\\Plastic_Waste\\src\\dataset\\Plastic-Waste-Makers-Index.csv"));
        String line;
        while ((line = br.readLine()) != null){
            String [] word = line.split(",");
            String rank = word[0];
            String producer = word[1];
            String noOfAssets = word[2];
            String flexible_SUP_waste = word[3];
            String rigid_SUP_waste = word[4];
            String total_SUP_waste = word[5];

            placticProduct = new PlacticProduct(rank, producer,noOfAssets,flexible_SUP_waste,rigid_SUP_waste,total_SUP_waste);
            listModel.addElement(placticProduct.getRank()+"- "+placticProduct.getPolymerProducer());
            arrayList.add(placticProduct);
            ImageIcon imageIcon = new ImageIcon("plasticWasteLogo.png");
            imageLbl.setIcon(imageIcon);
        }
    }

    //test
    public void printer(){
        for (PlacticProduct pp : arrayList){
            System.out.println(pp.getNumOfAssets());
        }
    }

    //quando selezioniamo un'azienda dalla JList i campi di testo vengono riempiti con i dati
    public void jlistElementSelector(){
        jlist1.addListSelectionListener(e -> {
            int index = jlist1.getSelectedIndex();
            if(index >0){
                PlacticProduct pp = arrayList.get(index);
                assetNumberTxt.setText(pp.getNumOfAssets() + "%");
                totalSupTxt.setText(pp.getTotal_SUP_waste() + "t");
            }
        });
    }

    //da informazioni sul significato di SUP
    public void helpButton(){
        helpBtn.addActionListener(e -> {
            String help = """
                    SUP = Single Use Plastic 
                    """;
            JOptionPane.showMessageDialog(rootPane,help);
        });
    }

    //da informazioni ulteriori sull'azienda
    public void moreInfoButton(){
        moreInfoBtn.addActionListener(e -> {
            int index = jlist1.getSelectedIndex();
            if(index > 0){
                PlacticProduct pp = arrayList.get(index);
                String producer = pp.getPolymerProducer();
                String rank = pp.getRank();
                String noAsset = pp.getNumOfAssets();
                String flexibleWaste = pp.getFlexible_SUP_waste();
                String rigidWaste = pp.getRigid_SUP_waste();
                String totalWaste = pp.getTotal_SUP_waste();

                JOptionPane.showMessageDialog(rootPane,"Rank='" + rank + '\n' +
                        "Producer= " + producer + '\n' +
                        "Number of Assets= " + noAsset + "%" + '\n' +
                        "Flexible_SUP_waste= " + flexibleWaste + "t" + '\n' +
                        "Rigid_SUP_waste= " + rigidWaste + "t" + '\n' +
                        "Total_SUP_waste= " + totalWaste + "t" + '\n');
            }
        });
    }

    //da informazioni su tutto il rpogramma
    public void readMeButton(){
        readMeBtn.addActionListener(e -> {
            String showMsg = """
                    Lo scopo di questo programma è quello di informare 
                    l'utente riguardo gli sprechi e i di plastica da parte 
                    di alcune delle piu grandi aziende produttrici di polimeri.
                    
                    Le aziende sono ordinate in base alle loro produzioni 
                    di SUP (Single Use Plastic).
                    
                    I due campi di testo ci mostrano rispettivamente il totale 
                    di plastica prodotta in base 100 e il totale di plastica  
                    in tonnellate dall'azienda selezionata.
                    
                    Il tasto More Info mostra nel dettaglio altre tipologie di plastica 
                    prodotte dall'azienda selezionata, oltre a informazioni 
                    già conosciute.     
                    """;
            JOptionPane.showMessageDialog(rootPane, showMsg);
        });
    }


    public void graphButton(){
        graphBtn.addActionListener(e -> {
            ImageIcon imageIcon = new ImageIcon("graph.png");
            JOptionPane.showMessageDialog(rootPane,imageIcon);
        });
    }
}
