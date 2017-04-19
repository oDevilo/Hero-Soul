package org.hero.soul.model.gene;

/**
 * 属性类型枚举
 */
public enum AttributeEnum {
    HP		("", "生命值上限",	true),
    HPUP    ("", "HP成长率",   true),
    MP		("", "魔法值上限",	true),
    MPUP    ("", "MP成长率",   true),
	ATK		("", "物理攻击",	true),
	DEF		("", "防御",		true),
	INT		("", "魔法攻击",	true),
	SPD		("", "速度",		true),
	EVA		("", "闪避",		true),
	HIT		("", "命中率",	true),
	AP		("", "行动点数",	true),
	RES		("", "魔法防御",	true),
	STR		("", "力量",		true),
	CON		("", "体质",		true),
	DEX		("", "灵巧",		true),
	PER		("", "感知",		true),
	LER		("", "学识",		true),
	WIL		("", "意志力",	true),
	MAG		("", "魔力",		true),
	CHR		("", "魅力",		true),
	FAME	("", "名声",		true),
	KARMA	("", "因果",		true),
	LIGHT_RESIST	("", "光属性抗性", true),
	DARK_RESIST		("", "暗属性抗性", true),
	WIND_RESIST		("", "风属性抗性", true),
	THUNDER_RESIST	("", "雷属性抗性", true),
	WATER_RESIST	("", "水属性抗性", true),
	FIRE_RESIST		("", "火属性抗性", true),
	WOOD_RESIST		("", "木属性抗性", true),
	SOIL_RESIST		("", "土属性抗性", true)
	;
	
	private String engName;//英文名称
	private String chName;//中文名称
	private Boolean enable;//该属性是否生效
	
	private AttributeEnum(String engName, String chName, Boolean enable) {
		this.engName = engName;
		this.chName = chName;
		this.enable = enable;
	}

	public String getEngName() {
		return engName;
	}

	public String getChName() {
		return chName;
	}

	public Boolean getEnable() {
		return enable;
	}
	
}
