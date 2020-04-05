package com.avatarduel.model.card;

import com.avatarduel.model.type.Element;
import com.avatarduel.model.type.CardType;
import com.avatarduel.util.Loader;

public abstract class Card  {
    protected int id;
    protected String name;
    protected Element element;
    protected String description;
    protected String image;
    protected CardType type;
    protected int power;

    // constructor
    public Card(int id, String name, Element element, String description, String image) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.description = description;
        this.image = image;
    }

    // getter & setter
    public Element getElement() {
        return element;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    // debugging function
    public void show() {
        System.out.println("ID : " + getId() + " Name : " + getName());
        System.out.println("Description : " + getDescription());
        System.out.println("Type : " + getType());
    }
}
