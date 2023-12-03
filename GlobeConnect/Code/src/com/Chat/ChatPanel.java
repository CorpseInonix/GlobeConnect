package com.Chat;

import javax.swing.*;
import javax.swing.plaf.basic.*;
import net.miginfocom.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {
	
	JScrollPane pane;
	JTextField message;
	JTextArea textArea;
	JPanel panelA;
	JPanel panelB;
	JPanel justForLooks;
	JLabel reciever;
	String displayName = "Currently messaging nobody, select or add a user to message";
	
	ChatPanel() {
		
		setPreferredSize(new Dimension(375, 420));
		setLayout(new BorderLayout());
		
		reciever = new JLabel(displayName);
		
		textArea = new JTextArea();
		
		panelA = new JPanel(new MigLayout());
		panelB = new JPanel(new FlowLayout());
		justForLooks = new JPanel();
		
		message = new JTextField(25);
		
		pane = new JScrollPane(textArea);
		
		setUp();
		addComponents();
		
	}
	
	public void setUp() {
		
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setCaretColor(Color.BLACK);
		textArea.setFocusable(false);
		
		reciever.setForeground(Color.WHITE);
		
		panelA.setBackground(Color.BLACK);
		panelA.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		
		panelB.setBackground(Color.BLACK);
		panelB.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
		
		justForLooks.setBackground(Color.BLACK);
		
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBorder(null);
		pane.setRowHeaderView(justForLooks);
		pane.getVerticalScrollBar().setBackground(Color.BLACK);
		pane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = Color.DARK_GRAY;
		    }
		    
		    @Override
		    protected JButton createDecreaseButton(int orientation) {
		        return createZeroButton();
		    }
		    
		    @Override
		    protected JButton createIncreaseButton(int orientation) {
		        return createZeroButton();
		    }
		});
		
		message.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
		message.setBackground(Color.BLACK);
		message.setForeground(Color.WHITE);
		message.setCaretColor(Color.WHITE);
		message.addKeyListener(Main.getKeyListener());
		
	}
	
	public void addComponents() {
		
		panelA.add(reciever);
		panelB.add(message);
		
		add(BorderLayout.NORTH, panelA);
		add(BorderLayout.CENTER, pane);
		add(BorderLayout.SOUTH, panelB);
		
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	protected JButton createZeroButton() {
	    JButton button = new JButton("zero button");
	    Dimension zeroDim = new Dimension(0,0);
	    button.setPreferredSize(zeroDim);
	    button.setMinimumSize(zeroDim);
	    button.setMaximumSize(zeroDim);
	    return button;
	}

}
