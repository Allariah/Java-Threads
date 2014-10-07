import javax.swing.*;

class Catch extends JFrame
{

	ClassLoader ldr=this.getClass().getClassLoader();
	java.net.URL poke2URL=ldr.getResource("images/poke2.gif");
	java.net.URL poke1URL=ldr.getResource("images/poke1.gif");
	ImageIcon magikarp=new ImageIcon(poke2URL);
	ImageIcon bulbasaur=new ImageIcon(poke1URL);
	JLabel lbl1=new JLabel(bulbasaur);
	JPanel pnl=new JPanel();
	JLabel lbl2=new JLabel("Bulbasaur use Solar Beam!");
	public Catch()
	{
		super("Pokébattle");
		setSize(310,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		pnl.add(lbl1);
		pnl.add(lbl2);
		setVisible(true);
	}
	
	String state;

	synchronized void Magikarp(boolean  running)
	{
	try 
	{
		Thread.sleep(1700);
	}
	catch (Exception e) {}
		if (!running)
		{	
			state = "Magikarp";  //stop the clock 
			notify  ();  // notify any waiting threads 
			return;
		}
	lbl1.setIcon(magikarp);
	lbl2.setText("It's Super Effective!");
	state = "Magikarp"; //set the current state to Magikarp
   
	notify();  //let Bulbasaur() run

		try
		{
			while (!state.equals("Bulbasaur"))
			wait(); //wait for Bulbasaur() to complete
		}
		catch(InterruptedException exc)
		{
			System.out.println("Thread Interrupted.");
		}
	}

	synchronized void Bulbasaur(boolean  running)
	{
	try 
	{
		Thread.sleep(1400);
	}
	catch (Exception e) {}
		if (!running)  //stop the clock
		{
			state = "Bulbasaur";
			notify();  //notify any waiting threads
			return;
		}
	lbl1.setIcon(bulbasaur);
	
	state = "Bulbasaur"; //set the current state to Bulbasaur
	lbl2.setText("Bulbasaur use Solar Beam!");
	notify();  //let Magikarp() run

		try
		{
			while(!state.equals("Magikarp"))
			wait();  //wait for Magikarp to complete
		}
		catch (InterruptedException exc)
		{
			System.out.println("Thread interrupted.");
		}
	}
}