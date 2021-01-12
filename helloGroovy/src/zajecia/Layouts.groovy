package zajecia

import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JPanel
import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.Color
import java.awt.Container
import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Layouts extends JFrame implements ActionListener{

    CardLayout card
    JFrame frame
    BorderLayout borderLayout
    Container container

    static String askForInput(String purpose, String initial)
    {
        return JOptionPane.showInputDialog(null, purpose, initial)
    }

    Layouts()
    {
        final int CNUM = 5
        def isBorder = false
        frame = new JFrame("Layouts show")
        container = new Container()
        borderLayout = new BorderLayout()
        def response = askForInput("What is your preferred Layout?", "Flow")
        if (response.toLowerCase() == "flow")
            container.setLayout(new FlowLayout())
        else if (response.toLowerCase() == "box x")
            container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS))
        else if (response.toLowerCase() == "box y")
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS))
        else if (response.toLowerCase() == "grid")
            container.setLayout(new GridLayout(2, 3))
        else if (response.toLowerCase() == "card")
        {
//            container = getContentPane()
            card = new CardLayout(40,30)
            container.setLayout(card)
        }
        else
        {
            isBorder = true
            container.setLayout(borderLayout)
        }

        container.setBackground(Color.BLUE)
        for (def j = 0 ; j < CNUM ; j++)
        {
            def b = new JButton("Przycisk " + (j + 1))
            b.addActionListener(this)
            container.add(b)
            if(isBorder)
            {
                switch (j+1)
                {
                    case 1:
                        borderLayout.addLayoutComponent(b, BorderLayout.EAST)
                        break
                    case 2:
                        borderLayout.addLayoutComponent(b, BorderLayout.WEST)
                        break
                    case 3:
                        borderLayout.addLayoutComponent(b, BorderLayout.NORTH)
                        break
                    case 4:
                        borderLayout.addLayoutComponent(b, BorderLayout.SOUTH)
                        break
                    case 5:
                        borderLayout.addLayoutComponent(b, BorderLayout.CENTER)
                        break
                    default:
                        break
                }
            }
        }
        frame.add(container)
        frame.setSize(400,400)
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
        frame.pack()
        frame.setVisible(true)
    }

    @Override
    void actionPerformed(ActionEvent e) {
        card.next(container)
    }
}
