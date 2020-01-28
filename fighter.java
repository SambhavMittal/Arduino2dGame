/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author manan
 */
public class fighter extends javax.swing.JFrame implements SerialPortEventListener {
SerialPort serialPort;
String inputVal;
int hp2=100;
int hp1=100;
int inputValue;


    /**
     * Creates new form fighter
     */
    public fighter() {
        initComponents();
    }
    
    
    
        /** The port we're normally going to use. */
    private static final String PORT_NAMES[] = {
            "COM23", // Windows
    };
   
    /**
    * A BufferedReader which will be fed by a InputStreamReader
    * converting the bytes into characters
    * making the displayed results codepage independent
    */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;
 
    public void initialize() {
                // the next line is for Raspberry Pi and
                // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
       
               CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
 
        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }
 
        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);
 
            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
 
            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();
 
            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
 
    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }
 
    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                inputValue= Integer.parseInt(inputLine);
                System.out.println(inputLine);
                
                Timer t= new Timer();
                if(a.isVisible()) {
                    if(inputValue<50) {
                    a.setVisible(false);
                    apunch.setVisible(true);


                    TimerTask t1= new TimerTask(){
                        public void run(){
                            apunch.setVisible(false);
                            a.setVisible(true);
                            }
                        };
        
        
                            t.schedule(t1, 300);
                            hp2=hp2-10;
                    }

                    hp2val.setValue(hp2);
                }
                
            }
            catch (Exception e) {
            System.err.println(e.toString());
            }
            try {
                String inputLine=input.readLine();
                inputValue= Integer.parseInt(inputLine);
                System.out.println(inputLine);
                
                Timer t= new Timer();
                if(buprpunch.isVisible()) {
                    if(inputValue<50) {
                    buprpunch.setVisible(false);
                    bpunch.setVisible(true);


                    TimerTask t5= new TimerTask(){
                        public void run(){
                           bpunch.setVisible(false);
                           buprpunch.setVisible(true);
                            }
                        };
        
        
                            t.schedule(t5, 300);
                            hp1=hp1-10;
                    }

                    hp1val.setValue(hp1);
                }
                
            }
        catch (Exception e) {
            System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JLabel();
        hp2val = new javax.swing.JProgressBar();
        aPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        hp1val = new javax.swing.JProgressBar();
        buprpunch = new javax.swing.JLabel();
        bpunch = new javax.swing.JLabel();
        ahpunch = new javax.swing.JLabel();
        akick = new javax.swing.JLabel();
        ablock = new javax.swing.JLabel();
        apunch = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        bkick = new javax.swing.JLabel();
        b = new javax.swing.JLabel();

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("fighter");
        setSize(new java.awt.Dimension(600, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        hp2val.setValue(100);
        getContentPane().add(hp2val);
        hp2val.setBounds(400, 50, 200, 14);

        aPanel.setOpaque(false);
        getContentPane().add(aPanel);
        aPanel.setBounds(380, 90, 100, 110);

        jLabel3.setText("Player 2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 20, 39, 14);

        jButton1.setText("start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 270, 90, 23);

        jLabel4.setText(" Player 1");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 20, 42, 14);

        hp1val.setValue(100);
        getContentPane().add(hp1val);
        hp1val.setBounds(40, 50, 200, 14);

        buprpunch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-b-block.gif"))); // NOI18N
        getContentPane().add(buprpunch);
        buprpunch.setBounds(470, 160, 90, 110);

        bpunch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-b-punch.gif"))); // NOI18N
        bpunch.setText(" ");
        getContentPane().add(bpunch);
        bpunch.setBounds(390, 180, 90, 100);

        ahpunch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-high-punch.gif"))); // NOI18N
        ahpunch.setOpaque(true);
        ahpunch.setVisible(false);
        getContentPane().add(ahpunch);
        ahpunch.setBounds(70, 100, 100, 100);

        akick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-kick.gif"))); // NOI18N
        akick.setVisible(false);
        getContentPane().add(akick);
        akick.setBounds(180, 80, 100, 100);

        ablock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-block.gif"))); // NOI18N
        ablock.setVisible(false);
        getContentPane().add(ablock);
        ablock.setBounds(130, 220, 100, 100);

        apunch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-punch.gif"))); // NOI18N
        apunch.setVisible(false);
        getContentPane().add(apunch);
        apunch.setBounds(210, 260, 100, 100);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-b-hpunch.gif"))); // NOI18N
        jLabel5.setText(" ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 180, 90, 100);

        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-a.gif"))); // NOI18N
        getContentPane().add(a);
        a.setBounds(230, 170, 100, 100);

        bkick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-b-kick.gif"))); // NOI18N
        bkick.setText(" ");
        getContentPane().add(bkick);
        bkick.setBounds(400, 180, 107, 100);

        b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arduino/playa-b.gif"))); // NOI18N
        b.setText(" ");
        b.setOpaque(true);
        b.setRequestFocusEnabled(false);
        getContentPane().add(b);
        b.setBounds(390, 180, 107, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
         
        
        int key= evt.getKeyCode();
        System.out.println(key);
        Timer t= new Timer();
        if(a.isVisible())
        {
          if(key==68)
            {
               a.setVisible(false);
               apunch.setVisible(true);
                
               TimerTask t1= new TimerTask()
              {
              public void run()
              {
             apunch.setVisible(false);
              a.setVisible(true);
              }
             };
               t.schedule(t1, 100);
             hp2=hp2-10;
           }
        
        else if(key==87)
        {
          a.setVisible(false);
           ahpunch.setVisible(true);
              
        TimerTask t1= new TimerTask(){
        public void run(){
        ahpunch.setVisible(false);
            a.setVisible(true);}
            };
        t.schedule(t1, 400);
        hp2=hp2-20;
        }
        else if(key==83)
        {
        a.setVisible(false);
        akick.setVisible(true);
        
        
        TimerTask t1= new TimerTask(){
        public void run(){
        akick.setVisible(false);
            a.setVisible(true);}
            };
        t.schedule(t1, 200);
        hp2=hp2-15;
        }
        else if(key==65)
        {
        a.setVisible(false);
        ablock.setVisible(true);    
        }
        
        
        hp2val.setValue(hp2);
        if(hp2<=0)
        { this.setVisible(false);
        new exit_match().setVisible(true);
        
        }
        }
        
    }//GEN-LAST:event_jButton1KeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          
        // TODO add your handling code here:
        
        
  
          Timer Task2= new Timer();
          
          TimerTask t3 = new TimerTask()
          { public void run()
          {
               Random x = new Random();
         int key1 = x.nextInt(4);
            System.out.println(key1);
              if(b.isVisible())
              {
                  switch (key1) {
                      case 0:
                      {
                          b.setVisible(false);
                          bpunch.setVisible(true);
                          TimerTask t2= new TimerTask()
                          {
                              public void run()
                              {
                                  bpunch.setVisible(false);
                                  b.setVisible(true);
                              }
                          };  Task2.schedule(t2, 200);
                          
                          break;
                      }
                      case 1:
                      {
                          b.setVisible(false);
                          bpunch.setVisible(true);
                          TimerTask t2= new TimerTask(){
                              public void run(){
                                  ahpunch.setVisible(false);
                                  a.setVisible(true);}
                          };          Task2.schedule(t2, 400);
                          hp1=hp1-20;
                          break;
                      }
                      case 2:
                          b.setVisible(false);
                          bkick.setVisible(true);
                          TimerTask t2= new TimerTask(){
                              public void run(){
                                  bkick.setVisible(false);
                                  b.setVisible(true);}
                          };        Task2.schedule(t2, 200);
                          hp1=hp1-15;
                          break;
                      case 3:
                          b.setVisible(false);
                          buprpunch.setVisible(true);
                          break;
                      default:
                          break;
                  }
                  
                  
                  hp1val.setValue(hp1);
               
               
              }
          if(hp1<=0)
               /*   {
                   this.setVisible(false);
                  }
                  new exit_match().setVisible(true);
          */
          }
          
          };   Task2.scheduleAtFixedRate(t3, 1222, 1222);
           

    }//GEN-LAST:event_formWindowOpened

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        // TODO add your handling code here:
         int key= evt.getKeyCode();
        if(key==65){        
        ablock.setVisible(false);
            a.setVisible(true);
         }
    }//GEN-LAST:event_jButton1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
       
        this.initialize();
        
        Thread t=new Thread() {
            public void run() {
                //the following line will keep this app alive for 10 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {Thread.sleep(10000);
                }
                catch (InterruptedException ie) {}
            }
        };
        t.start();
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fighter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fighter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fighter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fighter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fighter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JPanel aPanel;
    private javax.swing.JLabel ablock;
    private javax.swing.JLabel ahpunch;
    private javax.swing.JLabel akick;
    private javax.swing.JLabel apunch;
    private javax.swing.JLabel b;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bkick;
    private javax.swing.JLabel bpunch;
    private javax.swing.JLabel buprpunch;
    private javax.swing.JProgressBar hp1val;
    private javax.swing.JProgressBar hp2val;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
