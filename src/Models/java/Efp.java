package Models.java;

import com.ms4systems.devs.core.model.CoupledModel;
import com.ms4systems.devs.core.model.impl.CoupledModelImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;

public class Efp extends CoupledModelImpl {
	private static final long serialVersionUID = 1L;

	public Efp() {
		super("Efp");
		Proc proc = new Proc("Proc",25);
		Ef ef = new Ef("Ef",10,100);
		
		addChildModel(ef);
		addChildModel(proc);
		
		addCoupling(ef.out,proc.in);
		addCoupling(proc.out,ef.in);
	}
	
	public static void main(String[] args) {
		CoupledModel efp = new Efp();
		Simulation sim = new SimulationImpl("Efp Simulation", efp);
		
		System.out.println(sim.getURI());
		System.out.println(efp.getSimulator().getURI());
		System.out.println("---");
		sim.startSimulation(0);
		System.out.println(sim.getAllContents());
		//System.exit(0);
		
		sim.simulateIterations(Long.MAX_VALUE);
	}

}
