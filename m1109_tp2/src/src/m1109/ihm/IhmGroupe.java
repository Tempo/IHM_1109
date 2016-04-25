/*
 * Module 1109 : module IHM : Carnet d'adresse
 */
package m1109.ihm;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import m1109.nf.Contact;
import m1109.nf.Groupe;
/**
 *
 * @author IUT2
 */
public class IhmGroupe extends javax.swing.JPanel {
    /*
     * Composants graphiques constituants l'interface
     */
    private IhmLogo ihmLogo, logo;
    private JTextField champNomG;
    private JTable table;
    private JButton effacer, valider, annuler;
    private JList symbole; 
    private DefaultTableModel model;
    /**
     * Creates new form CarnetUI
     */
    public IhmGroupe() { 
        super();
        
        initUIComponents();    
    }

    /**
     * Crée et positionne les composants graphiques constituant l'interface
     * avec : 
     *  - en haut : les informations du groupe (nom, icone, symbole,...)
     *  - au centre : la liste des membres du groupe
     *  - en bas : les boutons d'action sur le groupe
     */
    private void initUIComponents() {      
        
        this.add(new javax.swing.JLabel("Fiche groupe à compléter"));
        
        // TP2 - 4.1
        this.add(new JLabel("Nom du groupe :"));
        champNomG = new JTextField(30);
        this.add(champNomG);
        
        // Table des contacts
        String [] colonnes = {"Nom", "Prénom", "Date de naiss"};
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colonnes); //intitulé des colonnes        
        JTable table = new JTable(model);       
        this.add(table.getTableHeader());
        this.add(table);
        
        // Zone de dessin
        ihmLogo = new IhmLogo();
        this.add(ihmLogo); 
        
        // Bouton pour effacer zone de dessin
        effacer = new JButton("Effacer");
        this.add(effacer);
        
        // Liste des symboles associés au groupe
        this.add(new JLabel("Symbole :"));
        symbole = new JList();
        this.add(symbole);
        
        
        // Valider les modifications
        valider = new JButton("Valider");
        this.add(valider);
    
        // Annuler les modifications
        annuler = new JButton("Annuler");
        this.add(annuler);
    }        
                         

    
    /**
     * Affecte les valeurs des attributs d'un groupe aux widgets de l'IHM
     * @param groupe groupe de contacts
     */    
    public void displayGroupe(Groupe groupe) {
        if (groupe != null) { 
            // TP2 - 4.2
            
            for(Contact c : groupe.getContacts()){  
                String [] valeur = {c.getNom(), c.getPrenom(), c.getDateNaissance()};
                
                for(int i=0; i<valeur.length; i++){
                   model.addRow(valeur);
                }
            }          
        }
    }
    
    /**
     * Retourne les valeurs associées au formulaire de fiche groupe de contacts
     * @param groupe
    */    
    public void majGroupeDepuisIhm(Groupe groupe) {
        if (groupe != null) { 
            // A compléter en TP2
        }
    }
       
}
