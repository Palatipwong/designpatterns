package simulator;

import duckfactory.AbstractDuckFactory;
import duckfactory.CountingDuckFactory;
import duckfactory.Flock;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RubberDuck;
import goose.Goose;
import goose.GooseAdapter;
import pigeon.Pigeon;
import pigeon.PigeonAdapter;
import quack.QuackCounter;
import quack.Quackable;
import ducks.RedHeadDuck;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }
    void simulate(AbstractDuckFactory duckFactory) {
        Flock flock = new Flock();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        flock.add(mallardDuck);

        Quackable redheadDuck = duckFactory.createRedheadDuck();
        flock.add(redheadDuck);

        Quackable duckCall = duckFactory.createDuckCall();
        flock.add(duckCall);

        Quackable rubberDuck = duckFactory.createRubberDuck();
        flock.add(rubberDuck);

        Quackable goose = new GooseAdapter(new Goose());
        flock.add(goose);


        flock.add(mallardDuck);

        Quackable pigeon = new PigeonAdapter(new Pigeon());
        flock.add(pigeon);

        flock.add(duckCall);

        System.out.println("-- Duck Simulator --");

        simulate(flock);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }
    void simulate(Quackable duck) {
        duck.quack();
    }
}
