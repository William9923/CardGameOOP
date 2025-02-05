package com.avatarduel.model.card;

import com.avatarduel.factory.CardFactory;
import com.avatarduel.model.type.CardType;
import com.avatarduel.model.type.Element;

/**
 * SkillDestoryCard is one the SkillCard types that able to kill the targeted player.
 * @author G10-K03-CardGameOOP
 */

public class SkillDestroyCard extends SkillCard {

    // Destroy Skill Card
    public SkillDestroyCard (int id, String name, Element element, String description, String image, String power) {
        super(id,name,element,description,image);
        this.type = CardType.SKILL_DESTROY;
        this.power = Integer.parseInt(power);
    }

    public SkillDestroyCard(String[] elements) {
        this(Integer.parseInt(elements[0]), elements[1], CardFactory.outputElement(elements[2]), elements[3], elements[4], elements[5]);
    }
}
