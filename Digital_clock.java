
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Digital_clock extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel dayLabel;

    public Digital_clock() {
        setTitle("Digital Clock");
        setSize(500, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 20));
        panel.setLayout(new BorderLayout());


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.ORANGE);


        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(Color.WHITE);


        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dayLabel.setForeground(Color.GREEN);


        panel.add(timeLabel, BorderLayout.NORTH);
        panel.add(dateLabel, BorderLayout.CENTER);
        panel.add(dayLabel, BorderLayout.SOUTH);


        panel.setBackground(Color.BLACK);


        add(panel);


        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeDateDay();
            }
        });
        timer.start();
    }

    private void updateTimeDateDay() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss a");
        String time = timeFormatter.format(calendar.getTime());


        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM YYYY");
        String date = dateFormatter.format(calendar.getTime());


        SimpleDateFormat dayFormatter = new SimpleDateFormat("EEEE");
        String day = dayFormatter.format(calendar.getTime());


        timeLabel.setText(time);
        dateLabel.setText(date);
        dayLabel.setText(day);
    }


//    private String formatDate(String date) {
//        String[] parts = date.split(" ");
//        return parts[0] + "  " + parts[1] + "  " + parts[2];
//    }


    public static void main(String[] args) {
        Digital_clock clock = new Digital_clock();
        clock.setVisible(true);
    }
}
