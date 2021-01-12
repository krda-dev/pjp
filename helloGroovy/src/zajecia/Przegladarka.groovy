package zajecia

import groovy.io.FileType

import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.Color
import java.awt.Container
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Przegladarka extends JFrame implements ActionListener {

    def counter = 0
    def fileList = []
    ImageIcon image
    JLabel imagelabel


    Przegladarka()
    {
        def dir = new File("helloGroovy/src/zdjecia")
        dir.eachFileRecurse (FileType.FILES) { file ->
            fileList.add(file)
        }
        def frame = new JFrame("Przegladarka obrazkow")
        def container = new Container()
        def borderLayout = new BorderLayout()
        def nextButton = new JButton("Next")
        image = new ImageIcon(fileList[counter] as String)
        imagelabel = new JLabel(image)
        container.setLayout(borderLayout)
        container.setBackground(Color.BLUE)
        nextButton.addActionListener(this)
        borderLayout.addLayoutComponent(imagelabel, BorderLayout.NORTH)
        borderLayout.addLayoutComponent(nextButton, BorderLayout.SOUTH)
        container.add(imagelabel)
        container.add(nextButton)
        frame.add(container)
        frame.setSize(400,400)
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
        frame.pack()
        frame.setVisible(true)
    }

    @Override
    void actionPerformed(ActionEvent e) {
        changePhoto(++counter)
    }

    void changePhoto(int number)
    {
        if(number > fileList.size()-1)
            counter = 0
        image.getImage().flush()
        image = new ImageIcon(fileList[counter] as String)
        imagelabel.setIcon(image)
    }
}