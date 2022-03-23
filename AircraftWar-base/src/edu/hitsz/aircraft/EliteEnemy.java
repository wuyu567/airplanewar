package edu.hitsz.aircraft;

import edu.hitsz.application.Game;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.AbstractBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BloodProp;
import edu.hitsz.prop.BulletProp;
import edu.hitsz.prop.BombProp;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 精英敌机
 * 每隔一段时间随机生成
 * 可以射击
 * 击毁后可能原地生成一种道具
 * @author fish
 */

public class EliteEnemy extends AbstractAircraft {

    /** 攻击方式 */
    private int shootNum = 1;     //子弹一次发射数量
    private int power = 20;       //子弹伤害
    private int direction = 1;  //子弹射击方向 (向上发射：-1，向下发射：1)

    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
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

    public AbstractProp change(){

        int rand = (int)(Math.random() * 3);

        if(rand==0){
            return new BloodProp(this.getLocationX(),this.getLocationY(),0,0);
        }
        else if(rand==1){
            return new BulletProp(this.getLocationX(),this.getLocationY(),0,0);
        }
        else if(rand==2){
            return new BombProp(this.getLocationX(),this.getLocationY(),0,0);
        }
        else{
            return null;
        }
    }
}
