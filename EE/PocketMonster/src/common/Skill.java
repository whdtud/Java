package common;

enum SkillType {
	ATTACK,
	DEFENSE,
	RECOVERY
}

public class Skill {
	
	public String name;
	
	private SkillType type;
	private int value;
	
	public Skill(String name) {
		this.name = name;
		this.type = SkillType.ATTACK;
		this.value = 1;
	}
	
	public void fire(PocketMon caster, PocketMon target) {
		System.out.printf("%s!! ", name);
		
		switch (type) {
		case ATTACK:
			System.out.printf("%d의 데미지를 입혔다!!\n", value);
			target.onDamaged(value);
			break;
		case DEFENSE:
			break;
		case RECOVERY:
			caster.onRecovery(value);
			break;
		}
	}
}
