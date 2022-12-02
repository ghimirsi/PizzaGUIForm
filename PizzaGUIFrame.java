import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class PizzaGUIFrame extends JFrame
{
    JFrame frame = new JFrame();
    JPanel mainPnl;
    JPanel midPnl;
    JPanel topPnl;
    JPanel crustPnl;
    JPanel botPnl;
    JPanel sizePnl;
    JPanel toppingsPnl;
    JPanel formPnl;
    JPanel receiptPnl;
    JLabel titleLbl;
    JLabel toppingsLbl;
    JButton orderButton;
    JButton clearButton;
    JButton quitButton;
    JLabel crustLabel;
    JRadioButton thinCrustBut;
    JRadioButton regularCrustBut;
    JRadioButton deepDishBut;

    JComboBox<String> sizeBox = new JComboBox<>();

    JTextArea receiptText;

    ButtonGroup crustGroups;
    JCheckBox pepperoniBox;
    JCheckBox pineappleBox;
    JCheckBox cheeseBox;
    JCheckBox cornBox;
    JCheckBox mushroomBox;
    JCheckBox sausageBox;


    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        createMiddlePanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);
        createBottomPanel();
        mainPnl.add(botPnl, BorderLayout.SOUTH);
        add(mainPnl);
        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel()
    {
        topPnl = new JPanel();
        titleLbl = new JLabel("PIZZA ORDER FORM",JLabel.CENTER);
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 28));
        topPnl.add(titleLbl);
    }

    private void createMiddlePanel()
    {
        midPnl = new JPanel();
        midPnl.setLayout(new BorderLayout());
        formPnl = new JPanel();
        formPnl.setLayout(new GridLayout(3,1));
        receiptPnl = new JPanel();
        crustPnl = new JPanel();
        sizePnl = new JPanel();
        sizePnl.setLayout(new BorderLayout());
        toppingsPnl = new JPanel();
        toppingsPnl.setLayout(new GridLayout(2,3));
        crustLabel = new JLabel("Crust:");
        crustLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        thinCrustBut = new JRadioButton("thin");
        regularCrustBut = new JRadioButton("regular");
        deepDishBut = new JRadioButton("deep ");
        crustGroups = new ButtonGroup();
        crustGroups.add(thinCrustBut);
        crustGroups.add(regularCrustBut);
        crustGroups.add(deepDishBut);

        String[] sizes = {"small", "medium", "large", "super"};
        sizeBox = new JComboBox<String>(sizes);
        sizeBox.setSelectedIndex(0);

        toppingsLbl = new JLabel("Toppings:");
        toppingsLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
        pepperoniBox = new JCheckBox("Pepperoni");
        cheeseBox = new JCheckBox("Cheese");
        pineappleBox= new JCheckBox("Pineapple");
        cornBox= new JCheckBox("corn");
        sausageBox= new JCheckBox("Sausage");
        mushroomBox= new JCheckBox("Mushroom");

        receiptText = new JTextArea(20,60);

        crustPnl.add(crustLabel);
        crustPnl.add(thinCrustBut);
        crustPnl.add(regularCrustBut);
        crustPnl.add(deepDishBut);

        sizePnl.add(sizeBox);

        toppingsPnl.add(toppingsLbl);
        toppingsPnl.add(pepperoniBox);
        toppingsPnl.add( pineappleBox);
        toppingsPnl.add(cheeseBox);
        toppingsPnl.add(cornBox);
        toppingsPnl.add(sausageBox);
        toppingsPnl.add(mushroomBox);

        formPnl.add(crustPnl);
        formPnl.add(sizePnl);
        formPnl.add(toppingsPnl);


        receiptPnl.add(receiptText);

        crustPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Crust"));
        receiptPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Receipt"));
        toppingsPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Toppings"));
        sizePnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Size"));


        midPnl.add(formPnl, BorderLayout.CENTER);
        midPnl.add(receiptPnl, BorderLayout.SOUTH);

    }

    private void createBottomPanel()
    {
        botPnl = new JPanel();
        botPnl.setLayout(new GridLayout(1,3));
        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        quitButton = new JButton("Quit");

        orderButton.addActionListener(
                (ActionEvent ae) -> {
                    double total = 0;
                    receiptText.append("\n" +"=========================================");
                    // part for crust
                    if(thinCrustBut.isSelected())
                    {
                        receiptText.append("\n" +"Thin Crust         $1.00");
                        total += 1;
                    }
                    else if (regularCrustBut.isSelected())
                    {
                        receiptText.append("\n" +"Regular Crust      $2.00");
                        total += 2;
                    }
                    else if (deepDishBut.isSelected())
                    {
                        receiptText.append("\n" +"Deep Dish          $4.00");
                        total += 4;
                    }

                    System.out.println(crustGroups.getSelection());

                    //part of receipt

                    switch(sizeBox.getSelectedIndex())
                    {
                        case 0:
                            receiptText.append("\n" + "Small              $8.00");
                            total += 8;
                            break;
                        case 1:
                            receiptText.append("\n" +"Regular           $12.00");
                            total += 12;
                            break;
                        case 2:
                            receiptText.append("\n" +"Large              $16.00");
                            total += 16;
                            break;
                        case 3:
                            receiptText.append("\n" +"Super            $20.00");
                            total += 20;
                            break;
                    }

                    // toppings to receipt
                    if(pepperoniBox.isSelected())
                    {
                        receiptText.append("\n" +"Pepperoni         $1.00");
                        total += 1;
                    }
                    if(cheeseBox.isSelected())
                    {
                        receiptText.append("\n" +"Cheese         $1.00");
                        total += 1;
                    }
                    if( pineappleBox.isSelected())
                    {
                        receiptText.append("\n" +"Pineapple         $1.00");
                        total += 1;
                    }
                    if(cornBox.isSelected())
                    {
                        receiptText.append("\n" +"Corn        $1.00");
                        total += 1;
                    }
                    if(sausageBox.isSelected())
                    {
                        receiptText.append("\n" +"Sausage         $1.00");
                        total += 1;
                    }
                    if(mushroomBox.isSelected())
                    {
                        receiptText.append("\n" +"Mushroom       $1.00");
                        total += 1;
                    }

                    //display Everything
                    String subTotal = new String("");
                    receiptText.append("\n" +"\n" +"Subtotal: $" + total);
                    double tax = total * .07;
                    String taxRound = String.format("%.2f", tax);
                    receiptText.append("\n" +"Tax:    $" + taxRound);
                    total += tax;
                    receiptText.append("\n" +"----------------------------------------------");
                    receiptText.append("\n"  +"Total:    $" + total);
                    receiptText.append("\n" +"==============================================");
                }
        );
        quitButton.addActionListener(
                (ActionEvent ae) -> {
                    int a = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?");

                    if (a == JOptionPane.YES_OPTION)
                    {
                        System.exit(0);
                    }
                }

        );

        clearButton.addActionListener(
                (ActionEvent ae) -> {
                    crustGroups.clearSelection();
                    sizeBox.setSelectedIndex(0);
                    pepperoniBox.setSelected(false);
                    cheeseBox.setSelected(false);
                    cornBox.setSelected(false);
                    pineappleBox.setSelected(false);
                    mushroomBox.setSelected(false);
                    sausageBox.setSelected(false);
                }

        );
        botPnl.add(orderButton);
        botPnl.add(clearButton);
        botPnl.add(quitButton);
    }

}