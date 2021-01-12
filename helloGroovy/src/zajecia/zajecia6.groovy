package zajecia

import groovy.io.FileType
import groovy.swing.impl.TableLayout

import javax.swing.BoxLayout
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.SpringLayout
import javax.swing.WindowConstants
import java.awt.BorderLayout
import javax.swing.BorderFactory
import java.awt.CardLayout
import java.awt.Color
import java.awt.Container
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import java.awt.Frame
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.GridLayout
import groovy.swing.SwingBuilder

import java.awt.LayoutManager
import java.awt.TextArea
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class zajecia6 extends JFrame{

    static void zadanie1() {
        def fontName = askForInput("Which font do you need?", "Times New Roman")
        def fontSize = askForInput("Which size of font do you need?", "40")
        def fontColor = askForInput("Which font color do you need?", "Blue")
        def bgColor = askForInput("Which background color do you need?", "White")

        def f = new JFrame("Prosty edytor")
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

//        def b = new JButton("submit")

        def ta = new JTextArea(10, 10)
        ta.setLineWrap(true)
        Font font = new Font(fontName, Font.BOLD, fontSize as int)
        ta.setFont(font)
        ta.setForeground(checkColor(fontColor))
        ta.setBackground(checkColor(bgColor))
        JScrollPane scrollPane = new JScrollPane(ta)

//        def p = new JPanel()
//        p.add(scrollPane)

        f.add(scrollPane)
        f.setSize(300, 400)
        f.setVisible(true)
    }

    static void zadanie2()
    {
        def f = new JFrame("Prosty przycisk")
        def colors = [Color.GREEN,Color.WHITE,Color.BLUE,Color.BLACK,Color.YELLOW,Color.ORANGE]
        def colorNo = 0
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        def b = new JButton("SwapColor")
        b.setForeground(Color.CYAN)
        b.addActionListener(new ActionListener()
        {
            @Override
            void actionPerformed(ActionEvent e)
            {
                if(colorNo >= colors.size())
                    colorNo=0
                b.setBackground(colors.get(colorNo))
                colorNo++
            }
        })
        f.add(b)
        f.setSize(100, 100)
        f.setVisible(true)
    }

    static String askForInput(String purpose, String initial)
    {
        return JOptionPane.showInputDialog(null, purpose, initial)
    }

    static Color checkColor(String colorName)
    {
        if(colorName.toLowerCase() == "yellow")
            return Color.YELLOW
        if(colorName.toLowerCase() == "blue")
            return Color.BLUE
        if(colorName.toLowerCase() == "red")
            return Color.RED
        if(colorName.toLowerCase() == "green")
            return Color.GREEN
        if(colorName.toLowerCase() == "white")
            return Color.WHITE
        else
            return Color.BLACK
    }

    static void zadanie3()
    {
        new Layouts()
    }

    static void zadanie4()
    {
        new Przegladarka()
    }

}