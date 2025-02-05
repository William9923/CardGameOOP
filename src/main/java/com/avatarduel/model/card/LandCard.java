package com.avatarduel.model.card;

import com.avatarduel.factory.CardFactory;
import com.avatarduel.model.type.CardType;
import com.avatarduel.model.type.Element;

/**
 * LandCard is one of the card types that has 3 main card atrributes plus 3 others.
 * This card is the power source for the player according to the element.
 * @author G10-K03-CardGameOOP
 */

public class LandCard extends Card {
    private int power;
    public LandCard(int id, String name, Element element, String description, String image) {
        super(id, name, element, description, image);
        this.power = 1; // hard-coded without context power
        this.type = CardType.LAND;
    }

    public LandCard(String[] elements) {
        this(Integer.parseInt(elements[0]), elements[1], CardFactory.outputElement(elements[2]), elements[3], elements[4]);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
