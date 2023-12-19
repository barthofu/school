package utilitaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
/**
 * @author Christine Bonnet
 * @param <V>
 */
public class Conteneur<V extends java.io.Serializable> {
    /**
     * référence de type List<V> du conteneur
    */
    private List<V> lesValeurs;
    /**
     * position dans l'ArrayList<V>
     */
    private int indiceCourant;
    /** 
     * @param m référence de type List<V> du conteneur
     */
    public Conteneur(List<V> m) {
        if (m == null) {
            lesValeurs = null;
            indiceCourant = -1;
        } else {
            lesValeurs = m;
            indiceCourant = 0;
        }
    }
    public Conteneur() {
        lesValeurs = null;
        indiceCourant = -1;
    }
    /**
     * dé-sérialisation - le type V doit être Serialisable
     * @param nomFic
     * @throws java.lang.Exception
     */
    public void charger(String nomFic) throws Exception {
        File f1 = new File(nomFic); 
        FileInputStream fe = new FileInputStream(f1);
        try (ObjectInputStream feObj = new ObjectInputStream(fe)) {
            lesValeurs = (List<V>) feObj.readObject();
        }
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            indiceCourant = 0;
        }
    }
    
    
    /**
     * positionnement sur le dernier élément du conteneur
     */
    public void dernier() {
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            indiceCourant = lesValeurs.size() - 1;
        }
    }
    /**
     * indique si le conteneur est vide
     * @return  un booléen
    */
    public boolean estVide() {
        return lesValeurs==null ? true :lesValeurs.isEmpty();
    }
    /** 
     * @return le nombre d'objets présents dans le conteneur 
     */
    public int nbElements() {
        return lesValeurs==null ? 0 : lesValeurs.size();
    }
    /**
     * @return l'objet à la position courante dans le conteneur ou bien null
     */
    public V obtenir() {
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            return lesValeurs.get(indiceCourant);
        }
        return null;
    }
    /**
     * positionnement sur l'élément précédent
     */
    public void precedent() {
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            if (indiceCourant > 0) {
                indiceCourant--;
            }
        }
    }
    /**
     * positionnement sur le premier élément du conteneur
     */
    public void premier() {
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            indiceCourant = 0;
        }
    }
    /**
     * sérialisation dans un fichier
     * @param nomFic
     * @throws Exception
     */
    
    
    public void sauvegarder(String nomFic) throws Exception {
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            File f1 = new File(nomFic); //Déclaration du fichier
            FileOutputStream fs = new FileOutputStream(f1);
            try (ObjectOutputStream fsObj = new ObjectOutputStream(fs)) {
                fsObj.writeObject(lesValeurs);
            }
            }
    }
    /**
     * positionnement sur l'élément suivant
     */
    public void suivant() {
        if (lesValeurs != null && !lesValeurs.isEmpty()) {
            if (indiceCourant < lesValeurs.size() - 1) {
                indiceCourant++;
            }
        }
    }
    /**
     * vide le contenu du conteneur
     */
    public void vider() {
        if (lesValeurs != null) {
            lesValeurs.clear();
            indiceCourant = -1;
        }       
    }
    // annotation pour supprimer les warnings
    //@SuppressWarnings("unchecked") 
} // class Conteneur

