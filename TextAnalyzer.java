import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 class TextAnalyzer extends JFrame implements ActionListener
{
    //gui components
    private JTextArea text;
    private JButton button;
    private JLabel wordLabel,vowelLabel,consLabel;
    
    public TextAnalyzer()
    {
     setTitle("Application to analyze the entered text");
     setSize(600,400);
     setLayout(new BorderLayout());
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     // text area for input
     text = new JTextArea();
     JScrollPane scrollPane = new JScrollPane(text);
     add(scrollPane, BorderLayout.CENTER);

     //button
     button = new JButton("Analyze Text");
     button.addActionListener(this);

     JPanel p1 = new JPanel();
     p1.add(button);
     add(p1,BorderLayout.SOUTH);

     //result panel
     JPanel result = new JPanel(new GridLayout(3,1));
     wordLabel = new JLabel("words: 0");
     vowelLabel = new JLabel("vowels: 0");
     consLabel = new JLabel("consonants: 0");

     result.add(wordLabel);
     result.add(vowelLabel);
     result.add(consLabel);
     add(result,BorderLayout.NORTH);

     setVisible(true);
     

    }
    public void actionPerformed(ActionEvent e)
    {
        String t = text.getText();
        int words = countWords(t);
        int vowels = countVowels(t);
        int consonants= countConsonants(t);

        //update labels
        wordLabel.setText("words: "+words);
        vowelLabel.setText("vowels: "+vowels);
        consLabel.setText("consonants: "+consonants);

    }

    //count words
    private int countWords(String t)
    {
        if(t==null || t.trim().isEmpty())
        {
            return 0;
        }
        String[] w = t.trim().split("\\s+");
        return w.length;
    }

    private int countVowels(String t)
    {
        int count = 0;
        for ( char c: t.toCharArray()){
            c = Character.toLowerCase(c);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            {
                count++;

            }
        }
        return count;
    }
    private int countConsonants(String t)
    {
            int count=0;
            for(char c: t.toCharArray())
            {
                c = Character.toLowerCase(c);
                if(c>='a' && c<='z'&& c!='a' && c!='e'&&c!='i'&&c!='o'&&c!='u')
                {
                    count++;
                }
            }
            return count;
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new TextAnalyzer());
    }
}