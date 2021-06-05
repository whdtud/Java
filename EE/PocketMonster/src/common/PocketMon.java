package common;

import java.util.ArrayList;

public class PocketMon implements Cloneable {

	public String name;
	public int level;
	public int hp;
	public int maxHp;
	public int sp;
	public int maxSp;
	
	public ArrayList<Skill> skillList = new ArrayList<Skill>();
	
	public PocketMon(String name) {
		this.name = name;
		this.level = 1;
		this.maxHp = 10;
		this.hp = maxHp;
		
		skillList.add(new Skill("몸통박치기"));
		skillList.add(new Skill("째려보기"));
	}
	
	public PocketMon clone() throws CloneNotSupportedException {
		return (PocketMon)super.clone();
	}
	
	public void onDamaged(int value) {
		hp -= value;
	}
	
	public void onRecovery(int value) {
		hp += value;
	}
	
	public void fireSkill(int skillIndex, PocketMon target) {
		skillList.get(skillIndex).fire(this, target);
	}
}
