package ec.app.orderProblem;
import ec.*;
import ec.simple.*;
import ec.vector.*;

public class OrderProblem extends Problem implements SimpleProblemForm
    {
    public void evaluate(final EvolutionState state,
        final Individual ind,
        final int subpopulation,
        final int threadnum)


        {
        if (ind.evaluated) return;

        if (!(ind instanceof IntegerVectorIndividual))
            state.output.fatal("Error. No es un vector de enteros!",null);
        
        IntegerVectorIndividual ind2 = (IntegerVectorIndividual) ind;
        //El fitness que solo es factible cuando es mayor o igual a 0
        //y menor o igual que 15.05   
        double fitness = 0;      
        double[] pricesArray = new double[]{2.15,2.75,3.35,3.55,4.20,5.80};
        ind2.corregirMonto();

        //CALCULO EL FITNESS
        for (int i=0;i<ind2.genome.length;i++){        	
        	fitness += ind2.genome[i]*pricesArray[i];        
        };
        
        //Asigno el fitness al individuo
        if (!(ind2.fitness instanceof SimpleFitness))
            state.output.fatal("Error. No es un SimpleFitness",null);
        ((SimpleFitness)ind2.fitness).setFitness(state,fitness, fitness == 15.05);
        ind2.evaluated = true;
        }
    }
