class CatchRun implements Runnable
{
Thread thread;
	Catch pokeObject;

	//construct a new thread
	CatchRun (String name, Catch poke)
	{
		thread = new Thread(this, name);
		pokeObject = poke;
		thread.start(); // start the thread
	}

	//Begin execution of new thread.
	public void run()
	{
		if (thread.getName().compareTo("Magikarp")== 0)
		{
			for (int i=0; i <200; i++) pokeObject.Magikarp(true);
			pokeObject.Magikarp(false);
		}
		else
		{
			for (int i=0; i<200; i++) pokeObject.Bulbasaur(true);
			pokeObject.Bulbasaur(false);
		}
	}
}