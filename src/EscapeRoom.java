import com.oracle.deploy.update.UpdateCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeRoom {

    public static void main(String[] args) {
        new EscapeRoomGUI();

    }

        public static class EscapeRoomGUI {
            JFrame frame;
            JPanel panel;
            static JButton Begin = new JButton("Begin");
            static JButton MoveToKitchen = new JButton("Open Door 1");
            static JButton MoveToDiningRoom = new JButton("Open Door 2");
            static JButton OpenFridge = new JButton("Open Fridge");
            static JButton GrabCake = new JButton("Grab Cake");
            static JButton SitAtTable = new JButton("Sit at Table");
            static JButton EatCake = new JButton("Eat Cake");
            static JButton Restart = new JButton("Restart");
            static JButton InspectOven = new JButton("Inspect Oven");
            static JButton TurnOnLight = new JButton("Flip Switch");
            static JButton ReadMenu = new JButton("Read Menu");
            static int location;
            static boolean HasDepressionCake = false;
            static boolean Light = false;
            static JTextArea Text = new JTextArea("Welcome! Click Begin to start");


            public EscapeRoomGUI() {
                frame = new JFrame("Escape Room");
                JPanel panel = new Drawing();
                frame.setSize(400, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);


                //add panel stuff
                panel.add(Text);
                Text.setBounds(100,20,200,170);
                Text.setWrapStyleWord(true);
                Text.setEditable(false);
                Text.setLineWrap(true);
                panel.add(Begin);
                Begin.setBounds(125,220,150,25);
                Begin.setVisible(true);
                panel.add(MoveToKitchen);
                MoveToKitchen.setBounds(25,220,150,25);
                MoveToKitchen.setVisible(false);
                panel.add(MoveToDiningRoom);
                MoveToDiningRoom.setBounds(225,220,150,25);
                MoveToDiningRoom.setVisible(false);
                panel.add(OpenFridge);
                OpenFridge.setBounds(25,280,150,25);
                OpenFridge.setVisible(false);
                panel.add(GrabCake);
                GrabCake.setBounds(25,280,150,25);
                GrabCake.setVisible(false);
                panel.add(SitAtTable);
                SitAtTable.setBounds(225,280,150,25);
                SitAtTable.setVisible(false);
                panel.add(EatCake);
                EatCake.setBounds(225,280,150,25);
                EatCake.setVisible(false);
                panel.add(Restart);
                Restart.setBounds(125,220,150,25);
                Restart.setVisible(false);
                panel.add(ReadMenu);
                ReadMenu.setBounds(25,280,150,25);
                ReadMenu.setVisible(false);
                panel.add(TurnOnLight);
                TurnOnLight.setBounds(25,280,150,25);
                TurnOnLight.setVisible(false);
                panel.add(InspectOven);
                InspectOven.setBounds(225,280,150,25);
                InspectOven.setVisible(false);

                Begin.addActionListener(new BeginListener());
                MoveToKitchen.addActionListener(new MoveToKitchenListener());
                MoveToDiningRoom.addActionListener(new MoveToDiningRoomListener());
                OpenFridge.addActionListener(new OpenFridgeListener());
                GrabCake.addActionListener(new GrabCakeListener());
                SitAtTable.addActionListener(new SitAtTableListener());
                EatCake.addActionListener(new EatCakeListener());
                Restart.addActionListener(new RestartListener());
                InspectOven.addActionListener(new InspectOvenListener());
                TurnOnLight.addActionListener(new TurnOnLightListener());
                ReadMenu.addActionListener(new ReadMenuListener());

                frame.add(panel);
                panel.setLayout(null);
                frame.setVisible(true);

            }

            class Drawing extends JPanel {
                public Drawing() {
                    setBackground(Color.lightGray);
                }
            }

            public class BeginListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You wake up in a hallway with nothing to see but two doors. You have no idea how you got here, but you know one thing for certain, you must ESCAPE!");
                    Begin.setVisible(false);
                    MoveToKitchen.setVisible(true);
                    MoveToDiningRoom.setVisible(true);

                }
            }

            public class MoveToKitchenListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Light == true) {
                        Text.setText("Now that the light's on you are greeted with the familiar sights of a sink, a dishwasher, an oven, and a fridge. This must be the Kitchen!");
                        location = 1;
                        MoveToKitchen.setVisible(false);
                        MoveToDiningRoom.setVisible(true);
                        OpenFridge.setVisible(true);
                        TurnOnLight.setVisible(false);
                        ReadMenu.setVisible(false);
                        InspectOven.setVisible(true);
                    }
                    if (Light == false) {
                        Text.setText("You walk through Door 1. However, you can't see anything, it's too dark.");
                        TurnOnLight.setVisible(true);
                        ReadMenu.setVisible(false);
                    }
                }
            }

            public class MoveToDiningRoomListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You walk through Door 2. You are greeted with the familiar sights of multiple tables set with table cloths, rolled silverware, and empty glasses. this must be the Dining Room!");
                    location = 2;
                    MoveToDiningRoom.setVisible(false);
                    MoveToKitchen.setVisible(true);
                    OpenFridge.setVisible(false);
                    InspectOven.setVisible(false);
                    ReadMenu.setVisible(true);
                    if (HasDepressionCake == true) {
                        SitAtTable.setVisible(true);
                    }
                }
            }

            public class OpenFridgeListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You approach the fridge and open the door. Inside you see various food and drink items. But something catches your eye. A box containing some sort of chocolate cake. Curious.");
                    GrabCake.setVisible(true);
                    OpenFridge.setVisible(false);

                }
            }

            public class GrabCakeListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You pick up this interesting box of cake. It seems simple, yet you can feel that this cake has some greater meaning.");
                    HasDepressionCake = true;
                    GrabCake.setVisible(false);

                }
            }

            public class SitAtTableListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You sit down at the table and unroll the silverware. You wonder what you should do next?");
                    SitAtTable.setVisible(false);
                    if (HasDepressionCake == true) {
                        EatCake.setVisible(true);
                    }
                }
            }
            public class EatCakeListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You feel something deep within you changing. Your feelings of stress, anxiety, and depression are all going away! It seems this depression cake has gotten rid of all of this mental pain. And because of this, you now have escaped this dream and have achieved true inner peace. Congratulations! You have Won!");
                    EatCake.setVisible(false);
                    MoveToDiningRoom.setVisible(false);
                    MoveToKitchen.setVisible(false);
                    Restart.setVisible(true);
                }
            }
            public class RestartListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You wake up in a hallway with nothing to see but two doors. You have no idea how you got here, but you know one thing for certain, you must ESCAPE!");
                    Restart.setVisible(false);
                    Begin.setVisible(true);
                }
            }

            public class InspectOvenListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You walk over and inspect the oven, even turn it on and off a couple of times. Nothing out of the ordinary seems to happen, but something weird is definitely going on.");
                    InspectOven.setVisible(false);

                }
            }
            public class TurnOnLightListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Light == true){
                        Light = false;
                    }
                    if (Light == false){
                        Light = true;
                    }
                    Text.setText("Now that the light's on you are greeted with the familiar sights of a sink, a dishwasher, an oven, and a fridge. This must be the Kitchen!");
                    location = 1;
                    MoveToKitchen.setVisible(false);
                    MoveToDiningRoom.setVisible(true);
                    OpenFridge.setVisible(true);
                    TurnOnLight.setVisible(false);
                    ReadMenu.setVisible(false);
                    InspectOven.setVisible(true);

                }
            }
            public class ReadMenuListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Text.setText("You open the menu and attempt to read it only to find out that there aren't any words on it. Is this laziness? A lack of creativity? A fourth wall break!? I should stop my head's starting to hurt");
                    ReadMenu.setVisible(false);


                }
            }

        }

    }


