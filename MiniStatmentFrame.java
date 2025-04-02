import java.awt.*;
import javax.swing.*;
import java.util.List;
class MiniStatementFrame extends JFrame {

    JTextArea textArea;
    JScrollPane scrollPane;

    MiniStatementFrame(List<String> transactions) {
        super("Mini Statement");

        textArea = new JTextArea();
        textArea.setEditable(false);

        if (transactions.isEmpty()) {
            textArea.setText("No transactions done.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String transaction : transactions) {
                sb.append(transaction).append("\n");
            }
            textArea.setText(sb.toString());
        }

        scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
