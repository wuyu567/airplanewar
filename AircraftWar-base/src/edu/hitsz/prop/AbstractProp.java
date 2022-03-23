package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Game;
import edu.hitsz.application.Main;
import edu.hitsz.basic.FlyingObject;
import edu.hitsz.aircraft.EliteEnemy;

public abstract class AbstractProp extends FlyingObject {

    public AbstractProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    /**
     * 道具起作用抽象方法
     * @param heroAircraft
     */
    public abstract void propFunc(HeroAircraft heroAircraft);

}
