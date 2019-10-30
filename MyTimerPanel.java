package project1;


import project1.GeoCountDownTimer;

import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MyTimerPanel extends JPanel {
    private GeoCountDownTimer geoCountDownTimer;
    private Timer javaTimer;
    private MyTimerPanel.TimerListener timer = new MyTimerPanel.TimerListener((MyTimerPanel.TimerListener)null);
    private JButton start;
    private JButton stop;
    private JButton reset;
    private JButton inc;
    private JButton dec;
    private JButton compare;
    private JLabel currentDate;
    private JLabel futureDate;
    private JLabel result;
    private JTextField curDate;
    private JTextField futDate;
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel bottomPanel;
    private GeoCountDownTimer current;
    private GeoCountDownTimer future;

    public MyTimerPanel() {
        this.javaTimer = new Timer(35, this.timer);
        this.start = new JButton("Start");
        this.start.setBackground(Color.green);
        this.stop = new JButton("Stop");
        this.stop.setBackground(Color.red);
        this.reset = new JButton("Reset");
        this.reset.setBackground(Color.blue);
        this.inc = new JButton("inc");
        this.inc.setBackground((Color.ORANGE));
        this.dec = new JButton("dec");
        this.dec.setBackground(Color.CYAN);
        this.curDate = new JTextField();
        this.futDate = new JTextField();
        this.start.addActionListener(new MyTimerPanel.TimerListener((MyTimerPanel.TimerListener)null));
        this.stop.addActionListener(new MyTimerPanel.TimerListener((MyTimerPanel.TimerListener)null));
        this.reset.addActionListener(new MyTimerPanel.TimerListener((MyTimerPanel.TimerListener)null));
        this.inc.addActionListener(new MyTimerPanel.TimerListener((MyTimerPanel.TimerListener)null));
        this.dec.addActionListener(new MyTimerPanel.TimerListener((MyTimerPanel.TimerListener)null));
        this.currentDate = new JLabel("Current Date         ");
        this.futureDate = new JLabel("   Future Date");
        this.result = new JLabel("RESULTS HERE");
        this.upperPanel = new JPanel();
        this.upperPanel.add(this.currentDate);
        this.upperPanel.add(this.futureDate);
        this.centerPanel = new JPanel();
        this.centerPanel.add(this.curDate);
        this.centerPanel.add(this.futDate);
        this.centerPanel.add(this.result);
        this.bottomPanel = new JPanel();
        this.bottomPanel.add(this.inc);
        this.bottomPanel.add(this.start);
        this.bottomPanel.add(this.stop);
        this.bottomPanel.add(this.reset);
        this.bottomPanel.add(this.dec);
        this.curDate.setPreferredSize(new Dimension(100, 25));
        this.futDate.setPreferredSize(new Dimension(100, 25));
        this.setLayout(new BorderLayout());
        this.add(this.upperPanel, "North");
        this.add(this.centerPanel, "Center");
        this.add(this.bottomPanel, "South");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyTimerPanel");
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(new MyTimerPanel());
        frame.setSize(350, 250);
        frame.setVisible(true);
    }

    private class TimerListener implements ActionListener {
        private TimerListener(TimerListener timerListener) {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == MyTimerPanel.this.start) {
                MyTimerPanel.this.javaTimer.stop();
                String myDate = MyTimerPanel.this.curDate.getText().trim();
                String fromDate = MyTimerPanel.this.futDate.getText().trim();
                MyTimerPanel.this.current = new GeoCountDownTimer(myDate);
                MyTimerPanel.this.future = new GeoCountDownTimer(fromDate);
                MyTimerPanel.this.javaTimer.start();
                MyTimerPanel.this.result.setText("Time Elapsed" + MyTimerPanel.this.current.daysToGo(MyTimerPanel.this.futDate.getText()));
            }

            if (MyTimerPanel.this.javaTimer.isRunning()) {
                MyTimerPanel.this.result.setText(current.toString());
                MyTimerPanel.this.current.dec();
                if(MyTimerPanel.this.current == MyTimerPanel.this.future){
                    MyTimerPanel.this.javaTimer.stop();
                }
            }

            if (e.getSource() == MyTimerPanel.this.stop) {
                MyTimerPanel.this.javaTimer.stop();
            }

            if (e.getSource() == MyTimerPanel.this.reset) {
                MyTimerPanel.this.javaTimer.stop();
                MyTimerPanel.this.futDate.setText("");
                MyTimerPanel.this.curDate.setText("");
                MyTimerPanel.this.result.setText("");
            }
            if(e.getSource() == MyTimerPanel.this.inc){
                geoCountDownTimer.inc();
            }
            if(e.getSource() == MyTimerPanel.this.dec){
                geoCountDownTimer.dec();
            }

        }
    }
}
