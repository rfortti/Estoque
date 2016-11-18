    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

/**
 *
 * @author Strong
 */
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class AceitaNumeros extends PlainDocument
{
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException
    {
        super.insertString(offset, str.toUpperCase().replaceAll("[^0-9]", ""), attr); //aceita somente números e ponto
    }
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException
    {
        super.insertString(offset, str.toUpperCase().replaceAll("[^0-9]", ""), attr);
    }
}