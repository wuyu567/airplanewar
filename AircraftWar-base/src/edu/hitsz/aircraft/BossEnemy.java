package edu.hitsz.aircraft;

import edu.hitsz.application.Game;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.AbstractBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.AbstractProp;

import java.util.LinkedList;
import java.util.List;

/**
 * Boss敌机
 * 悬浮在屏幕上方
 * 可以射击
 * 击毁后可能原地生成一种道具
 */

public class BossEnemy extends AbstractAircraft {

    /** 攻击方式 */
    private int shootNum = 2;     //子弹一次发射数量
    private int power = 20;       //子弹伤害
    private int direction = 1;  //子弹射击方向 (向上发射：-1，向下发射：1)

    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
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
    public List<AbstractBullet> shoot() {
        List<AbstractBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = this.getSpeedY() + direction*5;
        AbstractBullet abstractBullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            abstractBullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, speedX, speedY, power);
            res.add(abstractBullet);
        }
        return res;
    }

}
