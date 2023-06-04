import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

public class D_boite_de_saisie {
    public static void main(String[] args) {
        int nb_secondes_att = 10 ;
        ThrBlocage attente = new ThrBlocage(nb_secondes_att*1000) ;
        attente.start() ;
    }
}

class ThrBlocage extends Thread {
    public ThrBlocage(int nb_ms_arret) {
        this.nb_ms_arret = nb_ms_arret ;
    }
    public void run() {
        final int NB_ESSAI_INITIAL = 3 ;
        int nb_essai = NB_ESSAI_INITIAL ;
        String essai_accord = " essais" ;
        String mot_de_passe = "1234" ;
        while (true)
        {   String code = JOptionPane.showInputDialog(null, "Quel est votre mot de passe ?", "SECURITÉ", JOptionPane.QUESTION_MESSAGE) ;
            //DEBUG System.out.println("Code saisi : " + code) ;
            if (code == null)
            {   JOptionPane.showMessageDialog(null, "Vous avez choisi de quitter", "Départ", JOptionPane.INFORMATION_MESSAGE);
                break ;
            }
            else if (code.length() == 0 ) JOptionPane.showMessageDialog(null, "ERREUR : vous avez saisi un mot de passe vide. Réessayez...", "ERREUR", JOptionPane.ERROR_MESSAGE);
            else if (code.equals(mot_de_passe))
            {   JOptionPane.showMessageDialog(null, "Merci.", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                break ;
            }
            else if (!(code.equals(mot_de_passe)))
            {   nb_essai-- ;
                if (nb_essai <= 1) essai_accord = " essai" ;
                JOptionPane.showMessageDialog(null, "Faux, mot de passe incorrect. Il vous reste " + nb_essai + essai_accord + ".", "Incorrect", JOptionPane.WARNING_MESSAGE);
                if (nb_essai == 0)
                {   JOptionPane.showMessageDialog(null, "Trop de tentatives incorrectes. Réessayez dans " + (nb_ms_arret/1000)  +" secondes.", "Blocage de sécurité", JOptionPane.WARNING_MESSAGE);
                    try
                    {   sleep(nb_ms_arret) ;
                        throw new InterruptedException() ;
                    }
                    catch (InterruptedException e)
                    {   //DEBUG System.out.println("Interruption du thread ThrBlocage") ;
                        nb_essai = NB_ESSAI_INITIAL ;
                        continue ;
                    }    
                }
            }
            else JOptionPane.showMessageDialog(null, "ERREUR : action inconnue.", "ERREUR", JOptionPane.ERROR_MESSAGE);
        } 
    }
    private int nb_ms_arret ; 
}
