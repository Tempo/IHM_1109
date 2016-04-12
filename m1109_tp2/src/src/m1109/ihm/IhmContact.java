/*
 * Module 1109 : module IHM : Carnet d'adresse
 */
package m1109.ihm;

import m1109.nf.Contact;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import m1109.nf.Mois;
import m1109.nf.Region;
import java.util.HashMap;
import m1109.nf.DispoSortie;
import m1109.nf.Hobby;

/**
 * @author IUT2
 */
public class IhmContact extends JPanel {

    private JTextField       champNom; // Widget de type champ texte pour afficher et saisir le nom du contact
    private JTextField       champPrenom;
    private JComboBox       champNaissJour;
    private JComboBox        champNaissMois;
    private JComboBox       champNaissAnnee;
    private JTextField      champEmail;
    private JComboBox        champRegion;
    private JTextField       champTelephone;
    private HashMap<Hobby, JCheckBox> HobbyM;
    private HashMap<DispoSortie, JRadioButton> DispoM;

    /*
     * Formulaire pour saisir les informations relatives à un contact
     */
    public IhmContact() {
        super();

        initUIComponents();
    }
    
    /**
     * Crée et positionne les composants graphiques constituant l'interface
     */
    private void initUIComponents() {      
        /** Pour l'exemple **/
        
        // Ajoute dans l'IHM un libellé + un champ pour la saisie/Affichage du nom
        this.add(new JLabel("Nom :"));
        champNom = new JTextField(30);
        this.add(champNom);
        
        /** TP 1 **/
        this.add(new JLabel("Prénom :"));
        champPrenom = new JTextField(30);
        this.add(champPrenom);
        
        this.add(new JLabel("Jour :"));
        champNaissJour = new JComboBox();
            for (int i=1; i<=31 ;i++)
            {
                champNaissJour.addItem(i);
            }
        this.add(champNaissJour);
                
        
        this.add(new JLabel("Mois :"));
        champNaissMois = new JComboBox(Mois.values());
        this.add(champNaissMois);
        
        this.add(new JLabel("Année :"));
        champNaissAnnee = new JComboBox();
            for (int i=1900; i<=2020 ;i++)
            {
                champNaissAnnee.addItem(i);
            }
        this.add(champNaissAnnee);
        
        this.add(new JLabel("Email :"));
        champEmail = new JTextField(30);
        this.add(champEmail);
        
        this.add(new JLabel("Région :"));
        champRegion = new JComboBox(Region.values());
        this.add(champRegion);
        
        this.add(new JLabel("Telephone :"));
        champTelephone = new JTextField(10);
        this.add(champTelephone);
        
        this.add(new JLabel("Disponibilité :"));
        DispoM = new HashMap();
        ButtonGroup rbGroup = new ButtonGroup();    
        
        for(DispoSortie d : DispoSortie.values()){
            JRadioButton champDispo = new JRadioButton(d.toString());
            DispoM.put(d, champDispo);
            rbGroup.add(champDispo);
            this.add(champDispo);
        }
        //champDispo = new JList(DispoSortie.values());
        
        this.add(new JLabel("Hobby :"));
        HobbyM = new HashMap();
        for (Hobby h : Hobby.values()){
            JCheckBox cb = new JCheckBox(h.toString());
            HobbyM.put(h, cb);
            this.add(cb);
        }
        /*for (Hobby h : Hobby.values()){
            JCheckBox cb = new JCheckBox(h.toString());
            this.add(cb);
        }*/
    }
    
    /**IhmContact 
     * Affecte des valeurs au formulaire de fiche contact
     * @param contact un contact pour mettre à jour à l'IHM
     * @return vrai si ok
     */
    public boolean displayContact(Contact contact) {
        if (contact == null) { return false; }
                
        // Nom du contact
        champNom.setText(contact.getNom());        

        /** TP 1 **/
        champPrenom.setText(contact.getPrenom());
        
        champNaissJour.setSelectedItem(contact.getDateNaissanceJour());
        champNaissMois.setSelectedItem(contact.getDateNaissanceMois());
        champNaissAnnee.setSelectedItem(contact.getDateNaissanceAnnee());
        
        champEmail.setText(contact.getEmail());
        
        champRegion.setSelectedItem(contact.getRegion());
        champTelephone.setText(contact.getNumeroTelephone());
        
        JRadioButton r = DispoM.get(contact.getDisponibilite());
        r.setSelected(true);
        
        for (Hobby h : contact.getHobbies()){
            JCheckBox c = HobbyM.get(h);
            c.setSelected(true);
        }

        return true;
    }
    
    /**
     * Relit les 
     * @param contact un contact à mettre à jour à partir de l'IHM
     * @return vrai si ok
     */
    public Boolean modifyContact(Contact contact) {
        if (contact == null) { return false; }

        // Affecte la valeur du champ nom à l'attribut nom du contact
        contact.setNom(champNom.getText()); 
        
        // TODO : TP1 - renseigner les autres attributs du contact à partir des champs de l'IHM
        contact.setPrenom(champPrenom.getText());   
        //contact.setDateNaissance();
        contact.setEmail(champEmail.getText());
        
        contact.setRegion((Region)champRegion.getSelectedItem());
        
        //contact.setDateNaissance((Integer)champNaissJour.getSelectedIndex(), (Mois)champNaissMois.get, (Integer)champNaissAnnee.);
        
        for (Hobby h : Hobby.values())
        {
            if(HobbyM.get(h).isSelected())
            {
                contact.addHobby(h);
            }
            else{
                contact.removeAllHobbies();
            }
        }
        
        for (DispoSortie d : DispoSortie.values())
        {
            if (DispoM.get(d).isSelected())
            {
                contact.setDisponibilite(d);
            }
        }
        
        return true;
    }
}