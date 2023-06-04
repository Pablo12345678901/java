public class B_wait_et_notify {
    public static void main(String[] args) {
        System.out.println("Donnez un nombre à partir duquel vous souhaitez calculer les racines : ") ;
        int nb_int = Clavier.lireInt() ;
        System.out.println("Combien de racines voudriez-vous ? ") ;
        int nb_rac = Clavier.lireInt() ;
        Nombres nb_obj = new Nombres(nb_int, nb_rac) ;
        ThrCalcul t1 = new ThrCalcul(nb_obj) ;
        ThrAffiche t2 = new ThrAffiche(nb_obj) ;
        t1.start();
        t2.start();
        //while (!t1.ok_quit || !t2.ok_quit){ continue ;}
        //while (!t1.ok_quit || !t2.ok_quit){}
        // Toutes les boucles vides bugguent en provocant une sorte de boucle (thread) qui va tellement vite qu'elle fait bugguer et attend.
        // Je pense qu'il s'agit d'une sécurité de l'environnement contre les boucles infinies.
        while (!t1.ok_quit || !t2.ok_quit){System.out.print("");}
        System.out.println("Fin du programme.") ;
    }    
}

class Nombres extends Thread {
    public Nombres(int nb, int nb_rac) {
        this.nb = nb ;
        this.carre = nb * nb ;
        this.rac_max = nb + nb_rac ;
    }
    public synchronized void calcul() throws InterruptedException {
        carre = nb * nb ;
        notifyAll();
        if (nb==rac_max) throw new InterruptedException() ;
        else wait() ; // mise en pause du thread qui appelle l'objet et sa méthode calcul
    }
    public synchronized void affiche() throws InterruptedException {
        System.out.println("Le nombre " + nb + " mis au carré vaut : " + carre) ;
        nb++ ; // et augmente de 1 pour passer au tour suivant
        notifyAll() ; // redémarrage de tous les threads sur l'objet
        if (nb==rac_max) throw new InterruptedException() ;
        else wait() ; // mise en pause du thread qui appelle l'objet et sa méthode affiche
    }
    public int nb ;
    private int rac_max ;
    private int carre ;
}

class ThrCalcul extends Thread {
    public ThrCalcul(Nombres n) {
        this.nombre = n ;
    }
    public void run() {
        while (!interrupted())
        {   try
            {   nombre.calcul() ;
                ThrCalcul.sleep(100);
            }
            catch (InterruptedException e)
            {   //DEBUG System.out.println("Interruption du thread calcul") ;
                ok_quit = true ;
                return ;
            }
        }
    }
    private Nombres nombre ;
     public boolean ok_quit = false ;   
}

class ThrAffiche extends Thread {
    public ThrAffiche(Nombres n) {
        this.nombre = n ;
    }
    public void run() {
        while (!interrupted())
        {   try
            {   nombre.affiche() ;
                ThrAffiche.sleep(20);
            }
            catch (InterruptedException e)
            {   //DEBUG System.out.println("Interruption du thread affiche") ;
                ok_quit = true ;
                return ;
            }
        }
        
    }
    private Nombres nombre ;
    public boolean ok_quit = false ;  
}