import javax.swing.*; // importer tous les fichiers des package débutant par javax.swing

public class A_base_fenetre {
    public static void main(String[] args) {
        System.out.println("Début main") ;
        JFrame fen = new JFrame() ;
        fen.setSize(300, 100); // height, width - car par défaut, taille nulle
        System.out.println("Avant fenêtre") ;
        fen.setVisible(true); // car par défaut, fenêtre invisible
        fen.setTitle("Titre de la fenêtre");
        System.out.println("Fin main") ;
    }
}
