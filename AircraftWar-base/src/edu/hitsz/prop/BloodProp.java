package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;

public class BloodProp extends AbstractProp {
    private int addHp = 50;

    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public void propFunc(HeroAircraft heroAircraft){
        if(heroAircraft.getMaxHp()-heroAircraft.getHp()>=addHp){
            heroAircraft.decreaseHp(-this.addHp);
        }
        else if(heroAircraft.getMaxHp()-heroAircraft.getHp()<addHp){
            heroAircraft.decreaseHp(heroAircraft.getHp()-heroAircraft.getMaxHp());
        }
    }
}
