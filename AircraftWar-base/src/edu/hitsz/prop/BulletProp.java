package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Game;
import edu.hitsz.application.Main;
import edu.hitsz.basic.FlyingObject;
import edu.hitsz.aircraft.EliteEnemy;

public class BulletProp extends AbstractProp {

    private int shootnum = 1;

    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
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
        System.out.println("FireSupply active!");
    }
}
