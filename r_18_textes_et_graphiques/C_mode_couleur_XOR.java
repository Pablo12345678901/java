import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

public class C_mode_couleur_XOR {
    public static void main (String args[])
    {   MaFenetreC fen = new MaFenetreC() ;
        fen.setVisible(true) ;
    }
}

class MaFenetreC extends JFrame implements ActionListener
{   MaFenetreC ()
    {   setTitle ("Dessin formes avec XOR") ;
        setSize (350, 250) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;

        Container contenu = getContentPane() ;

        pan = new Paneau() ;
        contenu.add(pan) ;

        rouge = new JButton("Rouge") ;
        rouge.addActionListener(this) ;
        contenu.add(rouge, "North") ;

        bleu = new JButton("Bleu") ;
        bleu.addActionListener(this) ;
        contenu.add(bleu, "South") ;
    }

    public void actionPerformed(ActionEvent e)
    {   if      (e.getSource() == rouge) pan.setBackground(Color.red);
        else if (e.getSource() ==  bleu) pan.setBackground(Color.cyan);
    }
    private JPanel pan ;
    private JButton rouge, bleu ;
}

class Paneau extends JPanel
{   public void paintComponent(Graphics g)
    {   super.paintComponent(g) ;
        g.setXORMode(getBackground());

        g.setColor(Color.orange) ;
        g.fillRect(10, 30, 150, 100);
        g.setColor(Color.black) ;
        g.drawRect(10, 30, 150, 100);
        g.setColor(Color.orange) ;
        g.fillOval(30, 10, 100, 150);
        g.setColor(Color.black) ;
        g.drawOval(30, 10, 100, 150);
        g.setColor(Color.yellow);
        g.fillRect(170, 30, 150, 100);
        g.setColor(Color.black) ;
        g.drawRect(170, 30, 150, 100);
        g.setColor(Color.green);
        g.fillOval(190, 10, 100, 150);
        g.setColor(Color.black) ;
        g.drawOval(190, 10, 100, 150);
    }
}


