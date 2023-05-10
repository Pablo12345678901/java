public class A_deux_threads_et_methodes_synchronized {
    public static void main(String[] args) {
        Nombres nb = new Nombres(0) ;
        ThrCalcul t1 = new ThrCalcul(nb) ;
        ThrAffiche t2 = new ThrAffiche(nb) ;
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

class Nombres {
    public Nombres(int nb) {
        this.nb = nb ;
    }
    public synchronized void calcul() {
        nb++ ;
        carre = nb * nb ;
    }
    public synchronized void affiche() {
        System.out.println("Le nombre " + nb + " mis au carré vaut : " + carre) ;
    }
    public int nb ;
    private int carre = 0 ;
}

class ThrCalcul extends Thread {
    public ThrCalcul(Nombres n) {
        this.nombre = n ;
    }
    public void run() {
        while (!interrupted())
        {   try
            {   nombre.calcul() ;
                if (nombre.nb==10)
                {   this.interrupt() ;
                    System.out.println("Test interrupted : = " + this.isInterrupted()) ;
                }
                ThrCalcul.sleep(100);
            }
            catch (InterruptedException e)
            {   System.out.println("Interruption du thread calcul") ;
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
                if (nombre.nb==10)
                {   this.interrupt() ;
                    System.out.println("Test interrupted : = " + this.isInterrupted()) ;
                }
                ThrAffiche.sleep(20);
            }
            catch (InterruptedException e)
            {   System.out.println("Interruption du thread affiche") ;
                ok_quit = true ;
                return ;
            }
        }
        
    }
    private Nombres nombre ;
    public boolean ok_quit = false ;  
}