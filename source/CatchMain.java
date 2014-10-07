class CatchMain
{
	public static void main(String apokes[] )
	{
	Catch poke = new Catch();
	CatchRun mt1 = new CatchRun("Magikarp", poke);
	CatchRun mt2 = new CatchRun("Bulbasaur", poke);

	try
	{
		mt1.thread.join();
		mt2.thread.join();
	}
	catch (InterruptedException exc)
	{
	System.out.println("Main thread interrupted.");
	}
	}
}