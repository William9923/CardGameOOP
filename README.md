<p align="center">
    <img src="docs/thumbnail.gif" width="400">
    <h2 align="center">Duel FX</h2>
</p> 
<p align="center">A trading card game built using javafx to learn OOP in medium sized application based on the famous cartoon <code>Avatar Aang Series</code></p>

> Notes: The game mechanics itself is highly inspired by YugiOh Trading Card Game System. For the detail of how to play the game please refer to this [link](https://en.wikipedia.org/wiki/Yu-Gi-Oh!_Trading_Card_Game).

## ✨ Features

- Main Menu / Lobby
- Arena / Duel
- Various Card Type
- Zones
- Phase
- End Battle

### Here are fews examples of how the game looks

**Main Menu**
* ![Main Menu](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/tampilan%20utama.jpg)

**Character that use in field**
* ![Character that use in field](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/characterinfield.jpg)

**Playing the cards from hand**
* ![Playing the cards from hand](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/mainin%20kartu%20dari%20tangan.jpg)

**Player description and Card Description**
* ![Player description and Card Description](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/Player%20and%20card%20desc.jpg)

**Defense Position**
* ![Defense Position](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/Defense%20Position.jpg)

**Error Message**
* ![Error Message](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/error%20message.jpg)

**Pop up to use some skills**
* ![Pop up to use some skills](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/Pop%20Up%20to%20use%20skill.jpg)

**Skill Card In Use**
* ![Skill Card In Use](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/skill%20card%20in%20use.jpg)

**Game Status and End Button**
* ![Game Status and End Button](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/game%20status%20and%20end%20button.jpg)

**A Win Message**
* ![A Win Message](https://github.com/William9923/CardGameOOP/blob/master/src/main/resources/com/avatarduel/win%20message.jpg)

## Credit
All images and description are taken from [Avatar Wikia](https://avatar.fandom.com/wiki/Avatar_Wiki)


## Code Structure
```
CardGameOOP
├───src
├───main
    ├───java
        └───com.avatarduel
            └───dao
                └───CardDAO.java
                └───CSVCardDAO.java
            └───event
                └───ActivateDestroyEvent.java
                └───ActivateSkillEvent.java
                └───AttackEvent.java
                └───ChangePositionEvent.java
                └───DirectAttackEvent.java
                └───DrawEvent.java
                └───EndTurnEvent.java
                └───IEvent.java
                └───NextPhaseEvent.java
                └───PlayLandCardEvent.java
                └───RemoveSkillCardEvent.java
                └───SummonEvent.java
            └───exception
                └───ExceptionCause
                    └───AttackCause.java
                    └───AttackOnTheCreatedTurncause.java
                    └───ExceptionCause.java
                    └───FullBoardCause.java
                    └───InvalidPhaseCause.java
                    └───InvalidTargetCause.java
                    └───MultipleAttackOnTheSameTurnCause.java
                    └───MultipleLandCardPlayedOnTheSameTurnCause.java
                    └───NoCharacterCardInFieldCause.java
                    └───NoCharactercardToDestroyCause.java
                    └───NotEnoughPowerCause.java
                └───EmptyFieldException.java
                └───InvalidAttackException.java
                └───InvalidOperationException.java
                └───InvalidPhaseException.java
                └───InvalidTargetException.java
                └───NotEnoughPowerException.java
                └───NotEnoughSpaceException.java
                └───UniquePlayCardException.java
            └───factory
                └───CardFactory.java
                └───CardInFieldFactory.java
            └───guicontroller
                └───Board
                    └───BoardController.java
                    └───DeckController.java
                    └───FieldController.java
                    └───GameStatusController.java
                    └───HandController.java
                    └───PlayerStatusController.java
                └───Card
                    └───CardController.java
                    └───CardInFieldController.java
                    └───CardInHandController.java
                    └───CharacterCardInFieldController.java
                    └───DisplayCardController.java
                    └───SkillCardInFieldController.java
                └───MainMenu
                    └───CardLibraryController.java
                    └───HowToPlayController.java
                    └───MainMenuController.java
                └───RenderQuest
                    └───AttackRequest.java
                    └───ChangeTurnRenderRequest.java
                    └───CheckWinRequest.java
                    └───DeckDrawAndRenderRequest.java
                    └───DeckRenderRequest.java
                    └───FieldRenderRequest.java
                    └───GameStatusRenderRequest.java
                    └───HandRenderRequest.java
                    └───PlayerStatusRenderRequest.java
                    └───RenderRequest.java
                    └───ShowSelectedCardRequest.java
            └───model
                └───card
                    └───Card.java
                    └───CardInHand.java
                    └───CharacterCard.java
                    └───CharacterCardInField.java
                    └───IField.java
                    └───LandCard.java
                    └───SkillAuraCard.java
                    └───SkillCard.java
                    └───SkillCardInField.java
                    └───SkillDestroyCard.java
                    └───SkillPowerUpCard.java
                └───player_component
                    └───Deck.java
                    └───Field.java
                    └───Hand.java
                    └───Player.java
                    └───PowerManager.java
                └───type
                    └───CardType.java
                    └───CharacterState.java
                    └───Element.java
                    └───Phase.java
                    └───PlayerType.java
                └───Game.java
            └───phase
                └───BattlePhase.java
                └───DrawPhase.java
                └───EndPhase.java
                └───IPhase.java
                └───MainPhase.java
            └───util
                └───CSVReader.java
                └───Loader.java
            └───AvatarDuel.java
            └───Main.java
    └───resources
    |   └───com.avatarduel
           └───card
                └───border
                    └───air.jpg
                    └───fire.jpg
                    └───water.jpg
                └───data
                    └───character.csv
                    └───land.csv
                    └───skill_aura.csv
                    └───skill_destroy.csv
                    └───skill_power_up.csv
                └───icon
                └───image
            └───character
                └───kira_yoshikage.png
                └───Light_Yagami.png
            └───GUI
                └───Board
                └───Card
                └───Main Menu
                └───Popup
            └───music
                └───main_menu_song.mp3
└───test
    └───java
        └───com.avatarduel
            └───dao
            └───event
            └───exception
            └───factory
            └───model
            └───phase
            └───util
                └───LoaderTest.java
```

## 📚 Tech Stack
- Java
- JavaFx (GUI)

## Credit
All images and description are taken from [Avatar Wikia](https://avatar.fandom.com/wiki/Avatar_Wiki)

## Contributor
* [William](https://github.com/William9923)
* [Arthur Edgar Yunanto](https://github.com/arthuredgary24)
* [Mario Gunawan](https://github.com/margunwa123)

## ❤️ Support
If you feel that this repo have helped you provide more example on learning software engineering, then it is enough for me! Wanna contribute more? Please ⭐ this repo so other can see it too!

