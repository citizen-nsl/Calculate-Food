import groovy.swing.SwingBuilder
import javax.swing.JFrame
import javax.imageio.ImageIO
import java.awt.BorderLayout
import java.awt.GridLayout
import java.awt.Dimension
import java.awt.Color
import java.io.File

def swing = new SwingBuilder()

def frame = swing.frame(title: 'โปรแกรมคำณวน ราคาค่าอาหาร', size: [390, 180], show: true) {
    borderLayout()
    panel(constraints: BorderLayout.CENTER, background: Color.WHITE) {
        gridLayout(rows: 5, columns: 1)
        label(text: 'Enter the price of the food:')
        def priceField = textField(preferredSize: new Dimension(100, 30))
        label(text: 'Enter the number of people:')
        def peopleField = textField(preferredSize: new Dimension(100, 30))
        
        button(text: 'Calculate', background: Color.LIGHT_GRAY, foreground: Color.BLACK, preferredSize: new Dimension(100, 30), actionPerformed: {
            try {
                def price = priceField.text.toBigDecimal()
                def people = peopleField.text.toInteger()
                def total = price * people
                resultLabel.text = "Total price: $total"
            } catch (NumberFormatException e) {
                resultLabel.text = "Please enter valid numbers."
            }
        })
        
        resultLabel = label(text: '', preferredSize: new Dimension(100, 30))
    }
}

frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE