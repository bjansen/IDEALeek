<#-- @ftlvariable name="weapons" type="java.util.List<com.plopiplop.leekwars.model.Weapon>" -->
<#-- @ftlvariable name="chips" type="java.util.List<com.plopiplop.leekwars.model.Chip>" -->
<#list weapons as weapon>
/**
 * ${weapon.name}. ${weapon.description}
 */
global ${weapon.id};

</#list>
<#list chips as chip>
/**
 * ${chip.name}. ${chip.description}
 */
global ${chip.id};

</#list>
